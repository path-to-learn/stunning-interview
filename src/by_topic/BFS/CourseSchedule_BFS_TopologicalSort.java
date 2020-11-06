package by_topic.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule_BFS_TopologicalSort {
    public static void main(String[] args) {
        // {1,0} -> to take course 1, finish course 0
        int[][] prerequisites = {{1,0}, {4,1}, {4,3}, {3,2}, {2,1}};
        int numOfCourses = 5;
        // for cyclic scenario
//        int[][] prerequisites = {{1,0}, {2,1}, {0,2}};
//        int numOfCourses = 3;
        System.out.println(canWeFinishSchedule(numOfCourses, prerequisites));
    }

    private static boolean canWeFinishSchedule(int numOfCourses, int[][] prerequisites) {
        int[] inDegreeArray = new int[numOfCourses];
        LinkedList<Integer>[] adjList = new LinkedList[numOfCourses];
        Queue<Integer> bfsQueue = new LinkedList<>();

        for (int i=0 ; i<numOfCourses; i++) {
            adjList[i] = new LinkedList<>();
        }

        // Populating adjacency list and inDegree Array
        // indegree value basically provide count of pre-requisites
        // arrEntrieres[1] is pre-requisite of arrEntrieres[0], so arrEntrieres[0] is in indegree.
        for (int[] arrEntrieres : prerequisites) {
            inDegreeArray[arrEntrieres[0]]++;
            adjList[arrEntrieres[1]].add(arrEntrieres[0]);
        }

        //populate queue with entry which has no indegree value.
        // this is basically starting point of a topological sort
        // which has no pre-requisite

        for (int i=0; i<inDegreeArray.length; i++) {
            if (inDegreeArray[i] == 0)
                bfsQueue.add(i);
        }

        // Parse through each value in bfs queue.
        // bfs anytime has a value for which indegree is 0.
        // Polling a value in bfs, will decrement indegree values of its adjacencny list values, this is done in loop.
        // if a value in adjacency list becomes 0, add in bfs
        // maintain a separate count.

        //For cyclic graph, indegree might be non-zero after the complete processing
        // this could result in count not equal to numOfCourse hence it will return false;

        int count = 0;
        while (!bfsQueue.isEmpty()) {
            Integer val = bfsQueue.poll();
            System.out.print(val + " -> ");
            count++;
            for (int adjValue : adjList[val]) {  // we start evaluating adj list for values with 0 indegree.
                inDegreeArray[adjValue]--;   // start reducing the in-degree
                if (inDegreeArray[adjValue] == 0)  // if any value got 0 as indegree, push ito bfs....
                    bfsQueue.offer(adjValue);
            }
        }
        return count == numOfCourses;
    }
}
