/*
 * To change this template, choose Tools | Templates
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
import model.PerfilDAO;

/**
 *
 * @author Administrador
 */
public class GerenciarPerfil extends HttpServlet {

    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        String mensagem="";
        
        String acao = request.getParameter("acao");
        String idPerfil = request.getParameter("idPerfil");         
        Perfil p = new Perfil();
        
        try{
        
            PerfilDAO pDAO = new PerfilDAO();
            if(acao.equals("alterar")){
                p = pDAO.getCarregaPorID(Integer.parseInt(idPerfil));
                if(p.getIdPerfil()>0){
                
                    RequestDispatcher disp = getServletContext().getRequestDispatcher("/editar_perfil.jsp");
                    request.setAttribute("perfil",p);
                    disp.forward(request, response);
                       
                }else{
                
                    mensagem ="Perfil não encontrado";
                }
            
            }
            
            
            if(acao.equals("deletar")){
            p.setIdPerfil(Integer.parseInt(idPerfil));
            if(pDAO.deletar(p)){
            
                mensagem ="Exluido com sucesso";
            }else{
                   mensagem ="Erro ao executar";
            }
            
            }
            
        }catch(Exception e){
            out.print(e);
            mensagem ="Erro ao executar";
        
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"')");
        out.println("location.href='listar_perfil.jsp';");
        out.println("</script>");
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
      PrintWriter out = response.getWriter();
      String idperfil = request.getParameter("idperfil");
      String nome = request.getParameter("nome");
      
      String mensagem="";
      
      
      Perfil p = new Perfil();
     
        try {
            PerfilDAO pDAO = new PerfilDAO();
            
             if(!idperfil.isEmpty()){
                    p.setIdPerfil(Integer.parseInt(idperfil));
      
             }
             
             if (nome.equals("") || nome.isEmpty()){
                mensagem = "Campos obrigatorios deverão ser preenchidos";
                
             }else{
                 p.setNome(nome);
                if (pDAO.gravar(p)){
                    mensagem = "Gravado com sucesso!";
                }else
                    mensagem = "Erro ao gravar o perfil no banco de dados";
            }
            
        } catch (Exception e){
            out.print(e);
            mensagem = "Erro ao executar";
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('"+mensagem+"')");
        out.println("location.href='listar_perfil.jsp';");
        out.println("</script>");
    }
    
    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
