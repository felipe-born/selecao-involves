package br.com.involves.selecao.flyweight;

public interface Flyweight<T> {

    T getInstance(Class<? extends T> clazz);
}
