package controllers;

import java.util.List;

import models.Curso;
import play.mvc.Controller;

public class Cursos extends Controller {
    
    public static void forms() {
        render();
    }

    public static void salvar(Curso curso) {
        curso.save();
        listar();
    }

    public static void listar() {
        List<Curso> cursos = Curso.findAll();
        render(cursos);
    }

    public static void remover(Long idCurso) {
        Curso c = Curso.findById(idCurso);
        c.delete();
        listar();
    }

    public static void editar(Long idCurso) {
        Curso c = Curso.findById(idCurso);
        renderTemplate("Cursos/forms.html", c);
    }
}
