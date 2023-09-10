package com.DeltaX.InventoryManagement.Repository;

import com.DeltaX.InventoryManagement.Entity.Inventory;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InventoryRepository {
    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public String save(Inventory inventory){
        dynamoDBMapper.save(inventory);
        return "New Product Added";
    }

    public Inventory getByID(String id){
        return dynamoDBMapper.load(Inventory.class,id);
    }

    public List<Inventory> findAll(){
        return dynamoDBMapper.scan(Inventory.class, new DynamoDBScanExpression());
    }

    public void delete(String id){
        Inventory inv = dynamoDBMapper.load(Inventory.class,id);
        dynamoDBMapper.delete(inv);
    }
    public void update(String id, Inventory inventory){
        dynamoDBMapper.save(inventory,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("id",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(id)
                                )));
    }

    public String saveItems(List<Inventory> items){
        dynamoDBMapper.batchSave(items);
        return "New Products are added";
    }

}
