package co.edu.iudigital.helpmeuid.service.iface;

import co.edu.iudigital.helpmeuid.dto.DelitoDTO;

import java.util.List;

public interface IDelitoService {

    // Consultar todos
    List<DelitoDTO> findAll();

    // Consultar por Id
    DelitoDTO findById(Long id);

    // Guardar
    DelitoDTO save(DelitoDTO delitoDTO);

    // Borrar
    void delete(Long id);

}
