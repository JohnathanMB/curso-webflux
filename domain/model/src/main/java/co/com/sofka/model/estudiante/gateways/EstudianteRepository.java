package co.com.sofka.model.estudiante.gateways;

import co.com.sofka.model.estudiante.Estudiante;

import java.util.List;

public interface EstudianteRepository {

    List<Estudiante> findAll();
}
