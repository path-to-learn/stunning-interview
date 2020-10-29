package by_pattern.tips_n_tricks;

import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Stack;

public class JavaTricks {
    @Test
    public void testNavigate2ArrayDimensional() {
        System.out.println();
        int[][] points = {{1,2},{3,4},{4,2}};

        for (int[]arr : points) {
            System.out.println(arr[0] + "," + arr[1]);
        }
        System.out.println();
        int[][] result = new int[2][2];

        for (int[]arr : result) {
            System.out.println(arr[0] + "," + arr[1]);
        }
    }

    @Test
    public void testCharacterStringToNumber(){
        String str = "51";
        Assert.assertTrue("First character converted to digit", str.charAt(0) - '0' == 5);
        Assert.assertTrue("Is digit", Character.isDigit(str.charAt(1)));
        System.out.println(('A'-0) + " " + ('Z'-0)); // 65, 90
        System.out.println(('a'-0) + " " + ('z'-0)); // 97, 122

        System.out.println(('a') + " " + ('z')); // 97, 122

        char ch = 'a';
        System.out.println(ch+1); // print ascii of b i.e 98
        System.out.println((char)(ch+1)); // prints b
    }

    @Test
    public void testCharString() {
        String str = "cab";
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        str = new String(ch);
        Assert.assertTrue("abc".equals(str));

    }

    @Test
    public void testStringBuffer() {
        StringBuilder sb = new StringBuilder("abc");
        sb.deleteCharAt(1);
        System.out.println(sb.toString());
        Assert.assertTrue("ac".equals(sb.toString()));

        StringBuffer sbuff = new StringBuffer("abc");
        sbuff.deleteCharAt(1);
        Assert.assertTrue("ac".equals(sbuff.toString()));

        String str = "abcd";
        StringBuilder sbb = new StringBuilder();
        char[] ch = str.toCharArray();
        for (char ch1 : ch) {
            sbb.append(ch1);
        }
        Assert.assertTrue(sbb.toString().equals(str));

        StringBuilder sbbb = new StringBuilder();
        sbbb.append(1);
        sbbb.append("ab");
        sbbb.append('z');
        sbbb.append('z'-'a');

        for (char chh : sbbb.toString().toCharArray()) {
            System.out.print(chh + " ");
        }

        StringBuilder appendAtBegining = new StringBuilder();
        appendAtBegining.insert(0, 'c');
        appendAtBegining.insert(0, 'b');
        appendAtBegining.insert(0, 'a');
        System.out.println(appendAtBegining.toString());

    }

    @Test
    public void testArrIncrement() {
        int[] arr = new int[3];
        arr[0] = 1;
        ++arr[0];
        ++arr[1];

        Assert.assertTrue(arr[0] == 2);
        Assert.assertTrue(arr[1] == 1);
    }

    @Test
    public void testCharToIntConversion() {
        int[] arr = new int[26];
        String str = "abctest";
        for (char ch : str.toCharArray())
            arr[ch-'a']++;
        Assert.assertTrue(arr[0] == 1); // count of a = 1;
        Assert.assertTrue(arr[19] == 2); // count of t ==2
        Assert.assertTrue(arr['t'-'a'] == 2); // count of t ==2

        String chars = "9chars";
        Assert.assertTrue(Character.isDigit(chars.charAt(0)));
    }

    @Test
    public void integerMaxMinVal() {
        Integer max = Integer.MAX_VALUE;
        Integer min = Integer.MIN_VALUE;
        Assert.assertTrue(max > min);
        //Long.MAX_VALUE;
        //Long.MIN_VALUE;
    }

    @Test
    public void stackUsage(){
        Stack<Integer> stack = new Stack<>();
        stack.push(12);
        stack.push(12);
        stack.push(11);
        stack.push(null);
        Assert.assertTrue(stack.size() == 4);

        Stack<Character> stack1 = new Stack<>();
        stack1.add(null);
        stack1.add('a');
        Assert.assertTrue(stack1.pop() == 'a');
        Assert.assertTrue(stack1.peek() == null);
        Assert.assertTrue(stack1.pop() == null);
    }

    @Test
    public void maxAndMinPriorityQueue() {
        PriorityQueue<Integer> pqMinQueue = new PriorityQueue<>(); // By default Java PQ is min heap.
        PriorityQueue<Integer> pqMaxQueue = new PriorityQueue<>((a, b) -> b-a); // Max heap, lambda used for comparator
        List<Integer> list = Arrays.asList(2,1,3,5,4,9,1,2);
        list.forEach(x -> {
            pqMinQueue.offer(x);
            pqMaxQueue.offer(x);
        });
        Assert.assertTrue(pqMaxQueue.peek() == 9);
        Assert.assertTrue(pqMinQueue.peek() == 1);
        //TODO Make a note that pq (min or max) does not sort entirely but just bring min or max at the top of the root.
    }

    @Test
    public void findKthLargest() {
        int[] nums = {2,1,3,5,4,9,1,2};
        int k = 2;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        Arrays.stream(nums).forEach(x -> {
            pq.add(x);
            if (pq.size()>k)
                pq.poll();
        });
        Assert.assertTrue(pq.peek() == 5);
    }

