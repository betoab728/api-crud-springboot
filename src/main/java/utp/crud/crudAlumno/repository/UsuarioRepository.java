package utp.crud.crudAlumno.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utp.crud.crudAlumno.model.Usuario;
import java.util.Optional;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

   // login de usuario recibe nombre de usuario y contraseña
   Optional<Usuario> findByNombre(String nombre);
}
