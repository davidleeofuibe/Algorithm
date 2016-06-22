//Learn to deal with corner cases

public class Solution {
    public int myAtoi(String str) {
        if(str==null) return 0;
        str=str.trim();
        char[] array=str.toCharArray();
        boolean positive=true;
        int rst=0;
        for(int i=0;i<array.length;i++){
            if(i==0 && array[i]=='-'){
                positive=false;
                continue;
            }else if(i==0 && array[i]=='+'){
                positive=true;
                continue;
            }else{
                if(array[i]>='0' && array[i]<='9'){
                    int tmp=rst*10+array[i]-'0';
                    if(tmp/10!=rst){
                        return positive?Integer.MAX_VALUE:Integer.MIN_VALUE;
                    }
                    rst=tmp;
                }else{
                    break;
                }
            }
        }
        
        return positive?rst:(-rst);
        
    }
}