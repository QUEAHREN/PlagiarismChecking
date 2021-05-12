import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class GUIText {

    JFrame frame = new JFrame("MyCheck");
    JPanel panel = new JPanel();
    public void mainUI(){
        final JTextArea textArea = new JTextArea(5, 10);
        textArea.setLineWrap(true);
        panel.add(textArea);
        JButton btn = new JButton("提交");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("提交: " + textArea.getText());
                JOptionPane.showMessageDialog (panel, "提示消息", "标题",JOptionPane.WARNING_MESSAGE);
            }
        });
        panel.add(btn);

        frame.setContentPane(panel);
        frame.setVisible(true);


    }
    public void showText(File_Pair pair){

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

        ta2.setText(pair.getContent2());
        ta2.setLineWrap (true);
        ta2.setWrapStyleWord(true);
        paneltxt.add(txt2);
        paneltxt.add(new JScrollPane(ta2));

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


//        String keyWord = " misinterpreted this relationship was";
//        int pos = 0;
//        while ((pos = text.indexOf(keyWord, pos)) >= 0)
//        {
//            try
//            {
//                highLighter.addHighlight(pos, pos + keyWord.length(), p);
//                pos += keyWord.length();
//            }
//            catch (BadLocationException e)
//            {
//                e.printStackTrace();
//            }
//        }
        frame.setContentPane(paneltxt);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

