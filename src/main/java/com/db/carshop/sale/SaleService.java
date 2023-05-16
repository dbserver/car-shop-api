package com.db.carshop.sale;

import com.db.carshop.sale.dto.SaleDto;
import com.db.carshop.sale.model.Sale;

import java.util.List;

public interface SaleService {
    Sale createSale(SaleDto dto);
    Sale updateSale(SaleDto dto, Long id);
    Sale getById(Long id);
    List<Sale> getAll();
    void deleteById(Long id);
}
