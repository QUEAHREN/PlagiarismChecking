public class Client {
    public static void main(String[] args) {
        File_Pair file = new File_Pair("test1.txt", "test2.txt");
        file.readTxt();
        System.out.println(file.getContent1());
    }

}
