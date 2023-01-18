package controllers;

import models.Usuario;
import play.libs.Crypto;
import play.mvc.Controller;

public class Logins extends Controller {

    public static void login() {
        render();
    }

    public static void logar(String email, String senha) {
        Usuario usuario = Usuario.find("email = ?1 and senha = ?2", email, Crypto.passwordHash(senha)).first();

        if (usuario == null) {
            flash.error("Email ou senha inválidos");
            login();

        } else {
            session.put("usuario", usuario.email);
            session.put("papel", usuario.papel);
            flash.success("Seja bem-vindo!");
            UsuariosAdmin.detalhar(usuario.id);
        } 

    }

    public static void logout() {
        session.clear();
        flash.success("Você saiu do sistema!");
        login();
    }
}
