package com;

import co.paralleluniverse.fibers.FiberAsync;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.fibers.Suspendable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class FooAsync<T> extends FiberAsync<T, FooException> implements FooCompletion<T> {

    @Override
    public void success(T result) {
        System.out.println("成功 = " + result);
        asyncCompleted(result);
    }

    @Override
    public void failure(FooException exception) {
        System.out.println("失败 = " + exception.getMsg());
        asyncFailed(exception);
    }

    @Override
    @Suspendable
    public T run() throws FooException, InterruptedException {
        try {
            return super.run();
        } catch (SuspendExecution e) {
            throw new AssertionError();
        }
    }

    @Override
    @Suspendable
    public T run(long timeout, TimeUnit unit) throws FooException, InterruptedException, TimeoutException {
        try {
            return super.run(timeout, unit);
        } catch (SuspendExecution e) {
            throw new AssertionError();
        }
    }
}
