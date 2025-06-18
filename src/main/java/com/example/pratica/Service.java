package com.example.pratica;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
@org.springframework.stereotype.Service
public class Service implements serviceInterface{
    private final repository repository;
    @Autowired
    public Service(repository repository) {
        this.repository = repository;
    }

    @Override
    public List<model> obtenerDatos() {
        return repository.findAll();
    }

    @Override
    public Optional<model> obtenerId(Long id) {
        return repository.findById(id);
    }



    @Override
    public String guardarDatos(model guardar) {
        repository.save(guardar);
        return null;
    }

    @Override
    public void eliminarDatos(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void actualizarDatos(Long id, model actualizarDatos) {
        model actu = repository.findById(id).orElse(null);

        if (actu!=null){
            actu.setNombre(actualizarDatos.getNombre());
            actu.setApellido(actualizarDatos.getApellido());
            repository.save(actu);
        }else {
            throw new RuntimeException("No se encontro el id: " + id);
        }

    }
}
