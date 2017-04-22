import java.util.List;
import java.util.ArrayList;

public class FriendsCircle {

	public static void main(String[] args) {

		System.out.println(compute(new String[]{"YYNN", "YYYN", "NYYN", "NNNY"}));
	}
	

	public static int compute(String[] values) {
		int N = values.length;
		int friendCircles = 0;

		List<Integer> included = new ArrayList<Integer>();
		for (int i = 0; i < N ; i++ ) {
			if (included.contains(i)) {
				continue;
			}
			included.add(i);
			friendCircles++;
			List<Integer> friends = new ArrayList<Integer>();
			friends.add(i);
			while(!friends.isEmpty()) {
				int friend = friends.remove(0);
				for (int j = 0; j < N ; j++ ) {
					if (values[friend].charAt(j) == 'Y' && !included.contains(j)) {
						//System.out.println("Adding friend of: " + friend + ", " + j);
						friends.add(j);
						included.add(j);
					}
				}
			}
		}

		return friendCircles;
	}
}