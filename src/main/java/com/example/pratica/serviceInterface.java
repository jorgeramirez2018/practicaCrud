package com.example.pratica;

import java.util.List;
import java.util.Optional;

public interface serviceInterface {
    List<model> obtenerDatos();
    public Optional<model> obtenerId(Long id);
    public String guardarDatos(model guardar);
    public void eliminarDatos(Long id);
    public void actualizarDatos(Long id, model actualizarDatos);

}
