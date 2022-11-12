package projetos.carros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetos.carros.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
