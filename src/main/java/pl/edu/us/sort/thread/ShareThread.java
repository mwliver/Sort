package pl.edu.us.sort.thread;

import pl.edu.us.sort.sort.SortSynchronized;

public class ShareThread extends Thread implements Runnable {

    private SortSynchronized sort;

    public ShareThread(SortSynchronized sort) {
        this.sort = sort;
    }

    public void run() {
        while (true) {
            sort.share();
            try {
                sleep((long) (Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
