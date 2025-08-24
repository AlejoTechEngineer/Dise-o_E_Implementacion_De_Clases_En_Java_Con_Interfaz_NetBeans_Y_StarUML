/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.modelo;

public class LibroTexto extends Libro {
    private String nivelEducativo;

    public LibroTexto(String titulo, String isbn, double precio, int anioPublicacion, String nivelEducativo) {
        super(titulo, isbn, precio, anioPublicacion);
        this.nivelEducativo = nivelEducativo;
    }

    public String getNivelEducativo() { return nivelEducativo; }

    @Override public String getInfo() {
        return "Libro de Texto: " + titulo + " | Nivel: " + nivelEducativo + " | Año: " + anioPublicacion;
    }
}
