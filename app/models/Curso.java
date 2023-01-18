package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import play.db.jpa.Model;

@Entity
public class Curso extends Model {

    public String titulo;
    public String descricao;
    public String foto;

    //Implementando relacionamentos
    @ManyToMany(mappedBy = "cursos")
    public List<Usuario> usuarios;

    @Override
    public String toString() {
        return titulo + " | " + descricao;
    }
    
}
