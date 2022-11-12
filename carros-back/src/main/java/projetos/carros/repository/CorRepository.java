package projetos.carros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetos.carros.model.Cor;

public interface CorRepository extends JpaRepository<Cor, Long> {
}
