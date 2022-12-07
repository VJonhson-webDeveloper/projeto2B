package controllers;

import org.junit.Before;

import play.mvc.Controller;

public class Seguranca extends Controller {
    
    @Before
    static void autenticarUsuarios() {

        if (session.contains("usuario.email") == false ) {
            Logins.login();
        }
    }
}
