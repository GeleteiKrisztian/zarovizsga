package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.HashSet;
import java.util.Set;

public class DigitsCounter {

    int getCountOfDigits(String s) {
        if (isNullOrEmptyString(s)) {
            return 0;
        }
        Set<Character> ints = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                ints.add(ch);
            }
        }
        return ints.size();
    }

    private boolean isNullOrEmptyString(String s) {
        if (s == null || s.isBlank()) {
            return true;
        }
        return false;
    }
}
