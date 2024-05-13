package org.example.escola.orm;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "alunos")
public class Aluno {


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
}
