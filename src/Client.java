/*
        Client program, currently need to manually add files and paths,
        can be upgraded to add files in GUI.
*/
public class Client {

    public static void main(String[] args) {
//        Read the file, pay attention to the path!
        MyFile[] file = new MyFile[5];
        file[0] = new MyFile("test1.txt");
        file[1] = new MyFile("test2.txt");
        file[2] = new MyFile("test3.txt");
        file[3] = new MyFile("test4.txt");
        file[4] = new MyFile("test5.txt");

//        Here is the test code.
//        System.out.println(file.getContent());
//        file.countFrequency();

//        Initialization object, generate File_Pair.
        File_Pair[] fP = new File_Pair[10];
        fP[0] = new File_Pair(file[0], file[1]);
        fP[1] = new File_Pair(file[0], file[2]);
        fP[2] = new File_Pair(file[0], file[3]);
        fP[3] = new File_Pair(file[0], file[4]);
        fP[4] = new File_Pair(file[1], file[2]);
        fP[5] = new File_Pair(file[1], file[3]);
        fP[6] = new File_Pair(file[1], file[4]);
        fP[7] = new File_Pair(file[2], file[3]);
        fP[8] = new File_Pair(file[2], file[4]);
        fP[9] = new File_Pair(file[3], file[4]);


//        Here is the test code.
//        fP[0].phraseMatching(10);
//        fP[1].phraseMatching(3);
//        fP[2].phraseMatching(3);
//        fP[3].phraseMatching(3);
//        fP[4].phraseMatching(3);
//        fP[5].phraseMatching(3);
//        fP[6].phraseMatching(3);
//        fP[7].phraseMatching(3);
//        fP[8].phraseMatching(3);
//        fP[9].phraseMatching(3);


//        GUI interactive window, using swing to build
        GUIText GT= new GUIText(file, fP);
        GT.mainUI();

    }

}
