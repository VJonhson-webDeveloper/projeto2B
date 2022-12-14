package controllers;

import java.util.Collections;
import java.util.List;

import org.hibernate.mapping.Collection;

import models.Curso;
import models.Status;
import models.Usuario;
import play.mvc.Controller;
import play.mvc.With;
import play.mvc.results.RenderTemplate;
import security.Administrador;
import security.Seguranca;

@With(Seguranca.class)
public class Usuarios extends Controller {

    public static void forms() {
        List<Curso> cursos = Curso.findAll();
        render(cursos);
    }

    public static void salvar(Usuario u) {
        long quantidade = Usuario.count("cpf = ?1", u.cpf);

        if (quantidade == 0) {
            u.save();
            flash.success("Cadastro realizado com sucesso!");

        } else {
            flash.error("Usuário já cadastrado, tente novamente!");
        }
        
        forms();
    }

    @Administrador
    public static void listar() {
        String termo = params.get("termo");
		
		List<Usuario> usuarios = Collections.EMPTY_LIST;
		if (termo == null || termo.isEmpty()) {
			usuarios = Usuario.find("status = ?1", Status.ATIVO).fetch();
		} else {
			usuarios = Usuario.find("(lower(nome) like ?1 OR cpf like ?2) AND status = ?3", 
					"%" + termo.toLowerCase() + "%",
					"%" + termo.toLowerCase() + "%",
                    Status.ATIVO).fetch();
		}
		render(usuarios, termo);
    }

    @Administrador
    public static void remover(Long id) {
        Usuario u = Usuario.findById(id);
        u.status = Status.INAVTIVO;
        u.save();
        flash.success("Usuário removido com sucesso!");
        listar();
    }

    public static void editar(Long id) {
        List<Curso> cursos = Curso.findAll();
        Usuario u = Usuario.findById(id);
        renderTemplate("Usuarios/forms.html", u, cursos);
    }

    
}
