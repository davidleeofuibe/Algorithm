public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int divider=1;
        while(x/divider>=10){
            divider=divider*10;
        }
        while(x!=0){
            int high=x/divider;
            int low=x%10;
            if(high==low){
                x=x%divider/10;
                divider=divider/100;
            }else{
                return false;
            }
        }
        return true;
    }
}