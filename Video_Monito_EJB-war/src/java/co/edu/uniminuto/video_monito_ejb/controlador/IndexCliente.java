/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.video_monito_ejb.controlador;

import co.edu.uniminuto.video_monito_ejb.entities.Tblcategoria;
import co.edu.uniminuto.video_monito_ejb.entities.TblcategoriaFacade;
import co.edu.uniminuto.video_monito_ejb.entities.Tblidioma;
import co.edu.uniminuto.video_monito_ejb.entities.TblidiomaFacade;
import co.edu.uniminuto.video_monito_ejb.entities.Tblvideo;
import co.edu.uniminuto.video_monito_ejb.entities.TblvideoFacade;
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
public class IndexCliente extends HttpServlet {

    @EJB
    private TblidiomaFacade tblidiomaFacade;

    @EJB
    private TblcategoriaFacade tblcategoriaFacade;

    @EJB
    private TblvideoFacade tblvideoFacade;

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
            out.println("<title>Servlet IndexCliente</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet IndexCliente at " + request.getContextPath() + "</h1>");
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
        this.cargarVideos(request, response);
    }

    private void cargarVideos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Tblvideo> videos = tblvideoFacade.findAll();
        request.setAttribute("listVideos", videos);
        List<Tblcategoria> categoria = tblcategoriaFacade.findAll();
        request.setAttribute("listCategoria", categoria);
        List<Tblidioma> idioma = tblidiomaFacade.findAll();
        request.setAttribute("listIdiomas", idioma);
        request.getRequestDispatcher("./indexCliente.jsp").forward(request, response);
    }

    private void cargarVideosConsulta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idioma = "", categoria = "";
        String tipo = request.getParameter("tipoVideo");
        int idCategoria, idIdioma;
        idCategoria = Integer.parseInt(request.getParameter("categoria"));
        idIdioma = Integer.parseInt(request.getParameter("idioma"));
        String año = request.getParameter("year");
        String duracion = request.getParameter("duracion");
        List<Tblvideo> videos = tblvideoFacade.findAll();
        request.setAttribute("listVideos", videos);
        request.getRequestDispatcher("./indexCliente.jsp").forward(request, response);
    }

    private void cargarVideosSinCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idioma = "", categoria = "";
        String tipo = request.getParameter("tipoVideo");
        int idIdioma;
        idIdioma = Integer.parseInt(request.getParameter("idioma"));
        String año = request.getParameter("year");
        String duracion = request.getParameter("duracion");
        List<Tblvideo> videos = tblvideoFacade.findAll();
        request.setAttribute("listVideos", videos);
        request.getRequestDispatcher("./indexCliente.jsp").forward(request, response);
    }

    private void cargarVideosSinIdioma(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idioma = "", categoria = "";
        String tipo = request.getParameter("tipoVideo");
        int idCategoria;
        idCategoria = Integer.parseInt(request.getParameter("categoria"));
        String año = request.getParameter("year");
        String duracion = request.getParameter("duracion");
        List<Tblvideo> videos = tblvideoFacade.findAll();
        request.setAttribute("listVideos", videos);
        request.getRequestDispatcher("./indexCliente.jsp").forward(request, response);
    }

    private void cargarVideosSinNada(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipo = request.getParameter("tipoVideo");
        String año = request.getParameter("year");
        String duracion = request.getParameter("duracion");
       // List<Tblvideo> videos = tblvideoFacade.find(año);
      //  request.setAttribute("listVideos", videos);
        request.getRequestDispatcher("./indexCliente.jsp").forward(request, response);
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
        String idioma = "", categoria = "";
        String tipo = request.getParameter("tipoVideo");
        int idCategoria, idIdioma;
        try {
            idCategoria = Integer.parseInt(request.getParameter("categoria"));

        } catch (NumberFormatException nfe) {
            categoria = request.getParameter("categoria");
        }
        try {
            idIdioma = Integer.parseInt(request.getParameter("idioma"));
        } catch (NumberFormatException nfe) {
            idioma = request.getParameter("idioma");
        }
        String año = request.getParameter("year");
        String duracion = request.getParameter("duracion");

        if (categoria.isEmpty() || categoria.equals("")) {
            if (idioma.isEmpty() || categoria.equals("")) {
                this.cargarVideosSinNada(request, response);
            }else{
                this.cargarVideosSinCategoria(request, response);
            }
        } else {
            if (idioma.isEmpty() || categoria.equals("")) {
                this.cargarVideosSinIdioma(request, response);
            }else{
                this.cargarVideosConsulta(request, response);
            }
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
