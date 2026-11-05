package icop.parcialpromocionberran.service;

import icop.parcialpromocionberran.dto.RequestSocioDto;
import icop.parcialpromocionberran.dto.ResponseSocioDto;
import icop.parcialpromocionberran.exception.RecursoNoEncontradoException;
import icop.parcialpromocionberran.exception.ReglaNegocioException;
import icop.parcialpromocionberran.model.Socio;
import icop.parcialpromocionberran.repository.SocioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SocioService {

    private final SocioRepository socioRepository;

    public List<ResponseSocioDto> listar() {
        return socioRepository.findAll().stream().map(this::aDto).toList();
    }

    public ResponseSocioDto buscarPorId(Long id) {
        return aDto(obtenerSocio(id));
    }

    public ResponseSocioDto crear(RequestSocioDto dto) {
        if (socioRepository.existsByDni(dto.getDni())) {
            throw new ReglaNegocioException("Ya existe un socio con el DNI: " + dto.getDni());
        }

        Socio socio = new Socio();
        socio.setNombre(dto.getNombre());
        socio.setApellido(dto.getApellido());
        socio.setDni(dto.getDni());

        return aDto(socioRepository.save(socio));
    }

    @Transactional
    public void eliminar(Long id) {
        Socio socio = obtenerSocio(id);

        if (!socio.getPrestamos().isEmpty()) {
            throw new ReglaNegocioException("No se puede eliminar el socio con id: " + id
                    + " porque tiene préstamos asociados");
        }

        socioRepository.delete(socio);
    }

    private Socio obtenerSocio(Long id) {
        return socioRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Socio no encontrado con id: " + id));
    }

    private ResponseSocioDto aDto(Socio socio) {
        return new ResponseSocioDto(socio.getNombreCompleto(), socio.getDni());
    }
}
