package com.redisPractice.RedisCachePractice.services;

import com.redisPractice.RedisCachePractice.exceptions.InvoiceNotFound;
import com.redisPractice.RedisCachePractice.model.Invoice;
import com.redisPractice.RedisCachePractice.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public class InvoiceServiceImpl implements InvoiceService{
  @Autowired
  private InvoiceRepository invoiceRepository;
  @Override
  public Invoice saveInvoice(Invoice inv){
    return invoiceRepository.save(inv);
  }

  @Override
  @CachePut(value = "Invoice", key = "#invId")
  public Invoice updateInvoice(Invoice inv, Integer invId){
    Invoice invoice = invoiceRepository.findById(invId)
      .orElseThrow(()->new InvoiceNotFound("Invoice Not Found"));
    invoice.setInvAmount(inv.getInvAmount());
    invoice.setInvName(inv.getInvName());
    return invoiceRepository.save(invoice);
  }

  @Override
  @CacheEvict(value = "Invoice", key = "#invId")
  public void deleteInvoice(Integer invId) {
    Invoice invoice = invoiceRepository.findById(invId).orElseThrow(()->new InvoiceNotFound("Invoice Not Found"));
    invoiceRepository.delete(invoice);
  }

  @Override
  @Cacheable(value = "Invoice", key = "#invId")
  public Invoice getOneInvoice(Integer invId) {
    Invoice invoice = invoiceRepository.findById(invId).orElseThrow(()->new InvoiceNotFound("Invoice Not Found"));
    return invoice;
  }

  @Override
  @Cacheable(value="Invoice")
  public List<Invoice> getAllInvoices() {
    return invoiceRepository.findAll();
  }

}
