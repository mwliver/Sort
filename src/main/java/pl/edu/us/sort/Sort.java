package pl.edu.us.sort;

public class Sort {

    private int array[];
    private int length;

    public void sort(int[] inputArr) {

        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }

    private void quickSort(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];

        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }

            if (i <= j) {
                exchangeNumbers(i, j);
                i++;
                j--;
            }
        }
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }

    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void selectionSort(int items[]) {
        int najwieksze;
        int temp;
        for (int i = items.length-1; i>=0 ;i--) {
            najwieksze=0;
            for (int j=0; j<=i; j++) {
                if (items[najwieksze] < (items[j])) {
                    najwieksze = j;
                }
            }

            if (najwieksze != i ) {
                temp = items[i];
                items[i] = items[najwieksze];
                items[najwieksze] = temp;
            }
        }
    }
}
