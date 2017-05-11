import java.util.List;
import java.util.ArrayList;

public class WeaveTwoLists {

	public static void main(String[] args) {
		List<Integer> first = new ArrayList<Integer>();
		List<Integer> second = new ArrayList<Integer>();

		first.add(1);
		//first.add(2);
		//first.add(3);

		second.add(4);
		//second.add(5);
		//second.add(6);

		List<List<Integer>> results = new ArrayList<List<Integer>>();
		List<Integer> prefix = new ArrayList<Integer>();

		weave(first, second, results, prefix);

		for (List<Integer> list : results) {
			for (Integer num : list) {
				System.out.print(num + " ");
			}
			System.out.println();
		}

		/**Comparator<Map<String, Object>> comparator = new Comparator<Map<String, Map>>() {
			public int compare(Map<String, Map> o1, Map<String, Map> o2) {
				Float price2 = o2.get("itemPrice");
				Float price1 = o1.get("itemPrice");
				return price2.compare(price1);
			}
		};**/
	}
	
	public static void weave(List<Integer> first, List<Integer> second, List<List<Integer>> results, List<Integer> prefix) {

		if (first.size() == 0 || second.size() == 0) {
			List<Integer> result = new ArrayList<Integer>();
			result.addAll(prefix);
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;	
		}

		int item = first.remove(0);
		prefix.add(item);
		weave(first, second, results, prefix);
		prefix.remove(prefix.size()-1);
		first.add(0, item);

		item = second.remove(0);
		prefix.add(item);
		weave(first, second, results, prefix);
		prefix.remove(prefix.size()-1);
		second.add(0, item);
	}
}