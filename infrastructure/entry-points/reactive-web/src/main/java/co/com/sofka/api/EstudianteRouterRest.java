package co.com.sofka.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class EstudianteRouterRest {
@Bean
public RouterFunction<ServerResponse> routerFunction(EstudianteHandler handler) {

    return route(GET("/api/estudiantes/getExample"), handler::listenGetExampleUseCase);
    /*
    return route(GET("/api/usecase/path"), handler::listenGETUseCase)
    .andRoute(POST("/api/usecase/otherpath"), handler::listenPOSTUseCase).and(route(GET("/api/otherusercase/path"), handler::listenGETOtherUseCase));


     */
    }
}
