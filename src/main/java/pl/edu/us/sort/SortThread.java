package pl.edu.us.sort;

public class SortThread extends Thread implements Runnable {

    private SortSynchronized sort;

    public SortThread(SortSynchronized sort) {
        this.sort = sort;
    }

    public void run() {
        while (true) {
            sort.replace();
            try {
                sleep((long) (Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
