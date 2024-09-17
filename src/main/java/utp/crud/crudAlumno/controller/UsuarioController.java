package utp.crud.crudAlumno.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utp.crud.crudAlumno.model.Usuario;
import utp.crud.crudAlumno.service.UsuarioService;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    public Usuario registerUser(@RequestBody Usuario usuario) {
        return usuarioService.registerUser(usuario);
    }

    @GetMapping
    public List<Usuario> getAllUsers() {
        return usuarioService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Usuario getUserById(@PathVariable Integer id) {
        return usuarioService.getUserById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Integer id) {
        usuarioService.deleteUserById(id);
    }
}
