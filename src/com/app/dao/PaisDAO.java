package com.app.dao;

import com.app.conexion.ConexionBD;
import com.app.modelo.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Steven
 */
public class PaisDAO implements Operaciones {

    private ConexionBD conexion = new ConexionBD();

    @Override
    public String insertar(Object obj) {
        String resp = null;
        String sql;
        try {
            //Casteamos en Pais el objeto que se reciba
            Pais pais = (Pais) obj;
            Connection cn = this.conexion.conectar();
            sql = "INSERT INTO paises VALUES(?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, pais.getIdPais());
            pst.setString(2, pais.getNombrePais());

            //Capturamos el numero de filas que se ingresaran
            int nFilas = pst.executeUpdate();

            //Creamos la respuesta a devolver
            if (nFilas == 1) {
                resp = "Se ha ingresado " + nFilas + " regitro.";
            } else {
                resp = "Se han ingresado " + nFilas + " regitros.";
            }
            pst.close();
            cn.close();
        } catch (Exception e) {
            resp = e.toString();
        } finally {
            this.conexion.desconectar();
        }
        return resp;
    }

    @Override
    public String modificar(Object obj) {
        String resp = null;
        String sql;
        try {
            //Casteamos en Pais el objeto que se reciba
            Pais pais = (Pais) obj;
            Connection cn = this.conexion.conectar();
            sql = "UPDATE paises SET nombrePais=? WHERE idPais=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, pais.getNombrePais());
            pst.setInt(2, pais.getIdPais());

            //Capturamos el numero de filas que se modificaran
            int nFilas = pst.executeUpdate();

            //Creamos la respuesta a devolver
            if (nFilas == 1) {
                resp = "Se ha modificado " + nFilas + " regitro.";
            } else {
                resp = "Se han modificado " + nFilas + " regitros.";
            }
            pst.close();
            cn.close();
        } catch (Exception e) {
            resp = e.toString();
        } finally {
            this.conexion.desconectar();
        }
        return resp;
    }

    @Override
    public String eliminar(Object obj) {
        String resp = null;
        String sql;
        try {
            //Casteamos en Pais el objeto que se reciba
            Pais pais = (Pais) obj;
            Connection cn = this.conexion.conectar();
            sql = "DELETE FROM paises WHERE idPais=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, pais.getIdPais());

            //Capturamos el numero de filas que se eliminaran
            int nFilas = pst.executeUpdate();

            //Creamos la respuesta a devolver
            if (nFilas == 1) {
                resp = "Se ha eliminado " + nFilas + " regitro.";
            } else {
                resp = "Se han eliminado " + nFilas + " regitros.";
            }
            pst.close();
            cn.close();
        } catch (Exception e) {
            resp = e.toString();
        } finally {
            this.conexion.desconectar();
        }
        return resp;
    }

    @Override
    public List<?> consultar() {
        List<Pais> lst = new ArrayList();
        try {
            Connection cn = this.conexion.conectar();
            Statement sentencia = cn.createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM paises");
            while (rs.next()) {
                lst.add(new Pais(rs.getInt(1), rs.getString(2)));
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
        List<Pais> lst = new ArrayList();
        String sql;
        try {
            //Casteamos en Pais el objeto que se reciba
            Pais pais = (Pais) obj;
            Connection cn = this.conexion.conectar();
            sql = "SELECT * FROM paises WHERE idPais=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, pais.getIdPais());

            //Capturamos el objeto encontrado
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                lst.add(new Pais(rs.getInt(1), rs.getString(2)));
            }
            rs.close();
            pst.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.conexion.desconectar();
        }

        return lst;
    }

}
