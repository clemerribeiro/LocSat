/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.ClienteDAO;
import model.Endereco;
import model.EnderecoDAO;

/**
 *
 * @author clemer.ribeiro
 */
public class GerenciarCliente extends HttpServlet {

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

        String id_cliente = request.getParameter("id_cliente");
        String id_endereco = request.getParameter("id_endereco");
        
        Cliente c = new Cliente();
        ArrayList<Endereco> e = new ArrayList();

        try {

            ClienteDAO cDAO = new ClienteDAO();
            if (acao.equals("alterar")) { 
                if (GerenciarLogin.verificarPermissao(request, response)) {
                
                c = cDAO.getCarregaPorID(Integer.parseInt(id_cliente));
                if (c.getId_cliente() > 0) {
                    RequestDispatcher disp = getServletContext().getRequestDispatcher("/editar_cliente.jsp");
                    request.setAttribute("cliente", c);
                    disp.forward(request, response);

                } else {

                    mensagem = "Cliente não encontrado";
                }
                }else{
                    mensagem ="Acesso Negado";
                }
            }
            
            if (acao.equals("exibir")) { 
                if (GerenciarLogin.verificarPermissao(request, response)) {
                
                c = cDAO.getCarregaPorID(Integer.parseInt(id_cliente));
                if (c.getId_cliente() > 0) {
                    RequestDispatcher disp = getServletContext().getRequestDispatcher("/exibir_cliente.jsp");
                    request.setAttribute("cliente", c);
                    disp.forward(request, response);

                } else {

                    mensagem = "Cliente não encontrado";
                }
                }else{
                    mensagem ="Acesso Negado";
                }
            }
              EnderecoDAO eDAO = new EnderecoDAO();
             if (acao.equals("exibirend")) {                  
                if (GerenciarLogin.verificarPermissao(request, response)) {
                
                e = eDAO.getListaSelect(Integer.parseInt(id_cliente));
                if (e.size() > 0) {
                    RequestDispatcher disp = getServletContext().getRequestDispatcher("/exibir_endereco.jsp");
                    request.setAttribute("enderecos", e);
                    disp.forward(request, response);

                } else {

                    mensagem = "Endereço não encontrado";
                }
                }else{
                    mensagem ="Acesso Negado";
                }
            }         
            

            if (acao.equals("deletar")) {
                 if (GerenciarLogin.verificarPermissao(request, response)) {
                c.setId_cliente(Integer.parseInt(id_cliente));
                if (cDAO.deletar(c)) {

                    mensagem = "Exluido com sucesso";
                } else {
                    mensagem = "Erro ao executar";
                }
                 }else{
                     mensagem="Acesso Negado";
                 }
            }

        } catch (Exception ex) {
            out.print(ex);
            mensagem = "Erro ao executar";

        }
        out.println("<script type='text/javascript'>");
        out.println("alert('" + mensagem + "')");
        out.println("location.href='listar_cliente.jsp';");
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

        String id_cliente = request.getParameter("id_cliente");
        String nome_razao = request.getParameter("nome_razao");
        String cpf_cnpj = request.getParameter("cpf_cnpj");
        String rg_ie = request.getParameter("rg_ie");
        String telefone_cliente = request.getParameter("telefone_cliente");
        String responsavel_obra = request.getParameter("responsavel_obra");
        String email_cliente = request.getParameter("email_cliente");
        String obs_cliente = request.getParameter("obs_cliente");
        String tipo_cliente = request.getParameter("tipo_cliente");
        String status_cliente = request.getParameter("status_cliente");

        String mensagem = "";

        Cliente c = new Cliente();
        try {

            ClienteDAO cDAO = new ClienteDAO();

            if (!id_cliente.isEmpty()) {

                c.setId_cliente(Integer.parseInt(id_cliente));
            }
            if (nome_razao.equals("") || cpf_cnpj.equals("") || rg_ie.equals("") || telefone_cliente.equals("") ||
                    responsavel_obra.equals("") || email_cliente.equals("") || obs_cliente.equals("") ||
                    tipo_cliente.equals("") || status_cliente.equals("")) {

                mensagem = "Campos obrigatorios deverâo ser preenchidos";

            } else {

                c.setNome_razao(nome_razao);
                c.setCpf_cnpj(cpf_cnpj);
                c.setRg_ie(Integer.parseInt(rg_ie));
                c.setTelefone_cliente(telefone_cliente);
                c.setResponsavel_obra(responsavel_obra);
                c.setEmail_cliente(email_cliente);
                c.setObs_cliente(obs_cliente);
                c.setTipo_cliente(Integer.parseInt(tipo_cliente));
                c.setStatus_cliente(Integer.parseInt(status_cliente));
                

                if (cDAO.gravar(c)) {

                    mensagem = "Cliente cadastrado com sucesso";
                } else {

                    mensagem = "Erro ao gravar o cliente";
                }
            }

        } catch (Exception e) {
            out.print(e);
            mensagem = "Erro ao executar";

        }
        out.println("<script type='text/javascript'>");
        out.println("alert('" + mensagem + "')");
        out.println("location.href='listar_cliente.jsp';");
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
