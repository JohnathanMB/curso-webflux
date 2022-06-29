package co.com.sofka.usecase.estudiante;

import co.com.sofka.model.estudiante.Estudiante;
import co.com.sofka.model.estudiante.gateways.EstudianteRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class EstudianteUseCase {

    private final EstudianteRepository estudianteRepository;

    public Mono<String> pruebaMonoString(){
        return Mono.just("Hola Usecase");
    }

    public Flux<Estudiante> getAllEstudiantes(){
        return Flux.fromIterable(estudianteRepository.findAll());
    }
}
