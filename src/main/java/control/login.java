/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entita.Amministratore;
import entita.Dipendente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gino
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

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
           String username= request.getParameter("username");
           String password= request.getParameter("password");
           String ruolo=request.getParameter("ruolo");
           boolean cc=false;
           
           if(ruolo.equals("dipendente"))
           {
            Dipendente dip= (Dipendente)request.getSession().getAttribute(username);
            if(dip!=null)
            {
                
                if(password.equals(dip.getPassword()))
                {
                    request.getSession().setAttribute("loggatod", dip);
                    cc=true;
                  
                }
                
            }
           }
           else if(ruolo.equals("amministratore"))
           {
            Amministratore amm= (Amministratore)request.getSession().getAttribute(username);
            if(amm!=null)
            {
                
                if(password.equals(amm.getPassword()))
                {
                    request.getSession().setAttribute("loggatoa", amm);
                    cc=true;
                    
                }
                
            } 
           }
           if(cc)
           {
               response.sendRedirect("./loginsucc.jsp");
           }
           else{
               response.sendRedirect("./errorelogin.jsp");
           }
           
           
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
