package com.example.sqlinjectiontest;
import java.util.*;

public class Main {
    private static final Logger logger = Logger.getLogger(MiClase.class.getName());

    public static void main(String[] args) {
        logger.info("Resultado suma: " + sumar(2, 3));
    }

    public static int sumar(int a, int b) {
        return a + b;
    }
}
