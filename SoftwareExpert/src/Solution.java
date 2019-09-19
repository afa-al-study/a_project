 import java.util.ArrayList;
 import java.util.Scanner;

 class Solution {

     public static void main(String args[]) {
         String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
         String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
         int[] result = new int[queries.length];

         for (int i = 0; i < queries.length; i++) {
             String srch = "";
             boolean isFront = false;

             String q = queries[i];
             int quest_num = 0;
             if (q.substring(0, 1).equals("?")) // ?마크가 앞에
                 isFront = true;

             for (int j = 0; j < q.length(); j++) {
                 if (!q.substring(j, j + 1).equals("?")) {//?아닌거
                     srch += q.substring(j, j + 1);
                 } else quest_num += 1;
             }

             for (int j = 0; j < words.length; j++) {
                 if (words[j].length() == q.length() && quest_num < q.length()) {

                     if (words[j].contains(srch)) {
                         if (isFront) { //앞에 ?일때, ?이후부터
                             if (words[j].substring(quest_num).contains(srch))
                                 result[i] += 1;
                         } else {
                             if (words[j].substring(0, words[j].length() - quest_num).contains(srch))
                                 result[i] += 1;
                         }
                     }
                 } else if (words[j].length() == q.length() && quest_num == q.length()) //모두 ????일 경우
                     result[i] += 1;
             }
         }

         int[] answer = result;

         for(int i : answer)
             System.out.println(i + ", ");


//         Scanner sc = new Scanner(System.in);
//         String s = "abcabcdede";
//
//         int min_result = s.length();
//         int size = 0;
//
//
//
//         for(int i = 1; i <= s.length(); i++){ //자르는 단위 수
//             ArrayList<String[]> list = new ArrayList<String[]>(); // 'ab'
//             list.add(new String[]{s.substring(0, i), "1"}); //첫번째꺼
//             int n = s.length()/i;
//             int km = i;
//             int ym = 0;
//             for(int k = i; k < (n+i)-1 ; k++){ //단위행위로 반복되는 수
////                 for(int j = 0; j <= list.size(); j++){ //같은게 있으면 횟수를 늘리고 아니면 add
//                     if(s.substring(km, km+i).equals(list.get(list.size()-1)[0])){
//                         int num = 0;
//                         num = Integer.parseInt(list.get(list.size()-1)[1]) + 1;
//                         list.set(list.size()-1, new String[]{list.get(list.size()-1)[0], Integer.toString(num)});
//
//                         km = km+i;
//
//                     }
//                     else {
//                         list.add(new String[]{s.substring(km, km+i) , "1"});
//                         km = km+i;
//                     }
////                 }
//                 if(k == n+i-2){
//                     int tmp = 0;
//                     for(int j = 0; j < list.size(); j++){
//                         if(list.get(j)[1].equals("1")) tmp += i;
//                         else tmp += i+1;
//
//                     }
//                     if(km < s.length()){
//                         size = tmp + (s.length() - km);
//                     }
//                     else size = tmp;
//
////                     size = tmp + (s.length()-(km+i)+1);
//                 }
//             }
//             if(min_result > size){
//                 min_result = size;
//             }
//         }
//
////문자
//
//         int answer = min_result;
//
//System.out.println(answer);

     }
 }