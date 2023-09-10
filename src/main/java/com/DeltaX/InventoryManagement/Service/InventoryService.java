package com.DeltaX.InventoryManagement.Service;

import com.DeltaX.InventoryManagement.Entity.Inventory;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface InventoryService {

    public String createInventory(Inventory inventory);
    public String addItems(List<Inventory> items);
    public List<Inventory> getAllProducts();
    public Inventory getAProduct(String id);
    public String deleteproduct(String id);
    public String updateProduct(String id,Inventory inventory);
    public boolean isAvailable(String id,Long reqQuant);
}
