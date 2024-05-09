package org.example.escola.Repository;

import org.example.escola.orm.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor,Long> {

}
