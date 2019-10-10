package com;

import co.paralleluniverse.fibers.Suspendable;

public class FiberFooClient implements FooClient {
    private AsyncFooClient asyncFooClient;

    public FiberFooClient(AsyncFooClient asyncFooClient) {
        this.asyncFooClient = asyncFooClient;
    }

//    @Override
//    @Suspendable
//    public String op(String arg) throws FooException, InterruptedException {
//
//        try {
//            return new FiberAsync<String, FooException>() {
//                @Override
//                protected void requestAsync() {
//                    asyncFooClient.asyncOp(arg, new FooCompletion<String>() {
//                        @Override
//                        public void success(String result) {
//                            System.out.println("成功 = "+result);
//                        }
//
//                        @Override
//                        public void failure(FooException exception) {
//                            System.out.println("失败 = "+exception.getMsg());
//                        }
//                    });
//                }
//            }.run();
//        } catch (SuspendExecution suspendExecution) {
//            throw new AssertionError(suspendExecution);
//        }
//    }

    @Override
    @Suspendable
    public String op(String arg) throws FooException, InterruptedException {

        return new FooAsync<String>() {
            @Override
            protected void requestAsync() {
                asyncFooClient.asyncOp(arg, this);
            }
        }.run();
    }
}
