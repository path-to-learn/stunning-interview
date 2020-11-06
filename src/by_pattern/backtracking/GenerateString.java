package by_pattern.backtracking;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateString {
    public static void main(String[] args) {
        GenerateString gg = new GenerateString("abcd", 2);
        System.out.println(gg.next());
        System.out.println(gg.next());
        System.out.println(gg.next());
        System.out.println(gg.next());
        System.out.println(gg.next());
        System.out.println(gg.hasNext());
    }

    String str = null;
    int k = 0;
    Queue<String> queue;

    public GenerateString(String characters, int combinationLength) {
        str = characters;
        k = combinationLength;
        queue = new LinkedList();
        generate("", 0);
    }

    public String next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    private void generate(String abc, int i) {
        generate(abc, str, i);
    }

    private void generate(String abc, String str, int m) {
        if (abc.length() == k) {
            queue.add(abc);
            return;
        }
        for (int j = m; j <str.length(); j++) {
            generate(abc+str.charAt(j)+"", str, j+1);
        }
    }
}
