package co.com.sofka.usecase.estudiante;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class EstudianteUseCase {

    public Mono<String> pruebaMonoString(){
        return Mono.just("Hola Usecase");
    }
}
