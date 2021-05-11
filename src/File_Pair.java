import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class File_Pair {

    private MyFile File1;
    private MyFile File2;

    public File_Pair(MyFile File1, MyFile File2){
        this.File1 = File1;
        this.File2 = File2;
    }

    public void phraseMatching() {
        int matchingLength = 4;
        ArrayList<String> objArray1 = File1.getObjArray();
        ArrayList<String> objArray2 = File2.getObjArray();
        ArrayList<String> objArray11 = new ArrayList<String>();
        ArrayList<String> objArray22 = new ArrayList<String>();
        ArrayList<String> outobjArray11 = new ArrayList<String>();
        ArrayList<String> outobjArray22 = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        int i, k;

        for (i = 0; i <= objArray1.size() - matchingLength; i++) {
            String str0 = "";
            for (k = i; k < i + matchingLength; k++) {
                sb.append(str0).append(objArray1.get(k));
                sb.append(str0).append(" ");

                objArray11.add(i, str0);
            }
            for (i = 0; i <= objArray2.size() - matchingLength; i++) {
                str0 = "";
                for (k = i; k < i + matchingLength; k++) {
                    sb.append(str0).append(objArray2.get(k));
                    sb.append(str0).append(" ");
                }
                objArray22.add(i, str0);
            }

            for (i = 0, k = 0; i <= objArray1.size() - matchingLength; i++) {
                if (objArray22.contains(objArray11.get(i))) {
                    outobjArray11.add(k++, "*" + objArray11.get(i) + "*");
                    i += matchingLength - 1;

                } else {
                    if (i == objArray1.size() - matchingLength) {
                        outobjArray11.add(k++, "*" + objArray11.get(i) + "*");
                    }

                    outobjArray11.add(k++, " " + objArray1.get(i) + " ");
                }
            }
            System.out.println("why?");
            for (i = 0; i <= outobjArray11.size(); i++)
                System.out.println(outobjArray11.get(i));

        }
    }






}
