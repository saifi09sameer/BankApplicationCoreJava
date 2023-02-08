package com.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestMap {
    public static void main(String[] args) {
        List<Member> list = new ArrayList<>();
        list.add(new Member("Sameer", 21, "Male", "Gr Noida"));
        list.add(new Member("Salmen", 30, "Male", "Noida"));
        list.add(new Member("Sofiya", 28, "Female", "Aligarh"));
        list.add(new Member("Nadeem", 32, "Male", "Anupshahr"));
        Collections.sort(list, (o1, o2) -> {
            return o1.age - o2.age;
        });
        System.out.println(list);

        System.out.print(list.parallelStream().filter( m -> m.age > 30).collect(Collectors.toList()));
    }
    public static void printList(List<String> list){
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
