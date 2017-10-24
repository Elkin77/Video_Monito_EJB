/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.video_monito_ejb.controlador;

import co.edu.uniminuto.video_monito_ejb.entities.Tblcategoria;
import co.edu.uniminuto.video_monito_ejb.entities.TblcategoriaFacade;
import co.edu.uniminuto.video_monito_ejb.entities.Tblclasificacion;
import co.edu.uniminuto.video_monito_ejb.entities.TblclasificacionFacade;
import co.edu.uniminuto.video_monito_ejb.entities.Tblproveedor;
import co.edu.uniminuto.video_monito_ejb.entities.TblproveedorFacade;
import co.edu.uniminuto.video_monito_ejb.entities.Tblvideo;
import co.edu.uniminuto.video_monito_ejb.entities.TblvideoFacade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ep77
 */
public class Lista_Categorias extends HttpServlet {

    @EJB
    private TblvideoFacade tblvideoFacade;

    @EJB
    private TblproveedorFacade tblproveedorFacade;

    @EJB
    private TblclasificacionFacade tblclasificacionFacade;

    @EJB
    private TblcategoriaFacade tblcategoriaFacade;

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

        Vector<Tblcategoria> listaCategorias = (Vector<Tblcategoria>) tblcategoriaFacade.findAll();
        request.setAttribute("listaCat", listaCategorias);

        Vector<Tblclasificacion> listaClasificacion = (Vector<Tblclasificacion>) tblclasificacionFacade.findAll();
        request.setAttribute("listaClasifi", listaClasificacion);

        Vector<Tblproveedor> listaProveedores = (Vector<Tblproveedor>) tblproveedorFacade.findAll();
        request.setAttribute("listaProve", listaProveedores);
        request.getRequestDispatcher("./videos.jsp").forward(request, response);

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
        processRequest(request, response);
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
        String idVideo = request.getParameter("id");
        String yearProduccion = request.getParameter("yearProduccion");
        String duracion = request.getParameter("duracion");
        String titulo = request.getParameter("titulo");
        String descripcion = request.getParameter("descripcion");
        String imagen = request.getParameter("imagen");
        String video = request.getParameter("video");
        int idCategoria = Integer.parseInt(request.getParameter("categoriaId"));
        Tblcategoria idCat = tblcategoriaFacade.find(idCategoria);
        int idClasificacion = Integer.parseInt(request.getParameter("clasificacionId"));
        Tblclasificacion idClasif = tblclasificacionFacade.find(idClasificacion);
        int idProveedor = Integer.parseInt(request.getParameter("proveedorId"));
        Tblproveedor idprov = tblproveedorFacade.find(idProveedor);

        if (idVideo == null || idVideo.isEmpty()) {
            Tblvideo videos = new Tblvideo(yearProduccion, duracion, titulo, descripcion, imagen, video, idCat, idClasif, idprov);
            tblvideoFacade.create(videos);

        }
        request.getRequestDispatcher("./videos.jsp");
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
