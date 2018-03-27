package my.utils;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/2/27
 */
public class Stack<T> implements Serializable{


    private LinkedList<T> linkedList = new LinkedList<>();


    public void push(T t){
        linkedList.addFirst(t);
    }

    public synchronized T pop(){
        return linkedList.removeFirst();
    }

    public synchronized T peek(){
        return linkedList.getFirst();
    }

    public boolean isEmpty(){
        return linkedList.isEmpty();
    }

}
