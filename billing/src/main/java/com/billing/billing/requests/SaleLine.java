package com.billing.billing.requests;

public class SaleLine {
    private int cantidad;
    private ProductRequest producto;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ProductRequest getProducto() {
        return producto;
    }

    public void setProducto(ProductRequest producto) {
        this.producto = producto;
    }
}
