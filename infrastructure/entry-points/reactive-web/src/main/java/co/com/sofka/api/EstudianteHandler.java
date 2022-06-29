package co.com.sofka.api;

import co.com.sofka.usecase.estudiante.EstudianteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class EstudianteHandler {
    private final EstudianteUseCase estudianteUseCase;

    public Mono<ServerResponse> listenGetExampleUseCase(ServerRequest serverRequest){
        return estudianteUseCase.pruebaMonoString()
                .flatMap(response -> ServerResponse.ok().bodyValue(response));
    }

    public Mono<ServerResponse> listenGetFindAll(ServerRequest serverRequest){
        return ServerResponse.ok().body(estudianteUseCase.getAllEstudiantes(), Flux.class);
    }

    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {

        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        // useCase2.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        // usecase.logic();
        return ServerResponse.ok().bodyValue("");
    }
}
