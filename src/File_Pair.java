import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class File_Pair {

    private String File_Name1;
    private String File_Name2;
    private String content1 = "";
    private String content2 = "";


    public File_Pair(String File_Name1, String File_Name2){
        this.File_Name1 = File_Name1;
        this.File_Name2 = File_Name2;
    }

    public String getContent1() {
        return content1;
    }
    public String getContent2() {
        return content2;
    }
    public void readTxt() {
        this.content1 = conRead(File_Name1);
        this.content2 = conRead(File_Name2);
    }

    public String conRead(String File_Name){
        try {
            BufferedReader in = new BufferedReader(new FileReader(File_Name));
            String line = "";
            String content = "";
            while((line = in.readLine()) != null) {
                line = line.trim();
                if (!line.equals(" "))  {
                    content += line;
                }
            }
            content = content.toLowerCase();
            content = content.replaceAll("\"[^\"]+\"", ""); //strips out anything in quotes
            content = content.replaceAll("[^a-zA-Z ]", "");
            in.close();
            return content;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
