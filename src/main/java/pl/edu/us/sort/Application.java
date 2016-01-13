package pl.edu.us.sort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Application extends JFrame {

    private JPanel panel;
    private int[] array;
    JTextField numberOfThreadsField;

    public Application() {
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        panel = new JPanel();
        panel.add(createButtonForSort());
        panel.add(createButtonForSynchronizedSort());
        panel.add(new Label("Ilość wątków w synchonizedSort: "));
        panel.add(createTextField());
        add(panel);
    }

    private JTextField createTextField() {
        numberOfThreadsField = new JTextField(20);
        numberOfThreadsField.setText("1");
        return numberOfThreadsField;
    }

    private JButton createButtonForSynchronizedSort() {
        JButton synchronizedSort = new JButton("Synchonized sort");
        synchronizedSort.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                setArray();
                long startTime = System.currentTimeMillis();
                SortSynchronized sort = new SortSynchronized(array, 0, array.length - 1);
                for (int i = 0; i < Integer.valueOf(numberOfThreadsField.getText()); i++) {
                    new ShareThread(sort).start();
                    new SortThread(sort).start();
                }

                Boolean isPrint = false;
                while (Boolean.FALSE.equals(isPrint)) {
                    int lastElem = 0;
                    boolean isOk = true;
                    for (int q = 0; array.length > q; q++) {
                        if (lastElem > array[q]) isOk = false;
                        lastElem = array[q];
                    }

                    if (isOk && Boolean.FALSE.equals(isPrint)) {
                        long endTime = System.currentTimeMillis();
                        for (int q = 0; array.length > q; q++) {
                            System.out.println(array[q]);
                        }
                        isPrint = true;

                        System.out.println(TimeUtils.millisToShortDHMS(endTime - startTime));
                    }
                }
            }
        });
        return synchronizedSort;
    }

    private JButton createButtonForSort() {
        JButton sort = new JButton("Sort");
        sort.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                setArray();
                long startTime = System.currentTimeMillis();
                Sort sort = new Sort();
                sort.sort(array);
                for (int q = 0; array.length > q; q++) {
                    System.out.println(array[q]);
                }
                long endTime = System.currentTimeMillis();
                System.out.println(TimeUtils.millisToShortDHMS(endTime - startTime));
            }
        });
        return sort;
    }

    public void setArray() {
        this.array = new int[]{31, 2, 1, 5, 11, 22, 14, 7, 3, 15, 3, 6, 8, 4, 8, 15, 30, 1, 2, 14, 22, 18, 90};
    }
}
