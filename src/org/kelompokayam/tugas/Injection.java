/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.kelompokayam.tugas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 *
 * @author raz
 */
public class Injection {
    private static final Map<String, Supplier> injections = new HashMap<>();
    
    public static <T> T Put(T object) {
        return (T) Put(object.getClass(), object);
    }
    
    public static <T> T Put(Class<? extends T> clazz, T object) {
        return Put(clazz.getName(), object);
    }
    
    public static <T> T Put(String type, T object) {
        injections.put(type, (Supplier)() -> object);
        
        return object;
    }
    
    public static <T> T LazyPut(Class<? extends T> clazz, Supplier<T> builder) {
        return LazyPut(clazz.getName(), builder);
    }
    
    public static <T> T LazyPut(String type, Supplier<T> builder) {
        return (T) injections.put(type, (Supplier<T>)() -> {
            T object = builder.get();
            injections.put(type, () -> object);
            
            return object;
        });
    }
    
    public static <T> T Create(Class<? extends T> clazz, Supplier<T> builder) {
        return Create(clazz.getName(), builder);
    }
    
    public static <T> T Create(String type, Supplier<T> builder) {
        if (!injections.containsKey(type)) return null;
        
        return (T) injections.put(type, builder);
    }
    
    public static <T> T Get(Class<? extends T> clazz) {
        return Get(clazz.getName());
    }
    
    public static <T> T Get(String type) {
        if (!injections.containsKey(type)) return null;
        
        return (T) injections.get(type).get();
    }
    
    public static <T> T Delete(Class<? extends T> clazz) {
        return Delete(clazz.getName());
    }
    
    public static <T> T Delete(String type) {
        return (T) injections.remove(type);
    }
}
