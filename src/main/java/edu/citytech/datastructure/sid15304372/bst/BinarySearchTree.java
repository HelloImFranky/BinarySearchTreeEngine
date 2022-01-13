package edu.citytech.datastructure.sid15304372.bst;

import com.jbbwebsolutions.bst.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class BinarySearchTree <T extends Comparable<T>> implements BSTFacade<T> {

    private Node<T> root;
    private AbstractSearchEngine<T> findEngine = null;
    private NodeFacadeInsertion<T> insertFacade = null;

    public BinarySearchTree(){
        this.findEngine = new DefaultSearch<T>();
        this.insertFacade = new BasicNodeInsertion<>();
    }

    public BinarySearchTree(NodeFacadeInsertion<T> insertFacade){
        this.findEngine = new DefaultSearch<T>();
        this.insertFacade = insertFacade;
    }

    public BinarySearchTree(AbstractSearchEngine findEngine){
        this.findEngine = findEngine;
        this.insertFacade = new BasicNodeInsertion<>();
    }

    public BinarySearchTree(AbstractSearchEngine findEngine, NodeFacadeInsertion insertFacade){
        this.findEngine = findEngine;
        this.insertFacade = insertFacade;
    }

    public void batchInserts(T... values){
        Arrays.stream(values).forEach(this::insert);
    }


    @Override
    public void insert(T... values) {
        Arrays.stream(values).forEach(this::insert);
    }

    private long size = 0;

    public void insert(T value) {
        this.root = this.insertFacade.insert(root, value, e ->{
            this.size = e;
            this.height();
        });
    }


    public T find(T value){
        return this.find(value, e -> {});
    }

    public T find(T value, Consumer<T> consumer){
        return this.findEngine.find(root,value,consumer);
    }

    public T min(){
        return this.findEngine.min(root);
    }

    public T max(){
        return this.findEngine.max(root);
    }

    @Override
    public List<T> toList() {
        List<T> list = new ArrayList<>();
        this.findEngine.traversePreOrder(this.root, list::add);
        return list;
    }

    @Override
    public double sum() {
        return this.findEngine.sum(root);
    }

    @Override
    public double average() {
        return this.findEngine.sum(root)/size;
    }

    @Override
    public long size() {

        return this.size;
    }

    @Override
    public long height() {

        return this.findEngine.height(root);
    }

    @Override
    public long height(T t) {
        AtomicLong h = new AtomicLong(-1);
        this.findEngine.find(root, t, (e,height) ->{
            h.set(height);
        });

        return h.get();
    }

    public Node<T> rotateLeft(){
        var newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        return newRoot;
    }

    @Override
    public List<T> findAll(T value, Predicate<EnumComparison> predicate, BiConsumer<T, Long> biConsumer) {
        return this.findEngine.findAll(this.root, value, predicate, biConsumer);
    }
}
