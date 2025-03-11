package br.sistemalojaroupas.model.services;

import br.sistemalojaroupas.model.dao.ProductDao;
import br.sistemalojaroupas.model.dao.SaleDao;
import br.sistemalojaroupas.model.entities.Product;
import br.sistemalojaroupas.model.entities.Sale;
import br.sistemalojaroupas.model.entities.SaleItem;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class SaleService {
    
    public static void confirmSale(Sale sale) {
        sale.getItems().forEach(x -> {
            Product product = x.getProduct();
            product.setQuantity(product.getQuantity() - x.getQuantity());
            ProductDao.update(product);
        });
        sale.setMoment(new Date());
        SaleDao.insert(sale);
    }
    
    public static Double ticketMedio() {
        Long totalSales = SaleDao.size();
        Double revenues = SaleDao.revenues(0);
        
        Double result = 0.0;
        result = revenues / totalSales;
        
        return (totalSales != 0) ? result : 0.0;
    }
    
    public static Double receitaLiquida() {
        Double revenues = SaleDao.revenues(0);
        Double receitaLiquida = 0.0;
        List<SaleItem> items = new LinkedList<>();
        
        SaleDao.findAll().forEach(s -> {
            items.addAll(s.getItems());
        });
        
        for (SaleItem item : items) {
            Double subTotal = item.getSubTotal();
            Integer quantity = item.getQuantity();
            Double totalCost = item.getProduct().getCostPrice() * quantity;
            
            receitaLiquida += subTotal - totalCost;
        }
        return receitaLiquida;
    }
}
