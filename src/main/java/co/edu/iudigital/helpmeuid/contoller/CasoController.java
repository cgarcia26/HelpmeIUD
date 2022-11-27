package co.edu.iudigital.helpmeuid.contoller;

import co.edu.iudigital.helpmeuid.dto.CasoDTO;
import co.edu.iudigital.helpmeuid.service.iface.ICasoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/casos")
public class CasoController {

    @Autowired
    private ICasoService casoService;

    @GetMapping
    public ResponseEntity<List<CasoDTO>> index(){
            return ResponseEntity
                    .ok()
                    .body(casoService.findAll());
    }

    @PostMapping
    public ResponseEntity<CasoDTO> create(@RequestBody CasoDTO casoDTO){
        return new ResponseEntity<>(
                casoService.save(casoDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CasoDTO> show(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(casoService.findById(id));
    }

}
