package week10;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListX {

	public static void append(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		list1.addAll(list2);
	}

	public static ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		ArrayList<Integer> res = new ArrayList<Integer>();

		int listSize = 0;
		ArrayList<Integer> tail = new ArrayList<Integer>();

		if(list1.size() < list2.size()){
			listSize = list1.size();
			tail = new ArrayList<Integer>(list2.subList(list1.size(), list2.size()));
			
		} else {
			listSize = list2.size();
			tail = new ArrayList<Integer>(list1.subList(list2.size(), list1.size()));
			
		}

		for(int i = 0; i < listSize; i++){
			res.add(list1.get(i));
			res.add(list2.get(i));
		}

		res.addAll(tail);

		return res;	
	}

	public static void printList(ArrayList<Integer> list, String name) {
		System.out.println("------------------------\n"+name+":\n");
		for (int i = 0; i <list.size(); i++) {
			System.out.println(list.get(i));
		}

	}	
}