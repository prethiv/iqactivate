package com.neilson.controllers;

import com.neilson.entity.*;
import com.neilson.mappers.ProductEntityMapper;
import com.neilson.mappers.ShoppingDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.Logger;

@RestController
public class StoreShopperController {

    private static final String template = "Hello, %s!";

    @Autowired
    ShoppingInfoRepo shoppingInfoRepo;

    @Autowired
    ShelfEntityRepo shelfrepo;


    @Autowired
    ProductEntityRepo prdtrepo;

    @Autowired
    Retrievedetails retr;

    @Autowired
    ProductEntityMapper productEntityMapper;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello";
    }
    Logger logger = Logger.getLogger("StoreShopperController");

    /**
     * Endpoint to save products
     * @param product
     * @return JSON
     */
    @RequestMapping(value = "/saveproducts", method = RequestMethod.POST,
            consumes = "application/json")
    public Map<String, Object> saveShopperInfo(@RequestBody ProductModel product) {
        ProductEntity productEntity = productEntityMapper.getProductEntity(product);
        logger.info("Inside /saveproducts endpoint");
        Map<String, Object> response = new HashMap<>();
        if (!prdtrepo.existsById(productEntity.getId())) {
            logger.info("Going to save product");
            prdtrepo.save(productEntity);
            logger.info("Product Saved Successfully");
            response.put("message","InsertionSuccessful");
        } else {
            logger.severe("Primary Key Issue");
            response.put("message", "PK Issue");
        }
        logger.info("Returning the response");
        return response;
    }

    /**
     * Endpoint to save ShopperInfo
     * @param shoppingInfo
     * @return JSON
     */
    @RequestMapping(value = "/saveShoppers", method = RequestMethod.POST,
            consumes = "application/json")
    public Map<String, Object> saveShopperInfo(@RequestBody ShoppingInfo shoppingInfo) {
        logger.info("Inside /saveShoppers endpoint");
        String shopperId = shoppingInfo.getShopperId();
        String shelfid = UUID.randomUUID().toString();
        List<Product> products = shoppingInfo.getShelf();
        logger.info("Framing the shopping details pojo");
        ShoppingDetails shoppingDetails = ShoppingDetailsMapper.getShoppingDetails(shopperId,shelfid);
        List<ShelfEntity> shelfEntities = new ArrayList<>();
        logger.info("Framing the products list");
        Map<String, Object> resposne = new HashMap<>();

        for (Product product : products) {
            ShelfEntity shelfEntity = new ShelfEntity();
            shelfEntity.setId(UUID.randomUUID().toString());
            shelfEntity.setAdditionalInfo("{}");
            shelfEntity.setShelfid(shelfid);
            shelfEntity.setProductid(product.getProductId());
            shelfEntity.setScore(String.valueOf(product.getRelevancyScore()));
            shelfEntity.setTime_updated((int) System.currentTimeMillis());
            shelfEntity.setTime_created((int) System.currentTimeMillis());
            shelfEntities.add(shelfEntity);
        }

        if (!shoppingInfoRepo.existsById(shopperId)) {
            logger.info("shopper does not exist hence saving");
            shoppingInfoRepo.save(shoppingDetails);
            shelfrepo.saveAll(shelfEntities);
            resposne.put("message","Save Success");
        } else {
            resposne.put("message", "PK issue");
        }
        return resposne;
    }

    /**
     * An utility method to clear the db
     * @return
     */
    @RequestMapping(value = "/clearAll", method = RequestMethod.DELETE)
    public String clearDb() {
        List<ShelfEntity> shelfEntities = retr.getAllShelfRecords();
        for (ShelfEntity shelfEntity : shelfEntities) {
            shelfrepo.deleteById(shelfEntity.getId());
        }
        List<ProductEntity> productEntities = prdtrepo.findAll();
        for (ProductEntity productEntity : productEntities) {
            prdtrepo.deleteById(productEntity.getId());
        }
        List<ShoppingDetails> shoppingDetails = shoppingInfoRepo.findAll();
        for (ShoppingDetails shoppingDetail : shoppingDetails) {
            shoppingInfoRepo.deleteById(shoppingDetail.getShopperId());
        }
        return "DB CLEARED";
    }

    /**
     * Find Shoppers purchased products
     * @param request
     * @return
     */
    @RequestMapping(value = "/findShoppersProduct", method = RequestMethod.POST,
            consumes = "application/json")
    public List<ProductEntity> findShoppersProduct(@RequestBody Map<String, Object> request) {
        String shopperid = (String) request.get("shopperid");
        List<ShoppingDetails> shoppingDetailsList = shoppingInfoRepo.fetchShoppers(shopperid);
        String shelfid = shoppingDetailsList.get(0).getShelfid();
        List<ShelfEntity> shelfEntities = retr.fetchShelves(shelfid);
        List<String> productids = new ArrayList<>();
        for (ShelfEntity shelfEntity : shelfEntities) {
            productids.add(shelfEntity.getProductid());
        }
        return prdtrepo.findAllById(productids);
    }


    /**
     * FInd products by category
     * @param request
     * @return
     */
    @RequestMapping(value = "/findProductsByCategory", method = RequestMethod.POST,
            consumes = "application/json")
    public List<ProductEntity> findbyProductCategory(@RequestBody Map<String, Object> request) {
        String category = (String) request.get("category");
        return prdtrepo.fetchProducts(category);
    }


    /**
     * Find products by brand
     * @param request
     * @return
     */
    @RequestMapping(value = "/findProductsByBrand", method = RequestMethod.POST,
            consumes = "application/json")
    public List<ProductEntity> findProductsByBrand(@RequestBody Map<String, Object> request) {
        String brand = (String) request.get("brand");
        return prdtrepo.fetchProductsByBrand(brand);
    }

    /**
     * FInd products by limit
     * @param request
     * @return
     */
    @RequestMapping(value = "/findProductsByLimit", method = RequestMethod.POST,
            consumes = "application/json")
    public List<ProductEntity> findProductsByLimit(@RequestBody Map<String, Object> request) {
        int limitstart = (int) request.get("limitstart");
        int maxlimit = (int) request.get("maxlimit");
        return prdtrepo.fetchProductsByLimit(limitstart, maxlimit);
    }


}