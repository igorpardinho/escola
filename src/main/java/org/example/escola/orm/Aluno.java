package org.example.escola.orm;


import jakarta.persistence.*;
import lombok.*;


import java.util.HashSet;

import java.util.Set;


@Entity
@Table(name = "alunos")
public class Aluno {

    @Deprecated
    public Aluno() {

    }

    public Aluno(String nome, String cpf, String telefone, String email, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "alunos")
    private Set<Disciplina> disciplinas = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @NonNull
    @Getter
    @Setter
    @Column(nullable = false)
    private String nome;

    @NonNull
    @Getter
    @Setter
    @Column(nullable = false, unique = true)
    private String cpf;

    @NonNull
    @Getter
    @Setter
    @Column(nullable = false)
    private String telefone;

    @NonNull
    @Getter
    @Setter
    @Column(nullable = false, unique = true)
    private String email;

    @NonNull
    @Getter
    @Setter
    @Column(nullable = false)
    private String endereco;

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
