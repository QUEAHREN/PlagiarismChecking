import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

/*
This class is used to generate interactive windows
Using swing component in Java
*/

public class GUIText {

    private MyFile[] file;
    private File_Pair[] fP;
    JFrame frame = new JFrame("MyCheck");
    Box vBox = Box.createVerticalBox();

    //    Constructors
    public GUIText(MyFile[] file, File_Pair[] fP){
        this.file = file;
        this.fP = fP;
    }


    public MyFile[] getFile() {
        return file;
    }
    public File_Pair[] getfP() {
        return fP;
    }

//    main window
    public void mainUI(){

        JPanel panel1 = new JPanel();
        panel1.add(new Label("----Finds the specified word frequency in the specified file----"));
        vBox.add(panel1);
        vBox.add(findWordFre());

        JPanel panel2 = new JPanel();
        panel2.add(new Label("----Displays the frequency of words in a file----"));
        vBox.add(panel2);
        vBox.add(showTextFre());

        JPanel panel3 = new JPanel();
        panel3.add(new Label("----Highlight the matching phrase in both files and calculate phrase matching----"));
        vBox.add(panel3);
        vBox.add(showPairText());


        frame.setLocationRelativeTo(null);
        frame.setContentPane(vBox);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
//    Finds the specified word frequency in the specified file
    public JPanel showTextFre(){
        JPanel panel = new JPanel();
        final JTextArea filename = new JTextArea(1, 10);
        final JTextArea num = new JTextArea(1, 10);
        filename.setLineWrap(true);
        num.setLineWrap(true);

        panel.add(new Label("FileName(e.g. test1.txt):"));
        panel.add(filename);
        panel.add(new Label("Number of words to display:"));
        panel.add(num);
        JButton btn = new JButton("submit");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fre = OperateTXT.find_Text_Frequency(file,
                        filename.getText(),
                        Integer.parseInt(num.getText()));

                if (!fre.isEmpty()){
                    JOptionPane.showMessageDialog(
                            panel,
                            fre,
                            filename.getText() + "Frequency",
                            JOptionPane.WARNING_MESSAGE
                    );
                }
                else {
                    JOptionPane.showMessageDialog(
                            panel,
                            fre,
                            "Warning",
                            JOptionPane.WARNING_MESSAGE
                    );
                }
            }
        });
        panel.add(btn);
        return panel;
    }

//    Displays the frequency of words in a file
    public JPanel findWordFre(){

        JPanel panel = new JPanel();
        final JTextArea filename = new JTextArea(1, 10);
        final JTextArea word = new JTextArea(1, 10);
        filename.setLineWrap(true);
        word.setLineWrap(true);
        panel.add(new Label("FileName(eg: test1.txt):"));
        panel.add(filename);
        panel.add(new Label("The word:"));
        panel.add(word);
        JButton btn = new JButton("submit");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("submit: " + filename.getText());
                int fre = OperateTXT.find_FileWord_Frequency(file, filename.getText(), word.getText());
                if (fre == -1){
                    JOptionPane.showMessageDialog(
                            panel,
                            "Not Found!",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE
                    );
                }
                else
                    JOptionPane.showMessageDialog (panel,
                            " Word: " + word.getText() + "\n Frequency:" + fre, "Frequency",
                            JOptionPane.WARNING_MESSAGE);
            }
        });
        panel.add(btn);
        return panel;

    }

//    Highlight the matching phrase in both files
    public JPanel showPairText() {

        JPanel panel = new JPanel();
        final JTextArea filename1 = new JTextArea(1, 10);
        final JTextArea filename2 = new JTextArea(1, 10);
        final JTextArea minlength = new JTextArea(1, 10);

        filename1.setLineWrap(true);
        filename2.setLineWrap(true);
        minlength.setLineWrap(true);
        panel.add(new Label("File Name1(e.g. test1.txt):"));
        panel.add(filename1);
        panel.add(new Label("File Name2(e.g. test2.txt):"));
        panel.add(filename2);
        panel.add(new Label("The min matching length:"));
        panel.add(minlength);
        JButton btn = new JButton("submit");

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < fP.length; i ++) {
                    if ((filename1.getText().equals(fP[i].getFile1().getFile_Name()) &&
                            filename2.getText().equals(fP[i].getFile2().getFile_Name()))||
                            (filename1.getText().equals(fP[i].getFile2().getFile_Name()) &&
                                    filename2.getText().equals(fP[i].getFile1().getFile_Name()))){
                        System.out.println("1");
                        JFrame frame2 = new JFrame();
                        frame2.setContentPane(showText(fP[i], Integer.parseInt(minlength.getText())));

                        frame2.setVisible(true);
                        frame2.setLocationRelativeTo(null);
                        frame2.pack();
//                        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        break;
                    }
                }

            }
        });
        panel.add(btn);

        return panel;
    }


    public JPanel showText(File_Pair pair, int minlength){

        pair.phraseMatching(minlength);
        JPanel paneltxt = new JPanel();
        JLabel txt1 = new JLabel(pair.getFile1().getFile_Name());
        JLabel txt2 = new JLabel(pair.getFile2().getFile_Name());
        JTextArea ta = new JTextArea(20, 50);
        JTextArea ta2 = new JTextArea(20, 50);

        ta.setText(pair.getContent1());
        ta.setLineWrap (true);
        ta.setWrapStyleWord(true);
        paneltxt.add(txt1);
        paneltxt.add(new JScrollPane(ta));
        System.out.println(pair.getContent1());


        ta2.setText(pair.getContent2());
        ta2.setLineWrap (true);
        ta2.setWrapStyleWord(true);
        paneltxt.add(txt2);
        paneltxt.add(new JScrollPane(ta2));
        System.out.println(pair.getContent2());

        Highlighter highLighter = ta.getHighlighter();
        String text = ta.getText();
        DefaultHighlighter.DefaultHighlightPainter p = new DefaultHighlighter.DefaultHighlightPainter(Color.RED);
        ArrayList<String> keyWord = pair.getMatchPhrase1();

        for (Iterator<String> it = keyWord.iterator(); it.hasNext(); ) {
            String key = it.next();
            int pos = 0;
            while ((pos = text.indexOf(key, pos)) >= 0)
            {
                try
                {
                    highLighter.addHighlight(pos, pos + key.length(), p);
                    pos += key.length();
                }
                catch (BadLocationException e)
                {
                    e.printStackTrace();
                }
            }
        }

        highLighter = ta2.getHighlighter();
        text = ta2.getText();
        keyWord = pair.getMatchPhrase2();
        for (Iterator<String> it = keyWord.iterator(); it.hasNext(); ) {
            String key = it.next();
            int pos = 0;
            while ((pos = text.indexOf(key, pos)) >= 0)
            {
                try
                {
                    highLighter.addHighlight(pos, pos + key.length(), p);
                    pos += key.length();
                }
                catch (BadLocationException e)
                {
                    e.printStackTrace();
                }
            }
        }
        Box vbox1 = Box.createVerticalBox();
        JLabel fre1 = new JLabel();
        JLabel fre2 = new JLabel();
        fre1.setText(pair.getFile1().getFile_Name() + "--" + pair.getFile1().getFile_Name() +
                " Phrase Match (%):" + pair.getPhrase_Match_1_2());
        fre2.setText(pair.getFile2().getFile_Name() + "--" + pair.getFile2().getFile_Name() +
                " Phrase Match (%):" + pair.getPhrase_Match_2_1());
        vbox1.add(fre1);
        vbox1.add(fre2);
        paneltxt.add(vbox1);
//        Phrase Match (%)


        return paneltxt;
    }

}

