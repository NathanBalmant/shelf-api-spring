package com.cefet.ds_guia09.controllers;

import com.cefet.ds_guia09.dto.TipoDTO;
import com.cefet.ds_guia09.services.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos")
public class TipoController {

    @Autowired
    private TipoService tipoService;

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<TipoDTO> findById(@PathVariable Long id) {
        TipoDTO tipoDTO = tipoService.findById(id);
        return ResponseEntity.ok(tipoDTO);
    }

    // Buscar todos
    @GetMapping
    public ResponseEntity<List<TipoDTO>> findAll() {
        List<TipoDTO> tipoDTOs = tipoService.findAll();
        return ResponseEntity.ok(tipoDTOs);
    }

    // Inserir novo tipo
    @PostMapping
    public ResponseEntity<TipoDTO> create(@RequestBody TipoDTO tipoDTO) {
        TipoDTO novoTipo = tipoService.insert(tipoDTO);
        return ResponseEntity.status(201).body(novoTipo);
    }

    // Atualizar tipo
    @PutMapping("/{id}")
    public ResponseEntity<TipoDTO> update(@PathVariable Long id, @RequestBody TipoDTO tipoDTO) {
        TipoDTO tipoAtualizado = tipoService.update(id, tipoDTO);
        return ResponseEntity.ok(tipoAtualizado);
    }

    // Deletar tipo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tipoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
