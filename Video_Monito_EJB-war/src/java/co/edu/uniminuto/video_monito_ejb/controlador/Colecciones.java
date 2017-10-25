/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.video_monito_ejb.controlador;

import static co.edu.uniminuto.video_monito_ejb.entities.Tblcliente_.nombre;
import co.edu.uniminuto.video_monito_ejb.entities.Tblcoleccion;
import co.edu.uniminuto.video_monito_ejb.entities.TblcoleccionFacade;
import co.edu.uniminuto.video_monito_ejb.entities.Tblserie;
import static co.edu.uniminuto.video_monito_ejb.entities.Tblserie_.fechaInicio;
import static co.edu.uniminuto.video_monito_ejb.entities.Tblserie_.temporada;
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
public class Colecciones extends HttpServlet {

    @EJB
    private TblcoleccionFacade tblcoleccionFacade;

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
            out.println("<title>Servlet Colecciones</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Colecciones at " + request.getContextPath() + "</h1>");
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
        this.cargarColecciones(request, response);
    }
    
    private void  cargarColecciones (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       
        
        List<Tblcoleccion> series =tblcoleccionFacade.findAll();
        request.setAttribute("colecciones", series);
        request.getRequestDispatcher("./colecciones.jsp").forward(request, response);
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
        String coleccion = request.getParameter("coleccion");
        String version = request.getParameter("version");
        String fecha_creacion = request.getParameter("fechaCreacion");
        String estado = request.getParameter("estado");
        

        if (id == null || id.isEmpty()) {
            Tblcoleccion colecc = new Tblcoleccion(coleccion, version, fecha_creacion, estado);
            tblcoleccionFacade.create(colecc);
            
        }
        this.cargarColecciones(request, response);
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
