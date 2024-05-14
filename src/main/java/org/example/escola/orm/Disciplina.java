package org.example.escola.orm;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

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
        return "Professor:{" + professor + "= Disciplina{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", semestre=" + semestre +
                "}}";
    }


}
