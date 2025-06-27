package org.yearup.data;

import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

import java.security.Principal;

public interface ShoppingCartDao {
    ShoppingCart getByUserId(int userId);
    ShoppingCart add(int userId, int productId, Principal principal);
    void update (int userId, int productId, Principal principal, ShoppingCartItem item);
    void clearCart(String userId);


}
