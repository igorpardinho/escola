package org.example.escola;


import org.example.escola.service.CrudAlunoService;
import org.example.escola.service.CrudProfessorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class EscolaApplication implements CommandLineRunner {
    private CrudProfessorService professorService;
    private CrudAlunoService alunoService;

    public EscolaApplication(CrudProfessorService professorService, CrudAlunoService alunoService) {
        this.professorService = professorService;
        this.alunoService = alunoService;
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
            System.out.println("Digite 0 - para sair ");

            int digito = sc.nextInt();

            sc = new Scanner(System.in);
            switch (digito) {
                case 1:
                    professorService.menu(sc);
                    break;
                case 2:
                    alunoService.menu(sc);
                    break;
                default:
                    isTrue = false;

            }

        }
        System.out.println("saindo...");
    }
}
