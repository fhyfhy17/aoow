package com;

import co.paralleluniverse.fibers.Fiber;

public class Test1 {
    public static void main(String[] args) {
        AsyncFooImpl asyncFoo = new AsyncFooImpl();
//        asyncFoo.asyncOp("abc", new FooCompletion<String>() {
//            @Override
//            public void success(String result) {
//                System.out.println(result);
//            }
//
//            @Override
//            public void failure(FooException exception) {
//                System.out.println(exception.getMsg());
//            }
//        });
        new Fiber<Void>(() -> {
            FiberFooClient fiberFooClient = new FiberFooClient(asyncFoo);
            try {
                fiberFooClient.op("abc1");
            } catch (FooException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
