package controllers;

import java.util.List;

import models.Curso;
import models.Usuario;
import play.cache.Cache;
import play.data.validation.Valid;
import play.libs.Crypto;
import play.mvc.Controller;

public class UsuariosAlunos extends Controller {
    public static void forms() {
        Usuario u = (Usuario) Cache.get("usuario");
        Cache.clear();

        List<Curso> cursos = Curso.findAll();
        render(cursos, u);
    }

    public static void salvar(@Valid Usuario u) {
        //se houve algum erro ao tentar salvar
        if (validation.hasErrors()) {

            //guarde as mensagens de erro e exiba no formulario
            validation.keep();
            flash.error("Falha ao salvar os seus dados.");

            Cache.set("usuario", u);
            forms();
        }

        long quantidade = Usuario.count("cpf = ?1", u.cpf);
        if (quantidade == 0) {
            u.senha = Crypto.passwordHash(u.senha);
            u.save();
            flash.success("Cadastro realizado com sucesso!");

        } else {
            flash.error("Usuário já cadastrado, tente novamente!");
        }
        
        forms();
    }
}
