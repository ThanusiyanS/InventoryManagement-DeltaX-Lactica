package com.DeltaX.InventoryManagement.Service;

import com.DeltaX.InventoryManagement.Entity.Inventory;
import com.DeltaX.InventoryManagement.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService{
    @Autowired
    private InventoryRepository inventoryRepository;
    @Override
    public String createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public List<Inventory> getAllProducts() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory getAProduct(String id) {
        return inventoryRepository.getByID(id);
    }

    @Override
    public String deleteproduct(String id) {
        inventoryRepository.delete(id);
        return "Product deleted";
    }

    @Override
    public String updateProduct(String id, Inventory inventory) {
        inventoryRepository.update(id,inventory);
        return id+" successfully updated";
    }

    @Override
    public String addItems(List<Inventory> items) {
        return inventoryRepository.saveItems(items);
    }

    @Override
    public boolean isAvailable(String id, Long reqQuant) {
        Inventory product = inventoryRepository.getByID(id);
        return (product.getStockQuantity() >= reqQuant);
    }
}
