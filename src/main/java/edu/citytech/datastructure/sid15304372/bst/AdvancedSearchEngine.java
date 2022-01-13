package edu.citytech.datastructure.sid15304372.bst;

import com.jbbwebsolutions.bst.EnumComparison;
import com.jbbwebsolutions.bst.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

import static edu.citytech.datastructure.sid15304372.bst.TreeHelper.*;

public class AdvancedSearchEngine<T extends Comparable<T>> extends CustomSearchEngine<T> {


    @Override
    public List<T> findAll(Node<T> node, T value, Predicate<EnumComparison> predicate, BiConsumer<T, Long> biConsumer) {
        boolean greaterThan = predicate.test(EnumComparison.GREATER_THAN);
        boolean equalTo = predicate.test(EnumComparison.EQUAL);
        boolean lessThan = predicate.test(EnumComparison.LESS_THAN);

        System.out.println(greaterThan);
        System.out.println(equalTo);
        System.out.println(lessThan);

        if(greaterThan && !lessThan){
            return findGreaterAVL(node, value, biConsumer);
        }
        else if(lessThan){
            return findLessAVL(node, value, biConsumer);
        }
        else {
            return findEqualTo(node, value, biConsumer);
        }
    }


    private List<T> findGreaterAVL(Node<T> root, T value, BiConsumer<T, Long> biConsumer) {
        T t = null;
        var current = root;

        List<T> findAllList = new ArrayList<>();

        if(!isEmpty(current)) {
            if (isLessThan(value, current.value)) {

                biConsumer.accept(current.value, 1L);
                findAllList.add(current.value);

                traversePreOrder(current.rightChild, ((x) -> {
                    findAllList.add(current.value);

                    if (isGreaterThan(x, value)) {
                        findAllList.add(current.value);
                        biConsumer.accept(x, 1l);
                    }
                }));

                findGreaterAVL(current.leftChild, value, biConsumer);
            } else if (isLessThan(current.value, value)) {
                biConsumer.accept(current.value, 1l);
                findAllList.add(current.value);
                traversePreOrder(current.rightChild, ((x) -> {
                    if (isGreaterThan(x, value) || isEqual(x, value)) {
                        findAllList.add(current.value);
                        biConsumer.accept(x, 1l);
                    }
                }));
            }
            return findAllList;
        }
        return null;
    }

    private List<T> findLessAVL(Node<T> root, T value, BiConsumer<T, Long> biConsumer) {
        T t = null;
        var current = root;

        List<T> findAllList = new ArrayList<>();

        if(current != null) {

            if (isGreaterThan(current.value, value)) {

                traversePreOrder(current.leftChild, ((x) -> {

                    if (isLessThan(x, value)) {
                        findAllList.add(current.value);
                        biConsumer.accept(x, 1L);
                    }
                }));

                findLessAVL(current.rightChild, value, biConsumer);
            }

            else if(isGreaterThan(value, current.value)){
                biConsumer.accept(current.value, 1L);
                findAllList.add(current.value);
                traversePreOrder(current.rightChild, ((x) -> {
                    if (isLessThan(x, value) || isEqual(x,value)) {
                        findAllList.add(current.value);
                        biConsumer.accept(x, 1L);
                    }
                }));
            }

            return findAllList;
        }
        return null;
    }

    private List<T> findEqualTo(Node<T> root, T value, BiConsumer<T, Long> biConsumer) {
        T t = null;
        var current = root;

        List<T> findAllList = new ArrayList<>();

        while (!isEmpty(current)) {

            if (isLessThan(value, current.value)) {
                biConsumer.accept(current.value, 1L);
                findAllList.add(current.value);
                current = current.leftChild;

            } else if (isGreaterThan(value, current.value)) {
                biConsumer.accept(current.value, 1L);
                findAllList.add(current.value);
                current = current.rightChild;
            } else {
                biConsumer.accept(current.value, 1L);
                findAllList.add(current.value);
                return findAllList;
            }
        }
        return null;
    };
}