package com;

import java.util.concurrent.Future;

public interface AsyncFooClient{
	Future<String> asyncOp(String arg,FooCompletion<String> callback);
}
