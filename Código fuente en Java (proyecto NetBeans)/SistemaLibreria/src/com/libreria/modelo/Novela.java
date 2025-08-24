/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.modelo;

public class Novela extends Libro {
    private String genero;

    public Novela(String titulo, String isbn, double precio, int anioPublicacion, String genero) {
        super(titulo, isbn, precio, anioPublicacion);
        this.genero = genero;
    }

    public String getGenero() { return genero; }

    @Override public String getInfo() {
        return "Novela: " + titulo + " | Género: " + genero + " | Año: " + anioPublicacion;
    }
}
