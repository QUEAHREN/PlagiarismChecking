import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class File_Pair {

    private MyFile File1;
    private MyFile File2;
    ArrayList<String> phrase1 = new ArrayList<String>();
    ArrayList<String> phrase2 = new ArrayList<String>();
    private double phrase_Match_1_2;
    private double phrase_Match_2_1;
    public File_Pair(MyFile File1, MyFile File2){
        this.File1 = File1;
        this.File2 = File2;
    }

    public double getPhrase_Match_1_2(){
        return phrase_Match_1_2;
    }
    public double getPhrase_Match_2_1(){
        return phrase_Match_2_1;
    }

    public void phraseMatching() {

        int matchingLength = 3;
        ArrayList<String> objArray1 = File1.getObjArray();
        ArrayList<String> objArray2 = File2.getObjArray();
        ArrayList<String> objArray11 = new ArrayList<String>();
        ArrayList<String> objArray22 = new ArrayList<String>();
        ArrayList<String> outobjArray11 = new ArrayList<String>();
        ArrayList<String> outobjArray22 = new ArrayList<String>();
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

        int[] flag2 = new int[objArray2.size()];
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
        for (Iterator<String> it = phrase2.iterator(); it.hasNext(); ) {
            String s = it.next();
            System.out.println(s);
        }
        String str0 = "";
        int marchwords1 = 0;
        for (i = 0; i < objArray1.size(); i++){
            if (flag1[i] == 0)  str0 += objArray1.get(i) + " ";
            else{
                str0 += objArray1.get(i) + "***";
                marchwords1 ++;
            }

        }
        System.out.println(str0);

        str0 = "";
        int marchwords2 = 0;
        for (i = 0; i < objArray2.size(); i++){
            if (flag2[i] == 0)  str0 += objArray2.get(i) + " ";
            else  {
                str0 += objArray2.get(i) + "***";
                marchwords2 ++;
            }

        }
        System.out.println(str0);

        this.phrase_Match_1_2 = (double)marchwords1/File1.getTotalWords();
        this.phrase_Match_2_1 = (double)marchwords2/File2.getTotalWords();
        System.out.println(File1.getoriginalContent());
//            System.out.println(k);
//            String str0 = "";
//            for (i = 0; i < k; i++)
//                str0 += outobjArray11.get(i);
//            System.out.println(str0);
    }

    public void outPutcontent(){




    }

}







