package com.example.pratica;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
@org.springframework.stereotype.Service
public class Service implements Metodos{
    private final Repository repository;
    @Autowired
    public Service(Repository repository) {
        this.repository = repository;
    }


    @Override
    public List<Model> obtenerUsuarios() {
        return repository.findAll();
    }

    @Override
    public Optional<Model> obtenerId(Long id) {
        return repository.findById(id);
    }

    @Override
    public String guardarDatos(Model guardar) {
        repository.save(guardar);
        return null;
    }

    @Override
    public void borrarDatos(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void actualizarDatos(Long id, Model guardar) {

        Model actu = repository.findById(id).orElse(null);

        if (actu!=null){
            actu.setNombre(guardar.getNombre());
            actu.setApellido(guardar.getApellido());
            actu.setEdad(guardar.getEdad());
            actu.setEmail(guardar.getEmail());

            repository.save(actu);

        }else {
            throw new RuntimeException("No se encontro el id: " + id);
        }

    }
}
