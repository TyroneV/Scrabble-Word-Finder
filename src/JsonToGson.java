
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonToGson {

    // gets the Json from an API and returns result as a string
    public static String getJsonFromAddress(String urlAddress) throws Exception{
        URL address;
        address = new URL(urlAddress);
        InputStreamReader isr = new InputStreamReader(address.openStream());
        BufferedReader br = new BufferedReader(isr);
        return readAllLinesWithStream(br);
    }
    //reads all lines using a stream reader
    public static String readAllLinesWithStream(BufferedReader reader) {
        return reader.lines().collect(Collectors.joining(System.lineSeparator()));
    }

    //Converts the Json string into Map using Gson;
    public static Map jsonToMap(String urlAddress){
        String json = "";
        try{
           json = getJsonFromAddress(urlAddress);
        } catch (Exception e){
            System.out.println(e);
        }
        Gson gson = new Gson();
        Type wordMapType = new TypeToken<Map<String, String>>() {}.getType();
        Map<String, String> scrambleMap = gson.fromJson(json, wordMapType);
        return scrambleMap;
    }
}
