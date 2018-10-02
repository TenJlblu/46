package my_bot;

import java.util.ArrayList;
import java.util.Map;

public class AnswerGenerator {

    private final Resource resource = new Resource();

    public String GetAnswer(String request){
        resource.Fill();
        for (Map.Entry<String, ArrayList<String>> entry : resource.Variants.entrySet()){
            if (entry.getValue().contains(request.toLowerCase())){
                return entry.getKey();
            }
        } 
        return "khmm, I don't know, what should I say\n";
    }
}
