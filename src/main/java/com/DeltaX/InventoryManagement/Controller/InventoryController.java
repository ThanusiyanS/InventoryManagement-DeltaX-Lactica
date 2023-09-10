package com.DeltaX.InventoryManagement.Controller;

import com.DeltaX.InventoryManagement.Entity.Inventory;
import com.DeltaX.InventoryManagement.InventoryManagementApplication;
import com.DeltaX.InventoryManagement.Service.InventoryService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/add")
    public String addProduct(@RequestBody Inventory inventory) {
        return inventoryService.createInventory(inventory);
    }

    @PostMapping("/addAll")
    public String addProduct(@RequestBody List<Inventory> items) {
        return inventoryService.addItems(items);
    }

    @GetMapping("/getAll")
    public List<Inventory> getAllProduct() {
        return inventoryService.getAllProducts();
    }

    @GetMapping("/get/{productId}")
    public Inventory getAProduct(@PathVariable String productId) {
        return inventoryService.getAProduct(productId);
    }

    @DeleteMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable String productId) {
        return inventoryService.deleteproduct(productId);
    }

    @PostMapping("/update/{productId}")
    public String updateProduct(@PathVariable String productId, @RequestBody Inventory inventory) {
        return inventoryService.updateProduct(productId, inventory);
    }

    @GetMapping("/checkStock/{productId}")
    public boolean IsAvailable(@PathVariable String productId, @RequestParam Long reqQuant) {
        return inventoryService.isAvailable(productId, reqQuant);
    }
}
