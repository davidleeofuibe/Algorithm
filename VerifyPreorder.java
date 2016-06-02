/*
*
*There are several corner cases in this, first if string is "#", return true
*if the string starts with "#" return false
*pay attention that while loop may cause the stack empty, need an if judgement.
*/

public class Solution {
     public boolean isValidSerialization(String preorder) {
        if(preorder==null || preorder=="") return true;
        if(preorder.length()==1 && preorder.equals("#")) return true;
        if(preorder.startsWith("#")) return false;
        
        String[] preArray=preorder.split(",");
        Stack<Node> stack=new Stack<Node>();
        
        for(int i=0;i<preArray.length;i++){
            if(i!=0 && stack.empty()){
                return false;
            }
            if(preArray[i].equals("#")){
                stack.peek().count=stack.peek().count-1;
                while((!stack.empty()) && stack.peek().count==0){
                    stack.pop();
                    if(!stack.empty()){
                        stack.peek().count=stack.peek().count-1;
                    }
                }
            }else{
                stack.push(new Node(preArray[i]));
            }
        }
        return stack.empty();        
        
    }
    class Node{
        String val;
        int count;
        public Node(String val){
            this.val=val;
            this.count=2;
        }
    }
}