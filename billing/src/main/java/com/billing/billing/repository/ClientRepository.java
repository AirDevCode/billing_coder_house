package com.billing.billing.repository;
import com.billing.billing.models.*;
import org.springframework.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    
}
