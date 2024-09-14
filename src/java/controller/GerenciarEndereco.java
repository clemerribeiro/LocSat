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
import model.Cliente;
import model.Endereco;
import model.EnderecoDAO;

/**
 *
 * @author clemer.ribeiro
 */
public class GerenciarEndereco extends HttpServlet {

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
        String id_endereco = request.getParameter("id_endereco");

        try {
            Endereco e = new Endereco();
            EnderecoDAO eDAO = new EnderecoDAO();
            if (acao.equals("alterar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    e = eDAO.getCarregaPorID(Integer.parseInt(id_endereco));
                    if (e.getId_endereco() > 0) {
                        RequestDispatcher disp = getServletContext().getRequestDispatcher("/editar_endereco.jsp");
                        request.setAttribute("endereco", e);
                        disp.forward(request, response);

                    } else {

                        mensagem = "Endereço não encontrado";
                    }
                } else {
                    mensagem = "Acesso Negado";
                }
            }

            if (acao.equals("deletar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    e.setId_endereco(Integer.parseInt(id_endereco));
                    if (eDAO.deletar(e)) {

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
        out.println("location.href='listar_endereco.jsp';");
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

        String id_endereco = request.getParameter("id_endereco");
        String cep = request.getParameter("cep");
        String rua = request.getParameter("rua");
        String numero = request.getParameter("numero");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");
        String complemento = request.getParameter("complemento");
        String id_cliente = request.getParameter("id_cliente");
        String mensagem = "";

        Endereco e = new Endereco();

        if (!id_endereco.isEmpty()) {

            e.setId_endereco(Integer.parseInt(id_endereco));
        }
        if (cep.equals("") || rua.equals("") || numero.equals("") || bairro.equals("") || cidade.equals("") || 
                uf.equals("") || complemento.equals("") || id_cliente.equals("")) {

            mensagem = "Campos obrigatorios deverâo ser preenchidos";

        } else {

            e.setCep(Integer.parseInt(cep));
            e.setRua(rua);
            e.setNumero(Integer.parseInt(numero));
            e.setBairro(bairro);
            e.setCidade(cidade);
            e.setUf(uf);
            e.setComplemento(complemento);
            Cliente c = new Cliente();
            c.setId_cliente(Integer.parseInt(id_cliente));
            e.setCliente(c);
            try {
                EnderecoDAO eDAO = new EnderecoDAO();
                if (eDAO.gravar(e)) {
                    mensagem = "Endereço cadastrado com sucesso";
                } else {

                    mensagem = "Erro ao cadastrar Endereço";
                }

            } catch (Exception ex) {
                out.print(ex);
                mensagem = "Erro ao executar";
            }
            out.println("<script type='text/javascript'>");
            out.println("alert('" + mensagem + "')");
            out.println("location.href='listar_endereco.jsp';");
            out.println("</script>");

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
