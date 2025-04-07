package com.ohgiraffers.exception.number;

public class NumberProcess {

    public boolean checkDouble(int a, int b) throws NumberRangeException {
        boolean boo = a <= 0 || b <= 0 || a > 100 || b > 100;

        if (boo) {
            throw new NumberRangeException("1부터 100사이의 값이 아닙니다.");
        }

        if (a % b == 0) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        return true;
    }

    public void close() {
    }
}
