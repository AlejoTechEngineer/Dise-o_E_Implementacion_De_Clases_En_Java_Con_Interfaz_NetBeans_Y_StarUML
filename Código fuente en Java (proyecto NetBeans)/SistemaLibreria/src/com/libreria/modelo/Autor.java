/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.modelo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Autor {
    private String nombre;
    private String nacionalidad;
    private Set<Libro> libros = new HashSet<>();

    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() { return nombre; }
    public String getNacionalidad() { return nacionalidad; }
    public Set<Libro> getLibros() { return libros; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autor)) return false;
        Autor autor = (Autor) o;
        return Objects.equals(nombre, autor.nombre) &&
               Objects.equals(nacionalidad, autor.nacionalidad);
    }
    @Override public int hashCode() { return Objects.hash(nombre, nacionalidad); }

    @Override public String toString() { return nombre + " (" + nacionalidad + ")"; }
}
