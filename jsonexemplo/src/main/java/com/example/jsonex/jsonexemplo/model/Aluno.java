package com.example.jsonex.jsonexemplo.model;

public class Aluno {
    // Identificador único do aluno
    private Long id;
    private String nome;
    private int idade;
    private String curso;

    // Construtor vazio
    // Necessário para o Spring/Thymeleaf criar objetos
    public Aluno() {
    }

    // Construtor utilizado para criar alunos
    public Aluno(Long id, String nome, int idade, String curso) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
    }

    // GETTERS
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCurso() {
        return curso;
    }

    // SETTERS
    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
