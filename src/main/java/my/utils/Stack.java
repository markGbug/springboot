package my.utils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/2/27
 */
public class Stack<T> implements Serializable {


    private LinkedList<T> linkedList = new LinkedList<>();


    public void push(T t) {
        linkedList.addFirst(t);
    }

    public synchronized T pop() {
        return linkedList.removeFirst();
    }

    public synchronized T peek() {
        return linkedList.getFirst();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public static void main(String[] args) {
        /*1530806400000UserAntenatalInfoDO{id=null, userId=36, templateId=17, checkTime=, template=null, isFinished=null}*/
        System.out.println(new SimpleDateFormat("yyyy年MM月dd日").format(1525316937751L));
        System.out.println(System.currentTimeMillis());
    }
}

