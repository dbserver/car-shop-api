package com.db.carshop.sale;


import com.db.carshop.sale.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
