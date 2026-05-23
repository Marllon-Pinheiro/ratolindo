package br.com.ratolindo.dto;

import br.com.ratolindo.repository.PessoaDao;

import java.util.UUID;

public class Pessoa {

    private UUID uuid;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;

    public Pessoa() {}

    public Pessoa(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {return telefone;}

    public void setTelefone(String telefone) { this.telefone = telefone;}


}
