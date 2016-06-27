public class Solution{
    public int divide(int dividend, int divisor) {
        if(dividend<divisor) return 0;
        if(divisor==0) return Integer.MAX_VALUE;
        
        boolean positive=true;
        if((dividend>0 && divisor<0) || (dividend<0 && divisor>0)){
            positive=false;
        }
        
        long dividendl=Math.abs((long)dividend);
        long divisorl=Math.abs((long)divisor);
        
        int rst=0;
        System.out.println(dividendl);
        while(dividendl>=divisorl){
            System.out.println("here");
            int n=1;
            while((divisorl<<n)<=dividendl){
                n++;
            }
            rst=rst+(1<<(n-1));
            dividendl=dividendl-(divisorl<<(n-1));
        }
        
        return positive?rst:(-rst);
    }

    public static void main(String args[]){
        Solution s=new Solution();
        s.divide(-2147483648,10);
    }
}