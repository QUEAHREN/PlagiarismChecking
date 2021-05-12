import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class File_Pair {

    private final MyFile File1;
    private final MyFile File2;
    ArrayList<String> phrase1 = new ArrayList<String>();
    ArrayList<String> phrase2 = new ArrayList<String>();
    ArrayList<String> objArray1 = new ArrayList<String>();
    ArrayList<String> objArray2 = new ArrayList<String>();
    private ArrayList<String> matchPhrase1 = new ArrayList<String>();
    private ArrayList<String> matchPhrase2 = new ArrayList<String>();
    String outContent1;
    String outContent2;
    String content1;
    String content2;

    private double phrase_Match_1_2;
    private double phrase_Match_2_1;


    public File_Pair(MyFile File1, MyFile File2){
        this.File1 = File1;
        this.File2 = File2;
        objArray1 = File1.getObjArray();
        objArray2 = File2.getObjArray();
    }

    public MyFile getFile1() {
        return File1;
    }
    public MyFile getFile2() {
        return File2;
    }
    public double getPhrase_Match_1_2(){
        return phrase_Match_1_2;
    }
    public double getPhrase_Match_2_1(){
        return phrase_Match_2_1;
    }
    public String getOutContent1() {
        return outContent1;
    }
    public String getOutContent2() {
        return outContent2;
    }
    public String getContent1() {
        return content1;
    }
    public String getContent2() {
        return content2;
    }
    public void setContent1(String content1) {
        this.content1 = content1;
    }
    public void setContent2(String content2) {
        this.content2 = content2;
    }
    public ArrayList<String> getMatchPhrase1() {
        return matchPhrase1;
    }
    public ArrayList<String> getMatchPhrase2() {
        return matchPhrase2;
    }

    public void phraseMatching(int matchingLength) {


        ArrayList<String> objArray11 = new ArrayList<String>();
        ArrayList<String> objArray22 = new ArrayList<String>();
//        ArrayList<String> outobjArray11 = new ArrayList<String>();
//        ArrayList<String> outobjArray22 = new ArrayList<String>();
        int i, k;

        for (i = 0; i <= objArray1.size() - matchingLength; i++) {
            StringBuilder str0 = new StringBuilder();
            for (k = i; k < i + matchingLength; k++) {
                str0.append(objArray1.get(k));
                str0.append(" ");
            }
            objArray11.add(i, str0.toString());
        }

        for (i = 0; i <= objArray2.size() - matchingLength; i++) {
            StringBuilder str0 = new StringBuilder();
            for (k = i; k < i + matchingLength; k++) {
                str0.append(objArray2.get(k));
                str0.append(" ");
            }
            objArray22.add(i, str0.toString());
        }

//        for (Iterator<String> it = objArray22.iterator(); it.hasNext(); ) {
//            String s = it.next();
//            System.out.println("2222   "+s);
//        }
        int[] flag1 = new int[objArray1.size()];
        for (i = 0; i < objArray1.size(); i ++)    flag1[i] = 0;

        for (i = 0; i <= objArray1.size() - matchingLength; i++)
            if (objArray22.contains(objArray11.get(i))) {
                phrase1.add(objArray11.get(i));
                flag1[i] = 1;
                flag1[i+1] = 1;
                flag1[i+2] = 1;
            }

        int[] flag2 = new int[objArray1.size()];
        for (i = 0; i < objArray2.size(); i ++)    flag2[i] = 0;

        for (i = 0; i <= objArray2.size() - matchingLength; i++)
            if (objArray11.contains(objArray22.get(i))) {
                phrase2.add(objArray22.get(i));

                flag2[i] = 1;
                flag2[i+1] = 1;
                flag2[i+2] = 1;
            }
//                System.out.println(objArray11.get(i));
//                String str0 = "";
//                str0 += objArray11.get(i);
//                int n = i + 1;
//                while (true) {
//                    if (objArray22.contains(objArray11.get(n))) n ++;
//                    else break;
//                }
//                n = n - i - 1;
//                int num = n/4;
//                int wnum = n % 4;
//                System.out.println(n);
//                System.out.println(num);
//                System.out.println(wnum);
//                for (int j = 1; j <= num; j ++)     str0 += objArray11.get(j*4+i);
//                for (int j = i + (num+1)*4; j <= i + (num+1)*4 + wnum - 1; j ++)    str0 += objArray1.get(j) + " ";
//                System.out.println(str0);
//                outobjArray11.add(k++, "<<*" + str0 + "*>>");
//                i = i + (num+1) * 4 + wnum - 1;
//            }
//             else {
//                if (i == objArray1.size() - matchingLength) {
//                    outobjArray11.add(k++, objArray11.get(i) + " ");
//                }else {
//                    outobjArray11.add(k++, objArray1.get(i) + " ");
//                }
//        }
//        }
//        for (Iterator<String> it = phrase2.iterator(); it.hasNext(); ) {
//            String s = it.next();
//            System.out.println(s);
//        }






        //转成文字
        StringBuilder str0 = new StringBuilder();
        String str1 = "";
        StringBuilder str2 = new StringBuilder();
        int marchwords1 = 0, tag1 = 0;
        for (i = 0; i < objArray1.size(); i++){
            str2.append(objArray1.get(i)).append(" ");
            if (flag1[i] == 0){
                tag1 = 0;
                str0.append(objArray1.get(i)).append(" ");

            }
            else{
                tag1 ++;
                if (tag1 == 1){
                    str0.append("*");
                    if(!str1.isEmpty()) {
                        matchPhrase1.add(str1);
                        str1 = "";
                    }
                }
                str0.append(objArray1.get(i)).append("*");
                str1 += objArray1.get(i) + " ";
                marchwords1 ++;
            }
        }
        matchPhrase1.add(str1);
        this.outContent1 = str0.toString();
        setContent1(str2.toString());

//        for (Iterator<String> it = marchPhrase1.iterator(); it.hasNext(); ) {
//            String s = it.next();
//            System.out.println(s);
//        }
        str0 = new StringBuilder();
        str1 = "";
        str2 = new StringBuilder();
        int marchwords2 = 0, tag2 = 0;
        for (i = 0; i < objArray2.size(); i++){
            str2.append(objArray2.get(i)).append(" ");
            if (flag2[i] == 0){
                tag2 = 0;
                str0.append(objArray2.get(i)).append(" ");

            }
            else{
                tag2 ++;
                if (tag2 == 1){
                    str0.append("*");
                    if(!str1.isEmpty()) {
                        matchPhrase2.add(str1);
                        str1 = "";
                    }
                }
                str0.append(objArray2.get(i)).append("*");
                str1 += objArray2.get(i) + " ";
                marchwords2 ++;
            }
        }
        matchPhrase2.add(str1);
        this.outContent2 = str0.toString();
        setContent2(str2.toString());


//        str0 = new StringBuilder();
//        str2 = new StringBuilder();
//        int marchwords2 = 0;
//        for (i = 0; i < objArray2.size(); i++){
//            str2.append(objArray2.get(i)).append(" ");
//            if (flag2[i] == 0)  str0.append(objArray2.get(i)).append(" ");
//            else  {
//                str0.append(objArray2.get(i)).append("*");
//                marchwords2 ++;
//            }
//        }
//        setContent2(str2.toString());


//        System.out.println(str0);
        this.outContent2 = str0.toString();

        this.phrase_Match_1_2 = ((double)marchwords1/File1.getTotalWords())*100;
        this.phrase_Match_2_1 = ((double)marchwords2/File2.getTotalWords())*100;
//        System.out.println(marchwords1);
//        System.out.println(File1.getTotalWords());

//        System.out.println(File1.getoriginalContent());

    }

    public void outPutcontent(){




    }

}







