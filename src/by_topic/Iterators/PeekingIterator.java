package by_topic.Iterators;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer value = null;

    //As this test class, we need to have one public zero-arguementt-constructor
    public void Initalizer(Iterator<Integer> itr) {
        this.iterator = itr;
        if (iterator.hasNext())
            value = iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return value;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer val = value;
        if (iterator.hasNext()){
            value = iterator.next();
        } else {
            value = null;
        }
        return val;
    }

    @Override
    public boolean hasNext() {
        return value !=null;
    }

    @Test
    public void verifyPeekingIterator() {
        Iterator<Integer> iterator = Arrays.asList(1,2,3).iterator();
        PeekingIterator peekingIterator = new PeekingIterator();
        peekingIterator.Initalizer(iterator);

        Assert.assertTrue(peekingIterator.next() == 1);
        Assert.assertTrue(peekingIterator.peek() == 2);
        Assert.assertTrue(peekingIterator.next() == 2);
        Assert.assertTrue(peekingIterator.next() == 3);
        Assert.assertFalse(peekingIterator.hasNext());
    }
}
