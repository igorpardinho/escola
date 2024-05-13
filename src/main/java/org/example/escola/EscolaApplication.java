package org.example.escola;


import org.example.escola.service.CrudAlunoService;
import org.example.escola.service.CrudDisciplinaService;
import org.example.escola.service.CrudProfessorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class EscolaApplication implements CommandLineRunner {
    private final CrudProfessorService PROFESSOR_SERVICE;
    private final CrudAlunoService ALUNO_SERVICE;
    private final CrudDisciplinaService DISCIPLINA_SERVICE;

    public EscolaApplication(CrudProfessorService PROFESSOR_SERVICE, CrudAlunoService ALUNO_SERVICE, CrudDisciplinaService DISCIPLINA_SERVICE) {
        this.PROFESSOR_SERVICE = PROFESSOR_SERVICE;
        this.ALUNO_SERVICE = ALUNO_SERVICE;
        this.DISCIPLINA_SERVICE = DISCIPLINA_SERVICE;
    }


    public static void main(String[] args) {
        SpringApplication.run(EscolaApplication.class, args);

    }

    @Override
    public void run(String... args) {

        Scanner sc = new Scanner(System.in);
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("Qual entidade você deseja interagir?:");
            System.out.println("Digite 1 - para interagir com o professor");
            System.out.println("Digite 2 - para interagir com o aluno");
            System.out.println("Digite 3 - para interagir com a disciplina");
            System.out.println("Digite 0 - para sair ");

            int digito = sc.nextInt();

            sc = new Scanner(System.in);
            switch (digito) {
                case 1:
                    PROFESSOR_SERVICE.menu();
                    break;
                case 2:
                    ALUNO_SERVICE.menu();
                    break;
                case 3:
                    DISCIPLINA_SERVICE.menu();
                    break;
                default:
                    isTrue = false;

            }

        }
        System.out.println("saindo...");
    }
}
