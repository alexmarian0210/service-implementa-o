package com.example.jsonex.jsonexemplo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.jsonex.jsonexemplo.model.Aluno;
import com.example.jsonex.jsonexemplo.service.AlunoService;


@Controller
public class AlunoController {


    // O Controller precisa de um AlunoService.
    private final AlunoService alunoService;


    // INJEÇÃO DE DEPENDÊNCIA
    //
    // O Spring cria o AlunoService e entrega
    // automaticamente para o Controller.
    public AlunoController(AlunoService alunoService) {

        this.alunoService = alunoService;
    }


    // ------------------------------------------------
    // LISTAR ALUNOS
    // ------------------------------------------------

    // GET
    // http://localhost:8080/alunos

    @GetMapping("/alunos")
    public String listarAlunos(Model model) {


        // Agora o Controller não acessa mais
        // diretamente a lista.
        //
        // Ele solicita os alunos para o Service.
        model.addAttribute(
            "alunos",
            alunoService.listarTodos()
        );


        // Abre:
        // templates/alunos.html
        return "alunos";
    }


    // ------------------------------------------------
    // ABRIR FORMULÁRIO
    // ------------------------------------------------

    // GET
    // http://localhost:8080/alunos/novo

    @GetMapping("/alunos/novo")
    public String abrirFormulario(Model model) {


        // Cria um objeto vazio
        // para o formulário preencher.
        model.addAttribute(
            "aluno",
            new Aluno()
        );


        return "formulario-aluno";
    }


    // ------------------------------------------------
    // CADASTRAR ALUNO
    // ------------------------------------------------

    // POST
    // http://localhost:8080/alunos

    @PostMapping("/alunos")
    public String cadastrarAluno(
            @ModelAttribute Aluno aluno) {


        // O Controller não adiciona mais
        // o aluno diretamente na lista.
        //
        // Ele solicita essa operação ao Service.
        alunoService.cadastrar(aluno);


        // Após cadastrar,
        // realiza uma nova requisição GET /alunos.
        return "redirect:/alunos";
    }
}
