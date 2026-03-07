package org.trumio.java.language.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        // 1. Get the Class object
        Class<?> clazz = Samosa.class;
        Samosa mySamosa = new Samosa();

        // 2. Access a PRIVATE field
        Field field = clazz.getDeclaredField("secretIngredient");
        field.setAccessible(true); // The "Magic" line that bypasses 'private'
        
        System.out.println("Original Ingredient: " + field.get(mySamosa));
        
        // Modify the private field!
        field.set(mySamosa, "Paneer");
        System.out.println("Updated Ingredient: " + field.get(mySamosa));

        // 3. Invoke a PRIVATE method
        // Parameters: Method name, then the parameter types
        Method method = clazz.getDeclaredMethod("deepFry", int.class);
        method.setAccessible(true); 
        
        // Invoke: Provide the object instance and the arguments
        method.invoke(mySamosa, 180);
    }
}