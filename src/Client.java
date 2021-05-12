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
        f1_2.phraseMatching(5);
        System.out.println(f1_2.getPhrase_Match_1_2());
        System.out.println(f1_2.getPhrase_Match_2_1());
        GUIText GT1= new GUIText(f1_2);
    }

}
