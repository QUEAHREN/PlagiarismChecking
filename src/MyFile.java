import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/*
        Each file corresponds to a myfile class,
        which contains the objects and methods we need.
*/

public class MyFile {

    private String File_Name;
    private String originalContent = "";    //Original text content
    private String content = "";            //Text contains content without quotation marks. Text is case insensitive.
    private int totalWords;
    private ArrayList<String> objArray = new ArrayList<String>();
    Map<String,Integer> frequency = new HashMap<String, Integer>();
    List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>();

//    Constructors
    public MyFile(String File_Name){
        this.File_Name = File_Name;
        conRead(File_Name);
        countFrequency();
    }

//    Returns the object in the class
    public List<Map.Entry<String, Integer>> getList() {
        return list;
    }
    public String getFile_Name() {
        return File_Name;
    }
    public String getoriginalContent() {
        return originalContent;
    }
    public String getContent() {
        return content;
    }
    public int getTotalWords() {
        return totalWords;
    }
    public ArrayList<String> getObjArray() { return objArray; }

    public void printObjArray() {
        for (Iterator<String> it = objArray.iterator(); it.hasNext(); ) {
            String s = it.next();
            System.out.println(s);
        }
    }


    public void conRead(String File_Name) {
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

            this.originalContent = content;

            content = content.toLowerCase();
            content = content.replaceAll("\"[^\"]+\"", " "); //strips out anything in quotes
            content = content.replaceAll("[^a-zA-Z ]", " ");
            this.content = content;

            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void countFrequency() {

        String[] spilt = this.content.split(" ");

        for (int i = 0; i < spilt.length; i ++) {
            if (spilt[i].equals(""))   continue;
            else                       objArray.add(spilt[i]);
        }

        for (int i = 0; i < objArray.size(); i ++){
            String s = objArray.get(i);
            if (frequency.get(s) == null){
                frequency.put(s, 1);
            }else {
                int fre = frequency.get(s);
                frequency.put(s, ++fre);
            }
        }
        Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String,Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,Map.Entry<String, Integer> o2) {
                /*return o1.getValue ()-o2.getValue ();// 升序排序 */
                return o2.getValue() - o1.getValue();// 降序排序
            }
        };

        // map转换成list进行排序，Entry是Map中的一个静态内部类，用来表示Map中的每个键值对，
        //除非使用了静态导入import static java.util.Map.*，否则Map不可以省略。
        // map.EntrySet(),实现了Set接口，里面存放的是键值对.
        list = new ArrayList<Map.Entry<String,Integer>>(frequency.entrySet());

        Collections.sort(list, valueComparator);
//        System.out.println("------------map 按照 value 降序排序 --------------------");

        int total = 0, uniqueTotal = 0;

        for (Map.Entry<String, Integer> entry : list) {
            total += entry.getValue();
            uniqueTotal++;

        }
        this.totalWords = total;
//        System.out.println("Total:" + total);
//        System.out.println("uniqueTotal:" + uniqueTotal);


    }
    public int findWordFrequency(String keyword){
        if (frequency.get(keyword) == null) return -1;
        return frequency.get(keyword);
    }
}
