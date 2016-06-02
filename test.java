import java.util.Stack;
public class Test {
    public boolean isValidSerialization(String preorder) {
        if(preorder==null || preorder=="") return true;
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
                    System.out.println(stack.pop().val);
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
    public static void main(String args[]){
        Test test=new Test();
        test.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
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
