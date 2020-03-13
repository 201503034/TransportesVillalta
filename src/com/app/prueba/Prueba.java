
package com.app.prueba;

import com.app.dao.TipoUsuarioDAO;
import com.app.modelo.TipoUsuario;
import java.util.List;

/**
 *
 * @author Steven
 */
public class Prueba {
    public static void main(String[] args) {
        TipoUsuarioDAO tudao = new TipoUsuarioDAO();
        
        List<TipoUsuario> lst = (List<TipoUsuario>) tudao.consultar();
        for(TipoUsuario tu : lst){
            System.out.println(tu.getNombreTU());
        }
    }
}
