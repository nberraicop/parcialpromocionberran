package icop.parcialpromocionberran.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "socio")
@Getter
@Setter
@NoArgsConstructor
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String dni;

    @OneToMany(mappedBy = "socio")
    private List<Prestamo> prestamos = new ArrayList<>();

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}
