package com.example.jsonex.jsonexemplo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.jsonex.jsonexemplo.model.Aluno;
import com.example.jsonex.jsonexemplo.service.AlunoService;

@Controller
public class AlunoController {
    // O Controller depende do Service
    private final AlunoService alunoService;

    // Injeção de dependência
    //
    // O Spring cria o AlunoService e entrega
    // automaticamente para o Controller.
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    // ==================================================
    // LISTAR ALUNOS
    // ==================================================
    // GET
    // http://localhost:8080/alunos
    @GetMapping("/alunos")
    public String listarAlunos(Model model) {
        // Solicita os alunos para o Service
        model.addAttribute(
                "alunos",
                alunoService.listarTodos());
        // Abre:
        // templates/alunos.html
        return "alunos";
    }

    // ==================================================
    // ABRIR FORMULÁRIO DE CADASTRO
    // ==================================================
    // GET
    // http://localhost:8080/alunos/novo
    @GetMapping("/alunos/novo")
    public String novoAluno(Model model) {
        // Cria um aluno vazio para o formulário
        model.addAttribute(
                "aluno",
                new Aluno());
        // Podemos também enviar um título
        // para reaproveitar o mesmo formulário.
        model.addAttribute(
                "titulo",
                "Cadastrar Aluno");
        return "formulario-aluno";
    }

    // ==================================================
    // CADASTRAR
    // ==================================================
    // POST
    // http://localhost:8080/alunos
    @PostMapping("/alunos")
    public String cadastrarAluno(
            @ModelAttribute Aluno aluno) {
        // O Controller envia o aluno para o Service
        alunoService.cadastrar(aluno);
        // Depois faz nova requisição para GET /alunos
        return "redirect:/alunos";
    }

    // ==================================================
    // ABRIR FORMULÁRIO DE EDIÇÃO
    // ==================================================
    // Exemplo:
    // GET /alunos/2/editar
    @GetMapping("/alunos/{id}/editar")
    public String editarAluno(
            @PathVariable Long id,
            Model model) {
        // Busca o aluno no Service
        Aluno aluno = alunoService.buscarPorId(id);
        // Se o aluno não existir,
        // voltamos para a listagem.
        if (aluno == null) {
            return "redirect:/alunos";
        }
        // Envia o aluno existente para o formulário
        model.addAttribute(
                "aluno",
                aluno);
        model.addAttribute(
                "titulo",
                "Editar Aluno");
        return "formulario-aluno";
    }

    // ==================================================
    // ATUALIZAR
    // ==================================================
    // POST
    // /alunos/2/editar
    @PostMapping("/alunos/{id}/editar")
    public String atualizarAluno(
            @PathVariable Long id,
            @ModelAttribute Aluno aluno) {
        alunoService.atualizar(
                id,
                aluno);
        return "redirect:/alunos";
    }

    // ==================================================
    // EXCLUIR
    // ==================================================
    // POST
    // /alunos/2/excluir
    @PostMapping("/alunos/{id}/excluir")
    public String excluirAluno(
            @PathVariable Long id) {
        alunoService.excluir(id);
        return "redirect:/alunos";
    }
}
