package my_bot;

import java.text.SimpleDateFormat;
import java.util.*;

public class Resource implements ResourceInterface {

    public void Fill(){
        ArrayList<String> helpVariants = new ArrayList<String>();
        String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\n";
        helpVariants.addAll(Arrays.asList("help", "start", "help me", "let's start", "hi", "hello", "let's go", "go", "/start", "/help", "/go"));
        String helpString = "Hi, What do you want? I am busy, but I think, I can find one minute for you\n" +
                "If you want know? what date is it? write \"/date\"\n";
        this.Variants.put(helpString, helpVariants);
        ArrayList<String> dateVariants = new ArrayList<String>();
        dateVariants.addAll(Arrays.asList("/date", "/time", "date", "time", "what time is it?"));
        this.Variants.put(currentDate, dateVariants);
    }
}
