package com.crazyjava;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.SynchronousQueue;

/**
 * @Author: Richered
 * @Date: 2020/8/11 21:40
 * @Description:
 */
public class MyTextPane extends JTextPane {

    protected StyledDocument doc;

    protected SyntaxFormatter formatter = new SyntaxFormatter("my.stx");

    private SimpleAttributeSet normalAttr = formatter.getNormalAttributeSet();

    private SimpleAttributeSet quotAttr = new SimpleAttributeSet();

    private int docChangeStart = 0;

    private int docChangeLength = 0;

    public MyTextPane(){
        StyleConstants.setForeground(quotAttr, new Color(255, 0, 255));

        StyleConstants.setFontSize(quotAttr, 16);

        this.doc = super.getStyledDocument();

        this.setMargin(new Insets(3, 40, 0, 0));

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                syntaxParse();
            }
        });

        doc.addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                docChangeStart = e.getOffset();
                docChangeLength = e.getLength();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
    }

    public void syntaxParse(){
        try{
            Element root = doc.getDefaultRootElement();

            int cursorPos = this.getCaretPosition();

            int line = root.getElementIndex(cursorPos);

            Element para = root.getElement(line);

            int start = para.getStartOffset();

            start = start > docChangeStart ? docChangeLength : start;

            int length = para.getEndOffset() - start;

            length = length < docChangeLength ? docChangeLength + 1 : length;

            String s = doc.getText(start, length);

            String[] tokens = s.split("\\s +|\\.|\\(|\\)|\\{|\\}|\\[|\\]");

            int curStart = 0;

            boolean isQuot = false;

            for (String token : tokens){
                int tokenPos = s.indexOf(token, curStart);
                if (isQuot && (token.endsWith("\"") || token.endsWith("\'"))){
                    doc.setCharacterAttributes(start + tokenPos, token.length(), quotAttr, false);
                }else if (isQuot && !(token.endsWith("\"")) || token.endsWith("\'")){
                    doc.setCharacterAttributes(start + tokenPos, token.length(), quotAttr, false);
                }else if ((token.startsWith("\"")) || token.startsWith("\'") && (token.endsWith("\"")) || token.endsWith("\'")){
                    doc.setCharacterAttributes(start + tokenPos, token.length(), quotAttr, false);
                }else if ((token.startsWith("\"")) || token.startsWith("\'") && !(token.endsWith("\"")) || token.endsWith("\'")){
                    doc.setCharacterAttributes(start + tokenPos, token.length(), quotAttr, false);
                }else {
                    formatter.setHighLight(doc, token, start + tokenPos, token.length());
                }
                curStart = tokenPos + token.length();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void paint(Graphics g){
        super.paint(g);

        Element root = doc.getDefaultRootElement();

        int line = root.getElementIndex(doc.getLength());

        g.setColor(new Color(230, 230, 230));

        g.fillRect(0, 0, this.getMargin().left - 10, getSize().height);

        g.setColor(new Color(40, 40, 40));

        for (int count = 0, j = 1; count <= line; count++, j++){
            g.drawString(String.valueOf(j), 3, (int)((count + 1) * 1.535 * StyleConstants.getFontSize(normalAttr)));
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("文本编辑器");

        frame.getContentPane().add(new JScrollPane(new MyTextPane()));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final  int inset = 50;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        frame.setBounds(inset, inset, screenSize.width - inset * 2, screenSize.height - inset * 2);

        frame.setVisible(true);
    }
}
