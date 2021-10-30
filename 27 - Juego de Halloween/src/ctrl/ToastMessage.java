package ctrl;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class ToastMessage extends JDialog{
	int miliseconds;
    public ToastMessage(String toastString, int time) {
        this.miliseconds = time;
        setUndecorated(true);
        getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBorder(new LineBorder(Color.RED, 2));
        getContentPane().add(panel, BorderLayout.CENTER);

        JLabel toastLabel = new JLabel("");
        toastLabel.setText(toastString);
        toastLabel.setFont(new Font("Dialog", Font.BOLD, 12));
        toastLabel.setForeground(Color.BLACK);

        setBounds(100, 100, toastLabel.getPreferredSize().width+20, 31);


        setAlwaysOnTop(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int y = dim.height/2-getSize().height/2;
        int half = y/2;
        setLocation(dim.width/2-getSize().width/2, y);
        panel.add(toastLabel);
        setVisible(false);

        new Thread(){
            public void run() {
                try {
                    Thread.sleep(miliseconds);
                    dispose();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

}
