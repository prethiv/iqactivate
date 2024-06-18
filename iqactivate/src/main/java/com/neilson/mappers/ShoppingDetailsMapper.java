package com.neilson.mappers;

import com.neilson.entity.ShoppingDetails;
import org.springframework.stereotype.Component;

@Component
public class ShoppingDetailsMapper {

    public static ShoppingDetails getShoppingDetails(String shopperId,String shelfId){
        ShoppingDetails shoppingDetails = new ShoppingDetails();
        shoppingDetails.setShopperId(shopperId);
        shoppingDetails.setAdditionalInfo("{}");
        shoppingDetails.setShelfid(shelfId);
        shoppingDetails.setTime_created((int) System.currentTimeMillis());
        shoppingDetails.setTime_updated((int) System.currentTimeMillis());
        return shoppingDetails;
    }
}
