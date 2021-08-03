package ua.goit;

import ua.goit.config.HibernateDatabaseConnector;

public class Main {
    public static void main(String[] args) {
        System.out.println("Init hibernate connector");
        HibernateDatabaseConnector.init();
        System.out.println("Hibernate initialisation finished successfully");
    }
}
