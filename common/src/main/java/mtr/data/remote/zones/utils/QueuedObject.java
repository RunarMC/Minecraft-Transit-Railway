package mtr.data.remote.zones.utils;

import java.io.Serializable;

@SuppressWarnings("ALL")
public class QueuedObject<A, B> implements Serializable {
    private final A first;
    private final B second;

    public QueuedObject(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public static <A, B> QueuedObject<A, B> of(A first, B second) {
        return new QueuedObject<>(first, second);
    }

    @Override
    public String toString() {
        return "QueuedObject{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }
}
