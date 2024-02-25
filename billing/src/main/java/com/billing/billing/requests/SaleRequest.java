package com.billing.billing.requests;

import java.util.List;

public class SaleRequest {
    private ClientRequest cliente;
    private List<SaleLine> lineas;

    public ClientRequest getCliente() {
        return cliente;
    }

    public void setCliente(ClientRequest cliente) {
        this.cliente = cliente;
    }

    public List<SaleLine> getLineas() {
        return lineas;
    }

    public void setLineas(List<SaleLine> lineas) {
        this.lineas = lineas;
    }
}


