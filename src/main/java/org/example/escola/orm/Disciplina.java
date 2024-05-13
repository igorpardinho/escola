package org.example.escola.orm;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "disciplinas")
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Disciplina {


    @ManyToOne
    @JoinColumn(name = "professor_id")
    @Getter @Setter
    @NonNull
    private Professor professor;

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
    @Column(unique = true, nullable = false)
    @NonNull
    private Integer semestre;


}
