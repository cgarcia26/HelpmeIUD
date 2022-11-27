package co.edu.iudigital.helpmeuid.service.iface;

import co.edu.iudigital.helpmeuid.dto.CasoDTO;

import java.util.List;

public interface ICasoService {

    // Consultar todos

    List<CasoDTO> findAll();

    // Crear

    CasoDTO save(CasoDTO casoDTO);

    // Activar

    Boolean visible(Boolean visible, Long id);

    // Consultar por ID

    CasoDTO findById(Long id);
}
