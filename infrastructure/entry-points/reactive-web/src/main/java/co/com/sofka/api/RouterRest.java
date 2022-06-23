package co.com.sofka.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class RouterRest {
@Bean
public RouterFunction<ServerResponse> routerFunction(Handler handler) {
    return route(GET("/api/usecase/path"), handler::listenGETUseCase)
            .andRoute(GET("/api/usecase/exampleMonoFromFlux"), handler::listenGETUseCaseFlux)
            .andRoute(GET("/api/usecase/exampleFilterFlux"), handler::listenGETExampleFilterFlux)
            .andRoute(GET("/api/usecase/exampleMerge"), handler::listenGETExampleMerge)
            .andRoute(GET("/api/usecase/exampleMergeWith"), handler::listenGETExampleMergeWith)
            .andRoute(GET("/api/usecase/exampleZip"), handler::listenGETExampleZip);

    }
}
