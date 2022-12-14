package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Curso extends Model {

    public String titulo;
    public String descricao;
    public String foto;

    @Override
    public String toString() {
        return titulo + " | " + descricao;
    }
    
}
