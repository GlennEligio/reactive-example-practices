package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()
        // NOTE: Uncomment all exception the one Flux that you want to test

        // Print values from intNumbersFluxWithException and print a message when error happens
        ReactiveSources.intNumbersFluxWithException()
                .doOnError(err -> System.out.println("Error happened: " + err.getMessage()))
                .subscribe(num -> System.out.println(num),
                        err -> System.out.println(err.getMessage()));

        // Print values from intNumbersFluxWithException and continue on errors
        ReactiveSources.intNumbersFluxWithException()
                .onErrorContinue((err, item) -> System.out.println("Error happened! Item is " + item));

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        ReactiveSources.intNumbersFluxWithException()
                .onErrorResume(err -> Flux.just(-1, -2))
                .subscribe(n -> System.out.println(n));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
