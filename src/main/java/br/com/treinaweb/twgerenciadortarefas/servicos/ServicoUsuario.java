package br.com.treinaweb.twgerenciadortarefas.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.treinaweb.twgerenciadortarefas.modelos.Usuario;
import br.com.treinaweb.twgerenciadortarefas.repositorios.RepositorioUsuario;

@Service
public class ServicoUsuario {
	
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Autowired
	private BCryptPasswordEncoder passwordEnconder;

	public Usuario encontrarPorEmail(String email) {
		return repositorioUsuario.findByEmail(email);

	}

	public void salvar(Usuario usuario) {
        usuario.setPassword(passwordEnconder.encode(usuario.getPassword()));
        repositorioUsuario.save(usuario);
	}

}
