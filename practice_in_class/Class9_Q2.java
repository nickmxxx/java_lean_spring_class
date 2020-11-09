import java.util.ArrayList;

public class Class9_Q2 {
    public static void main(String[] args) {
        String s = "ab#12453";
        String regex = "#";
        String s1 = "ab#12453#";
        String s2 = "#ab#12453#";
        String s3 = "###";
        String s4 = "ab?12?453#?";
        String regex1 = "?#";
        spilt(s1, regex);
        spilt(s2, regex);
        spilt(s3, regex);
        spilt(s4, regex1);
    }

    public static String[] spilt(String s, String regex) {
        ArrayList<Integer> index = new ArrayList<>();
        int s_len = s.length();
        int regex_len = regex.length();
        for (int i = 0; i < s_len; i++) {
            for (int j = 0; j < regex_len; j++) {
                if (s.charAt(i) == regex.charAt(j)) {
                    index.add(i);
                }
            }
        }

        ArrayList<String> ans1 = new ArrayList<>();
        
        for (int i=0;i<index.size()-1;i++) {
            ans1.add(s.substring(index.get(i)+1, index.get(i+1)));
            // System.out.println(index.get(i));
        }
        System.out.print(s.substring(0, index.get(0))+" ");
        for (int i=0;i<ans1.size();i++) {
            System.out.print(s.charAt(index.get(i))+" ");
            System.out.print(ans1.get(i)+" ");
        }
        System.out.println(s.substring(index.get(index.size()-1), s.length())+" ");
        return null;
    }
}
