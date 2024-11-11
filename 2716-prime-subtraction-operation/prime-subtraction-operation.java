class Solution {
    public boolean primeSubOperation(int[] nums) {
        int x=0;    //Initialize x as 0, which keeps track of the last modified value in nums
        for (int num : nums){
            if(x >= num) return false;
            int prime = num-x-1;    // Calculate the maximum possible prime less than (num - x)
            while(prime > 0 && !(isPrime(prime))){// Find the largest prime less than or equal to (num - x - 1)
                prime--;     //Decrement `prime` until a prime number is found
            }
            x = num-prime;   // Update x to the modified value of num (i.e., num - prime)
        }
        return true;
    }

    boolean isPrime(int n){
        if(n <= 1) return false;
        if(n == 2) return true;
        if(n%2 ==0 || n%3 == 0) return false;
        // Check divisibility from numbers starting from 5, only checking odd numbers
        for(int i=5; i*i<=n ; i+=6){    // Skip multiples of 2 and 3 by checking divisibility with i and i + 2
            if(n % i == 0 || n % (i+2) == 0) return false;
        }
        return true;
    }
}