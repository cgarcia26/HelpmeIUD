package co.edu.iudigital.helpmeuid.contoller;


import co.edu.iudigital.helpmeuid.dto.DelitoDTO;
import co.edu.iudigital.helpmeuid.model.Delito;
import co.edu.iudigital.helpmeuid.service.iface.IDelitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/delitos")
public class DelitoController {

    @Autowired
    private IDelitoService delitoService;

    @GetMapping
    public ResponseEntity<List<DelitoDTO>> index() {
        return ResponseEntity
                .ok()
                .body(delitoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DelitoDTO> show(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(delitoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<DelitoDTO> save(@RequestBody DelitoDTO delitoDTO) {
        return new ResponseEntity<>(
                delitoService.save(delitoDTO),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        delitoService.delete(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Deleted");
        return ResponseEntity
                .ok()
                .body(response);
    }

}
