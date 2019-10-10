package com;

import java.util.concurrent.Future;

public class AsyncFooImpl implements AsyncFooClient {


    @Override
    public Future<String> asyncOp(String arg, FooCompletion<String> callback) {

        return ExecutorHelper.submit(() -> {
            if (arg.equals("abc")) {
                callback.failure(new FooException("生成了错误"));
            } else {
                callback.success(arg);
            }
        });
    }
}
