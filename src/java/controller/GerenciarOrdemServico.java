/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cacamba;
import model.CacambaDAO;
import model.Cliente;
import model.ClienteDAO;
import model.Usuario;
import model.UsuarioDAO;
import model.OrdemServico;
import model.OrdemServicoDAO;

/**
 *
 * @author clemer.ribeiro
 */
public class GerenciarOrdemServico extends HttpServlet {

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
        String id_ordem_servico = request.getParameter("id_ordem_servico");
        

        try {
            
            OrdemServico os = new OrdemServico();
            OrdemServicoDAO osDAO = new OrdemServicoDAO();
            if (acao.equals("alterar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    os = osDAO.getCarregaPorID(Integer.parseInt(id_ordem_servico));
                    if (os.getId_ordem_servico() > 0) {
                        RequestDispatcher disp = getServletContext().getRequestDispatcher("/finalizar_ordem_servico.jsp");
                        request.setAttribute("ordemservico", os);
                        disp.forward(request, response);

                    } else {

                        mensagem = "OS não encontrada";
                    }
                } else {
                    mensagem = "Acesso Negado";
                }
            }
            
            if (acao.equals("exibir")) { 
                if (GerenciarLogin.verificarPermissao(request, response)) {
                
                os = osDAO.getCarregaPorID(Integer.parseInt(id_ordem_servico));
                if (os.getId_ordem_servico() > 0) {
                    RequestDispatcher disp = getServletContext().getRequestDispatcher("/exibir_ordem_servico.jsp");
                    request.setAttribute("ordemservico", os);
                    disp.forward(request, response);

                } else {

                    mensagem = "OS não encontrada";
                }
                }else{
                    mensagem ="Acesso Negado";
                }
            }
            if (acao.equals("finalizar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    os.setId_ordem_servico(Integer.parseInt(id_ordem_servico));
                    if (osDAO.finalizar(os)) {

                        mensagem = "Ordem de Serviço finalizada com sucesso";
                    } else {
                        mensagem = "Erro ao executar";
                    }
                } else {
                    mensagem = "Acesso Negado";
                }
            }
           if (acao.equals("cancelar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    os.setId_ordem_servico(Integer.parseInt(id_ordem_servico));
                    if (osDAO.cancelar(os)) {

                        mensagem = "Ordem de Serviço cancelada com sucesso";
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
        out.println("location.href='listar_ordem_servico.jsp';");
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

        String id_ordem_servico = request.getParameter("id_ordem_servico");
        String id_cacamba = request.getParameter("id_cacamba");
        String id_usuario = request.getParameter("id_usuario");
        String id_cliente = request.getParameter("id_cliente");
        String placa_caminhao = request.getParameter("placa_caminhao");
        String ctr = request.getParameter("ctr");
        String status_ordem_servico = request.getParameter("status_ordem_servico");
        String valor_servico = request.getParameter("valor_servico");
        String tipo_servico = request.getParameter("tipo_servico");
        String endereco = request.getParameter("endereco");
        String mensagem = "";

        OrdemServico os = new OrdemServico();

        if (!id_ordem_servico.isEmpty()) {

            os.setId_ordem_servico(Integer.parseInt(id_ordem_servico));
        }
        if (id_cacamba.equals("") || id_usuario.equals("") || id_cliente.equals("") || placa_caminhao.equals("") || ctr.equals("") || status_ordem_servico.equals("") || valor_servico.equals("")|| tipo_servico.equals("") || endereco.equals("")) {

            mensagem = "Campos obrigatorios deverâo ser preenchidos";

        } else {
            Cacamba ca = new Cacamba();
            ca.setId_cacamba(Integer.parseInt(id_cacamba));
            os.setCacamba(ca);
            Usuario u = new Usuario();
            u.setId_usuario(Integer.parseInt(id_usuario));
            os.setUsuario(u);
            Cliente c = new Cliente();
            c.setId_cliente(Integer.parseInt(id_cliente));
            os.setCliente(c);
            os.setPlaca_caminhao(placa_caminhao);
            os.setCtr(Integer.parseInt(ctr));
            os.setStatus_ordem_servico(Integer.parseInt(status_ordem_servico));
            os.setValor_servico(Integer.parseInt(valor_servico));
            os.setTipo_servico(Integer.parseInt(tipo_servico));
            os.setEndereco(endereco);
            
            try {
                OrdemServicoDAO osDAO = new OrdemServicoDAO();
                if (osDAO.gravar(os)){
                    mensagem = "Ordem de Serviço criada com sucesso";
                } else {

                    mensagem = "Erro ao cadastrar Ordem de Serviço";
                }

            } catch (Exception e) {
                out.print(e);
                mensagem = "Erro ao executar";
            }
            out.println("<script type='text/javascript'>");
            out.println("alert('" + mensagem + "')");
            out.println("location.href='listar_ordem_servico.jsp';");
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
