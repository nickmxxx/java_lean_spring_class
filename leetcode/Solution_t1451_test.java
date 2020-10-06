public class Solution_t1451_test {
    public static void main(String[] args) {
        String text = "Leetcode is cool";
        String[] new_text = text.split(" ");
        String ans = "";
        // for (int i = 0; i < new_text.length; i++) {
        //     System.out.println(new_text[i]);
        // }
        new_text[0] = new_text[0].toLowerCase();
        for (int i = 1; i < new_text.length; i++) {
            boolean flag = true;
            for(int j = 0;j<new_text.length-i;j++){
                if(new_text[j].length()>new_text[j+1].length()){
                    String tmp = new_text[j];
                    new_text[j] = new_text[j+1];
                    new_text[j+1] = tmp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
        new_text[0] = (new_text[0].substring(0,1).toUpperCase()).concat(new_text[0].substring(1));
        for (int i = 0; i < new_text.length; i++) {
            ans = ans.concat(new_text[i]);
            if(i!=new_text.length-1){
                ans = ans.concat(" ");
            }
        }
        System.out.println(ans);
    }
}
