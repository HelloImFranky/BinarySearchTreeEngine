package edu.citytech.datastructure.sid15304372;

import edu.citytech.datastructure.sid15304372.bst.BinarySearchTree;
import edu.citytech.datastructure.sid15304372.bst.CustomSearchEngine;
import edu.citytech.datastructure.sid15304372.model.Product;
import com.jbbwebsolutions.bst.BSTFacade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class T5_ToList {
	
	static Product[] products;
	static double sum = 0;
	
	static {
		
		Product[] aProducts = {new Product("p1", 76f), new Product("p2", 40f), new Product("p7", 10f)
				, new Product("p3", 96f), new Product("p4", 100f)
				, new Product("p5", 82f), new Product("p6", 88f)
				};
		
		products = Arrays.stream(aProducts).toArray(Product[]::new);
		
		sum = Arrays.stream(aProducts).mapToDouble(Product::getPrice).sum(); 
		
	}
	
	
	@Test
	@DisplayName("To Size")
	void getSize() {
		
		BSTFacade<Product> bst = new BinarySearchTree<Product>(new CustomSearchEngine<>());
		bst.insert(products);
		
		var list = bst.toList();
		
		list.stream().map(Product::getPrice).forEach(System.out::println);
		
		var actual = bst.toList().size();
		var expected = 7;
		
	    assertEquals(actual, expected);
	}

	
}