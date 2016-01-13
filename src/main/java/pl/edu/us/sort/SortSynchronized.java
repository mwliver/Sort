package pl.edu.us.sort;

public class SortSynchronized {

    private int array[];
    private int i;
    private int j;

    public SortSynchronized(int[] array, int i, int j) {
        this.array = array;
        this.i = i;
        this.j = j;
    }

    public synchronized void replace() {
        while (array[i] > array[j]) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
        }

        this.notifyAll();
    }

    public synchronized void share() {
        if (i < j) {
            i++;
        } else if (j > 0) {
            i = 0;
            j--;
        } else {
            i = 0;
            j = array.length - 1;
        }

        this.notifyAll();
    }
}
