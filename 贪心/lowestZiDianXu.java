package Greed;

import java.util.Arrays;
import java.util.Comparator;
/**
 * 
 * 保证拼接起来的大字符串字典序最小。
 *
 * [bk,at,cs]将三个短字符串拼接，生成6位的长字符串，这个结果字典序最小。
 *
 * 不同长度的字符串比较字典序，短的右边补齐0，从左向右比较。
 *
 * 贪心策略：ab和ba比较，选择字典序靠前。
 *
 * 错的想法： a,b  a<=b,  a放前 否则b放前  反例： b,ba  如果按照这个意思这么想 拼接后应该是 bba  但实际上是bab最小
 */
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
