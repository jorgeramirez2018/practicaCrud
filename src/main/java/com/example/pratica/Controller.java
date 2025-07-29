package com.example.pratica;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }
    @GetMapping
    public List<Model> obtenerDatos(){
        return service.obtenerUsuarios();
    }
    @GetMapping("/obtener/{id}")
    public Optional<Model> obtenerId(@PathVariable("id") Long id){
        return service.obtenerId(id);
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> guardarDatos(@RequestBody Model guardar){
        service.guardarDatos(guardar);
        return ResponseEntity.ok("Se guardo con exito");
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarDatos(@PathVariable("id") Long id){
        service.borrarDatos(id);
        return ResponseEntity.ok("Se elimino con exito");
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizarDatos(@PathVariable("id") Long id, @RequestBody Model actualizar ){
        service.actualizarDatos(id,actualizar);
        return ResponseEntity.ok("Se actualizo con exito");
    }

}
