package medium.my_calendar_i_729;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MyCalendar {

	/*
	 * TreeMap<Integer, Integer> events;
	 * 
	 * public MyCalendar() { events = new TreeMap(); }
	 * 
	 * public boolean book(int start, int end) { Integer prev =
	 * events.floorKey(start), next = events. ceilingKey(start);
	 * 
	 * return false;
	 * 
	 * }
	 */
	public static void main(String[] args) {
		/*
		 * MyCalendar myCalendar = new MyCalendar(); myCalendar.book(10, 20); // return
		 * True myCalendar.book(15, 25); // return False, It can not be booked because
		 * time 15 is already booked by // another event. myCalendar.book(20, 30);
		 * 
		 * 
		 */
		
		LinkedHashMap<Integer,Integer> map  = new LinkedHashMap<>();
		map.put(1,1);
		map.put(2,1);
		for (java.util.Map.Entry<Integer, Integer> e : map.entrySet()) {
			System.out.println(e.getKey()+","+e.getValue());
		}
		
		map.remove(1);
		for (Entry<Integer, Integer> e : map.entrySet()) {
			System.out.println(e.getKey()+","+e.getValue());
		}
	}
}

