import edu.cmu.sphinx.api.*;
import java.awt.Desktop;
import java.net.URI;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        config.setDictionaryPath("/home/ibaad/IdeaProjects/VOICE_ASSISTANT/dic.dic");
        config.setLanguageModelPath("/home/ibaad/IdeaProjects/VOICE_ASSISTANT/lm.lm");

        try {
            LiveSpeechRecognizer rec = new LiveSpeechRecognizer(config);
            rec.startRecognition(true);
            Desktop desktop = Desktop.getDesktop();

            while (rec.getResult() != null){
                String result = rec.getResult().getHypothesis();
                if(result.toLowerCase().equals("google")){
                    URI uri = new URI("http://google.com/");
                    desktop.browse(uri);

                }else if(result.toLowerCase().equals("youtube")){
                    URI uri = new URI("http://youtube.com/");
                    desktop.browse(uri);
                }else if(result.toLowerCase().equals("geeksforgeeks")){
                    URI uri = new URI("https://geeksforgeeks.org/");
                    desktop.browse(uri);
                }else if(result.toLowerCase().equals("github")){
                    URI uri = new URI("https://github.com/");
                    desktop.browse(uri);
                }else if(result.toLowerCase().equals("freecodecamp")){
                    URI uri = new URI("https://www.freecodecamp.org/");
                    desktop.browse(uri);
                }else if(result.toLowerCase().equals("w3schools")){
                    URI uri = new URI("https://www.w3schools.com/");
                    desktop.browse(uri);
                }else if(result.toLowerCase().equals("codecademy")){
                    URI uri = new URI("https://www.codecademy.com/");
                    desktop.browse(uri);
                }

            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
