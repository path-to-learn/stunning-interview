package by_topic.Iterators;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagIterator {

    Queue<Iterator> queueIterator = null;

    public void Initializer(List<List<Integer>> nestedList) {
        queueIterator = new LinkedList<>();
        nestedList.forEach(v -> {
            if(!v.isEmpty()) queueIterator.add(v.iterator());
        });
    }

    public int next() {
        Iterator<Integer> itr = queueIterator.poll();
        int num = itr.next();
        if (itr.hasNext())
            queueIterator.offer(itr);
        return num;
    }

    public boolean hasNext() {
        return !queueIterator.isEmpty();
    }

    @Test
    public void testZigZagIterator() {
        List<Integer> list1 = Arrays.asList(1,2);
        List<Integer> list2 = Arrays.asList(11);
        List<Integer> list3 = Arrays.asList(21,22,23);
        List<Integer> list4 = Arrays.asList(31,34,200,300);
        List<List<Integer>> nestedList = Arrays.asList(list1, list2, list3, list4);

        ZigzagIterator zz = new ZigzagIterator();
        zz.Initializer(nestedList);
        int i = 0, j =0, k=0, l =0;
        List<Integer> result = new ArrayList<>();
        while (zz.hasNext()) {
            result.add(zz.next());
        }
        Assert.assertTrue(1 == result.get(0));
        Assert.assertTrue(11 == result.get(1));
        Assert.assertTrue(21 == result.get(2));
        Assert.assertTrue(300 == result.get(result.size()-1));
    }
}
