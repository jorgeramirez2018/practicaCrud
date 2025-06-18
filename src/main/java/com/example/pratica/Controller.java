package com.example.pratica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("practica")
public class Controller {

    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping
    public List<model> obternerDatos (){

        return service.obtenerDatos();
    }

    @GetMapping("/{id}")
    public Optional<model> obtenerId(@PathVariable Long id){
        return service.obtenerId(id);
    }

    @PostMapping("agregando")
    public  ResponseEntity<String> guardando(@RequestBody model guardar){
        service.guardarDatos(guardar);
        return ResponseEntity.ok("Datos guardados Correctamente");
    }

    @DeleteMapping("eliminando/{id}")
    public  ResponseEntity<String> eliminando(@PathVariable Long id){
        service.eliminarDatos(id);
        return ResponseEntity.ok("Datos eliminados correctamente");
    }

    @PutMapping("actualizando/{id}")
    public  ResponseEntity<String> actualizando(@PathVariable Long id, @RequestBody model actualizarDatos){
        service.actualizarDatos(id,actualizarDatos);
        return ResponseEntity.ok("Actualizando datos");
    }

}
