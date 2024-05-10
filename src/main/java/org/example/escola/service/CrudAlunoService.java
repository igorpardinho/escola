package org.example.escola.service;

import org.example.escola.repository.AlunoRepository;
import org.example.escola.orm.Aluno;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudAlunoService {

    private AlunoRepository alunoRepository;

    public CrudAlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public void menu(Scanner scanner) {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("Qual ação você deseja tomar? ");
            System.out.println("Digite 1 - para cadastrar um aluno: ");
            System.out.println("Digite 2 - para listar os alunos: ");
            System.out.println("Digite 3 - para atualizar um aluno: ");
            System.out.println("Digite 0 - para voltar ao menu: ");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    listarAlunos();
                    break;
                case 3:
                    atualizarAluno();
                    break;
                default:
                    isTrue = false;
                    break;
            }
        }
        System.out.println();

    }


    private void cadastrarAluno() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do aluno: ");
        String nome = sc.nextLine();

        System.out.println("Digite o numero do cpf do aluno: ");
        String cpf = sc.nextLine();

        System.out.println("Digite o numero do telelefone do aluno: ");
        String telefone = sc.nextLine();

        System.out.println("Digite o email do aluno: ");
        String email = sc.nextLine();

        System.out.println("Digite o endereço do aluno: ");
        String endereco = sc.nextLine();

        Aluno aluno = new Aluno(nome, cpf, telefone, email, endereco);
        alunoRepository.save(aluno);

    }

    private void listarAlunos() {
        System.out.println(alunoRepository.findAll());

    }

    private void atualizarAluno() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o id do Aluno pra atualizar");
        Long id = sc.nextLong();

        Optional<Aluno> optionalAluno = this.alunoRepository.findById(id);

        if (optionalAluno.isPresent()) {
            System.out.println("O que deseja atualizar no aluno? ");
            System.out.println("1 - nome/ 2 - cpf/ 3 - telefone/ 4 - email/ 5 - endereco");
            Scanner sc2 = new Scanner(System.in);
            int option2 = sc2.nextInt();
            Aluno aluno = optionalAluno.get();
            switch (option2) {

                case 1:
                    sc = new Scanner(System.in);
                    System.out.println("Digite o nome do aluno: ");
                    String nome = sc.nextLine();
                    aluno.setNome(nome);
                    break;

                case 2:
                    sc = new Scanner(System.in);
                    System.out.println("Digite o cpf do aluno: ");
                    String cpf = sc.nextLine();
                    aluno.setCpf(cpf);
                    break;
                case 3:
                    sc = new Scanner(System.in);
                    System.out.println("Digite o telefone do aluno: ");
                    String telefone = sc.nextLine();
                    aluno.setTelefone(telefone);
                    break;
                case 4:
                    sc = new Scanner(System.in);
                    System.out.println("Digite o email do aluno: ");
                    String email = sc.nextLine();
                    aluno.setEmail(email);
                    break;
                case 5:
                    sc = new Scanner(System.in);
                    System.out.println("Digite o endereco do aluno: ");
                    String endereco = sc.nextLine();
                    aluno.setEndereco(endereco);
                    break;
                default:
                    System.out.println("acao nao encontrada");
                    break;
            }

            alunoRepository.save(aluno);

        } else {
            System.out.println("Aluno não encontrado");
        }
    }

}

