package com;

public interface FooCompletion<T>{
	void success(T result);
	
	void failure(FooException exception);
}
