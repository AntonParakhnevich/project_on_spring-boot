package com.test.validator;

public interface Validator<T> {

  String validate(T value);
}
