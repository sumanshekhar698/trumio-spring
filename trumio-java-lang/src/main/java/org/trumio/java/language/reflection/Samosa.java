package org.trumio.java.language.reflection;



public class Samosa {
    private String secretIngredient = "Aloo";

    private void deepFry(int temperature) {
        System.out.println("Frying Samosa at " + temperature + "°C with " + secretIngredient);
    }


    private void deepFry(String temperature) {
        System.out.println("Frying Samosa at " + temperature + "°C with " + secretIngredient);
    }
}