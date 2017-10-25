/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.video_monito_ejb.controlador;

import co.edu.uniminuto.video_monito_ejb.entities.Tblserie;
import co.edu.uniminuto.video_monito_ejb.entities.TblserieFacade;
import java.io.IOException;
import java.io.PrintWriter;
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
public class Series extends HttpServlet {

    @EJB
    private TblserieFacade tblserieFacade;

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
            out.println("<title>Servlet Series</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Series at " + request.getContextPath() + "</h1>");
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
        this.cargarSeries(request, response);
    }
    private void  cargarSeries (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       
        
        List<Tblserie> series =tblserieFacade.findAll();
        request.setAttribute("series", series);
        request.getRequestDispatcher("./series.jsp").forward(request, response);
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
        String id = request.getParameter("id");
        String temporada = request.getParameter("temporada");
        String nombre = request.getParameter("nombre");
        String estado = request.getParameter("estado");
        String fechaInicio = request.getParameter("fechaIn");
        String fechaFin = request.getParameter("fechaFi");

        if (id == null || id.isEmpty()) {
            Tblserie serie = new Tblserie(temporada, nombre, estado, fechaInicio, fechaFin);
            tblserieFacade.create(serie);

        }
        this.cargarSeries(request, response);
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
