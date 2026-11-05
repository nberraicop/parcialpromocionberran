package icop.parcialpromocionberran.service;

import icop.parcialpromocionberran.dto.RequestPrestamoDto;
import icop.parcialpromocionberran.dto.ResponsePrestamoDto;
import icop.parcialpromocionberran.exception.RecursoNoEncontradoException;
import icop.parcialpromocionberran.exception.ReglaNegocioException;
import icop.parcialpromocionberran.model.Prestamo;
import icop.parcialpromocionberran.model.Socio;
import icop.parcialpromocionberran.repository.PrestamoRepository;
import icop.parcialpromocionberran.repository.SocioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrestamoService {

    private final PrestamoRepository prestamoRepository;
    private final SocioRepository socioRepository;

    public ResponsePrestamoDto crear(RequestPrestamoDto dto) {
        Socio socio = obtenerSocio(dto.getSocioId());

        if (prestamoRepository.existsByTituloLibroAndDevueltoFalse(dto.getTituloLibro())) {
            throw new ReglaNegocioException("El libro " + dto.getTituloLibro() + " ya se encuentra prestado");
        }

        Prestamo prestamo = new Prestamo();
        prestamo.setTituloLibro(dto.getTituloLibro());
        prestamo.setFechaPrestamo(dto.getFechaPrestamo());
        prestamo.setDevuelto(false);
        prestamo.setSocio(socio);

        return aDto(prestamoRepository.save(prestamo));
    }

    @Transactional(readOnly = true)
    public List<ResponsePrestamoDto> listarPorSocio(Long socioId) {
        Socio socio = obtenerSocio(socioId);
        return socio.getPrestamos().stream().map(this::aDto).toList();
    }

    private Socio obtenerSocio(Long id) {
        return socioRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Socio no encontrado con id: " + id));
    }

    private ResponsePrestamoDto aDto(Prestamo p) {
        return new ResponsePrestamoDto(
                p.getId(),
                p.getTituloLibro(),
                p.getFechaPrestamo(),
                p.isDevuelto(),
                p.getSocio().getNombreCompleto());
    }
}
