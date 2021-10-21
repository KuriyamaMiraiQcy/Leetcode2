package 数组;

import java.util.HashMap;
import java.util.Map;

public class alienDictionary {
    public boolean IsAlienSorted(String[] words, String order) {

        for(int i = 0;i < words.length - 1; i++){
            int j = 0;
            boolean isSame = true;
            while(j < Math.min(words[i].length(), words[i+1].length())){
                int a = order.indexOf(words[i].charAt(j));
                int b = order.indexOf(words[i+1].charAt(j));
                if(a > b){
                    return false;
                }else if(a < b){
                    isSame = false;
                    break;
                }else if(a == b){
                    j++;
                }
            }
            if(isSame && words[i].length() > words[i+1].length()) return false;
        }

        return true;
    }

    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> dictOrder = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            dictOrder.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            boolean isLess = false;
            for (int j = 0; j < Math.min(words[i].length(), words[i+1].length()); j++) {
                int res;
                if ((res = dictOrder.getOrDefault(words[i].charAt(j), -1) - dictOrder.getOrDefault(words[i + 1].charAt(j), -1)) !=0) {
                    if (res > 0) {
                        return false;
                    }
                    isLess = true;
                    break;
                }
            }
            if (!isLess) {
                if (words[i].length() > words[i+1].length()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        alienDictionary a = new alienDictionary();
        System.out.print(a.isAlienSorted(new String[]{"apple","apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}
