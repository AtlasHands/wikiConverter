import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alpine Tree on 7/15/2017.
 */
public class GUI {
    private JButton convertButton;
    private JEditorPane editorPane1;
    private JPanel root;
    public GUI(){
        JFrame main = new JFrame();
        main.add(root);
        main.pack();
        main.setVisible(true);
        convertButton.addActionListener((ActionEvent e)->{
            editorPane1.setEnabled(false);
            String temp = editorPane1.getText();
            String substring;
            String fullString = "";
            Boolean flag = false;
            for(int x = 0;x<temp.length();x++) {
                substring = temp.substring(x, x + 1);
                if (substring.equals("\n")) {
                    if (flag == true) {
                        flag = false;
                    }
                }
                if (flag == false) {

                    try {
                        int subStringInt = Integer.parseInt(substring);
                        if (subStringInt >= 0 && subStringInt <= 9) {
                            fullString = fullString + "#";
                        }
                        flag = true;
                    } catch (NumberFormatException nfe) {
                        char c = substring.charAt(0);
                        if(c > 'A' && c < 'z'){
                            fullString = fullString + "##";
                            flag = true;
                        }
                        else{
                            fullString = fullString + substring;
                        }
                    }
                }
                else if(flag == true){
                    fullString = fullString + substring;
                }


            }
            editorPane1.setText(fullString);
            editorPane1.setEnabled(true);
        });
    }

}
