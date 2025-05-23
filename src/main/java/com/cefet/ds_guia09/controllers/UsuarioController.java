package com.cefet.ds_guia09.controllers;

import com.cefet.ds_guia09.dto.UsuarioDTO;

import com.cefet.ds_guia09.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Listar todos os usuários
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<UsuarioDTO> lista = usuarioService.findAll();
        return ResponseEntity.ok(lista);
    }

    // Buscar usuário por ID
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
        UsuarioDTO dto = usuarioService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO usuarioDTO) {
    UsuarioDTO usuarioNovo = usuarioService.insert(usuarioDTO);
    return ResponseEntity.status(201).body(usuarioNovo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
    UsuarioDTO usuarioAtualizado = usuarioService.update(id, usuarioDTO);
    return ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
    usuarioService.delete(id);
    return ResponseEntity.noContent().build();
    }

    @GetMapping("/existe")
    public ResponseEntity<Boolean> loginExiste(@RequestParam String login){
        boolean resultado = usuarioService.verificarLogin(login);
        return ResponseEntity.ok(resultado);
        

    }

}
