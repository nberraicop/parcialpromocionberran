package icop.parcialpromocionberran.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class RequestPrestamoDto {
    private Long socioId;
    private String tituloLibro;
    private LocalDate fechaPrestamo;
}
