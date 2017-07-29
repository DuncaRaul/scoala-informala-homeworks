package ro.siit.tema;

/**
 * Created by x-RauL-x on 7/26/2017.
 */
public class BubbleSort {
    /**
     * A method used to bubble sort an array of objects
     * @param SalesGuy object of the class SalesRepresentatives
     */
    public static void bubbleSort(SalesRepresentatives[] SalesGuy) {
        int swap;
        do {
            swap = 0;
            for (int i = 0; i < SalesGuy.length - 1; i++) {    //bubble sort algorythm
                SalesRepresentatives tmp = SalesGuy[i];        //used to sort all the objects
                int revenue = SalesGuy[i].getRevenue();          //in the array
                int revenuePlus = SalesGuy[i + 1].getRevenue();
                if (revenue < revenuePlus) {
                    SalesGuy[i] = SalesGuy[i + 1];
                    SalesGuy[i + 1] = tmp;
                    swap++;
                }
            }
        }
        while (swap > 0);

    }
}
