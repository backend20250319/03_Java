package com.ohgiraffers.stream;

import java.util.List;

// 문제: 이름 리스트에서 길이가 5글자 이상인 이름만 골라 대문자로 바꾸고 출력하세요.

public class PrintName {

    public static void main(String[] args) {

                List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Eve",
                "Franklin");

                for (String name : names) {
                    if (name.length() >= 5) {
                        System.out.println(name.toUpperCase());
                    }
                }
// 출력값
// ALICE
// CHARLIE
// DAVID
// FRANKLIN
    }
}