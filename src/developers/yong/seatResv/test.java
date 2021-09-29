package developers.yong.seatResv;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> arr2 = new ArrayList<String>();
		arr2.add("a1");arr2.add("a2");arr2.add("a3");arr2.add("a4");
		arr.add(arr2.toString());
		System.out.println(arr.get(0));
		
		/*String result1 = arr.get(0).substring(arr.get(0).lastIndexOf("[")+1);
		String result2 = arr.get(0).substring(arr.get(0).lastIndexOf(",")+1);
		String result3 = arr.get(0).substring(arr.get(0).lastIndexOf(",")+1);
		String result4 = arr.get(0).substring(arr.get(0).lastIndexOf(",")+1);
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);*/
		String target = "a1";
		String str = arr.get(0);
		String result = str.substring(1,3);
		System.out.println(result);
		String result2 = str.substring(5,7);
		System.out.println(result2);
		arr.get(0).substring(1,3);
		System.out.println(arr.get(0).substring(1,3));
		System.out.println(arr.get(0).substring(5,7));
		System.out.println(arr.get(0).substring(9,11));
		System.out.println(arr.get(0).substring(13,15));
		System.out.println(arr.get(0).indexOf("a1"));
		System.out.println(arr.get(0).indexOf("a2"));
		System.out.println(arr.get(0).indexOf("b"));
		
		Long datetime = System.currentTimeMillis();
		SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
		String time = date.format(datetime);
		System.out.println(time);
	}
}
