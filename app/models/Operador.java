package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import play.db.jpa.Model;

@Entity
public class Operador extends Model {
    
    public String email;
    public String senha;

    @Enumerated(EnumType.STRING)
    public Papel papel;

    public Operador() {
        papel = Papel.USUARIO;
    }

}
