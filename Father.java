public class Father{
      public static int a=0;

     public static void main(String args[]){
             Son.a=10;
             System.out.println(Father.a);	
     }	
}

class Son extends Father{
	
}

class Son2 extends Father{}
