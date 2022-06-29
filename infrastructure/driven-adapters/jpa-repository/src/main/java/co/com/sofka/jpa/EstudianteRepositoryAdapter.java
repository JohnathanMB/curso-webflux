package co.com.sofka.jpa;

import co.com.sofka.jpa.helper.AdapterOperations;
import co.com.sofka.model.estudiante.Estudiante;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EstudianteRepositoryAdapter extends AdapterOperations<Estudiante, EstudianteData, String, EstudianteRepository>
    implements co.com.sofka.model.estudiante.gateways.EstudianteRepository {

    @Autowired
    public EstudianteRepositoryAdapter(EstudianteRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Estudiante.EstudianteBuilder.class).build());
    }
}
