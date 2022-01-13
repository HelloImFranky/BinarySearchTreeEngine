package edu.citytech.datastructure.sid15304372.bst;

import com.jbbwebsolutions.bst.AbstractSearchEngine;
import com.jbbwebsolutions.bst.Node;

import java.util.function.Consumer;

import static edu.citytech.datastructure.sid15304372.bst.TreeHelper.*;

public class DefaultSearch <T extends Comparable<T>> extends AbstractSearchEngine<T> {

    @Override
    public T find(Node<T> root, T value, Consumer<T> consumer) {
        T t = null;
        var current = root;

        while(!isEmpty(current)){

            consumer.accept(current.value);

            if(isLessThan(value, current.value)){
                current = current.leftChild;
            }
            else if(isGreaterThan(value, current.value)){
                current = current.rightChild;
            }
            else{
                return current.value;
            }
        }

        return null;
    }

    @Override
    public T min(Node<T> node) {

        while(!isEmpty(node)){
            if(node.leftChild == null){
                System.out.println(node.value);
                return node.value;
            }
            return min(node.leftChild);
        }
        return (T) new RuntimeException("Node Empty");
    }

    @Override
    public T max(Node<T> node) {
        if(node == null){
            return (T) new RuntimeException("Node Empty");
        }
        if(node.rightChild == null){
            return node.value;
        }
        return max(node.rightChild);
    }
}
