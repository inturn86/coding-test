package test.bemin;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class CodingTest5 {

	 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        Set<Integer> iArr = new HashSet<Integer>();
        Map<Integer, Integer> map = new HashMap<>();
        int s = 0;
        for (int i = 0, len = a; i<len; i++) {
        	s = sc.nextInt();
        	iArr.add(s);
        	map.put(s, map.getOrDefault(s, 0) + 1);
        }

        String result = "";
        List<Integer> sI = iArr.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        if(sI.size() < b) {
        	result =  "IMPOSSIBLE";
        }
        else {
            int target = sI.get(b -1);
            int targetByResult = map.get(target);
        	result = String.format("%d %d", target, targetByResult);
        }

        System.out.println(result);
    }

}
