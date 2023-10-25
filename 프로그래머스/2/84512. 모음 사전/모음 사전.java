import java.util.*;

class Solution {
    static char[] ch;
    static List<String> list;
    
    public int solution(String word) {
        int answer = 0;
        ch = new char[]{'A','E','I','O','U'};
        list = new ArrayList<>();
        search(word,"",0);
        for(int i=0; i<list.size(); i++){
            if(list.get(i).equals(word)){
                answer = i;
                break;    
            }
        }
        return answer;
    }
    static void search(String word, String str, int depth){
        list.add(str);
        if(depth==5)return;
        for(int i=0; i<ch.length; i++){
            search(word, str+ch[i], depth+1);
        }
    }
}