package org.example.escola.service;


import org.example.escola.repository.ProfessorRepository;
import org.example.escola.orm.Professor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudProfessorService {
    private ProfessorRepository professorRepository;

    public CrudProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public void menu(Scanner scanner) {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("Qual ação você deseja tomar? ");
            System.out.println("Digite 1 - para cadastrar um professor: ");
            System.out.println("Digite 2 - para listar os professores: ");
            System.out.println("Digite 3 - para atualizar um professor: ");
            System.out.println("Digite 0 - para voltar ao menu: ");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    cadastrarProfessor();

                    break;
                case 2:
                    listarProfessores();
                    break;
                case 3:
                    atualizarProfessor();
                    break;
                default:
                    isTrue = false;
                    break;
            }
        }
        System.out.println();

    }

    private void cadastrarProfessor() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do professor: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o numero do prontuario do professor: ");
        String numProntuario = scanner.nextLine();

        Professor professor = new Professor(nome, numProntuario);
        professorRepository.save(professor);
        System.out.println("Professor cadastrado com sucesso!");

    }

    private void listarProfessores() {
        professorRepository.findAll().forEach(System.out::println);
    }

    private void atualizarProfessor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o id do Professor pra atualizar");
        Long id = sc.nextLong();

        Optional<Professor> optionalProfessor = professorRepository.findById(id);

        if (optionalProfessor.isPresent()) {
            System.out.println("O que deseja atualizar no professor? ");
            System.out.println("1 - nome/ 2 - prontuario");
            Scanner sc2 = new Scanner(System.in);
            int option2 = sc2.nextInt();
            Professor professor = optionalProfessor.get();
            switch (option2) {

                case 1:
                    sc = new Scanner(System.in);
                    System.out.println("Digite o nome do professor: ");
                    String nome = sc.nextLine();
                    professor.setNome(nome);
                    break;

                case 2:
                    sc = new Scanner(System.in);
                    System.out.println("Digite o numero de prontuario: ");
                    String prontuario = sc.nextLine();
                    professor.setProntuario(prontuario);
                    break;
                default:
                    System.out.println("acao nao encontrada");
                    break;
            }
            professorRepository.save(professor);

        } else {
            System.out.println("Professor não encontrado");
        }

    }
}
