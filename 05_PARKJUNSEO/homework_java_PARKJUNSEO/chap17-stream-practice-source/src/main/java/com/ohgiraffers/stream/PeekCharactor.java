package com.ohgiraffers.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

// 문제: null이 아닌 문자열 중 "java"를 포함하는 텍스트만 소문자로 출력하세요.
// Objects::nonNull를 이용해서 null 체크

    public class PeekCharactor {
        public static void main(String[] args) {

            List<String> texts = Arrays.asList("I love Java", null, "java is fun",
                    "Python", null);

            texts.stream()
                    .filter(Objects::nonNull)
                    .map(String::toLowerCase)
                    .filter(text -> text.contains("java"))
                    .forEach(System.out::println);

        }
    }





// 출력값
// i love java
// java is fun