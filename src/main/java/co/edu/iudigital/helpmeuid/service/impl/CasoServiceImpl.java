package co.edu.iudigital.helpmeuid.service.impl;

import co.edu.iudigital.helpmeuid.dto.CasoDTO;
import co.edu.iudigital.helpmeuid.model.Caso;
import co.edu.iudigital.helpmeuid.model.Delito;
import co.edu.iudigital.helpmeuid.model.Usuario;
import co.edu.iudigital.helpmeuid.repository.ICasoRepository;
import co.edu.iudigital.helpmeuid.repository.IDelitoRepository;
import co.edu.iudigital.helpmeuid.repository.IUsuarioRepository;
import co.edu.iudigital.helpmeuid.service.iface.ICasoService;
import co.edu.iudigital.helpmeuid.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CasoServiceImpl implements ICasoService {

    @Autowired
    private ICasoRepository casoRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IDelitoRepository delitoRepository;

    @Override
    public List<CasoDTO> findAll() {
        List<Caso> casos = casoRepository.findAll();
        return Util.convertListCasosDTO(casos);
    }

    @Override
    public CasoDTO save(CasoDTO casoDTO) {
        Optional<Usuario> usuarioOpt = usuarioRepository
                .findById(casoDTO.getUsuarios_id());
        Optional<Delito> delitoOpt = delitoRepository
                .findById(casoDTO.getDelitoId());
        Caso caso = Util.convertCasoDTOToCaso(casoDTO);
        caso.setDelito(delitoOpt.get());
        caso.setUsuario(usuarioOpt.get());
        caso = casoRepository.save(caso);
        return Util.convertCasoToCasoDTO(caso);
    }

    @Override
    public Boolean visible(Boolean visible, Long id) {
        return casoRepository.setVisible(visible, id);
    }

    @Override
    public CasoDTO findById(Long id) {
        Optional<Caso> casoOpt = casoRepository.findById(id);
        return Util.convertCasoToCasoDTO(casoOpt.get());
    }
}
