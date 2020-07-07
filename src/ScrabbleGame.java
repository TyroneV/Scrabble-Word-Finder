import java.util.*;

public class ScrabbleGame {

    public static void startGame(Map<String,String> dictionary){
        ArrayList<String> possibleMatches = new ArrayList<>();
        Set<String> keys;
        keys = dictionary.keySet();
        String input;
        while (true) {
            input = getInput();
            for (String key : keys) {
                if(sameChars(input,key)){
                    if(key.length() != 1)// Prevents the result from being only 1 letter
                    possibleMatches.add(key);
                }
            }
            break;
        }
        System.out.println("Possible words");
        for (String result:possibleMatches) {
            String s = String.format("\"%s\" : %s",result,dictionary.get(result));
            System.out.println(s);
        }
    }

    private static boolean sameChars(String firstStr, String secondStr) {
        char[] first = firstStr.toCharArray();
        char[] second = secondStr.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        String s1 = new String(first);
        String s2 = new String(second);
        return s1.contains(s2);
    }

    private static String getInput(){
        while (true) {
            System.out.println("Input your Scrabble word");
            Scanner sc = new Scanner(System.in);
            String inputString = sc.nextLine();
            if(inputString.length() > 7){
                System.out.println("Input value is longer than 7. Please only enter 7");
            }
            else{
                return inputString.toUpperCase();
            }
        }
    }
}
