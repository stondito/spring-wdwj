package com.example.projectspring.services.managers;

import com.example.projectspring.models.Sale;
import com.example.projectspring.services.InvoiceService;
import com.example.projectspring.services.SaleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class BillService {

    private final SaleService saleService;
    private final InvoiceService invoiceService;

    public List<Sale> getSalesByMake(String make) {

        return this.saleService.getAll()
                .stream()
                .filter(sale -> sale.getCar().getMake().equals(make))
                .collect(Collectors.toList());

    }

    public double getTotalRevenue() {
        return this.invoiceService.getAll()
                .stream()
                .mapToDouble(invoice -> invoice.getSalesPrice().doubleValue()).
                sum();
    }
}
