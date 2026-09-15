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
    private final AlunoService alunoService;

    // Injeção de dependência
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    // ==================================================
    // LISTAR
    // ==================================================
    @GetMapping("/alunos")
    public String listarAlunos(Model model) {
        model.addAttribute(
                "alunos",
                alunoService.listarTodos());
        return "alunos";
    }

    // ==================================================
    // ABRIR FORMULÁRIO DE CADASTRO
    // ==================================================
    @GetMapping("/alunos/novo")
    public String abrirFormulario(Model model) {
        model.addAttribute(
                "aluno",
                new Aluno());
        return "formulario-aluno";
    }

    // ==================================================
    // CADASTRAR
    // ==================================================
    @PostMapping("/alunos")
    public String cadastrarAluno(
            @ModelAttribute Aluno aluno) {
        alunoService.cadastrar(aluno);
        return "redirect:/alunos";
    }

    // ==================================================
    // ABRIR FORMULÁRIO DE EDIÇÃO
    // ==================================================
    @GetMapping("/alunos/editar/{id}")
    public String abrirEdicao(
            @PathVariable Long id,
            Model model) {
        // Busca o aluno pelo ID.
        Aluno aluno = alunoService.buscarPorId(id);
        // Envia o aluno encontrado
        // para o formulário.
        model.addAttribute(
                "aluno",
                aluno);
        return "editar-aluno";
    }

    // ==================================================
    // ATUALIZAR
    // ==================================================
    @PostMapping("/alunos/editar/{id}")
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
    @GetMapping("/alunos/excluir/{id}")
    public String excluirAluno(
            @PathVariable Long id) {
        alunoService.excluir(id);
        return "redirect:/alunos";
    }
}
