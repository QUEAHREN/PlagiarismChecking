import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;

public class GUIText {


    public GUIText(File_Pair pair){
        JFrame frame = new JFrame();
        JTextArea ta = new JTextArea(10, 20);
        ta.setText(pair.getOutContent1());
        frame.add(new JScrollPane(ta));
        System.out.println(pair.getOutContent1());
        Highlighter highLighter = ta.getHighlighter();
        String text = ta.getText();
        DefaultHighlighter.DefaultHighlightPainter p = new DefaultHighlighter.DefaultHighlightPainter(Color.RED);
        String keyWord = " misinterpreted this relationship was";
        int pos = 0;
        while ((pos = text.indexOf(keyWord, pos)) >= 0)
        {
            try
            {
                highLighter.addHighlight(pos, pos + keyWord.length(), p);
                pos += keyWord.length();
            }
            catch (BadLocationException e)
            {
                e.printStackTrace();
            }
        }

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

