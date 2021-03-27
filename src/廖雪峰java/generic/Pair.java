package com.java.generic;

/**
 * @author weilc
 * @description
 * @className Pair
 * @date 2020-07-21
 */
class Pair<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
