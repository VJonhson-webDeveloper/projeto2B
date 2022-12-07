package models;

import javax.persistence.Entity;

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
    public Boolean status;

    public Usuario() {
        status = true;
    }

    public void inativar() {
        status = false;
    }

    public void ativar() {
        status = true;
    }

}
