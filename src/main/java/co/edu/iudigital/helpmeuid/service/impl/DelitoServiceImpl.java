package co.edu.iudigital.helpmeuid.service.impl;

import co.edu.iudigital.helpmeuid.dto.DelitoDTO;
import co.edu.iudigital.helpmeuid.model.Delito;
import co.edu.iudigital.helpmeuid.repository.IDelitoRepository;
import co.edu.iudigital.helpmeuid.service.iface.IDelitoService;
import co.edu.iudigital.helpmeuid.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DelitoServiceImpl implements IDelitoService {

    @Autowired
    private IDelitoRepository delitoRepository;

    @Transactional(readOnly = true)
    @Override
    public List<DelitoDTO> findAll() {
        List<Delito> delitos = delitoRepository.findAll();
        return Util.convertListDelitoDTO(delitos);
    }

    @Transactional(readOnly = true)
    @Override
    public DelitoDTO findById(Long id) {
        Optional<Delito> delito = delitoRepository.findById(id);
         return Util.convertDelitoToDelitoDTO(delito.get());
    }

    @Transactional
    @Override
    public DelitoDTO save(DelitoDTO delitoDTO) {
        Delito delito = Util.convertDelitoDTOToDelito(delitoDTO);
        delito = delitoRepository.save(delito);
        return Util.convertDelitoToDelitoDTO(delito);
    }

    @Transactional
    @Override
    public void delete(Long id) {
       delitoRepository.deleteById(id);
    }
}
