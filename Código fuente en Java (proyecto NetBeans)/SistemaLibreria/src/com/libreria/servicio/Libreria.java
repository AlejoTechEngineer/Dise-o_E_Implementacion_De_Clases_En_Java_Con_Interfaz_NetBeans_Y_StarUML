/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.servicio;

import com.libreria.modelo.Cliente;
import com.libreria.modelo.Libro;

import java.util.*;
import java.util.stream.Collectors;

public class Libreria {
    private Map<String, CatalogItem> catalogo = new HashMap<>();

    public void agregarLibro(Libro libro, int cantidad) {
        if (libro == null || cantidad <= 0) return;
        catalogo.merge(libro.getIsbn(), new CatalogItem(libro, cantidad),
                (oldItem, newItem) -> { oldItem.incrementar(cantidad); return oldItem; });
    }

    public List<Libro> buscarPorTitulo(String titulo) {
        if (titulo == null) return Collections.emptyList();
        String q = titulo.toLowerCase();
        return catalogo.values().stream()
                .map(CatalogItem::getLibro)
                .filter(l -> l.getTitulo().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }

    public List<Libro> buscarPorAutor(String nombreAutor) {
        if (nombreAutor == null) return Collections.emptyList();
        String q = nombreAutor.toLowerCase();
        return catalogo.values().stream()
                .map(CatalogItem::getLibro)
                .filter(l -> l.getAutores().stream()
                        .anyMatch(a -> a.getNombre().toLowerCase().contains(q)))
                .collect(Collectors.toList());
    }

    public boolean vender(String isbn, Cliente cliente) {
        CatalogItem item = catalogo.get(isbn);
        if (item == null || item.getCantidad() <= 0) return false;
        cliente.comprar(item.getLibro());
        item.decrementar(1);
        if (item.getCantidad() <= 0) catalogo.remove(isbn);
        return true;
    }

    public int getCantidad(String isbn) {
        CatalogItem item = catalogo.get(isbn);
        return (item == null) ? 0 : item.getCantidad();
    }

    public boolean disponible(String isbn) {
        return getCantidad(isbn) > 0;
    }
}
