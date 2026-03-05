package service;

import model.Usuario;

public class AuthService {

    private UsuarioService usuarioService;

    public AuthService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public boolean login(String username, String senha) {
        Usuario usuario = usuarioService.buscarPorUsername(username);

        if (usuario != null && usuario.getSenha().equals(senha)) {
            return true;
        }

        return false;
    }
    
}