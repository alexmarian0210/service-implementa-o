package com.example.jsonex.jsonexemplo.model;

public class Aluno {
    private String nome;
    private int idade;
    private String curso;

    // 1. Construtor vazio (OBRIGATÓRIO para o formulário Thymeleaf)
    public Aluno() {
    }

    // 2. Construtor com argumentos (que você já tinha)
    public Aluno(String nome, int idade, String curso) {
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; } // Setters são OBRIGATÓRIOS agora

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }
} 