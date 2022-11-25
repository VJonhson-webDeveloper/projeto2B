package controllers;

import java.util.Collections;
import java.util.List;

import org.hibernate.mapping.Collection;

import models.Usuario;
import play.mvc.Controller;
import play.mvc.With;
import play.mvc.results.RenderTemplate;

@With(Segurança.class)
public class Usuarios extends Controller {

    public static void forms() {
        render();
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

    public static void listar() {
        String termo = params.get("termo");
		
		List<Usuario> usuarios = Collections.EMPTY_LIST;
		if (termo == null || termo.isEmpty()) {
			usuarios = Usuario.findAll();
		} else {
			usuarios = Usuario.find("(lower(nome) like ?1 OR cpf like ?2)", 
					"%" + termo.toLowerCase() + "%",
					"%" + termo.toLowerCase() + "%").fetch();
		}
		render(usuarios, termo);
    }

    public static void remover(Long id) {
        Usuario u = Usuario.findById(id);
        u.delete();
        listar();
    }

    public static void editar(Long id) {
        Usuario u = Usuario.findById(id);
        renderTemplate("Usuarios/forms.html", u);
    }
    
}
