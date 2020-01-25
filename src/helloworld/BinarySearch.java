package helloworld;

import javax.management.openmbean.InvalidOpenTypeException;

public class BinarySearch {//二分查找
    //time complexity O(logn) space complexity(O(1))
//经典
    public static int binarySearch(int[] array,int target){
        //Firstly, we need to validate input and make sufficient assumption.
        if(array == null || array.length == 0){
            return -1;
        }
        int l = 0;
        int r = array.length-1;

        while(l<=r){
            int mid = l+(r-l)/2;//We not use(l+r)/2. Prevent the value overflow. mid的值会在循环中不断变化，因此不能写在循环外，否则死循环。

           if(array[mid] == target){
              // System.out.println(mid);
               return mid;
           }else if (array[mid] < target){
               l = mid+1;
           }else{
               r = mid-1; //if found, return early.
           }
        }
       // System.out.println("not found.");
        return -1; //not found.
    }

    //target第一次出现的index
    public static int firstOccur(int[] array,int target){
        //Firstly, we need to validate input and make sufficient assumption.
        if(array == null || array.length == 0){
            return -1;
        }
        int l = 0;
        int r = array.length-1;

        while(l < r-1){
            int mid = l+(r-l)/2; //mid的值会在循环中不断变化 因此不能写在循环外，否则死循环。
            if(array[mid] >= target) {
                r = mid;
            }
            else {
                l = mid+1;
            }
        }
        if(array[l] == target) return l;
        if(array[r] == target) return r;
        return -1;
    }

    public int firstOccur1(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= target) { // = 的情况只能和 >的情况写在一起，移动r。如果和 < 的情况写在一起移动l，可能会miss更前面的target。 口诀：找first ， 往前找 ,  r <----.
                right = mid;

            }else {
                left = mid + 1;
            }
        }
        if (array[left] == target) return left;
        if (array[right] == target) return right;
        return -1;
    }

    //target最后一次出现的index
    public static int lastOccur(int[] array, int target){
        //Firstly, we need to validate input and make sufficient assumption.
        if(array == null || array.length == 0){
            return -1;
        }
        int l = 0;
        int r = array.length-1;

        while(l < r-1){
            int mid =l+(r-l)/2 ;
            if(array[mid] <= target){
                l = mid;
            }else{
                r = mid-1;
            }
        }
        if(array[r] == target) return r;
        if(array[l] == target) return l;
        return -1;
    }
    //数组中最接近target的数
    public static int closest(int[] array, int target){
        if (array == null || array.length == 0){
            return -1;
        }
        if(array.length == 1){
            return 0; //只有一个元素，即这个元素与target最近。
        }
        int l = 0;
        int r = array.length-1;

        while(l<r-1){
            int mid = l +(r-l)/2;
            if(array[mid] == target){ //如果直接相等，则其本身就是离自己最接近的数。
                return mid;
            }else if(array[mid] < target){
                l = mid;
            }else{
                r = mid;
            }
        }
        if(Math.abs(array[l]-target)<Math.abs(array[r]-target)){
            return l;
        }else{
            return r;
        }
    }

    // Sorted Matrix
    public static int[] search(int[][] matrix, int target){
        int[] res = {-1,-1};
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m*n-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if (matrix[mid/n][mid%n] == target){
                res[0] = mid/n;
                res[1] = mid%n;
                return res;
            }else if(matrix[mid/n][mid%n] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }

        }
        return res;
    }

    public static void main(String[] args){
        int [][] matrix = {{1,2,3,4,5},{6,7,8,9,10}};
        int tar = 5;
        search(matrix,tar);

    }


}

