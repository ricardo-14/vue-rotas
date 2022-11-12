package projetos.carros.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetos.carros.model.Cor;
import projetos.carros.repository.CorRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cor")
public class CorController {

    @Autowired
    private CorRepository repository;

    @GetMapping
    public List<Cor> getAll() {

        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity get(
            @PathVariable("id") Long id) {
        Optional<Cor> cor = repository.findById(id);
        if (cor.isPresent()) {
            return ResponseEntity.ok(cor.get());
        }
        return ResponseEntity.badRequest().body("Id not found");
    }

    @PostMapping
    public void save(@RequestBody Cor cor) {
        repository.save(cor);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Cor cor,
                                 @PathVariable Long id) {
        repository.save(cor);

        return ResponseEntity.ok(cor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
