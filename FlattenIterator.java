/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
/*
Pay attention to initilization.
*/
import java.util.Iterator;

public class NestedIterator implements Iterator<Integer> {

   ArrayList<Integer> flattenList=new ArrayList<Integer>();
    int cursor=0;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        flatten(nestedList,flattenList);
    }
    
    private void flatten(List<NestedInteger> nestedList, ArrayList<Integer> result){
        
        for(NestedInteger ni:nestedList){
            if(ni.isInteger()){
                result.add(ni.getInteger());
            }else{
                flatten(ni.getList(),result);
            }    
        }
    }

    @Override
    public Integer next() {
        cursor++;
        return flattenList.get(cursor-1);
    }

    @Override
    public boolean hasNext() {
        return cursor < flattenList.size();
    }
    
    public void remove(){
        
    }
}

/*
Non-Recursive version, whenever into anther level, keep this level's info in stack, use loop
*/
public class NestedIterator implements Iterator<Integer> {
    Stack<Iterator<NestedInteger>> stack;
    Iterator<NestedInteger> itr;
    NestedInteger cur;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack();
        itr = nestedList.iterator();
        cur = null;
    }

    @Override
    public Integer next() {
        Integer x = cur.getInteger();
        cur = null;
        return x;
    }

    @Override
    public boolean hasNext() {
        if (cur != null) return true;
        while (!stack.isEmpty() || itr.hasNext()) {
            while (itr.hasNext()) {
                cur = itr.next();
                if (cur.isInteger()) return true;
                else {
                    stack.push(itr);
                    itr = cur.getList().iterator();
                }
            }
            itr = stack.pop();
        }
        return false;
    }
}  

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v.add(i.next());
 */