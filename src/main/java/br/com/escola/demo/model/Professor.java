package br.com.escola.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class Professor extends AbstractEntity {

    @NotEmpty(message = "Campo nome obrigatório")
    private String nome;

    @Email(message = "Email inválido.")
    @NotEmpty(message = "Campo email obrigatório")
    @Column(unique = true)
    private String email;

    public Professor() {
    }

    public Professor(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
