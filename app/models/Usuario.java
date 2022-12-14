package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import play.db.jpa.Model;

@Entity
public class Usuario extends Model {
    
    public String nome;
    public String email;
    public String senha;
    public String telefone;
    public String cpf;
    public String perfil;
    public String cidade;
    public String estado;
    public String idade;
    public String escolaridade;

    @Enumerated(EnumType.STRING)
    public Status status;

}
