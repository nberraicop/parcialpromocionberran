package icop.parcialpromocionberran.controller;

import icop.parcialpromocionberran.dto.RequestPrestamoDto;
import icop.parcialpromocionberran.dto.ResponsePrestamoDto;
import icop.parcialpromocionberran.service.PrestamoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
@RequiredArgsConstructor
public class PrestamoController {

    private final PrestamoService prestamoService;

    @PostMapping
    public ResponseEntity<ResponsePrestamoDto> crear(@RequestBody RequestPrestamoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(prestamoService.crear(dto));
    }

    @GetMapping("/socio/{id}")
    public ResponseEntity<List<ResponsePrestamoDto>> listarPorSocio(@PathVariable Long id) {
        return ResponseEntity.ok(prestamoService.listarPorSocio(id));
    }
}
