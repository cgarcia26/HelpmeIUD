package co.edu.iudigital.helpmeuid.contoller;

import co.edu.iudigital.helpmeuid.dto.UsuarioDTO;
import co.edu.iudigital.helpmeuid.service.iface.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping("/signup")
    private ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO usuarioDTO){
        return  new ResponseEntity<>(
                usuarioService.save(usuarioDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> show(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(usuarioService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> index() {
        return ResponseEntity
                .ok()
                .body(usuarioService.findAll());
    }
    
}

