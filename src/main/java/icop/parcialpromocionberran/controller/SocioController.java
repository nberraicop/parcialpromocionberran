package icop.parcialpromocionberran.controller;

import icop.parcialpromocionberran.dto.RequestSocioDto;
import icop.parcialpromocionberran.dto.ResponseSocioDto;
import icop.parcialpromocionberran.service.SocioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/socios")
@RequiredArgsConstructor
public class SocioController {

    private final SocioService socioService;

    @GetMapping
    public ResponseEntity<List<ResponseSocioDto>> listar() {
        return ResponseEntity.ok(socioService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseSocioDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(socioService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ResponseSocioDto> crear(@RequestBody RequestSocioDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(socioService.crear(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        socioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
