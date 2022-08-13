
import java.util.Stack;
class myQueue{
    //declare data structuresS- 2 stacks
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    //Initialize the 2 stacks
    public myQueue(){
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    //push numbers onto the first stack
    public void push(int x){
        stack1.push(x);
    }

    public int pop(){
        //This will push the elements of stack1 into stack 2 except for the first element in the "queue"
        while (stack1.size() > 1)
            stack2.push(stack1.pop());

        //fetch the top element in the queue
        int top = stack1.pop();

        //push back all of the contents of stack2 into stack1
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return top;
    }

    public int peek(){
        //This will push the elements of stack1 into stack 2 except for the first element in the "queue"
        while (stack1.size() > 1)
            stack2.push(stack1.pop());

        //fetch the top element in the queue
        int top = stack1.peek();

        //push back all of the contents of stack2 into stack1
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return top;
    }

    public boolean isEmpty(){
        if (stack1.size() == 0 && stack2.size() == 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args){
    myQueue newQ = new myQueue();
    newQ.push(3);
    newQ.push(8);
    newQ.push(4);
    newQ.push(4);
    newQ.push(4);
    System.out.println(newQ.pop());
    System.out.println(newQ.peek());

    //emptying out the queue/stack to test isEmpty() function

    newQ.pop();
    newQ.pop();
    newQ.pop();
    newQ.pop();

    if (newQ.isEmpty())
    System.out.println("Queue is empty");
    else 
    System.out.println("Queue is not empty");
}
}

