package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise7 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()
        // NOTE: Uncomment all but one that you want to test, since they all run in parallel

        // Print all values from intNumbersFlux that's greater than 5
        System.out.println("Print all values from intNumbersFlux that's greater than 5");
        ReactiveSources.intNumbersFlux()
                .filter(n -> n > 5)
                .subscribe(System.out::println);

        // Print 10 times each value from intNumbersFlux that's greater than 5
        System.out.println("Print 10 times each value from intNumbersFlux that's greater than 5");
        ReactiveSources.intNumbersFlux()
                .filter(n -> n > 5)
                .map(n -> 10 * n)
                .subscribe(System.out::println);

        // Print 10 times each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5
        System.out.println("Print 10 times each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5");
        ReactiveSources.intNumbersFlux()
                .filter(n -> n > 5)
                .map(n -> 10 * n)
                .take(3)
                .subscribe(System.out::println);

        // Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found
        System.out.println("Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found");
        ReactiveSources.intNumbersFlux()
                .filter(n -> n > 20)
                .defaultIfEmpty(-1)
                .subscribe(System.out::println);

        // Switch ints from intNumbersFlux to the right user from userFlux
        System.out.println("Switch ints from intNumbersFlux to the right user from userFlux");
        ReactiveSources.intNumbersFlux()
                .flatMap(n -> ReactiveSources.userFlux().filter(u -> u.getId() == n).take(1))
                .subscribe(System.out::println);

        // Print only distinct numbers from intNumbersFluxWithRepeat
        System.out.println("Print only distinct numbers from intNumbersFluxWithRepeat");
        ReactiveSources.intNumbersFluxWithRepeat()
                .distinct()
                .subscribe(System.out::println);

        // Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
        System.out.println("Print from intNumbersFluxWithRepeat excluding immediately repeating numbers");
        ReactiveSources.intNumbersFluxWithRepeat()
                .distinctUntilChanged()
                .subscribe(System.out::println);


        System.out.println("Press a key to end");
        System.in.read();
    }

}
