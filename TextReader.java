import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.*;



public class TextReader {
    private String path;
    public enum Sign { START, END };

    private static Logger logger = Logger.getLogger(LoggingApp.class.getName());

    private TextReader(String path) {
        this.path = path;
    }

    private void execute() {
        List<Integer> valueList = new ObjectList<>();
        

        try (FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);) {
            
            String line;
            while ((line = br.readLine()) != null) {
                valueList.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }   
        for (Integer value: valueList) {
            System.out.println(value);
        }
    }

    public static void main(String... args) { 
        logger.info(Sign.START.name());
        new TextReader(args[0]).execute();
        logger.info(Sign.END.name());
    }

}