package co.com.sofka.usecase.estudiante;

import co.com.sofka.model.estudiante.Estudiante;
import co.com.sofka.model.estudiante.gateways.EstudianteRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor
public class EstudianteUseCase {

    private final EstudianteRepository estudianteRepository;

    public Mono<String> pruebaMonoString(){
        return Mono.just("Hola Usecase");
    }

    public Flux<Estudiante> getAllEstudiantes(){
        return Flux.fromIterable(estudianteRepository.findAll());
    }

    public Mono<String> notificarEstudiantes(String grado){
        return getAllEstudiantes()
                .filter(estudiante -> estudiante.getCurso().equalsIgnoreCase(grado))
                .log()
                .flatMap(estudiante -> enviarNotificacionEstudiante(estudiante))
                .then(Mono.just("Envio de notificacion Finalizada"));
    }

    private Mono<String> enviarNotificacionEstudiante(Estudiante estudiante){
        String strNotificacion = "Notificacion enviada a Estudiante %s";
        return Mono.just(String.format(strNotificacion, estudiante.getId()));
    }

    public Mono<String> notificarEstudiantesParalelo(String grado){
        return getAllEstudiantes()
                .parallel(2).runOn(Schedulers.parallel())
                .filter(estudiante -> estudiante.getCurso().equalsIgnoreCase(grado))
                .log()
                .flatMap(estudiante -> enviarNotificacionEstudiante(estudiante))
                .sequential()
                .then(Mono.just("Envio de notificacion Finalizada"));
    }
}
