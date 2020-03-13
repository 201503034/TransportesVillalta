
package com.app.dao;

import java.util.List;

/**
 *
 * @author Steven
 */
public interface Operaciones {
    String insertar(Object obj);
    String modificar(Object obj);
    String eliminar(Object obj);
    public List<?> consultar();
    public List<?> buscar(Object obj);
}
