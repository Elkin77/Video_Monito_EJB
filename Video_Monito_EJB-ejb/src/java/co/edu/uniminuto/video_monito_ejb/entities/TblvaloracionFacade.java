/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.video_monito_ejb.entities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ep77
 */
@Stateless
public class TblvaloracionFacade extends AbstractFacade<Tblvaloracion> {

    @PersistenceContext(unitName = "Video_Monito_EJB-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblvaloracionFacade() {
        super(Tblvaloracion.class);
    }
    
}
