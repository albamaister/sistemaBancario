/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Modelo.Dao.ClienteDao;
import Modelo.Dao.ClienteDaoImp;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Cliente;
import org.primefaces.context.RequestContext;
import util.MyUtil;


/**
 *
 * @author bryan
 */
@ManagedBean
@RequestScoped
public class loginBean implements Serializable{
    
    public static String us;
 
    Cliente usuario;
    ClienteDao usuarioDao;

    private final HttpServletRequest serverRquest;
    private final FacesContext facesContext;
    private FacesMessage mensaje;

    public loginBean() {
        usuario = new Cliente();
        facesContext = FacesContext.getCurrentInstance();
        serverRquest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
    }

    public static String getUs() {
        return us;
    }

    public static void setUs(String us) {
        loginBean.us = us;
    }

    public Cliente getUsuario() {
        return usuario;
    }

    public void setUsuario(Cliente usuario) {
        this.usuario = usuario;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////

    
    public String obtenerUsuario()
    {
        
        
        return us;
    }
    
    public void verificarDatos() throws Exception {

        ClienteDaoImp servicio = new ClienteDaoImp();
        try {
us=usuario.getCorreo();
            usuario = servicio.verficarIngreso(this.usuario);
            
            if (usuario != null) {

                Object objeto = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("mbSesion");
                MbSesion mbSesion = null;
                if (objeto != null) {
                    mbSesion = (MbSesion) objeto;
                    mbSesion.setUsuario(usuario);
                }
                serverRquest.getSession().setAttribute("usuario", usuario);

                //Redireccion
                HttpServletRequest request = ((HttpServletRequest) FacesContext.getCurrentInstance().
                        getExternalContext().getRequest());
                HttpSession sesion = request.getSession();
                String url = (String) sesion.getAttribute("lastUrl");
                if (url != null) {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SistemaBancario2/faces/views/inicio.xhtml");
                    //FacesContext.getCurrentInstance().getExternalContext().redirect(url);
                } else {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SistemaBancario2/faces/views/inicio.xhtml");
                }

                mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Conexion Satisfactoria", null);
                facesContext.addMessage(null, mensaje);

            } else {
                /*
                mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o password incorrecto", null);
                facesContext.addMessage(null, mensaje);
*/
                FacesContext.getCurrentInstance().getExternalContext().redirect("/SistemaBancario2/faces/views/inicio.xhtml");
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public void logout() {
        String ruta = MyUtil.basepathlogin() + "index.xhtml";
        RequestContext context = RequestContext.getCurrentInstance();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) facesContext.getExternalContext().getSession(false);
        sesion.invalidate();

        context.addCallbackParam("loggetOut", true);
        context.addCallbackParam("ruta", ruta);

    }

}