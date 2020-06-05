package com.gdata.kotlinsync.sam;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerHandler<T> {

    private final List<Consumer<T>> consumers = new ArrayList<>();

    public void registerConsumer(Consumer<T> consumer) {
        consumers.add(consumer);
    }

    public void registerConsumerRaw(Consumer consumer) {
        consumers.add(consumer);
    }

    public void registerTwoConsumers(Consumer<T> consumer1, Consumer<T> consumer2) {
        consumers.add(consumer1);
        consumers.add(consumer2);
    }

    public void handle(T value) {
        consumers.forEach(consumer -> consumer.accept(value));
    }
}