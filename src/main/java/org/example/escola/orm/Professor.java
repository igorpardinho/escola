package org.example.escola.orm;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "professores")
public class Professor {

    @Deprecated
    public Professor() {

    }

    public Professor(String nome, String prontuario) {
        this.nome = nome;
        this.prontuario = prontuario;
    }

    @OneToMany(mappedBy = "professor")
    @Getter
    @Setter
    private List<Disciplina> disciplinas;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false)
    @Getter
    @Setter
    private String nome;

    @Column(nullable = false, unique = true)
    @Getter
    @Setter
    private String prontuario;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(disciplinas, professor.disciplinas) && Objects.equals(id, professor.id) && Objects.equals(nome, professor.nome) && Objects.equals(prontuario, professor.prontuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disciplinas, id, nome, prontuario);
    }

    @Override
    public String toString() {
        return "Professores{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", prontuario='" + prontuario + '\'' +
                "}";
    }
}
