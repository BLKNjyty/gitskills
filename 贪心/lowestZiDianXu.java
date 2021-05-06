package Greed;

import java.util.Arrays;
import java.util.Comparator;

public class lowestZiDianXu {
    public static String lowestString(String[] strs){
        if (strs == null || strs.length ==0){
            return "";
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (a + b).compareTo(b + a); //如果指定的数与参数相等返回0。如果指定的数小于参数（括号内）返回 -1。如果指定的数大于参数返回 1。
                //比较器 obj1和obj2是要比较的对象。如果对象相等，则此方法返回零。如果obj1大于obj2，则返回正值。否则返回负值。
            }
        });
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res = res + strs[i];  //拼接
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
        System.out.println(lowestString(strs1));//bw jibw jibw ji  jp

        String[] strs2 = { "ba", "b" };
        System.out.println(lowestString(strs2));

    }
}
