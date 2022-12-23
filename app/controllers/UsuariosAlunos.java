package controllers;

import java.util.List;

import models.Curso;
import models.Usuario;
import play.mvc.Controller;

public class UsuariosAlunos extends Controller {
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
}
