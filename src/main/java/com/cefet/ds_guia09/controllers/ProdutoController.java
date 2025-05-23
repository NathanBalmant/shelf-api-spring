package com.cefet.ds_guia09.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cefet.ds_guia09.dto.ProdutoDTO;
import com.cefet.ds_guia09.services.ProdutoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable long id) {
        ProdutoDTO produtoDTO = produtoService.findById(id);
        return ResponseEntity.ok(produtoDTO);
    }
    @GetMapping("/tipo/{tipoId}")
    public ResponseEntity<List<ProdutoDTO>> findByTipoId (@PathVariable long tipoId){
        List<ProdutoDTO> produtosDTO = produtoService.findByTipoId(tipoId);
        return ResponseEntity.ok(produtosDTO);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAll() {
    List<ProdutoDTO> produtosDTOs = produtoService.findAll();
    return ResponseEntity.ok(produtosDTOs);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> create(@RequestBody ProdutoDTO produtoDTO) {
    ProdutoDTO novoProduto = produtoService.insert(produtoDTO);
    return ResponseEntity.status(201).body(novoProduto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> update(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
    ProdutoDTO produtoAtualizado = produtoService.update(id, produtoDTO);
    return ResponseEntity.ok(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
    produtoService.delete(id);
    return ResponseEntity.noContent().build();
    }




}
