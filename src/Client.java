public class Client {
    public static void main(String[] args) {
        MyFile file1 = new MyFile("test1.txt");
        MyFile file2 = new MyFile("test2.txt");
//        System.out.println(file.getContent());
//        file.countFrequency();

        File_Pair f1_2 = new File_Pair(file1, file2);
        f1_2.phraseMatching();
    }

}
