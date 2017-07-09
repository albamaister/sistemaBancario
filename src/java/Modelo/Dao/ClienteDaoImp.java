/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import model.Cliente;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;



/**
 *
 * @author bryan
 */
public class ClienteDaoImp implements ClienteDao{

    @Override
    public Cliente verficarIngreso(Cliente usuario) throws Exception {
       Cliente cl = null;
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();

            String sql = "FROM Cliente WHERE correo = '" + usuario.getCorreo() + "' and contrasenia= '"
                 +usuario.getContrasenia() +"'";
                     // +usuario.getClave() +"'";

            Query query = sesion.createQuery(sql);
            if (!query.list().isEmpty()) {
                cl = (Cliente) query.list().get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return cl;
    }
    
}
