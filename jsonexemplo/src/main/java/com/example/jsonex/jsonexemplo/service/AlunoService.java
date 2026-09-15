package com.example.jsonex.jsonexemplo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.jsonex.jsonexemplo.model.Aluno;

@Service
public class AlunoService {
    // Lista que funciona como nosso "banco de dados"
    // temporário.
    private final List<Aluno> alunos = new ArrayList<>();
    // Variável usada para gerar IDs automaticamente.
    private Long proximoId = 1L;

    // Construtor do Service.
    public AlunoService() {
        // Utilizamos o próprio método cadastrar()
        // para criar os alunos iniciais.
        cadastrar(
                new Aluno(
                        null,
                        "João",
                        17,
                        "Desenvolvimento de Sistemas"));
        cadastrar(
                new Aluno(
                        null,
                        "Maria",
                        16,
                        "Desenvolvimento de Sistemas"));
        cadastrar(
                new Aluno(
                        null,
                        "Pedro",
                        18,
                        "Redes de Computadores"));
    }

    // ==================================================
    // READ - LISTAR TODOS
    // ==================================================
    public List<Aluno> listarTodos() {
        return alunos;
    }

    // ==================================================
    // READ - BUSCAR POR ID
    // ==================================================
    public Aluno buscarPorId(Long id) {
        // Percorre todos os alunos da lista.
        for (Aluno aluno : alunos) {
            // Verifica se o ID do aluno
            // é igual ao ID procurado.
            if (aluno.getId().equals(id)) {
                return aluno;
            }
        }
        // Caso não encontre, retorna null.
        return null;
    }

    // ==================================================
    // CREATE - CADASTRAR
    // ==================================================
    public void cadastrar(Aluno aluno) {
        // Define automaticamente o ID.
        aluno.setId(proximoId);
        // Incrementa o próximo ID.
        proximoId++;
        // Adiciona o aluno à lista.
        alunos.add(aluno);
    }

    // ==================================================
    // UPDATE - ATUALIZAR
    // ==================================================
    public boolean atualizar(Long id, Aluno alunoAtualizado) {
        // Primeiro procuramos o aluno.
        Aluno alunoExistente = buscarPorId(id);
        // Se não existir, não conseguimos atualizar.
        if (alunoExistente == null) {
            return false;
        }
        // Atualizamos os dados.
        alunoExistente.setNome(
                alunoAtualizado.getNome());
        alunoExistente.setIdade(
                alunoAtualizado.getIdade());
        alunoExistente.setCurso(
                alunoAtualizado.getCurso());
        return true;
    }

    // ==================================================
    // DELETE - EXCLUIR
    // ==================================================
    public boolean excluir(Long id) {
        // Busca o aluno.
        Aluno aluno = buscarPorId(id);
        // Verifica se existe.
        if (aluno == null) {
            return false;
        }
        // Remove da lista.
        alunos.remove(aluno);
        return true;
    }
}
