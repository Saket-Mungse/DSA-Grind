class Solution {

    int factorial(int n) {

        if(n>1){

            int factorial = 1;

            while(n>1){

                factorial*=n--;

            }

            return factorial;

        }else{

            return 1;

        }

    }

} 

