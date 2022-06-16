import java.util.Arrays;

public class Merging {
    /*


    Created by Hussein Shamas on June 16 , 2022.


     */

    private static void mergeSort(int [] array){

        int arrayLength = array.length;

        if (arrayLength < 2) {
            return;
        }

        int mid = arrayLength / 2 ; // taking the mid of the array

        int [] leftHalf = new int[mid]; // creating our left half array

        int [] rightHalf = new int[arrayLength - mid]; // mid-index could cause you
                                                       // trouble if the length was odd

        for (int i = 0 ; i < mid ; i++) {
            leftHalf[i] = array[i];
        }
        for (int i = mid ; i < arrayLength; i++) {
            rightHalf[i-mid] = array[i]; // we want to fill the array starting from zero not mid

        }

        // after this point , we should have 2 sorted halves
        mergeSort(leftHalf);
        mergeSort(rightHalf);

        // last step , is to merge( I'll be creating a function for that ).
        merge(array, leftHalf, rightHalf);


    }

    private static void merge(int [] array , int [] leftHalf, int [] rightHalf){
        int leftLength = leftHalf.length;
        int rightLength = rightHalf.length;

        // now we need 3 iterators, one for the left half ,
        // for the right half , and for the merged array.

        int i=0, j = 0 , k = 0 ;

        while (i < leftLength && j < rightLength) {
            if (leftHalf[i] < rightHalf[j]){
                array[k] = leftHalf[i];
                i++;
            }
            else {
                array[k] = rightHalf[j];
                j++;
            }
            // now we need to increment k so that we keep adding to the array.
            k++;
        }

        // now here we will have all elements in the left half in a nice order.
        while (i < leftLength){
            array[k] = leftHalf[i];
            k++;
            i++;
        }
        while (j < rightLength) {
            array[k] = rightHalf[j];
            k++;
            j++;

            // now scroll up to where I wrote merge to call this method.
        }
    }

    public static void main(String[] args) {
        int [] originalArray = {1,5,7,6,44,22,11,42,13,53,57,77,32,17,64,72,100};
        System.out.println("Your array before is : " );
        System.out.println(Arrays.toString(originalArray));

        mergeSort(originalArray);

        System.out.println("Your array after sorting : ");
        System.out.println(Arrays.toString(originalArray));
    }
}
