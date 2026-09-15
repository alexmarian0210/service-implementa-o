package com.example.jsonex.jsonexemplo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.jsonex.jsonexemplo.model.Aluno;


// Indica ao Spring que esta classe é um Service.
//
// O Service normalmente concentra:
// - regras de negócio;
// - processamento;
// - manipulação dos dados;
// - comunicação futura com o Repository.
@Service
public class AlunoService {


    // Lista que armazena os alunos temporariamente.
    //
    // Ainda não estamos utilizando banco de dados.
    private final List<Aluno> alunos = new ArrayList<>();


    // Construtor do Service.
    //
    // Quando o Spring criar o AlunoService,
    // esses alunos serão adicionados à lista.
    public AlunoService() {

        alunos.add(
            new Aluno(
                "João",
                17,
                "Desenvolvimento de Sistemas"
            )
        );

        alunos.add(
            new Aluno(
                "Maria",
                16,
                "Desenvolvimento de Sistemas"
            )
        );

        alunos.add(
            new Aluno(
                "Pedro",
                18,
                "Redes de Computadores"
            )
        );
    }


    // Retorna todos os alunos cadastrados.
    public List<Aluno> listarTodos() {

        return alunos;
    }


    // Recebe um objeto Aluno
    // e adiciona na lista.
    public void cadastrar(Aluno aluno) {

        alunos.add(aluno);
    }
}
