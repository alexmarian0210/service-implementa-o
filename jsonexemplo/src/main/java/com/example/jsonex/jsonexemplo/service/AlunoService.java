package com.example.jsonex.jsonexemplo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.jsonex.jsonexemplo.model.Aluno;

// Indica ao Spring que esta classe pertence
// à camada de serviço da aplicação.
@Service
public class AlunoService {
    // Lista que simula temporariamente um banco de dados.
    private final List<Aluno> alunos = new ArrayList<>();
    // Variável responsável pela geração dos IDs.
    private Long proximoId = 1L;

    // Construtor executado quando o Service é criado.
    public AlunoService() {
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

    // =================================================
    // LISTAR TODOS
    // READ
    // =================================================
    public List<Aluno> listarTodos() {
        return alunos;
    }

    // =================================================
    // BUSCAR POR ID
    // READ
    // =================================================
    public Aluno buscarPorId(Long id) {
        for (Aluno aluno : alunos) {
            if (aluno.getId().equals(id)) {
                return aluno;
            }
        }
        // Caso nenhum aluno seja encontrado
        return null;
    }

    // =================================================
    // CADASTRAR
    // CREATE
    // =================================================
    public Aluno cadastrar(Aluno aluno) {
        // Define o ID automaticamente
        aluno.setId(proximoId);
        // Incrementa para o próximo cadastro
        proximoId++;
        // Adiciona na lista
        alunos.add(aluno);
        // Retorna o aluno cadastrado
        return aluno;
    }

    // =================================================
    // ATUALIZAR
    // UPDATE
    // =================================================
    public Aluno atualizar(Long id, Aluno alunoAtualizado) {
        // Procura o aluno que já existe
        Aluno alunoExistente = buscarPorId(id);
        // Se não encontrar, retorna null
        if (alunoExistente == null) {
            return null;
        }
        // Atualiza apenas os dados que podem ser alterados
        alunoExistente.setNome(
                alunoAtualizado.getNome());
        alunoExistente.setIdade(
                alunoAtualizado.getIdade());
        alunoExistente.setCurso(
                alunoAtualizado.getCurso());
        return alunoExistente;
    }

    // =================================================
    // EXCLUIR
    // DELETE
    // =================================================
    public boolean excluir(Long id) {
        // Procura o aluno
        Aluno aluno = buscarPorId(id);
        // Verifica se existe
        if (aluno == null) {
            return false;
        }
        // Remove da lista
        alunos.remove(aluno);
        return true;
    }
}
