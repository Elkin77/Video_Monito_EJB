/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.video_monito_ejb.controlador;

import co.edu.uniminuto.video_monito_ejb.entities.Tblcliente;
import co.edu.uniminuto.video_monito_ejb.entities.TblclienteFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ep77
 */
public class Clientes extends HttpServlet {

    @EJB
    private TblclienteFacade tblclienteFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Clientes</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Clientes at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    

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
        this.cargarClientes(request, response);
    }
    
    private void  cargarClientes (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       
        
        List<Tblcliente> clientes =tblclienteFacade.findAll();
        request.setAttribute("clientes", clientes);
        request.getRequestDispatcher("./clientes.jsp").forward(request, response);
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
        java.util.Date d = new java.util.Date();
        java.sql.Date date2 = new java.sql.Date(d.getTime());

        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String password = request.getParameter("password");
        String documento = request.getParameter("documento");
        Date fecha_ingreso = date2;
        String correo = request.getParameter("correo");
        String referido = request.getParameter("referido");
        int puntos = Integer.parseInt(request.getParameter("puntos"));

        if (id == null || id.isEmpty()) {
            Tblcliente cliente = new Tblcliente(nombre, apellido, password, documento, fecha_ingreso, correo, referido, puntos);
            tblclienteFacade.create(cliente);

        }
        this.cargarClientes(request, response);
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
