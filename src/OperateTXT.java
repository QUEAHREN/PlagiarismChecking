import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OperateTXT {

    public static int find_FileWord_Frequency(MyFile[] file, String filename, String word){
        for (int i = 0; i < file.length; i ++) {
            if (filename.equals(file[i].getFile_Name())) {
                return file[i].findWordFrequency(word);
            }
        }
        System.out.println("faild");
        return -1;
    }

    public static String find_Text_Frequency(MyFile[] file, String filename, int num){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < file.length; i ++) {
            if (filename.equals(file[i].getFile_Name())) {
                if (num > file[i].getTotalWords()){
                    sb.append("num is larger than total words!");
                    return sb.toString();
                }
                List<Map.Entry<String,Integer>> list = file[i].getList();
                for (Map.Entry<String, Integer> entry : list) {
                    if (num >= 1){
                        System.out.println(entry.getKey()+ ":" + entry.getValue());
                        sb.append(entry.getKey()).append(":").append(entry.getValue()).append("\n");
                        num --;
                    }
                }
                return sb.toString();
            }
        }
        System.out.println("faild");
        sb.append("Not Found the File!");
        return sb.toString();
    }

}
