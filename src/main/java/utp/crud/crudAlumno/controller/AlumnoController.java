package utp.crud.crudAlumno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;
import utp.crud.crudAlumno.model.Alumno;
import utp.crud.crudAlumno.service.AlumnoService;


@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public List<Alumno> getAlumnos(){
        return alumnoService.getAlumnos();
    }

    @PostMapping
    public Alumno saveAlumno(@RequestBody Alumno alumno){
        return this.alumnoService.saveAlumno(alumno);
    }

    @GetMapping(path = "/{id}")
    public Optional<Alumno> getAlumnoById(@PathVariable("id") Integer id){
        return this.alumnoService.getById(id);

    }

    @PutMapping(path = "/{id}")
    public Alumno updateAlumnoById(@RequestBody Alumno request, @PathVariable("id") Integer id){
        return this.alumnoService.updateById(request, id);
    }

   //eliminar un alumno por id
    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Integer id){
      boolean ok = this.alumnoService.deleteAlumno(id);

        if(ok){
            return "Alumno eliminado";
        }else{
            return "Error al eliminar alumno";
        }
    }

}
