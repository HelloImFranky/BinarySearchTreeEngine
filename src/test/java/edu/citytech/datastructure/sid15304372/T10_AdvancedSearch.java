package edu.citytech.datastructure.sid15304372;

import com.jbbwebsolutions.bst.BSTFacade;
import com.jbbwebsolutions.bst.EnumComparison;
import edu.citytech.datastructure.sid15304372.bst.AVLTreeInsertion;
import edu.citytech.datastructure.sid15304372.bst.AdvancedSearchEngine;
import edu.citytech.datastructure.sid15304372.bst.BinarySearchTree;
import edu.citytech.datastructure.sid15304372.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class T10_AdvancedSearch {
	static Product[] products;
	static double sum = 0;

	static {
		
		Product[] aProducts = {new Product("p1", 700f), new Product("p2", 600f), new Product("p3", 500f)
				, new Product("p4", 400f), new Product("p5", 600f)
				, new Product("p6", 605f), new Product("p7", 625f), new Product("p8", 100f)
				, new Product("p9", 1200f)
				, new Product("p10", 800f)
				, new Product("p11", 950f)
				, new Product("p12", 1100f)
				, new Product("p12", 1300f)
				, new Product("p13", 340f)
				, new Product("p14", 200f)};

		products = Arrays.stream(aProducts).toArray(Product[]::new);
		sum = Arrays.stream(aProducts).mapToDouble(Product::getPrice).sum();
		
	}

	@Test
	@DisplayName("Greater 500")
	void getBasicSearchEngine2() {
		BSTFacade<Product> bst = new BinarySearchTree<Product>(new AdvancedSearchEngine(), new AVLTreeInsertion());
		bst.insert(products);

		Predicate<EnumComparison> predicate = e -> EnumComparison.GREATER_THAN == e;
		predicate = predicate.or(e->EnumComparison.EQUAL ==e);
		AtomicInteger comparisons = new AtomicInteger();
		var list = bst.findAll(new Product(500f), predicate, (Product e1, Long e2) -> {
			comparisons.addAndGet(Math.toIntExact(e2));
			System.out.println(e1 + " - " + comparisons);
		});

		var actual= list.size();
		var expected = 9;
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("less than 500")
	void getBasicSearchEngine3() {

		BSTFacade<Product> bst = new BinarySearchTree<Product>(new AdvancedSearchEngine(), new AVLTreeInsertion());
		bst.insert(products);

		Predicate<EnumComparison> predicate = e -> EnumComparison.LESS_THAN == e;
		predicate = predicate.or(e->EnumComparison.EQUAL ==e);
		AtomicInteger comparisons = new AtomicInteger();
		var list = bst.findAll(new Product(500f), predicate, (Product e1, Long e2) -> {
			comparisons.addAndGet(Math.toIntExact(e2));
			System.out.println(e1 + " - " + comparisons);
		});

		var actual = list.size();
		var expected = 4;
		assertEquals(expected,actual);
	}

	@Test
	@DisplayName("less than 950")
	void getBasicSearchEngine4() {

		BSTFacade<Product> bst = new BinarySearchTree<Product>(new AdvancedSearchEngine(), new AVLTreeInsertion());
		bst.insert(products);

		Predicate<EnumComparison> predicate = e -> EnumComparison.LESS_THAN == e;
		predicate = predicate.or(e->EnumComparison.EQUAL ==e);
		AtomicInteger comparisons = new AtomicInteger();
		var list = bst.findAll(new Product(950f), predicate, (Product e1, Long e2) -> {
			comparisons.addAndGet(Math.toIntExact(e2));
			System.out.println(e1 + " - " + comparisons);
		});

		var actual = list.size();
		var expected = 2;
		assertEquals(expected,actual);
	}

	@Test
	@DisplayName("less than 1200")
	void getBasicSearchEngine4A() {

		BSTFacade<Product> bst = new BinarySearchTree<Product>(new AdvancedSearchEngine(), new AVLTreeInsertion());
		bst.insert(products);

		Predicate<EnumComparison> predicate = e -> EnumComparison.LESS_THAN == e;
		predicate = predicate.or(e->EnumComparison.EQUAL ==e);
		AtomicInteger comparisons = new AtomicInteger();
		var list = bst.findAll(new Product(1200f), predicate, (Product e1, Long e2) -> {
			comparisons.addAndGet(Math.toIntExact(e2));
			System.out.println(e1 + " - " + comparisons);
		});

		var actual = list.size();
		var expected = 4;
		assertEquals(expected,actual);
	}

	@Test
	@DisplayName("greater than 950")
	void getBasicSearchEngine5() {

		BSTFacade<Product> bst = new BinarySearchTree<Product>(new AdvancedSearchEngine(), new AVLTreeInsertion());
		bst.insert(products);

		Predicate<EnumComparison> predicate = e -> EnumComparison.GREATER_THAN == e;
		predicate = predicate.or(e->EnumComparison.EQUAL ==e);
		AtomicInteger comparisons = new AtomicInteger();
		var list = bst.findAll(new Product(950f), predicate, (Product e1, Long e2) -> {
			comparisons.addAndGet(Math.toIntExact(e2));
			System.out.println(e1 + " - " + comparisons);
		});

		var actual = list.size();
		var expected = 5;
		assertEquals(expected,actual);
	}

	@Test
	@DisplayName("Equal to 500")
	void getBasicSearchEngine6() {

		BSTFacade<Product> bst = new BinarySearchTree<Product>(new AdvancedSearchEngine(), new AVLTreeInsertion());
		bst.insert(products);

		Predicate<EnumComparison> predicate = e -> EnumComparison.EQUAL == e;
		AtomicInteger comparisons = new AtomicInteger();
		var list = bst.findAll(new Product(500f), predicate, (Product e1, Long e2) -> {
			comparisons.addAndGet(Math.toIntExact(e2));
			System.out.println(e1 + " - " + comparisons);
		});

		var actual = list.size();
		var expected = 4;
		assertEquals(expected,actual);
	}

	@Test
	@DisplayName("Equal to 1200")
	void getBasicSearchEngine7() {

		BSTFacade<Product> bst = new BinarySearchTree<Product>(new AdvancedSearchEngine(), new AVLTreeInsertion());
		bst.insert(products);

		Predicate<EnumComparison> predicate = e -> EnumComparison.EQUAL == e;
		AtomicInteger comparisons = new AtomicInteger();
		var list = bst.findAll(new Product(1200f), predicate, (Product e1, Long e2) -> {
			comparisons.addAndGet(Math.toIntExact(e2));
			System.out.println(e1 + " - " + comparisons);
		});

		var actual = list.size();
		var expected = 3;
		assertEquals(expected,actual);
	}

	@Test
	@DisplayName("Equal to 625")
	void getBasicSearchEngine8() {

		BSTFacade<Product> bst = new BinarySearchTree<Product>(new AdvancedSearchEngine(), new AVLTreeInsertion());
		bst.insert(products);

		Predicate<EnumComparison> predicate = e -> EnumComparison.EQUAL == e;
		AtomicInteger comparisons = new AtomicInteger();
		var list = bst.findAll(new Product(625f), predicate, (Product e1, Long e2) -> {
			comparisons.addAndGet(Math.toIntExact(e2));
			System.out.println(e1 + " - " + comparisons);
		});

		var actual = list.size();
		var expected = 3;
		assertEquals(expected,actual);
	}

}