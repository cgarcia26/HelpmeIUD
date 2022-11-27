package co.edu.iudigital.helpmeuid.service.impl;

import co.edu.iudigital.helpmeuid.dto.UsuarioDTO;
import co.edu.iudigital.helpmeuid.model.Usuario;
import co.edu.iudigital.helpmeuid.repository.IUsuarioRepository;
import co.edu.iudigital.helpmeuid.service.iface.IUsuarioService;
import co.edu.iudigital.helpmeuid.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;


    @Transactional(readOnly = true)
    @Override
    public List<UsuarioDTO> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return Util.convertListUsuarioDTO(usuarios);
    }

    @Transactional
    @Override
    public UsuarioDTO findById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return Util.convertUsuarioToUsuarioDTO(usuario.get());
    }

    @Override
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        Usuario usuario = Util.convertUsuarioDTOToUsuario(usuarioDTO);
        UsuarioDTO usuarioFind = findByUsername(usuario.getUsername());
        if(usuarioFind != null){
            usuario = usuarioRepository.save(usuario);
            return Util.convertUsuarioToUsuarioDTO(usuario);
        }
        return Util.convertUsuarioToUsuarioDTO(usuario);
    }

    @Transactional(readOnly = true)
    @Override
    public UsuarioDTO findByUsername(String username) {
        Usuario usuario = usuarioRepository.findByUsername(username);
        return Util.convertUsuarioToUsuarioDTO(usuario);
    }
}