package org.example.escola.service;

import org.example.escola.repository.ProfessorRepository;
import org.example.escola.orm.Professor;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudProfessorService {
    private ProfessorRepository professorRepository;

    public CrudProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public void menu(Scanner scanner) {
        Boolean isTrue = true;
        while (isTrue) {
            System.out.println("Qual ação você deseja tomar? ");
            System.out.println("Digite 1 - para cadastrar um professor: ");
            System.out.println("Digite 0 - para voltar ao menu: ");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    cadastrarProfessor();

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

}
