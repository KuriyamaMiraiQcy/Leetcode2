package 字符串;

import java.util.HashMap;
import java.util.Map;

public class integerRoman {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int thousands = num / 1000;
        for (int i = 0; i < thousands; i++) {
            result = result.append("M");
        }
        num %= 1000;
        int hundreds = num / 100;
        if (hundreds == 9) {
            result = result.append("CM");
            hundreds = 0;
        }
        if (hundreds >= 5) {
            result = result.append("D");
            hundreds -= 5;
        }
        if (hundreds == 4) {
            result = result.append("CD");
            hundreds = 0;
        }
        for (int i = 0; i < hundreds; i++) {
            result = result.append("C");
        }
        num %= 100;
        int tens = num / 10;
        if (tens == 9) {
            result = result.append("XC");
            tens = 0;
        }
        if (tens >= 5) {
            result = result.append("L");
            tens -= 5;
        }
        if (tens == 4) {
            result = result.append("XL");
            tens = 0;
        }
        for (int i = 0; i < tens; i++) {
            result = result.append("X");
        }
        num %= 10;
        if (num == 9) {
            result = result.append("IX");
            num = 0;
        }
        if (num >= 5) {
            result = result.append("V");
            num -= 5;
        }
        if (num == 4) {
            result = result.append("IV");
            num = 0;
        }
        for (int i = 0; i < num; i++) {
            result = result.append("I");
        }
        return result.toString();
    }
}
