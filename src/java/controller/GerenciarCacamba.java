/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cacamba;
import model.CacambaDAO;

/**
 *
 * @author clemer.ribeiro
 */
public class GerenciarCacamba extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String mensagem = "";

        String acao = request.getParameter("acao");
        String id_cacamba = request.getParameter("id_cacamba");

        Cacamba ca = new Cacamba();

        try {

            CacambaDAO caDAO = new CacambaDAO();
            if (acao.equals("alterar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    ca = caDAO.getCarregaPorID(Integer.parseInt(id_cacamba));
                    if (ca.getId_cacamba() > 0) {
                        RequestDispatcher disp = getServletContext().getRequestDispatcher("/editar_cacamba.jsp");
                        request.setAttribute("cacamba", ca);
                        disp.forward(request, response);

                    } else {

                        mensagem = "Caçamba não encontrada";
                    }
                } else {
                    mensagem = "Acesso Negado";
                }
            }

            if (acao.equals("deletar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    ca.setId_cacamba(Integer.parseInt(id_cacamba));
                    if (caDAO.deletar(ca)) {

                        mensagem = "Exluido com sucesso";
                    } else {
                        mensagem = "Erro ao executar";
                    }
                } else {
                    mensagem = "Acesso Negado";
                }
            }

        } catch (Exception e) {
            out.print(e);
            mensagem = "Erro ao executar";

        }
        out.println("<script type='text/javascript'>");
        out.println("alert('" + mensagem + "')");
        out.println("location.href='listar_cacamba.jsp';");
        out.println("</script>");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        String id_cacamba = request.getParameter("id_cacamba");
        String numero_cacamba = request.getParameter("numero_cacamba");
        String status_cacamba = request.getParameter("status_cacamba");

        String mensagem = "";

        Cacamba ca = new Cacamba();
        try {

            CacambaDAO caDAO = new CacambaDAO();

            if (!id_cacamba.isEmpty()) {

                ca.setId_cacamba(Integer.parseInt(id_cacamba));
            }
            if (numero_cacamba.equals("") || status_cacamba.equals("")) {

                mensagem = "Campos obrigatorios deverâo ser preenchidos";

            } else {

                ca.setNumero_cacamba(Integer.parseInt(numero_cacamba));
                ca.setStatus_cacamba(Integer.parseInt(status_cacamba));

                if (caDAO.gravar(ca)) {

                    mensagem = "Gravado com sucesso";
                } else {

                    mensagem = "Erro ao gravar o menu";
                }
            }

        } catch (Exception e) {
            out.print(e);
            mensagem = "Erro ao executar";

        }
        out.println("<script type='text/javascript'>");
        out.println("alert('" + mensagem + "')");
        out.println("location.href='listar_cacamba.jsp';");
        out.println("</script>");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
