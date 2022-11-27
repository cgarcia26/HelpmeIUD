package co.edu.iudigital.helpmeuid.service.iface;

import co.edu.iudigital.helpmeuid.dto.UsuarioDTO;

import java.util.List;

public interface IUsuarioService {

    // Consultar todos
    List<UsuarioDTO> findAll();

    // Consultar por ID
    UsuarioDTO findById(Long id);

    // Guardar
    UsuarioDTO save(UsuarioDTO usuarioDTO);

    // Consultar por username
    UsuarioDTO findByUsername(String username);

}
