package edu.citytech.datastructure.sid15304372.bst;

import com.jbbwebsolutions.bst.AbstractSearchEngine;
import com.jbbwebsolutions.bst.INumber;
import com.jbbwebsolutions.bst.Node;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static edu.citytech.datastructure.sid15304372.bst.TreeHelper.*;

public class CustomSearchEngine<T extends Comparable<T>> extends AbstractSearchEngine<T> {

    private T binarySearch(Node<T> node, T value, Consumer<T> consumer) {

        consumer.accept(node.value);

        if(isEqual(node.value,value)){
            return node.value;
        }
        else if(isLessThan(value, node.value)){
            binarySearch(node.leftChild,value,consumer);
        }
        else if(isGreaterThan(value, node.value)) {
            binarySearch(node.rightChild, value, consumer);
        }
        return null;
    }


    @Override
    public T find(Node<T> root, T value, Consumer<T> consumer) {
        System.out.println("Customer Search Executed");

        return this.binarySearch(root, value, consumer);
    }

    private T minSearch(Node<T> node) {
        if(node == null ){
            return (T) new RuntimeException("Node Empty");
        }
        if(node.leftChild == null){
            return node.value;
        }
        return min(node.leftChild);
    }

    @Override
    public T min(Node<T> node) {
        System.out.println("Min Search Executed");
        return this.minSearch(node);
    }

    private T maxSearch(Node<T> node) {
        if(node == null ){
            return (T) new RuntimeException("Node Empty");
        }
        if(node.rightChild == null){
            return node.value;
        }
        return max(node.rightChild);
    }

    @Override
    public T max(Node<T> node) {
        System.out.println("Max Search Executed");
        return this.maxSearch(node);
    }

    @Override
    public void traversePreOrder(Node<T> node, Consumer<T> consumer) {
        if(node == null){
            return;
        }
        consumer.accept(node.value);


        traversePreOrder(node.leftChild, consumer);
        traversePreOrder(node.rightChild, consumer);
    }

    @Override
    public double sum(Node<T> node) {
        AtomicReference<Double> total = new AtomicReference<>(0d);
        this.traversePreOrder(node, data -> {
           if(data instanceof Number){
               var $123 = ((Number)data).doubleValue() + total.get();
               total.set($123);
           }
           else if(data instanceof INumber){
               var $123 = ((INumber)data).getNumber() + total.get();
               total.set($123);
           }
        });

        return total.get();
    }


    public long heightMyVersion(Node<T>node){
        if(node == null){
            return -1;
        }
        var leftNode = height(node.leftChild);
        var rightNode = height(node.rightChild);

        if(leftNode > rightNode){
            return leftNode + 1;
        }else{
            return rightNode + 1;
        }
    }

    @Override
    public long height(Node<T>node){
        if(isEmpty(node)){
            return -1;
        }
        if(isEmpty(node.leftChild) && isEmpty(node.rightChild)){
            return 0;
        }
        var leftNode = height(node.leftChild);
        var rightNode = height(node.rightChild);
        long max = Math.max(leftNode,rightNode)+1;
        node.height = max;

        return max;
    }

    @Override
    public T find(Node<T> node, T value, BiConsumer<T, Long> biConsumer) {
        return this.binarySearch(node, value, biConsumer);
    }

    private T binarySearch(Node<T> node, T value, BiConsumer<T, Long> biConsumer) {

        biConsumer.accept(node.value, node.height);

        if(isEqual(node.value,value)){
            return node.value;
        }
        else if(isLessThan(value, node.value)){
            binarySearch(node.leftChild,value,biConsumer);
        }
        else if(isGreaterThan(value, node.value)) {
            binarySearch(node.rightChild, value, biConsumer);
        }
        return null;
    }
}
