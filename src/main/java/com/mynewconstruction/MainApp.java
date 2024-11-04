package com.mynewconstruction;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("¡Bienvenido a My Construction!");
        System.out.println("Por favor, inicia sesión para continuar.");
        
        // Llamar al método de inicio de sesión
        login();
    }

    private static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa tu nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Ingresa tu contraseña: ");
        String password = scanner.nextLine();

        // Lógica simple de autenticación (esto debe ser mejorado para producción)
        if ("admin".equals(username) && "password".equals(password)) {
            System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + username + "!");
        } else {
            System.out.println("Nombre de usuario o contraseña incorrectos.");
        }

        scanner.close();
    }
}
