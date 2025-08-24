/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente {
    private String idCliente;
    private String nombre;
    private List<Libro> compras = new ArrayList<>();

    public Cliente(String idCliente, String nombre) {
        this.idCliente = idCliente;
        this.nombre = nombre;
    }

    public String getIdCliente() { return idCliente; }
    public String getNombre() { return nombre; }
    public List<Libro> getCompras() { return compras; }

    public void comprar(Libro libro) { compras.add(libro); }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente c = (Cliente) o;
        return Objects.equals(idCliente, c.idCliente);
    }
    @Override public int hashCode() { return Objects.hash(idCliente); }
}
