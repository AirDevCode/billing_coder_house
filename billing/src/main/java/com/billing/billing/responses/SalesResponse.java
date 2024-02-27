package com.billing.billing.responses;

import java.sql.Date;
import java.util.List;
import com.billing.billing.models.Product;

public class SalesResponse {
    private Long saleId;
    private Date saleDate;
    private ClientResponse client;
    private List<Product> products;
    private int totalProducts;
    private double total;

    public SalesResponse() {
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public Date getDate() {
        return saleDate;
    }

    public void setDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public ClientResponse getClient() {
        return client;
    }

    public void setClient(ClientResponse client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(int totalProducts) {
        this.totalProducts = totalProducts;
    }

}