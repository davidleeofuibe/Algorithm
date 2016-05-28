public class Solution {
    public int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int max=0;
        for(int x=0;x<=n/2;x++){
            if((n-2*x)%3==0){
                int product=0;
                int y=(n-2*x)/3;
                if(x==0){
                    product=(int)Math.pow(3,y);
                }else if(y==0){
                    product=(int)Math.pow(2,x);
                }else{
                    product=(int)Math.pow(3,y)*((int)Math.pow(2,x));
                }
                if(max<product){
                    max=product;
                }
            }
        }
        return max;
    }
}