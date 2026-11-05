package icop.parcialpromocionberran.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "prestamo")
@Getter
@Setter
@NoArgsConstructor
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo_libro")
    private String tituloLibro;

    @Column(name = "fecha_prestamo")
    private LocalDate fechaPrestamo;

    private boolean devuelto;

    // este lado tiene la fk
    @ManyToOne
    @JoinColumn(name = "socio_id")
    private Socio socio;
}
