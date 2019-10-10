package com;

import java.util.concurrent.Future;

interface FooClient {
    String op(String arg) throws FooException, InterruptedException;
}

interface AsyncFooClient {
    Future<String> asyncOp(String arg, FooCompletion<String> callback);
}

interface FooCompletion<T> {
    void success(T result);

    void failure(FooException exception);
}