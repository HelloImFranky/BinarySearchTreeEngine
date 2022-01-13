package edu.citytech.datastructure.sid15304372;

import com.jbbwebsolutions.bst.BSTFacade;
import edu.citytech.datastructure.sid15304372.bst.BinarySearchTree;
import edu.citytech.datastructure.sid15304372.bst.CustomSearchEngine;
import edu.citytech.datastructure.sid15304372.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T8_heightTest {

    @Test
    @DisplayName("Checking height")
    void getAverageProduct() {

        BSTFacade<Product> bst = new BinarySearchTree<Product>(new CustomSearchEngine<Product>());
        bst.insert( new Product("p1",10)
                ,new Product("p2",1)
                ,new Product("p3",30)
                ,new Product("p4",50)
                ,new Product("p5",2)
                ,new Product("p6",9));

        var actual = bst.height();
        var expected = 3 ;

        assertEquals(expected, actual);
    }


}
