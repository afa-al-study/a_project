public class test {
    public static void main(String args[]){
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        int a = queries[2].indexOf("?");
        System.out.println(a);
    }
}