    @Test
    public void verifyTwoDimesnsionalMatrix(){
        int[][] arr = {{1,2,3}, {4,5,6}, {7,8,9}, {10,11,12}};
        int rows = arr.length;
        int col = arr[0].length;
        Assert.assertTrue(rows == 4);
        Assert.assertTrue(col == 3);
        for (int i=0; i<rows; i++) {
            for (int j = 0; j<col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void verifyInList() {
        List<Integer> list = new ArrayList<>();
        list.add(0, 1);
        list.add(1, 1);
        list.add(2, null);
        list.add(3, null);
        System.out.println(list.size());
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println(list);
    }

    @Test
    public void verifyStringAndArray() {
        String str = "abc";
        Integer[] arr = {1,2,3};
        Assert.assertTrue(str.length() == 3);
        Assert.assertTrue(arr.length == 3);
        List<Integer> list =  Arrays.asList(arr);
        Assert.assertTrue(list.size() == 3);
        //TODO There is no size, and note length is method in string !
    }

    @Test
    public void verifyFloatDoubleInt() {
        double num = 3.7;

        int[] arr = {2,4,6,8};
        int closest = 0;
        for (int i : arr) {
            if (Math.abs(num-i) < Math.abs(num-closest))
                closest = i;
        }
        System.out.println(" closest :: " + closest);
    }

    @Test
    public void verifyStringSplit(){
        String ss = "/a/../b/.//c///d/";
        String[] splittedString = ss.split("/");
        for (String str : splittedString)
            System.out.print(str + " ");
        System.out.println();

        String str = "hello i am really  interested in   .";
        String[] splitter = str.split("\\s+");
        for (String str1 : splitter)
            System.out.print(str1+ " ");
    }

    @Test
    public void verifyMapOperations() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(2,2);
        map.put(3,2);

        List<Integer> list = new ArrayList<>();
        map.entrySet().forEach(x -> {
            list.add(x.getValue());
        });
        for (int i : list)
            System.out.print(i + " ");
        map.containsValue(2);
        map.getOrDefault(10,0);
    }

    @Test
    public void verifyRandom() {
        Random rand = new Random();
        int random = rand.nextInt(10);
        Assert.assertTrue(random < 9);
    }

    @Test
    public void verifyBinaryFromDecimal() {
        String sb = "1001";
        Assert.assertTrue(9 == Integer.parseInt(sb, 2));
        Assert.assertTrue(1001 == Integer.parseInt(sb, 10));
    }

    @Test
    public void verifyStringValueOf() {
        Assert.assertTrue("123".equals(String.valueOf(123)));
        Assert.assertTrue("c".equals(String.valueOf('c')));
        char[] ch = {'c','d','e'};
        Assert.assertTrue("cde".equals(String.valueOf(ch)));

        Stack<Character> ss = new Stack<>();
        ss.add('a');
        ss.add('b');
        ss.add('c');
        System.out.println(String.valueOf(ss));
        System.out.println(ss);
    }

    @Test
    public void verifyInstantBetweenTwoEvents() throws InterruptedException {
        Instant then  = Instant.now();
        Thread.sleep(2000);
        Instant now = Instant.now();
        System.out.println(Duration.between(then, now).getSeconds());
        Assert.assertTrue(now.isAfter(then));
    }

    @Test
    public void verifyArrayFromList() {
        List<int[]> list = new ArrayList<>();
        int[][] result = list.toArray(new int[list.size()][]);

        Integer[] arr = {1,2,3};
        List<Integer> targetList = new ArrayList<Integer>(Arrays.asList(arr));
        System.out.println(targetList);
    }

    @Test
    public void testMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"one");
        map.put(2,"two");
        map.put(3, "three");
        map.putIfAbsent(4,"fourfour");



        map.entrySet().forEach(x->{
            System.out.println(x.getKey() + " " + x.getValue());
        });

        PriorityQueue<Map.Entry<Integer, String>> pq = new PriorityQueue<>((x, y)-> y.getValue().length() - x.getValue().length());
        map.entrySet().forEach(x -> {
            pq.add(x);
        });
        System.out.println("Key with max value length : " + pq.peek().getKey());
    }

    @Test
    public void testCharSiftByNum() {
        String name = "amit";
        int s = 3;
//            char ch1 = (char)(((int)name.charAt(0) + s - 97) % 26 + 97);
//            System.out.println(ch1);

        int nn = 'a';
        System.out.println(nn);
        //char ch1 = (char)((nn + s ) % 26 + 97);
        char ch1 = (char)((nn + 54 ) %26);
        System.out.println(ch1);

    }

    @Test
    public void testLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list);

        list = new LinkedList<>();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        System.out.println(list);
    }

    @Test
    public void ListMemoryTest() {
        List<int[]> list = new ArrayList<>();
        int[] arr = {1};
        list.add(arr);
        for (int i=0; i< 100; i++)
            arr[0] = i;

        int val = list.get(0)[0];
        Assert.assertTrue( val == 99);
    }

    @Test
    public void checkArrayCopyOf(){
        String abc = "testing";
        char[] ch = abc.toCharArray();
        String result = String.valueOf(Arrays.copyOf(ch, 4));
        System.out.println(result); // prints test

        result = String.valueOf(Arrays.copyOf(ch, 20));
        System.out.println(result); // prints testing
    }

    @Test
    public void checkArrayOfListOrMap() {
        Map<String, ArrayList[]> map = new LinkedHashMap<>();
        Integer[] intArr = new Integer[2];
        Object[] objArr = new Object[2];
        List<String>[] ll = new ArrayList[2]; // array of list having string
        ll[0] = new ArrayList<>();
        ll[1] = new ArrayList<>();
    }

    @Test
    public void checkCharInteger() {
        for (char c='a' ; c<= 'z' ; c++) {
            System.out.print(c + " ");
            System.out.println();
            System.out.print((int)c + " ");
        }


    }

    @Test
    public void testbreakTheJinx() {
        int[] arr = {1,2,3,4};
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            System.out.println(i);
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
