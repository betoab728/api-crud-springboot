package utp.crud.crudAlumno.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import utp.crud.crudAlumno.model.Alumno;


@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {



}
