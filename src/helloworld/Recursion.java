package helloworld;

public class Recursion { // 递归

    /* Fibonacci Sequence
      0 1 1 2 3 5 8 13 21
      subproblem : f(n-1) , f(n-2), f(n-3), f(n-4) ...
      recursion rule : f(n) = f(n-1)+f(n-2)
      base case : f(0) = 0, f(1) =1
      Time Complexity: O(2^n)
      Space Complexity: O(n)
      notice：斐波那契数列 用递归求解并非最优解。
     */
    public static long fibo(int n){
        //先写base case (we should check whether the function need stop early at first.)
        if (n < 0){
            return -1;
        }
        if (n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        //return recursion rule
        return fibo(n-1)+fibo(n-2);
    }

    // DP ( Fibonacci Sequence)
    public  static long fibo2(int n){
        if (n < 0){
            return -1;
        }
        if (n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int a = 0;
        int b = 1;
        for(int i = 0 ; i < n-1; i++){
            int tmp = a+b;
            a = b;
            b =tmp;
        }
        return b;
    }

    //Power (calculate a^b)
    //method1 Time Complexity = O(b) Space Complexity = O(1)
        public static long power1(int a, int b){
        if(b == 0){
            return 1;
        }
        if(b == 1){
            return a;
        }
        long res = 1;
        for(int i = 0 ; i < b; i++){
            res *= a;
        }
        return res;
    }

    //method 2
    /*
    subproblem: f(a,b-1)
    recursion rule: f(a,b) = f(a,b-1)*a
    base case: f(a,0) = a^0=1
    Time Complexity = O(b) Space Complexity = O(b)
     */
    public static long power2(int a,int b){
        //base case assumption.
        if(b == 0){
            return 1;
        }
        //recursion rule
        return power2(a,b-1)*a;
    }

    //method 3
    /*
    subproblem: f(a,b/2)
    recursion rule: b is even: f(a,b) = f(a,b/2)*f(a,b/2); b is odd :  f(a,b) = f(a,b/2)*f(a,b/2)*a
    base case: f(a,0) = a^0=1
    Time Complexity = O(b) （存为half后，优化为logb） Space Complexity = O(log b)
     */

    public static long power3(int a,int b){
        //base case assumption.
        if(b == 0){
            return 1;
        }
        long half = power3(a,b/2);
        if(b%2 == 0){
        return half * half;
    }else{
            return half * half * a;
        }
    }

    public static void main(String[] args) {
        /*for (int i = 0;i<5;i++){
            System.out.println("Fibp("+i+")="+fibo(i)); */
        int a = 3;
        int b = 1;
        power1(a,b);
        }
    }





