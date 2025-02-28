package co.edu.poli.ejemplo1.database;

import java.util.List;

public interface DAO<T> {
    void guardar(T t);
    void actualizar(T t);
    void eliminar(int id);
    T obtener(int id);
    List<T> obtenerTodos();
}
