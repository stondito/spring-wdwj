package com.example.projectspring.services;

import com.example.projectspring.models.Invoice;
import com.example.projectspring.repos.InvoiceRepositoryI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Slf4j
@Service
public class InvoiceService {
    private final InvoiceRepositoryI invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepositoryI invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Long addInvoice(Invoice invoice) {
        log.debug("Adding invoice");
        log.info("Adding invoice");
        log.error("Adding invoice");

        Invoice invoice1 = invoiceRepository.save(invoice);

        return invoice1.getId();
    }

    public List<Invoice> getInvoiceHistory() {
        log.debug("Get Invoice History");
        log.info("Get Invoice History");
        log.error("Get Invoice History");

        return invoiceRepository.findAll();
    }

    public BigDecimal calculateTotalPrice(Invoice invoice) {
        log.debug("Calculate Total Price ");
        log.info("Calculate Total Price ");
        log.error("Calculate Total Price ");

        BigDecimal totalPrice = invoice.getSalesPrice();

        // Add tax to the total price
        BigDecimal tax = totalPrice.multiply(invoice.getTaxRate());
        totalPrice = totalPrice.add(tax);

        return totalPrice.setScale(2, RoundingMode.HALF_UP);
    }

    Invoice getInvoiceByName(String name) {
        return invoiceRepository.findInvoiceByCustomerName(name);
    }
}
