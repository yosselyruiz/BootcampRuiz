package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.yearup.data.ProductDao;
import org.yearup.data.ShoppingCartDao;
import org.yearup.data.UserDao;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;
import org.yearup.models.User;

import java.security.Principal;
import java.security.PublicKey;

// convert this class to a REST controller
// only logged-in users should have access to these actions
@RestController
@RequestMapping("/cart")
@PreAuthorize("hasRole('ROLE_USER')")

public class ShoppingCartController {
    // a shopping cart requires
    private ShoppingCartDao shoppingCartDao;
    private UserDao userDao;
    private ProductDao productDao;

    // each method in this controller requires a Principal object as a parameter
    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public ShoppingCart getCart(Principal principal){
        try {
            if (principal == null || principal.getName() == null) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
            }
            // get the currently logged in username
            String userName = principal.getName();
            // find database user by userId
            User user = userDao.getByUserName(userName);
            if (user == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
            }
            int userId = user.getId();
            // use the shoppingcartDao to get all items in the cart and return the cart
            ShoppingCart cart = shoppingCartDao.getByUserId(userId);

            if (cart == null) {
                // Optional: return empty cart instead of null or handle as needed
                cart = new ShoppingCart();
            }
            return cart;
        }
        catch(Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
        }
    }

    // add a POST method to add a product to the cart - the url should be
    // https://localhost:8080/cart/products/15 (15 is the productId to be added
@PostMapping("/products/{product_id}")
@PreAuthorize("hasRole('ROLE_USER')")
    public ShoppingCart addToCart(@RequestBody int user_id, int product_id, Principal principal){
        try{
            String userName = principal.getName();
            User user = userDao.getByUserName(userName);
            int userId = user.getId();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Our fault.");
        }
    return shoppingCartDao.add(user_id,product_id, principal);
}

    // add a PUT method to update an existing product in the cart - the url should be
    // https://localhost:8080/cart/products/15 (15 is the productId to be updated)
    // the BODY should be a ShoppingCartItem - quantity is the only value that will be updated
@PutMapping("/cart/products/{product_id}")
@PreAuthorize("hasRole('ROLE_USER')")
public void updateCart(@PathVariable int user_id, int productId, Principal principal, @RequestBody ShoppingCartItem item){
        try{
            shoppingCartDao.update(user_id,productId,principal, item);
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Our fault.");
        }
}

    // add a DELETE method to clear all products from the current users cart
    // https://localhost:8080/cart
@DeleteMapping("/cart")
@PreAuthorize("hasRole('ROLE_USER')")
    public void deleteteItem(Principal principal) {
    try {
        String userName = principal.getName(); // get current user
        shoppingCartDao.clearCart(userName); // delete all cart items for user
    } catch (Exception ex) {
        ex.printStackTrace();
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Our fault");
    }
}
}
