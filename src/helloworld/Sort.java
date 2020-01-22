package helloworld;

import java.util.Random;

public class Sort { // 一般情况下 merge sort 与 quick sort 为最优解。时间复杂度都为O(nlogn)

    // 1. Selection Sort
    // Time Complexity:O(n^2)双层for循环，循环嵌套的时间复杂度就是指最内层循环的时间负责度。
    // Space Complexity: O(1)  limited local variable & no new obj.
    public static void selectionSort(int[] a){ // because we sort the array in place, so we needn't return a new array, we can return void here.
       int len = a.length;
       for(int i = 0; i < len - 1 ; i++){ //assign unsorted array.
           int curMin = i;
           for(int j = i+1 ; j < len ; j++){ // find the currMin in unsorted array
               if(a[j] < a[curMin]){
                   curMin = j;
               }
           }
           //int temp = a[i];
           //a[i] = a[curMin];
           //a[curMin] = temp;
           swap(a,i,curMin);
       }
    }
    // 2. Merge Sort
    //Time Complexity: O(nlogn)
    //Space Complexity:O(n)
    public static int[] mergeSort(int[] a){
        if(a == null || a.length <=1){
            return a;
        }
        return mergeSort(a,0,a.length-1);
    }

    private static int[] mergeSort(int[] a, int left, int right){
        //base case ***1
        if(left == right){
            return new int[] {a[left]};
        } //拆成 只有一个元素的状态
        int mid = left + (right - left)/2;
        int[] leftArray = mergeSort(a, left, mid); //***2 不能写成 left ~ (mid-1), mid ~ right.                   ****左闭右闭
        int[] rightArray = mergeSort(a,mid+1,right); //For example: l = 5, r =6,mid = 5 left ~ (mid-1): (5,4) 空集  ,  mid ~ right: (5,6) 问题并未缩减，stack overflow，recurs
        return merge(leftArray,rightArray);
    }
    private static int[] merge(int[] leftArray, int[] rightArray){
        int[] res = new int[leftArray.length + rightArray.length];
        int i = 0;  //start of left array.
        int j = 0; //start of right array.
        int k = 0; //start of res array.
        while(i < leftArray.length && j < rightArray.length){ // compare every elements of each arrays, put the smaller one into res. And change the position of i or j & k.
            if(leftArray[i] <= rightArray[j] ){
                res[k] = leftArray[i];
                i++;
            }else{
                res[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while(i < leftArray.length){ //while one of array have been put into the res completely, you should put all of remaining elements of another array into the res too.
            res[k] = leftArray[i];
            i++;                     // And change the position of i or j & k.
            k++;
        }
        while(j < rightArray.length){
            res[k] = rightArray[j];
            j++;
            k++;
        }
      return res;
    }

    // 3. Quick Sort
    // Time Complexity: O(nlogn)  worstcase: O(n^2)
    // Space Complexity: O（logn) worstcase: O(n)
   public static void quickSort(int[] array){
        if(array == null || array.length <=1){
              return ;
       }
       quickSort(array,0,array.length-1);
   }

   static Random random = new Random();
   private static void quickSort(int[] array, int left, int right){
       if(left >= right){ //   > : pivot 选到了边界元素。    = ： 只剩下一个元素。
           return;
       }
       int pivotIndex = left + random.nextInt(right - left + 1); //random.nextInt(x) --> [0,x-1]
       swap(array, pivotIndex, right);
       int i = left;
       int j = right -1;
       while(i<=j){
       if(array[i]<=array[right]){
           i++;
       }else {
           swap(array,i,j);
           j--;
       }
       }
       swap(array,i,right); //i 是当前数列中比right大的第一个数

       quickSort(array,left,i-1);
       quickSort(array,i+1,right);
   }
   private static void swap(int[] array, int x, int y){
    int tmp = array[x];
    array[x] = array[y];
    array[y] = tmp;  //需要注意 这里swap的不是index 而是具体的数。
   }

   // 4. Rainbow Sort e.g. input: [2,1,1,2,3,1,2,3,3]
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static void rainbowSort(int[] array){
       if(array == null || array.length <=1){
           return;
       }
       int i = 0; // 第二个数的开头。
       int j = 0; // 当前需要比较的数。
       int k = array.length - 1; // 第三个数的开头。
       while(j <= k){
           if (array[j] == 1){
               swap(array,i,j);
               i++;
               j++;
           }else if(array[j] == 2){
               j++;
           }else{
               swap(array,j,k);
               k--;
           }
       }

    }

}
