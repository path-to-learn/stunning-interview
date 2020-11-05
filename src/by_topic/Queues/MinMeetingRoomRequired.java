package by_topic.Queues;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinMeetingRoomRequired {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        // room whose end time is less, should be at the top of pqueue
        // min pq queue based on end time
        PriorityQueue<int[]> result = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (int[] interval : intervals) {
            if (!result.isEmpty() && interval[0] >= result.peek()[1]){
                result.poll();
            }
            result.add(interval);
        }
        return result.size();
    }

    @Test
    public void testMeetingRoom() {
        // min meeting room required
        int[][] interval1 = {{9,10}, {4,9}};
        Assert.assertEquals(1, minMeetingRooms(interval1));

        int[][] interval2 = {{9,10}, {4,9}, {2,5}};
        Assert.assertEquals(2, minMeetingRooms(interval2));
    }
}
