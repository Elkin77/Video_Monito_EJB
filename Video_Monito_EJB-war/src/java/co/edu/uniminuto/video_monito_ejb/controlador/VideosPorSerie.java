/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.video_monito_ejb.controlador;


import co.edu.uniminuto.video_monito_ejb.entities.Tblserie;
import co.edu.uniminuto.video_monito_ejb.entities.TblserieFacade;
import co.edu.uniminuto.video_monito_ejb.entities.Tblvideo;
import co.edu.uniminuto.video_monito_ejb.entities.TblvideoFacade;
import co.edu.uniminuto.video_monito_ejb.entities.Tblvideoserie;
import co.edu.uniminuto.video_monito_ejb.entities.TblvideoserieFacade;
import co.edu.uniminuto.video_monito_ejb.entities.TblvideoseriePK;
import java.io.IOException;
import java.io.PrintWriter;
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
public class VideosPorSerie extends HttpServlet {

    @EJB
    private TblvideoserieFacade tblvideoserieFacade;

    @EJB
    private TblserieFacade tblserieFacade;

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

        List<Tblserie> listaSeries = (List<Tblserie>) tblserieFacade.findAll();
        request.setAttribute("listaClasifi", listaSeries);

        
        request.getRequestDispatcher("./videoEnSerie.jsp").forward(request, response);

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
        Tblserie serie = tblserieFacade.find(Integer.parseInt(request.getParameter("serieId")));
        
        if (idRegistro == null || idRegistro.isEmpty()) {
            TblvideoseriePK videoEnSeriePK=new TblvideoseriePK(video.getIdVideo(),serie.getIdSerie());
            Tblvideoserie videoEnSerie = new Tblvideoserie(videoEnSeriePK);
            tblvideoserieFacade.create(videoEnSerie);
            

        }
        request.getRequestDispatcher("./videoEnSerie.jsp");
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
