package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import play.data.validation.Email;
import play.data.validation.Match;
import play.data.validation.Max;
import play.data.validation.Min;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Usuario extends Model {
    
    @Id
    @GeneratedValue
    public Long id;

    @Required
    public String nome;

    @Required
    @Email(message = "O email digitado não é válido!")
    public String email;

    @Required
    public String senha;

    @Required 
    @Match("[0-9]{2} [0-9]{5}-[0-9]{4}") 
    public String telefone;

    @Required
    @Match("[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}")
    public String cpf;

    @Required
    public String perfil;

    @Required
    public String cidade;

    @Required
    public String estado;

    @Required
    public String idade;

    @Required
    public String escolaridade;

    @Required 
    public Blob foto;

    //Implementando relacionamentos
    @ManyToMany
    @JoinTable(name="Usuario_Curso")
    public List<Curso> cursos;

    public Usuario() {
        status = Status.ATIVO;
        papel = Papel.USUARIO;
    }

    @Enumerated(EnumType.STRING)
    public Status status;

    @Enumerated(EnumType.STRING)
    public Papel papel;

}
