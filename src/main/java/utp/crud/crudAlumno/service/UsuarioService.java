package utp.crud.crudAlumno.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import utp.crud.crudAlumno.model.Usuario;
import utp.crud.crudAlumno.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario registerUser(Usuario usuario) {
        // Encriptar contraseña antes de guardar
        usuario.setClave(passwordEncoder.encode(usuario.getClave()));
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUserById(Integer id) {
        return usuarioRepository.findById(id);
    }

    public void deleteUserById(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
