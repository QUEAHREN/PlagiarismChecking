public class Client {
    public static void main(String[] args) {

        MyFile file1 = new MyFile("test1.txt");
        MyFile file2 = new MyFile("test2.txt");
        MyFile file3 = new MyFile("test3.txt");
        MyFile file4 = new MyFile("test4.txt");
        MyFile file5 = new MyFile("test5.txt");
//        System.out.println(file.getContent());
//        file.countFrequency();

        File_Pair f1_2 = new File_Pair(file1, file2);
        File_Pair f1_3 = new File_Pair(file1, file3);
        File_Pair f1_4 = new File_Pair(file1, file4);
        File_Pair f1_5 = new File_Pair(file1, file5);
        File_Pair f2_3 = new File_Pair(file2, file3);
        File_Pair f2_4 = new File_Pair(file2, file4);
        File_Pair f2_5 = new File_Pair(file2, file5);
        File_Pair f3_4 = new File_Pair(file3, file4);
        File_Pair f3_5 = new File_Pair(file3, file5);
        File_Pair f4_5 = new File_Pair(file1, file5);
        f1_2.phraseMatching(3);
        f1_3.phraseMatching(3);
        System.out.println(f1_2.getPhrase_Match_1_2());
        System.out.println(f1_2.getPhrase_Match_2_1());
        GUIText GT1= new GUIText();
        GT1.mainUI();
//        GT1.showText(f1_3);
    }

}
