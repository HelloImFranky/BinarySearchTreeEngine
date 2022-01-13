package edu.citytech.datastructure.sid15304372.bst;

import com.jbbwebsolutions.bst.Node;
import com.jbbwebsolutions.bst.NodeFacadeInsertion;

import java.util.function.Consumer;



public class BasicNodeInsertion <T extends Comparable<T>> implements NodeFacadeInsertion<T> {
    private long size = 0;
    @Override
    public Node<T> insert(Node<T> root, T value, Consumer<Long> consumer) {
        var node = new Node(value);
        //new root
        if(TreeHelper.isEmpty(root)){
            size++;
            root = node;
            consumer.accept(size);
            return root;
        }
        size++;
        var current = root;
        while(true){
            if(TreeHelper.isLessThan(value, current.value)){
                if(TreeHelper.isEmpty(current.leftChild)) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }
            else if(TreeHelper.isGreaterThan(value, current.value)){
                if(TreeHelper.isEmpty(current.rightChild)) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
            else{
                throw new RuntimeException("Duplicate data entered, Invalid see data" + value);
            }
        }
        consumer.accept(size);

        return root;
    }
}
