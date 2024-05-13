package org.example.escola.orm;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "professores")
public class Professor {

    @OneToMany(mappedBy = "professor")
    @Getter
    @Setter
    private List<Disciplina> disciplinas;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false)
    @NonNull
    private String nome;

    @Getter
    @Setter
    @Column(nullable = false, unique = true)
    @NonNull
    private String prontuario;


}
