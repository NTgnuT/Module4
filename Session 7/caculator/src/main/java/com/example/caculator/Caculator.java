package com.example.caculator;

public class Caculator {
    public double caculate(double first, double second, Character operator) throws Exception {
        double result = 0;

        switch (operator) {
            case '+':
                result = first + second;
                break;
            case '-':
                result = first - second;
                break;
            case '*':
                result = first * second;
                break;
            case '/':
                if (second != 0) {
                    result = first / second;
                } else {
                    throw new Exception("Không thể chia cho 0");
                }
                break;
            default:
                throw new Exception("Không có lựa chọn này!!!");
        }
        return result;
    }
}
