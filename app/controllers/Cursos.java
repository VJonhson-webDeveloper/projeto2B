package controllers;

import java.util.List;

import models.Curso;
import play.mvc.Controller;
import play.mvc.With;


public class Cursos extends Controller {
    
    public static void forms() {
        render();
    }

    public static void salvar(Curso c) {
        c.save();
        listar();
    }

    public static void listar() {
        List<Curso> cursos = Curso.findAll();
        render(cursos);
    }

    public static void remover(Long id) {
        Curso c = Curso.findById(id);
        c.delete();
        listar();
    }

    public static void editar(Long id) {
        Curso c = Curso.findById(id);
        renderTemplate("Cursos/forms.html", c);
    }
}
