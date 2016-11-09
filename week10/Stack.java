package week10;

import java.util.*;

public class Stack<E> {

	private ArrayList<E> stack = new ArrayList<>();
	private int top = 0;


	public void push(E e){
		stack.add(e);
		top++;
	}

	public E pop(){
		
		if(top != -1){
			return stack.remove(--top);
		} else {
			return null;
		}
		
	}

	public boolean empty(){
		if(top == 0){
			return true;
		} else {
			return false;
		}
	}

}
