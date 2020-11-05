package by_topic.Queues;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopFrequentKElements {

    @Test
    public void testTopKFrequent() {
        int[] nums = {1,2,3,1,2,3,5,6,7, 7,7,7};
        System.out.println(topKFrequent(nums, 3));
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> resultList = new ArrayList<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue()); // maxheap
        //populatemap
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        map.entrySet().forEach(x-> {
            pq.add(x);
        });

        for (int i=0; i<k; i++) {
            resultList.add(pq.poll().getKey());
        }
        return resultList;
    }
}
