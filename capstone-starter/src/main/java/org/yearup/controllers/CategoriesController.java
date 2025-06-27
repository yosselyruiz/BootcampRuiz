package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.yearup.data.CategoryDao;
import org.yearup.data.ProductDao;
import org.yearup.models.Category;
import org.yearup.models.Product;

import java.util.List;

// add the annotations to make this a REST controller
// add the annotation to make this controller the endpoint for the following url
    // http://localhost:8080/categories
// add annotation to allow cross site origin requests
@RestController
@RequestMapping("/categories")
@CrossOrigin
public class CategoriesController {
    private CategoryDao categoryDao;
    private ProductDao productDao;

    // create an Autowired controller to inject the categoryDao and ProductDao
    @Autowired
    public CategoriesController(CategoryDao categoryDao, ProductDao productDao){
        this.categoryDao = categoryDao;
        this.productDao = productDao;
    }
    // add the appropriate annotation for a get action
    @GetMapping("")
    @PreAuthorize("permitAll()")
    // find and return all categories
    public ResponseEntity<List<Category>> getAll() {
        var categories = categoryDao.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    // add the appropriate annotation for a get action
    @GetMapping("/{id}")
    // get the category by id
    public ResponseEntity<Category> getById(@PathVariable int id) {
        Category category = categoryDao.getById(id);
        if(category == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(category, HttpStatus.OK);
        }
    }

    // the url to return all products in category 1 would look like this
    // https://localhost:8080/categories/1/products
    @GetMapping("{categoryId}/products")
    // get a list of product by categoryId
    public ResponseEntity<List<Product>> getProductsById(@PathVariable int categoryId) {
       List<Product> products = productDao.listByCategoryId(categoryId);
        if (products == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
    }

    // add annotation to call this method for a POST action
    // add annotation to ensure that only an ADMIN can call this function
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    // insert the category
    public Category addCategory(@RequestBody Category category) {
        try {
            return categoryDao.create(category);
        }
        catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Our fault");
        }
    }

    // add annotation to call this method for a PUT (update) action - the url path must include the categoryId
    // add annotation to ensure that only an ADMIN can call this function
    @PutMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    // update the category by id
    public void updateCategory(@PathVariable int id, @RequestBody Category category) {
       try{
           categoryDao.update(id,category);
        }
       catch (Exception ex){
           ex.printStackTrace();
           throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Our fault.");
       }
    }


    // add annotation to call this method for a DELETE action - the url path must include the categoryId
    // add annotation to ensure that only an ADMIN can call this function
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    // delete the category by id
    public void deleteCategory(@PathVariable int id) {
        try{
            var category = categoryDao.getById(id);
            if(category == null)
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            categoryDao.delete(id);
        }
        catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Our fault.");
        }
    }
}
