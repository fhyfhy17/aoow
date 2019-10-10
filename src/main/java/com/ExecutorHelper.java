package com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorHelper {
    private static ExecutorService service = Executors.newFixedThreadPool(4);

    public static <T> Future<T> submit(Runnable task) {
        return (Future<T>) service.submit(task);
    }

}
