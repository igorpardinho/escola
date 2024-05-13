package org.example.escola.repository;

import org.example.escola.orm.Disciplina;
import org.springframework.data.repository.CrudRepository;

public interface DisciplinaRepository extends CrudRepository<Disciplina, Long> {
}
