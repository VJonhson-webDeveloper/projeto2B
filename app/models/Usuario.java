package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import play.db.jpa.Blob;
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
    public Blob foto;

    public Usuario () {
        status = Status.ATIVO;
        papel = Papel.USUARIO;
    }

    @Enumerated(EnumType.STRING)
    public Status status;

    @Enumerated(EnumType.STRING)
    public Papel papel;

}
