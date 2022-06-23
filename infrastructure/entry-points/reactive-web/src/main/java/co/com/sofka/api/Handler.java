package co.com.sofka.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.print.attribute.standard.PresentationDirection;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Handler {

    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {

        return ServerResponse.ok().body(exampleFluxMap(), Flux.class);
    }

    public Mono<ServerResponse> listenGETUseCaseFlux(ServerRequest serverRequest) {

        return ServerResponse.ok().body(exampleMonoFromFluxMap(), String.class);
    }

    public Mono<ServerResponse> listenGETExampleFilterFlux(ServerRequest serverRequest) {

        return ServerResponse.ok().body(exampleFilterFlux(), Flux.class);
    }

    public Mono<ServerResponse> listenGETExampleMerge(ServerRequest serverRequest) {

        return ServerResponse.ok().body(exampleMerge(), Flux.class);
    }

    public Mono<ServerResponse> listenGETExampleMergeWith(ServerRequest serverRequest) {

        return ServerResponse.ok().body(exampleMergeWith(), Flux.class);
    }

    public Mono<ServerResponse> listenGETExampleZip(ServerRequest serverRequest) {

        return ServerResponse.ok().body(exampleMonoZip(), String.class);
    }

    private Mono<String> exampleMonoMap(){
        Integer i = 5;
        Mono<Integer> monoInt = Mono.just(i);
        return monoInt
                .map(data -> castIntToString(i));
    }

    private Mono<String> exampleMonoFlatMap(){
        Integer i = 5;
        Mono<Integer> monoInt = Mono.just(i);
        //return monoInt.map(data -> monoCastIntToString(i));
        return monoInt
                .flatMap(data -> monoCastIntToString(i));
    }

    private Flux<String> exampleFluxMap(){
        List<Integer> listInt = Arrays.asList(1,2,3,4,5);
        return Flux.fromIterable(listInt)
                .log("Entrando a log")
                .map(dataI -> castIntToString(dataI));
    }

    private Mono<String> exampleMonoFromFluxMap(){
        List<Integer> listInt = Arrays.asList(1,2,3,4,5);
        return Flux.fromIterable(listInt)
                    .log("log in Flux")
                    .flatMap(dataI -> monoCastIntToString(dataI))
                .reduce((subtotal, dataStr1) -> subtotal.concat("-").concat(dataStr1))
                .log("log post reduce");
    }

    //metodo no reactivo
    private String castIntToString(int i){
        return String.valueOf(i);
    }

    //Metado SI reactivo
    private Mono<String> monoCastIntToString(int i){
        return Mono.just(String.valueOf(i));
    }


    private Flux<String> exampleFilterFlux(){
        List<String> listStr = Arrays.asList("a", "b", "c", "ac");
        return Flux.fromIterable(listStr)
                .filter(dataI -> dataI.contains("a"))
                .map(dataFilter -> "Se encontró este dato: ".concat(dataFilter));
    }

    private Flux<String> exampleMerge(){
        Mono<String> monoStr1 = Mono.just("Mono-1");
        Mono<String> monoStr2 = Mono.just("Mono-2");
        Mono<String> monoStr3 = Mono.just("Mono-3");
        Flux<String> fluxStr1 = Flux.fromIterable(Arrays.asList("FluxStr-1", "Flux-Str2"));

        Flux<String> fluxFromMerge = Flux.merge(monoStr1, monoStr2, monoStr3, fluxStr1)
                .log();

        return fluxFromMerge;
    }

    private Flux<String> exampleMergeWith(){
        Mono<String> monoStr1 = Mono.just("Mono-1");
        Mono<String> monoStr2 = Mono.just("Mono-2");
        Mono<String> monoStr3 = Mono.just("Mono-3");
        Flux<String> fluxStr1 = Flux.fromIterable(Arrays.asList("FluxStr-1", "Flux-Str2"));

        Flux<String> fluxFromMerge = monoStr1.mergeWith(fluxStr1)
                .log();

        return fluxFromMerge;
    }

    private Mono<String> exampleMonoZip(){
        Mono<String> monoStr1 = Mono.just("Mono-1");
        Mono<String> monoStr2 = Mono.just("Mono-2");
        Mono<Integer> monoInt1 = Mono.just(1);

        /*
        return Mono.zip(monoInt1, monoStr1, monoStr2)
                .map(result -> String.valueOf(result.getT1()).concat(result.getT2()).concat(result.getT3()));

         */

        return monoStr1.zipWith(monoInt1)
                .map(result -> result.getT1().concat("-").concat(String.valueOf(result.getT2())));

    }


}
