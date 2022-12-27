package io.javabrains.reactiveworkshop;

import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberFlux() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        ReactiveSources.intNumbersFlux().subscribe(
                number -> System.out.println(number),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed")
        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }
}

class MySubscriber<T> extends BaseSubscriber<T> {
    @Override
    protected void hookOnNext(T value) {
        System.out.println(value);
        super.hookOnNext(value);
    }

    @Override
    protected void hookOnComplete() {
        System.out.println("Completed");
        super.hookOnComplete();
    }

    @Override
    protected void hookOnError(Throwable throwable) {
        System.out.println(throwable.getMessage());
        super.hookOnError(throwable);
    }
}