package service;

import model.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    private List<Usuario> usuarios = new ArrayList<>();
    
    private final String ARQUIVO = "usuarios.txt";

    public UsuarioService() {
        carregarUsuarios();
    }

    public void cadastrarUsuario(String username, String senha) {

        Usuario novo = new Usuario(username, senha);
        usuarios.add(novo);
        salvarUsuarios();
    }

    public List<Usuario> listarUsuarios() {
        return usuarios;
    }
public Usuario buscarPorUsername(String username) {

    for (Usuario u : usuarios) {
        if (u.getUsername().equalsIgnoreCase(username)) {
            return u;
        }
    }

    return null;
}
    private void salvarUsuarios() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Usuario u : usuarios) {
                writer.write(u.getUsername() + ";" + u.getSenha());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar usuários.");
        }
    }

    private void carregarUsuarios() {
        File arquivo = new File(ARQUIVO);

        if (!arquivo.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                usuarios.add(new Usuario(dados[0], dados[1]));
            }

        } catch (IOException e) {
            System.out.println("Erro ao carregar usuários.");
        }
    }
}