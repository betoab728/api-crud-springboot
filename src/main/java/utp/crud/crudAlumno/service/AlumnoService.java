package utp.crud.crudAlumno.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.crud.crudAlumno.model.Alumno;
import utp.crud.crudAlumno.repository.AlumnoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class AlumnoService {
    private static final Logger logger = LoggerFactory.getLogger(AlumnoService.class);

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> getAlumnos(){
        logger.info("Ejecutando el método getAlumnos()");

        // Verifica si el repositorio ha sido inyectado correctamente
        if (alumnoRepository == null) {
            logger.error("El repositorio de alumnos es nulo");
            throw new IllegalStateException("El repositorio de alumnos no está inicializado");
        }

        List<Alumno> alumnos;
        try {
            alumnos = alumnoRepository.findAll();
            logger.info("Número de alumnos encontrados: {}", alumnos.size());
        } catch (Exception e) {
            logger.error("Error al recuperar alumnos", e);
            throw e;  // Re-lanza la excepción para que pueda ser manejada por el controlador
        }

        return alumnos;
    }

    public Alumno saveAlumno(Alumno alumno){
        return alumnoRepository.save(alumno);
    }

    public Optional<Alumno> getById(Integer id) {
        return alumnoRepository.findById(id);
    }
    //login de usuario recibe nombre de usuario y contraseña




    public Alumno updateById(Alumno request, Integer id ) {
       try {
          //update alumno

           Alumno alumno = alumnoRepository.findById(id).get();
           alumno.setNombre(request.getNombre());
           alumno.setApellidoPaterno(request.getApellidoPaterno());
           alumno.setApellidoMaterno(request.getApellidoMaterno());
           alumno.setSexo(request.getSexo());
           alumno.setDireccion(request.getDireccion());
           alumno.setCorreo(request.getCorreo());
           alumno.setTelefono(request.getTelefono());
           alumno.setFechaNacimiento(request.getFechaNacimiento());
           alumno.setEstado(request.getEstado());

           return alumnoRepository.save(alumno);

        } catch (Exception e) {
            return null;
        }
    }

    public Boolean deleteAlumno(Integer id){
        try {

            alumnoRepository.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

}
