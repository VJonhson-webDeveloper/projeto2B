package controllers;

import java.util.List;

import models.Curso;
import play.mvc.Controller;
import play.mvc.With;
import security.Administrador;
import security.Seguranca;

@With(Seguranca.class)
public class Cursos extends Controller {
    
    @Administrador
    public static void forms() {
        render();
    }

    @Administrador
    public static void salvar(Curso c, Long id) {
        c.save();
        UsuariosAdmin.listarCursos(id);
    }

    @Administrador
    public static void listar() {
        List<Curso> cursos = Curso.findAll();
        render(cursos);
    }

    @Administrador
    public static void remover(Long id) {
        Curso c = Curso.findById(id);
        c.delete();
        listar();
    }

    @Administrador
    public static void editar(Long id) {
        Curso c = Curso.findById(id);
        renderTemplate("Cursos/forms.html", c);
    }
}
