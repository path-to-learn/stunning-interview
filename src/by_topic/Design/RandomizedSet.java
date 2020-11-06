package by_topic.Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Create a randomized set
 */
public class RandomizedSet {

    Map<Integer, Integer> map;
    List<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    // map > value, idx
    // list >  idx,value
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        int lastValue = list.get(list.size()-1);
        int post = map.get(val);

        list.set(post, lastValue);
        list.remove(list.size()-1);

        map.put(lastValue, post);
        map.remove(val);

        return true;

    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random ran = new Random();
        return list.get(ran.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        obj.insert(0);
        obj.insert(1);
        obj.remove(0);
        obj.insert(2);
        obj.remove(1);
        System.out.println(obj.getRandom());
    }
}
