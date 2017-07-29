package ro.siit.tema;

/**
 * Created by x-RauL-x on 7/26/2017.
 */
public class BubbleSort {
    public static void bubbleSort(SalesRepresentatives[] SalesGuy) {
        int swap;
        do {
            swap = 0;
            for (int i = 0; i < SalesGuy.length - 1; i++) {
                SalesRepresentatives tmp = SalesGuy[i];
                int quota = SalesGuy[i].getQuota();
                int quotaPlus = SalesGuy[i + 1].getQuota();
                if (quota > quotaPlus) {
                    SalesGuy[i] = SalesGuy[i + 1];
                    SalesGuy[i + 1] = tmp;
                    swap++;
                }
            }
        } while (swap > 0);
        System.out.print("\nSorted: ");
        for (int i = 0; i < SalesGuy.length; i++)
            System.out.print("\n" + SalesGuy[i]);
    }
}
