/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.servicio;

import com.libreria.modelo.Libro;

public class CatalogItem {
    private Libro libro;
    private int cantidad;

    public CatalogItem(Libro libro, int cantidad) {
        this.libro = libro;
        this.cantidad = cantidad;
    }

    public Libro getLibro() { return libro; }
    public int getCantidad() { return cantidad; }

    public void incrementar(int n) { this.cantidad += n; }
    public void decrementar(int n) { this.cantidad -= n; }
}
