package com.redisPractice.RedisCachePractice.controller;

import com.redisPractice.RedisCachePractice.model.Invoice;
import com.redisPractice.RedisCachePractice.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
  @Autowired
  InvoiceService invoiceService;
  @PostMapping("/saveInv")
  public Invoice saveInvoice(@RequestBody Invoice inv) {
    return invoiceService.saveInvoice(inv);
  }

  @GetMapping("/allInv")
  public ResponseEntity<List<Invoice>> getAllInvoices(){
    return ResponseEntity.ok(invoiceService.getAllInvoices());
  }

  @GetMapping("/getOne/{id}")
  public Invoice getOneInvoice(@PathVariable Integer id) {
    return invoiceService.getOneInvoice(id);
  }

  @PutMapping("/modify/{id}")
  public Invoice updateInvoice(@RequestBody Invoice inv, @PathVariable Integer id) {
    return invoiceService.updateInvoice(inv, id);
  }

  @DeleteMapping("/delete/{id}")
  public String deleteInvoice(@PathVariable Integer id) {
    invoiceService.deleteInvoice(id);
    return "Employee with id: "+id+ " Deleted !";
  }
}
