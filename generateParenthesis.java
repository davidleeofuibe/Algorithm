public class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result=new ArrayList<String>();
        generate(result,"",0,n);
        
        return result;
    }
    
    //num is unmatched "(" in string, n is how many "(" not in string
    private void generate(List<String> result,String s, int num, int n){
        if(n==0){
            while(num!=0){
                s+=")";
                num--;
            }
            result.add(s);
            return;
        }
        
        //select ')'
        if(num!=0){
            String tmp=s;
            tmp+=")";
            generate(result,tmp,num-1,n);
        }
        
        //select'('
        s+="(";
        generate(result,s,num+1,n-1);
        
    }
}