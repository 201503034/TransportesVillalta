/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.dao;

import com.app.conexion.ConexionBD;
import com.app.modelo.TipoUsuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Steven
 */
public class TipoUsuarioDAO implements Operaciones{

    private ConexionBD conexion = new ConexionBD();
    
    @Override
    public String insertar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String modificar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> consultar() {
        List<TipoUsuario> lst = new ArrayList();
        try {
            Connection cn = this.conexion.conectar();
            Statement sentencia = cn.createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM tipos_usuarios");
            while (rs.next()) {                
                lst.add(new TipoUsuario(rs.getInt(1),rs.getString(2),rs.getString(3)));
            }
            rs.close();
            sentencia.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.conexion.desconectar();
        }
        
        return lst;
    }

    @Override
    public List<?> buscar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
