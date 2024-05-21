package org.example.escola.orm;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "disciplinas")
public class Disciplina {

    @Deprecated
    public Disciplina() {

    }

    public Disciplina(String nome, Integer semestre, Professor professor) {
        this.nome = nome;
        this.semestre = semestre;
        this.professor = professor;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "disciplinas_alunos", joinColumns = @JoinColumn(name = "disciplina_fk"), inverseJoinColumns = @JoinColumn(name = "aluno_fk")
    )
    private Set<Aluno> alunos = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;


    @Column(nullable = false)
    @Getter
    @Setter
    private String nome;


    @Column(unique = true, nullable = false)
    @Getter
    @Setter
    private Integer semestre;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return Objects.equals(professor, that.professor) && Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(semestre, that.semestre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(professor, id, nome, semestre);
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "alunos=" + alunos +
                ", professor=" + professor +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", semestre=" + semestre +
                '}';
    }
}
