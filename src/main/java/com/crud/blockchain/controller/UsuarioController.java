package com.crud.blockchain.controller;

import com.crud.blockchain.Repository.UsuarioRepo;
import com.crud.blockchain.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuarios")
@CrossOrigin(origins = "http://localhost:4200/")
public class UsuarioController {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @GetMapping
    public String message() {
        return "CONEXION ESTABLECIDA";
    }

    @GetMapping("/usuario/{id}")
    public Optional<Usuario> usuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioRepo.findById(id);
    }

    @GetMapping("/todos")
    public List<Usuario> usuario(){
        return this.usuarioRepo.findAll();
    }

    @PostMapping("nuevo")
    public Usuario usuarios(@RequestBody Usuario usuario) {
        return this.usuarioRepo.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario usuario(@RequestBody Usuario usuario, @PathVariable("id") Long id) {
        Usuario actualizado = this.usuarioRepo.findById(id).orElse(null);
        actualizado.setNombre(usuario.getNombre());
        actualizado.setCant(usuario.getCant());
        actualizado.setFees(usuario.getFees());
        actualizado.setBlock(usuario.getBlock());

        return this.usuarioRepo.save(actualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        this.usuarioRepo.deleteById(id);
    }
}
