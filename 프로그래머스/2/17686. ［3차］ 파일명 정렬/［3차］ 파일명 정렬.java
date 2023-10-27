import java.util.*;
class Solution {
        public static String[] solution(String[] files) {

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] split1 = split(o1);
                String[] split2 = split(o2);

                if (split1[0].compareTo(split2[0]) == 0) {
                    int i1 = Integer.parseInt(split1[1]);
                    int i2 = Integer.parseInt(split2[1]);
                    if (i1 - i2 == 0) {
                        return 0;
                    }
                    return i1-i2;
                }
                return split1[0].compareTo(split2[0]);
            }
        });

        return files;
    }

    public static String[] split(String str) {
        String[] result = {"","",""};
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (checkNum(c)) {
                index = i;
                break;
            }
            result[0] += Character.toUpperCase(c);
        }
        for (int i = index; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!checkNum(c)) {
                index = i;
                break;
            }
            result[1] += c;
        }
        String substring = str.substring(index).toUpperCase();
        result[2] = substring;
        return result;
    }

    static boolean checkNum(char c) {
        if('0'<=c&&c<='9') return true;
        return false;
    }
}