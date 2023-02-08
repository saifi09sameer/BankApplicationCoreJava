package com.Test;

import java.util.Comparator;

public class MySort implements Comparator<Member> {

    @Override
    public int compare(Member o1, Member o2) {
        return o1.age - o2.age;
    }
}
