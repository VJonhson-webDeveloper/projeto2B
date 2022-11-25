package controllers;

import org.junit.Before;

import play.mvc.Controller;

public class Segurança extends Controller {
    
    @Before
    static void autenticarUsuarios() {
        if (session.get("usuario") == null) {
            flash.error("É necessário se autenticar no sistema!");
            Logins.login();
        }
    }
}
