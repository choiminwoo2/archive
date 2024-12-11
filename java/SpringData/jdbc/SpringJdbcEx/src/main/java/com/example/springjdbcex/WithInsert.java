package com.example.springjdbcex;

public interface WithInsert<T> {

    /**
     * Custom insert method.
     *
     * @param t
     * @return
     */
    T insert(T t);
}
