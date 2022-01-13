package edu.citytech.datastructure.sid15304372;

import edu.citytech.datastructure.sid15304372.bst.BinarySearchTree;
import edu.citytech.datastructure.sid15304372.bst.CustomSearchEngine;
import edu.citytech.datastructure.sid15304372.model.Product;
import com.jbbwebsolutions.bst.BSTFacade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T7_averageTest {

    @Test
    @DisplayName("Finding the average of products")
    void getAverageProduct() {

        BSTFacade<Product> bst = new BinarySearchTree<Product>(new CustomSearchEngine<Product>());
        bst.insert( new Product("p1",10)
                ,new Product("p2",20)
                ,new Product("p3",30));

        var actual = bst.average();
        var expected = 20 ;

        assertEquals(expected, actual);
    }


}
