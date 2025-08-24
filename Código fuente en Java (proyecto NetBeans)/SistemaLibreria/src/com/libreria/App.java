/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria;

import com.libreria.modelo.*;
import com.libreria.servicio.*;
import java.nio.charset.StandardCharsets;
import java.io.PrintStream;
import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        // Forzar salida en UTF-8
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        Libreria libreria = new Libreria();
        Cliente cliente = new Cliente("C-001", "Alejandro De Mendoza");

        // === Cargar datos desde archivo ===
        cargarLibrosDesdeArchivo("libros.txt", libreria);

        // Scanner para menú
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);

        int opcion = 0;
        while (opcion != 5) {
            System.out.println("\n=== Menú Librería ===");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Buscar libro por autor");
            System.out.println("3. Comprar libro por ISBN");
            System.out.println("4. Ver compras del cliente");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese título: ");
                    String titulo = sc.nextLine();
                    libreria.buscarPorTitulo(titulo).forEach(l ->
                        System.out.println(" - " + l.getInfo())
                    );
                    break;
                case 2:
                    System.out.print("Ingrese autor: ");
                    String autor = sc.nextLine();
                    libreria.buscarPorAutor(autor).forEach(l ->
                        System.out.println(" - " + l.getInfo())
                    );
                    break;
                case 3:
                    System.out.print("Ingrese ISBN: ");
                    String isbn = sc.nextLine();
                    boolean ok = libreria.vender(isbn, cliente);
                    System.out.println(ok ? "Compra realizada" : "No disponible");
                    break;
                case 4:
                    System.out.println("Compras del cliente:");
                    cliente.getCompras().forEach(l ->
                        System.out.println(" - " + l.getTitulo())
                    );
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        }

        sc.close();
    }

    private static void cargarLibrosDesdeArchivo(String archivo, Libreria libreria) {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(archivo), StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length < 8) continue; // línea inválida

                String tipo = partes[0];
                String titulo = partes[1];
                String isbn = partes[2];
                double precio = Double.parseDouble(partes[3]);
                int anio = Integer.parseInt(partes[4]);
                String extra = partes[5];
                String nombreAutor = partes[6];
                String pais = partes[7];

                Autor autor = new Autor(nombreAutor, pais);
                Libro libro;

                if (tipo.equalsIgnoreCase("NOVELA")) {
                    libro = new Novela(titulo, isbn, precio, anio, extra);
                } else {
                    libro = new LibroTexto(titulo, isbn, precio, anio, extra);
                }

                libro.addAutor(autor);
                libreria.agregarLibro(libro, 3); // stock inicial fijo (3)
            }
            System.out.println("📚 Libros cargados desde archivo correctamente.");
        } catch (IOException e) {
            System.out.println("⚠ No se pudo leer el archivo " + archivo);
        }
    }
}
