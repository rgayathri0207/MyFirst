package JavaPractise;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Challenge08 {

	public static void main(String[] args) {
		List<Integer> larray=new ArrayList<>();
		larray.add(123);
		larray.add(2345);
		larray.add(-987);
		larray.add(0);
		larray.add(876);
		larray.add(-87);
		larray.add(4567);
		System.out.println("Given array: "+larray);
		Collections.sort(larray);
		System.out.println("after sorting "+larray);
		int seconndLargestNumber= larray.get(larray.size()-2);
		System.out.println("second largest number is "+ seconndLargestNumber);
	}

}
