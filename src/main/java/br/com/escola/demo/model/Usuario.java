package br.com.escola.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class Usuario extends AbstractEntity {

    @NotEmpty(message = "Campo login obrigatório")
    @Column(unique = true)
    private String login;

    @NotEmpty(message = "Campo senha obrigatório")
    private String senha;

    private 

}
