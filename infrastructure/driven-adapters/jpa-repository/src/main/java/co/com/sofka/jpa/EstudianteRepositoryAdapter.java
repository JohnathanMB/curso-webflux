package co.com.sofka.jpa;

import co.com.sofka.jpa.helper.AdapterOperations;
import co.com.sofka.model.estudiante.Estudiante;
import co.com.sofka.model.estudiante.gateways.EstudianteRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class EstudianteRepositoryAdapter extends AdapterOperations<Estudiante, EstudianteData, String, EstudianteDataRepository>
    implements EstudianteRepository {

    @Autowired
    public EstudianteRepositoryAdapter(EstudianteDataRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Estudiante.EstudianteBuilder.class).build());
    }

    @Override
    public List<Estudiante> findAll(){
        return StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .map(estudianteData -> Estudiante.builder()
                        .id(estudianteData.getId())
                        .nombreCompleto(estudianteData.getNombreCompleto())
                        .fechaNacimiento(estudianteData.getFechaNacimiento())
                        .promedio(estudianteData.getPromedio())
                        .curso(estudianteData.getCurso())
                        .especificacionCurso(estudianteData.getEspecificacionCurso())
                        .build())
                .collect(Collectors.toList());

    }

}
