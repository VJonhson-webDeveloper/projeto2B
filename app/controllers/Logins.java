package controllers;

import models.Operador;
import models.Usuario;
import play.libs.Crypto;
import play.mvc.Controller;

public class Logins extends Controller {

    public static void login() {
        render();
    }

    public static void logar(String email, String senha) {
        Operador operador = Operador.find("login = ?1 and senha = ?2", email, Crypto.passwordHash(senha)).first();

        if (operador == null) {
            flash.error("Email ou senha inválidos");
            login();

        } else {
            session.put("operador", operador.email);
            session.put("papel", operador.papel);
            Usuarios.listar();
        }

    }

    public static void logout() {
        session.clear();
        flash.success("Você saiu do sistema!");
        login();
    }
}
