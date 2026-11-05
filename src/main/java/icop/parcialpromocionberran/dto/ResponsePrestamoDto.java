package icop.parcialpromocionberran.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePrestamoDto {
    private Long id;
    private String tituloLibro;
    private LocalDate fechaPrestamo;
    private boolean devuelto;
    private String nombreSocio;
}
