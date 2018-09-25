package amazon;
import java.util.*;

public class DeviceOptimumUtilization {

  public static void main(String[] args) {
    List<List<Integer>> foregroundAppList = new ArrayList<>();
    List<List<Integer>> backgroundAppList = new ArrayList<>();
    
    insert(foregroundAppList, 1, 2);
    insert(foregroundAppList, 2, 2);
    insert(foregroundAppList, 3, 3);
    insert(foregroundAppList, 4, 3);
    insert(foregroundAppList, 5, 3);



    insert(backgroundAppList, 2, 3);
    insert(backgroundAppList, 1, 3);
    insert(backgroundAppList, 5, 3);


    List<List<Integer>> result = optimalUtilization(20, foregroundAppList, backgroundAppList);
    for(List<Integer> item : result) {
      System.out.println(item.get(0) + " : " + item.get(1));
    }
  }

  public static void insert(List<List<Integer>> list, int id, int amount) {
    List<Integer> item = new ArrayList<>();
    item.add(id);
    item.add(amount);
    list.add(item);
  }

  public static List<List<Integer>> optimalUtilization(int deviceCapacity, List<List<Integer>> foregroundAppList, List<List<Integer>> backgroundAppList) {
    List<List<Integer>> result = new ArrayList<>();
    
    Comparator<List<Integer>> appComparator = new Comparator<List<Integer>>() {
      @Override
      public int compare(List<Integer> o1, List<Integer> o2) {
        return o2.get(1) - o1.get(1);
      }
    };

    Collections.sort(foregroundAppList, appComparator);
    Collections.sort(backgroundAppList, appComparator);

    PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
    
      @Override
      public int compare(int[] o1, int[] o2) {
        return foregroundAppList.get(o2[0]).get(1) + backgroundAppList.get(o2[1]).get(1) - foregroundAppList.get(o1[0]).get(1) - backgroundAppList.get(o1[1]).get(1);
      }
    });

    for (int i = 0; i < backgroundAppList.size(); i++) {
      queue.offer(new int[]{0, i});
    }

    int max = -1;
    while(!queue.isEmpty()) {
      int[] item = queue.poll();
      int currentSum = foregroundAppList.get(item[0]).get(1) + backgroundAppList.get(item[1]).get(1);  
      if (currentSum > deviceCapacity) continue;
      else if (currentSum < max) break;
      else {
        max = currentSum;
        List<Integer> resultItem = new ArrayList<>();
        resultItem.add(foregroundAppList.get(item[0]).get(0));
        resultItem.add(backgroundAppList.get(item[1]).get(0));
        result.add(resultItem);
        if (item[0] < foregroundAppList.size() - 1) {
          queue.add(new int[]{item[0] + 1, item[1]});
        }
      }
    }

    return result;
  }
}
