package icop.parcialpromocionberran.repository;

import icop.parcialpromocionberran.model.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocioRepository extends JpaRepository<Socio, Long> {

    boolean existsByDni(String dni);
}
