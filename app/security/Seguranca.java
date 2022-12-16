package security;

import controllers.Logins;
import models.Papel;
import play.mvc.Before;
import play.mvc.Controller;

public class Seguranca extends Controller {

    @Before
    static void checarLogin() {
        if (session.get("usuario") == null) {
            flash.error("É necessário se autenticar no sistema!");
            Logins.login();

        }
    }

    @Before
    static void verificarAdmin() {
        String papel = session.get("papel");
        Administrador admin = getActionAnnotation(Administrador.class);
        if (admin != null && !Papel.ADMIN.name().equals(papel)) {
            forbidden("Acesso restrito aos administradores do sistema!");
        }

    }
    
}
