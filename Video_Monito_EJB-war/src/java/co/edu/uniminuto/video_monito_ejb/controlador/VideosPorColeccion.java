/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.video_monito_ejb.controlador;

import co.edu.uniminuto.video_monito_ejb.entities.Tblcoleccion;
import co.edu.uniminuto.video_monito_ejb.entities.TblcoleccionFacade;
import co.edu.uniminuto.video_monito_ejb.entities.Tblcoleccionvideo;
import co.edu.uniminuto.video_monito_ejb.entities.TblcoleccionvideoFacade;
import co.edu.uniminuto.video_monito_ejb.entities.TblcoleccionvideoPK;
import co.edu.uniminuto.video_monito_ejb.entities.Tblvideo;
import co.edu.uniminuto.video_monito_ejb.entities.TblvideoFacade;
import co.edu.uniminuto.video_monito_ejb.entities.TblvideoseriePK;
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
public class VideosPorColeccion extends HttpServlet {

    @EJB
    private TblcoleccionvideoFacade tblcoleccionvideoFacade;

    @EJB
    private TblcoleccionFacade tblcoleccionFacade;

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
        List<Tblvideo> listaVideos = (List<Tblvideo>) tblvideoFacade.findAll();
        request.setAttribute("listaCat", listaVideos);

        List<Tblcoleccion> listaColecciones = (List<Tblcoleccion>) tblcoleccionFacade.findAll();
        request.setAttribute("listaClasifi", listaColecciones);

        
        request.getRequestDispatcher("./videoEnColeccion.jsp").forward(request, response);

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
        String idRegistro = request.getParameter("id");
        Tblvideo video = tblvideoFacade.find(Integer.parseInt(request.getParameter("videoId")));
        Tblcoleccion coleccion = tblcoleccionFacade.find(Integer.parseInt(request.getParameter("coleccionId")));
        
        if (idRegistro == null || idRegistro.isEmpty()) {
            TblcoleccionvideoPK videoEnColeccionPK=new TblcoleccionvideoPK(video.getIdVideo(),coleccion.getIdColeccion());
            Tblcoleccionvideo videoEnColeccion = new Tblcoleccionvideo(videoEnColeccionPK);
            tblcoleccionvideoFacade.create(videoEnColeccion);
            

        }
        request.getRequestDispatcher("./videoEnColeccion.jsp");
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
