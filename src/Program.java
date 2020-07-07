import java.util.Map;
//Tyrone Veneracion
public class Program {
    public static void main(String[] args){
        String jsonURL = "https://raw.githubusercontent.com/adambom/dictionary/master/dictionary.json";
        Map<String,String> dictionary
                = JsonToGson.jsonToMap(jsonURL);
        ScrabbleGame.startGame(dictionary);
    }
}
