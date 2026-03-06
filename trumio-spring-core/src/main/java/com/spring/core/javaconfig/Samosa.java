package com.spring.core.javaconfig;

import org.springframework.stereotype.Component;

//@Component
public class Samosa {

    private String flavor = "Spicy";

    public void order() {
        System.out.printf("Ordering Samosa with flavor: %s\n", flavor);
    }

    public Samosa() {
        System.out.println("Samosa created !!");
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
        System.out.println("Flavor set to " + flavor);
    }

    public Samosa(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public String toString() {
        return "Samosa{" +
                "flavor='" + flavor + '\'' +
                '}';
    }
}
