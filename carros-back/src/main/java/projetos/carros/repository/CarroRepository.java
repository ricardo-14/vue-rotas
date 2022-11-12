package projetos.carros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetos.carros.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}
