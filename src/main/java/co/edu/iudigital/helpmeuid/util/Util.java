package co.edu.iudigital.helpmeuid.util;

import co.edu.iudigital.helpmeuid.dto.CasoDTO;
import co.edu.iudigital.helpmeuid.dto.DelitoDTO;
import co.edu.iudigital.helpmeuid.dto.UsuarioDTO;
import co.edu.iudigital.helpmeuid.model.Caso;
import co.edu.iudigital.helpmeuid.model.Delito;
import co.edu.iudigital.helpmeuid.model.Usuario;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Util {


    public static DelitoDTO convertDelitoToDelitoDTO(Delito delito) {
        DelitoDTO delitoDTO = new DelitoDTO();
        BeanUtils.copyProperties(delito, delitoDTO);
        return delitoDTO;
    }

    public static List<DelitoDTO> convertListDelitoDTO(
            List<Delito> delitos){
        return delitos
                .stream()
                .map(Util::convertDelitoToDelitoDTO)
                .collect(Collectors.toList());
    }

    public static Delito convertDelitoDTOToDelito(DelitoDTO delitoDTO) {
        Delito delito = new Delito();
        BeanUtils.copyProperties(delitoDTO, delito);
        return delito;
    }

    public static CasoDTO convertCasoToCasoDTO(Caso caso) {
        CasoDTO casoDTO = new CasoDTO();
        BeanUtils.copyProperties(caso, casoDTO);
        return casoDTO;
    }

    public static List<CasoDTO> convertListCasosDTO(
            List<Caso> casos){
        return casos
                .stream()
                .map(Util::convertCasoToCasoDTO)
                .collect(Collectors.toList());
    }

    public static Caso convertCasoDTOToCaso(CasoDTO casoDTO) {
        Caso caso = new Caso();
        BeanUtils.copyProperties(casoDTO, caso);
        return caso;
    }

    public static UsuarioDTO convertUsuarioToUsuarioDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        BeanUtils.copyProperties(usuario, usuarioDTO);
        return usuarioDTO;
    }

    public static List<UsuarioDTO> convertListUsuarioDTO(
            List<Usuario> usuarios){
        return usuarios
                .stream()
                .map(Util::convertUsuarioToUsuarioDTO)
                .collect(Collectors.toList());
    }

    public static Usuario convertUsuarioDTOToUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        return usuario;
    }

}
