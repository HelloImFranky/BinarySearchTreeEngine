package edu.citytech.datastructure.sid15304372;

import edu.citytech.datastructure.sid15304372.bst.AVLTreeInsertion;
import edu.citytech.datastructure.sid15304372.bst.BinarySearchTree;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class T9_BTSProduct {

	@Test
	@DisplayName("Searching for 1500,2000,1750,3000")
	void getBasicSearchEngineA() {
		var bst = new BinarySearchTree<Integer>(new AVLTreeInsertion());
		bst.batchInserts(1500,2000,1750,3000);
		var node = bst.rotateLeft();
		System.out.println(node);
//	    assertEquals(actual, expected);
	}

	@Test
	@DisplayName("Searching for 1, 2, 3")
	void getBasicSearchEngineB() {
		var bst = new BinarySearchTree<Integer>(new AVLTreeInsertion());
		bst.batchInserts(10,20,30,40,7,100,50);
		System.out.println("");
//	    assertEquals(actual, expected);
	}
}