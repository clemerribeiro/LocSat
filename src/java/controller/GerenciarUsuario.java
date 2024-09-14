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
import model.Perfil;
import model.Usuario;
import model.UsuarioDAO;

/**
 *
 * @author clemer.ribeiro
 */
public class GerenciarUsuario extends HttpServlet {

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
        String id_usuario = request.getParameter("id_usuario");

        try {
            Usuario u = new Usuario();
            UsuarioDAO uDAO = new UsuarioDAO();
            if (acao.equals("alterar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    u = uDAO.getCarregaPorID(Integer.parseInt(id_usuario));
                    if (u.getId_usuario() > 0) {
                        RequestDispatcher disp = getServletContext().getRequestDispatcher("/editar_usuario.jsp");
                        request.setAttribute("usuario", u);
                        disp.forward(request, response);

                    } else {

                        mensagem = "Usuário não encontrado";
                    }
                } else {
                    mensagem = "Acesso Negado";
                }
            }

            if (acao.equals("desativar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    u.setId_usuario(Integer.parseInt(id_usuario));
                    if (uDAO.desativar(u)) {

                        mensagem = "Usuário desativado com sucesso";
                    } else {
                        mensagem = "Erro ao executar";
                    }
                } else {
                    mensagem = "Acesso Negado";
                }
            }

            if (acao.equals("ativar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    u.setId_usuario(Integer.parseInt(id_usuario));
                    if (uDAO.ativar(u)) {

                        mensagem = "Usuário ativado com sucesso";
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
        out.println("location.href='listar_usuario.jsp';");
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

        String id_usuario = request.getParameter("id_usuario");
        String nome_usuario = request.getParameter("nome_usuario");
        String login_usuario = request.getParameter("login_usuario");
        String senha_usuario = request.getParameter("senha_usuario");
        String status_usuario = request.getParameter("status_usuario");
        String idperfil = request.getParameter("idperfil");
        String mensagem = "";

        Usuario u = new Usuario();

        if (!id_usuario.isEmpty()) {

            u.setId_usuario(Integer.parseInt(id_usuario));
        }
        if (nome_usuario.equals("") || login_usuario.equals("") || senha_usuario.equals("") || status_usuario.equals("") || idperfil.equals("")) {

            mensagem = "Campos obrigatorios deverâo ser preenchidos";

        } else {

            u.setNome_usuario(nome_usuario);
            u.setLogin_usuario(login_usuario);
            u.setSenha_usuario(senha_usuario);
            u.setStatus_usuario(Integer.parseInt(status_usuario));
            Perfil p = new Perfil();
            p.setIdPerfil(Integer.parseInt(idperfil));
            u.setPerfil(p);
            try {
                UsuarioDAO uDAO = new UsuarioDAO();
                if (uDAO.gravar(u)) {
                    mensagem = "Gravado com sucesso";
                } else {

                    mensagem = "Erro ao cadastrar Usuario";
                }

            } catch (Exception e) {
                out.print(e);
                mensagem = "Erro ao executar";
            }
            out.println("<script type='text/javascript'>");
            out.println("alert('" + mensagem + "')");
            out.println("location.href='listar_usuario.jsp';");
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
