package br.com.escola.exame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Usuario extends AbstractEntity {

    @NotEmpty(message = "Campo login obrigatório")
    @Column(unique = true)
    private String login;

    @NotEmpty(message = "Campo senha obrigatório")
    private String senha;

    public Usuario(String login, String senha, Professor professor) {
        this.login = login;
        this.senha = senha;
        this.professor = professor;
    }

    public Usuario() {
    }

    @OneToOne
    private Professor professor;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

}
