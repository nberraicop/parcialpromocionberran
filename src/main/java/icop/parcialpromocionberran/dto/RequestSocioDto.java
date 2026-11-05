package icop.parcialpromocionberran.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestSocioDto {
    private String nombre;
    private String apellido;
    private String dni;
}
