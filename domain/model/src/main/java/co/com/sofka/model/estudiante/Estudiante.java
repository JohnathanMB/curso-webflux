package co.com.sofka.model.estudiante;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder(toBuilder = true)
public class Estudiante {
    private String id;
    private String nombreCompleto;
    private Date fechaNacimiento;
    private float promedio;
    private String curso;
    private String especificacionCurso;
}
