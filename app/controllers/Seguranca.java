package controllers;

import org.junit.Before;

import play.mvc.Controller;

public class Seguranca extends Controller {
    
    @Before
    static void verificar() {

        if (session.get("usuario") == null) {
            flash.error("É preciso se autenticar no sistema!");
            Logins.login();
        }
    }
}
