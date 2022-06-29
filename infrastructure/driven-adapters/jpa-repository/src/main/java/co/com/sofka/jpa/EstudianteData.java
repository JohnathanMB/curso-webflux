package co.com.sofka.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EstudianteData {

    @Id
    private String id;
    private String nombreCompleto;
    private Date fechaNacimiento;
    private float promedio;
    private String curso;
    private String especificacionCurso;
}