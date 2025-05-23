package com.cefet.ds_guia09.services;

import com.cefet.ds_guia09.dto.UsuarioDTO;
import com.cefet.ds_guia09.entities.Usuario;
import com.cefet.ds_guia09.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Gerador de senha aleatória segura
    private String gerarSenha(int tamanho) {
    String alfabeto = "ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz23456789";
    SecureRandom random = new SecureRandom();
    StringBuilder senha = new StringBuilder();
    for (int i = 0; i < tamanho; i++) {
    int index = random.nextInt(alfabeto.length());
    senha.append(alfabeto.charAt(index));
    }
    return senha.toString();
    }

    // Listar todos os usuários
    public List<UsuarioDTO> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioDTO::new).toList();
    }

    // Buscar usuário por ID
    public UsuarioDTO findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
        return new UsuarioDTO(usuario);
    }

    // Verificar se login já existe
    public boolean loginExiste(String login) {
        return usuarioRepository.existsByLogin(login);
    }

    // Inserir Usuário
    public UsuarioDTO insert(UsuarioDTO usuarioDTO) {
    // Verifica se já existe login
    if (usuarioRepository.existsByLogin(usuarioDTO.getLogin())){
    throw new IllegalArgumentException("Login já está em uso.");
    }
    Usuario usuario = new Usuario();
    usuario.setNome(usuarioDTO.getNome());
    usuario.setLogin(usuarioDTO.getLogin());
    usuario.setSenha(gerarSenha(6));
    Usuario usuarioSalvo = usuarioRepository.save(usuario);
    return new UsuarioDTO(usuarioSalvo);
    } 

    //Atualizar Usuário
    public UsuarioDTO update(Long id, UsuarioDTO usuarioDTO) {
    Usuario usuario = usuarioRepository.findById(id)
    .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));
    // Garante que o login não seja alterado
    if (usuarioDTO.getLogin() != null && !usuario.getLogin().equals(usuarioDTO.getLogin())) {
    throw new IllegalArgumentException("Não é permitido alterar o login.");
    }
    usuario.setNome(usuarioDTO.getNome());
    Usuario usuarioAtualizado = usuarioRepository.save(usuario);
    return new UsuarioDTO(usuarioAtualizado);
    }

    // Remover por ID
    public void delete(Long id) {
    if (!usuarioRepository.existsById(id)) {
    throw new EntityNotFoundException("Usuário não encontrado com ID: " + id);
    }
    usuarioRepository.deleteById(id);
    }

    public boolean verificarLogin(String login){
        return usuarioRepository.existsByLogin(login);
    }


}

