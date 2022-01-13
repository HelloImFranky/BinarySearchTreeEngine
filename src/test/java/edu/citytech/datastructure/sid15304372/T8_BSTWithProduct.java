package edu.citytech.datastructure.sid15304372;

import edu.citytech.datastructure.sid15304372.bst.AVLTreeInsertion;
import edu.citytech.datastructure.sid15304372.bst.BinarySearchTree;
import edu.citytech.datastructure.sid15304372.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


class T8_BSTWithProduct {
	static Product[] products;
	static {
		
		Product[] aProducts = {new Product("p1", 76f), new Product("p2", 40f), new Product("p2b", 10f)
				, new Product("p3", 96f), new Product("p4", 100f)
				, new Product("p5", 82f), new Product("p6", 88f), new Product("p4", 9)
				, new Product("p7", 105f)};
		
		products = Arrays.stream(aProducts).toArray(Product[]::new);
		
	}

	@Test
	@DisplayName("Searching by Product")
	void getBasicSearchEngine() {
		var bst = new BinarySearchTree<Product>(new AVLTreeInsertion());
		bst.batchInserts(products);
		var product = bst.find( new Product(105f));
		var actual = 105f;
		var expected = product.getPrice();
	    assertEquals(actual, expected);
	}

}