package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        ReactiveSources.intNumberMono().subscribe(System.out::println);

        // Get the value from the Mono into an integer variable
        int number = ReactiveSources.intNumberMono().block();
        System.out.println("Fetched the integer from Mono: " + number);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
