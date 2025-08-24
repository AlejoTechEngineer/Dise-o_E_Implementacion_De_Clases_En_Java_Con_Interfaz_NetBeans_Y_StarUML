/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.modelo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Libro implements Vendible {
    protected String titulo;
    protected String isbn;
    protected double precio;
    protected int anioPublicacion;
    protected Set<Autor> autores = new HashSet<>();

    public Libro(String titulo, String isbn, double precio, int anioPublicacion) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.precio = precio;
        this.anioPublicacion = anioPublicacion;
    }

    // ======================
    // Métodos de la interfaz Vendible
    // ======================
    @Override
    public String getTitulo() { return titulo; }

    public String getIsbn() { return isbn; }

    @Override
    public double getPrecio() { return precio; }

    public int getAnioPublicacion() { return anioPublicacion; }

    public Set<Autor> getAutores() { return autores; }

    public void addAutor(Autor a) {
        if (a != null) {
            autores.add(a);
            a.getLibros().add(this);
        }
    }

    // Forzado por la interfaz (lo implementan las subclases)
    @Override
    public abstract String getInfo();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Libro)) return false;
        Libro libro = (Libro) o;
        return Objects.equals(isbn, libro.isbn);
    }

    @Override
    public int hashCode() { return Objects.hash(isbn); }
}
