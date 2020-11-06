package by_topic.Queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Sort the language by number of occurance, if occurance is same, sort by natural order of language
 * i.e. shorter string should come first.
 *
 */
public class KSortedValueOrKeyByNaturalOrder {
    public static List<String> getKOccuranceOfString(int k, List<String> stringList) {
        List<String> resultSet = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String str : stringList) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        //Define priority queue and custom comparator
        //comparator sort by value first, if same sort by key's natural order.
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getValue() == o2.getValue())
                return o1.getKey().compareTo(o2.getKey());
            else
                return  o2.getValue()-o1.getValue();
        });
        for (Map.Entry<String, Integer> entr : map.entrySet()) {
            priorityQueue.add(entr);
        }
        for (int i = 0; i<k ; i++) {
            Map.Entry<String, Integer> entry = priorityQueue.poll();
            resultSet.add(entry.getKey());
        }

        return resultSet;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("java", "go", "go","java", "javascript", "lua", "c++", "python", "go", "java","javascript", "javascript"
                ,"javascript","javascript","javascript");
        List<String> resultSet = getKOccuranceOfString(2, list);
        for (String str : resultSet)
            System.out.println(str);
    }
}
