package org.example.escola.service;

import org.example.escola.Repository.AlunoRepository;
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
            System.out.println("Digite 0 - para voltar ao menu: ");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    listarAlunos();
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
    private void atualizarAluno(Scanner sc) {
        System.out.println("Digite o id do Aluno pra atualizar");
        Long id = sc.nextLong();

        Optional<Aluno> optionalAluno = this.alunoRepository.findById(id);

        if (optionalAluno.isPresent()) {
            Aluno aluno = optionalAluno.get();
            aluno.setNome(sc.nextLine());
            aluno.setCpf(sc.nextLine());
            aluno.setTelefone(sc.nextLine());
            aluno.setEmail(sc.nextLine());
            aluno.setEndereco(sc.nextLine());
            alunoRepository.save(aluno);

        }else {
            System.out.println("Aluno não encontrado");
        }
    }

}

