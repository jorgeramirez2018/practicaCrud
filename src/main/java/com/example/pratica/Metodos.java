package com.example.pratica;

import java.util.List;
import java.util.Optional;

public interface Metodos {
    public List<Model> obtenerUsuarios();
    public Optional <Model> obtenerId(Long id);
    public String guardarDatos(Model guardar);
    public void borrarDatos(Long id);
    public void actualizarDatos(Long id,Model guardar);
}
