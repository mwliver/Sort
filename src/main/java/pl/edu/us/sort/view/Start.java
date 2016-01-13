package pl.edu.us.sort.view;

import javax.swing.*;

public class Start {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Application application = new Application();
                application.setSize(300, 300);
                application.setVisible(true);
            }
        });
    }
}
