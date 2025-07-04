package org.bikesim;

// Detects and handles input source and feeds input lines into CommandProcesor.
public class BikeSimApp {
    public static void main(String[] args) {
        if (args.length != 0) {
            System.out.println("argument detected");
            String formattedStr = String.format("Hello world! %s", args[0]);
            System.out.println(formattedStr);
        } else {
            System.out.println("Hello world!");
        }


    }
}