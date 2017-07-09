/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import model.Cliente;

/**
 *
 * @author bryan
 */
@ManagedBean
@SessionScoped
public class MbSesion {
/**
     * Creates a new instance of MbSesion
     */
   
    private final HttpServletRequest serverRquest;
    private final FacesContext facesContext;
    private FacesMessage mensaje;
    String usuarioConectado;
    Cliente usuario;
    
    
    public MbSesion() {
       // cliente= new Cliente();
    
        facesContext= FacesContext.getCurrentInstance();
        serverRquest= (HttpServletRequest)facesContext.getExternalContext().getRequest();
        if(serverRquest.getSession().getAttribute("usuario")!=null){
            usuarioConectado=serverRquest.getSession().getAttribute("usuario").toString();
        }
//    else{
//        try {
//            FacesContext.getCurrentInstance().getExternalContext().redirect("iniciarSesion.xhtml");
//        } catch (IOException ex) {
//            Logger.getLogger(MbSesion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    }

    public void setUsuario(Cliente usuario) {
        this.usuario = usuario;
    }
    

    
}
