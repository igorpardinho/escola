package org.example.escola.orm;

import jakarta.persistence.*;
import lombok.*;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    @Column(nullable = false)
    @NonNull
    private String nome;

    @Getter @Setter
    @Column(nullable = false,unique = true)
    @NonNull
    private String prontuario;


}
