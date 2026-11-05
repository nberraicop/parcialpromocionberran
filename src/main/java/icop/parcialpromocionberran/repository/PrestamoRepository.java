package icop.parcialpromocionberran.repository;

import icop.parcialpromocionberran.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

    boolean existsByTituloLibroAndDevueltoFalse(String tituloLibro);
}
