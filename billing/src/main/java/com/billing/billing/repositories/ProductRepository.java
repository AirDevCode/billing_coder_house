package com.billing.billing.repositories;
import com.billing.billing.models.*;
import org.springframework.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    
}
