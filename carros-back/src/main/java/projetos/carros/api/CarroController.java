package projetos.carros.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetos.carros.model.Carro;
import projetos.carros.repository.CarroRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    private CarroRepository repository;

    @GetMapping
    public List<Carro> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity get(
            @PathVariable("id") Long id) {
        Optional<Carro> carro = repository.findById(id);
        if (carro.isPresent()) {
            return ResponseEntity.ok(carro.get());
        }
        return ResponseEntity.badRequest().body("Id not found");
    }

    @PostMapping
    private void save(@RequestBody Carro carro) {
        repository.save(carro);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Carro carro,
                                 @PathVariable Long id) {
        repository.save(carro);

        return ResponseEntity.ok(carro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
