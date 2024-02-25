package com.billing.billing.services;
import com.billing.billing.models.Sale;
import com.billing.billing.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import com.billing.billing.models.Client;
import com.billing.billing.models.Product;
import com.billing.billing.models.SaleDetail;
import com.billing.billing.repositories.ClientRepository;
import com.billing.billing.repositories.ProductRepository;
import com.billing.billing.repositories.SaleRepository;
import com.billing.billing.requests.*;
import com.billing.billing.responses.*;
import com.billing.billing.repositories.SaleDetailRepository;

@Service
public class SaleService {

    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;
    private final SaleRepository saleRepository;
    private final SaleDetailRepository saleDetailRepository;

    @Autowired
    public SaleService(ClientRepository clientRepository, ProductRepository productRepository, 
                       SaleRepository saleRepository, SaleDetailRepository saleDetailRepository) {
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
        this.saleRepository = saleRepository;
        this.saleDetailRepository = saleDetailRepository;
    }

    @Transactional
    public SalesResponse createSale(SaleRequest saleRequest) {
        // Obtener el cliente por su ID
        Client client = clientRepository.findById(saleRequest.getCliente().getClienteId()).orElse(null);
        if (client == null) {
            throw new IllegalArgumentException("El cliente especificado no existe");
        }

        // Obtener la fecha actual
        Date date = getCurrentDate();

        // Calcular el precio total de la venta y la cantidad total de productos
        double total = 0;
        int totalQuantity = 0;

        // Crear la venta
        Sale sale = new Sale();
        sale.setClient(client);
        sale.setDate(date);

        // Lista para almacenar los detalles de la venta
        List<SaleDetail> saleDetails = new ArrayList<>();

        // Iterar sobre las líneas de la venta
        for (SaleLine line : saleRequest.getLineas()) {
            // Obtener el producto por su ID
            Product product = productRepository.findById(line.getProducto().getProductId()).orElse(null);
            if (product == null) {
                throw new IllegalArgumentException("El producto especificado no existe");
            }

            // Verificar si hay suficiente stock
            if (product.getStock() < line.getCantidad()) {
                throw new IllegalArgumentException("Cantidad de productos solicitados excede el stock disponible");
            }

            // Crear el detalle de la venta
            SaleDetail saleDetail = new SaleDetail();
            saleDetail.setSale(sale);
            saleDetail.setProduct(product);
            saleDetail.setQuantity(line.getCantidad());
            saleDetail.setSubtotal(product.getPrice() * line.getCantidad());

            // Actualizar el stock del producto
            product.setStock(product.getStock() - line.getCantidad());

            // Actualizar el precio total y la cantidad total de productos
            total += saleDetail.getSubtotal();
            totalQuantity += line.getCantidad();

            // Guardar el detalle de la venta en la lista
            saleDetails.add(saleDetail);
        }

        // Establecer el precio total y la cantidad total de productos en la venta
        sale.setSale_value(total);
        sale.setTotal(total);
        sale.setTotal_products(totalQuantity);

        // Guardar la venta
        saleRepository.save(sale);

        // Guardar los detalles de la venta
        saleDetailRepository.saveAll(saleDetails);

        // Construir y retornar la respuesta de la venta
        return buildSaleResponse(sale, saleDetails, client);
    }

    private SalesResponse buildSaleResponse(Sale sale, List<SaleDetail> saleDetails, Client client) {
        SalesResponse saleResponse = new SalesResponse();
        saleResponse.setSaleId(sale.getId());
        saleResponse.setTotal(sale.getTotal());
        saleResponse.setTotalProducts(sale.getTotal_products());
        saleResponse.setClientName(client.getName());
        saleResponse.setClientEmail(client.getEmail());

         List<Product> products = new ArrayList<>();
         for (SaleDetail saleDetail : saleDetails) {
             Product product = saleDetail.getProduct();
             products.add(product);
         }
         saleResponse.setProducts(products);

        return saleResponse;
    }

    private Date getCurrentDate() {
        return new Date();
    }
}