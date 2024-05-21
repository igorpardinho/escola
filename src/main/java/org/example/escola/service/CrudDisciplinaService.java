package org.example.escola.service;

import jakarta.transaction.Transactional;
import org.example.escola.orm.Disciplina;
import org.example.escola.orm.Professor;
import org.example.escola.repository.DisciplinaRepository;
import org.example.escola.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Transactional
@Service
public class CrudDisciplinaService {
    private DisciplinaRepository disciplinaRepository;
    private ProfessorRepository professorRepository;

    public CrudDisciplinaService(DisciplinaRepository disciplinaRepository, ProfessorRepository professorRepository) {
        this.disciplinaRepository = disciplinaRepository;
        this.professorRepository = professorRepository;
    }


    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("Qual ação você deseja tomar? ");
            System.out.println("Digite 1 - para cadastrar uma disciplina: ");
            System.out.println("Digite 2 - para listar as disciplinas: ");
            System.out.println("Digite 3 - para atualizar uma disciplina: ");
            System.out.println("Digite 4 - para deletar uma disciplina: ");
            System.out.println("Digite 0 - para voltar ao menu: ");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    this.cadastrarDisciplina();
                    break;
                case 2:
                    this.listarDisciplinas();
                    break;
                case 3:
                    this.atualizarDisciplina();
                    break;
                case 4:
                    this.deletarDisciplina();
                    break;
                default:
                    isTrue = false;
                    break;
            }
        }
        System.out.println();

    }


    private void deletarDisciplina() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o id da disciplina que deseja deletar: ");
        Long id = sc.nextLong();
        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
        if (disciplina.isPresent()) {
            disciplinaRepository.deleteById(id);
            System.out.println("Disciplina deletada com sucesso!");
        } else {
            System.out.println("Disciplina não encontrado");
        }
    }


    private void cadastrarDisciplina() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome da disciplina que deseja adicionar: ");
        String nome = sc.nextLine();

        System.out.println("Digite o numero do semestre da disciplina: ");
        Integer semestre = sc.nextInt();


        System.out.println("Digite o ID do Professor:");
        Long professorId = sc.nextLong();
        Optional<Professor> optionalProfessor = professorRepository.findById(professorId);
        if (optionalProfessor.isPresent()) {
            Professor professor = optionalProfessor.get();
            Disciplina disciplina = new Disciplina(nome, semestre, professor);
            disciplinaRepository.save(disciplina);
            System.out.println("Disciplina cadastrado com sucesso!");
        } else {
            System.out.println("ID do Professor não encontrado");
        }

    }

    private void listarDisciplinas() {
        Iterable<Disciplina> disciplinas = disciplinaRepository.findAll();
        if (disciplinas.iterator().hasNext()) {
            disciplinas.forEach(System.out::println);
        } else {
            System.out.println("Nenhuma disciplina encontrado");
        }

        System.out.println();

    }

    private void atualizarDisciplina() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o id da Disciplina pra atualizar");
        Long id = sc.nextLong();

        Optional<Disciplina> optionalDisciplina = disciplinaRepository.findById(id);

        if (optionalDisciplina.isPresent()) {
            System.out.println("O que deseja atualizar na Disciplina? ");
            System.out.println("1 - nome/ 2 - semestre");
            Scanner sc2 = new Scanner(System.in);
            int option2 = sc2.nextInt();
            Disciplina disciplina = optionalDisciplina.get();
            switch (option2) {

                case 1:
                    sc = new Scanner(System.in);
                    System.out.println("Digite o nome da disciplina: ");
                    String nome = sc.nextLine();
                    disciplina.setNome(nome);
                    break;

                case 2:
                    sc = new Scanner(System.in);
                    System.out.println("Digite o semestre da disciplina: ");
                    Integer semestre = sc.nextInt();
                    disciplina.setSemestre(semestre);
                    break;

                default:
                    System.out.println("acao nao encontrada");
                    break;
            }

            disciplinaRepository.save(disciplina);

        } else {
            System.out.println("Disciplina não encontrada");
        }
    }

}
