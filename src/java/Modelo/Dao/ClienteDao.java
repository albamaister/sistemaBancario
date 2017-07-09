/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import model.Cliente;
import org.hibernate.HibernateException;

/**
 *
 * @author bryan
 */
public interface ClienteDao {
     public Cliente verficarIngreso(Cliente usuario) throws Exception;
//     public void RegistrarCliente(Cliente usuario)throws HibernateException;
//      public void Eliminar(Integer id)throws HibernateException;
    
}
