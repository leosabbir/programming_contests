/* File:    USCensus.java
 * Created: 2017-06-01
 * Author:  Sabbir Manandhar
 *
 * Copyright (c) 2017 WorldLingo Inc.
 */

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * TODO Insert Description of the Class
 *
 * @author Sabbir Manandhar
 * @version 1.0
 */
public class USCensus {
  static Object[][] population = {
          {"Alabama", 4779736},
          {"Alaska", 710231},
          {"Arizona", 6392017},
          {"Arkansas", 2915918},
          {"California", 37253956},
          {"Colorado", 5029196},
          {"Connecticut", 3574097},
          {"Delaware", 897934},
          {"Florida", 18801310},
          {"Georgia", 9687653},
          {"Hawaii", 1360301},
          {"Idaho", 1567582},
          {"Illinois", 12830632},
          {"Indiana", 6483802},
          {"Iowa", 3046355},
          {"Kansas", 2853118},
          {"Kentucky", 4339367},
          {"Louisiana", 4533372},
          {"Maine", 1328361},
          {"Maryland", 5773552},
          {"Massachusetts", 6547629},
          {"Michigan", 9883640},
          {"Minnesota", 5303925},
          {"Mississippi", 2967297},
          {"Missouri", 5988927},
          {"Montana", 989415},
          {"Nebraska", 1826341},
          {"Nevada", 2700551},
          {"New Hampshire", 1316470},
          {"New Jersey", 8791894},
          {"New Mexico", 2059179},
          {"New York", 19378102},
          {"North Carolina", 9535483},
          {"North Dakota", 672591},
          {"Ohio", 11536504},
          {"Oklahoma", 3751351},
          {"Oregon", 3831074},
          {"Pennsylvania", 12702379},
          {"Rhode Island", 1052567},
          {"South Carolina", 4625364},
          {"South Dakota", 814180},
          {"Tennessee", 6346105},
          {"Texas", 25145561},
          {"Utah", 2763885},
          {"Vermont", 625741},
          {"Virginia", 8001024},
          {"Washington", 6724540},
          {"West Virginia", 1852994},
          {"Wisconsin", 5686986},
          {"Wyoming", 563626 }
  };

  public static void main(String[] args) {
    PriorityQueue<State> states = new PriorityQueue<>();
    int statesWithMinRepCount = 0;
    for (Object obj : population) {
      Object[] statePop = (Object[]) obj;
      states.add(new State((String) statePop[0], (Integer) statePop[1]));
    }

    int rounds = 0;
    while (statesWithMinRepCount < 50) {
      rounds++;
      State state = states.poll();
      state.representative++;
      if (state.representative == 2) statesWithMinRepCount++;
      state.computeGDP();
      states.add(state);
    }

    System.out.println(rounds);
  }

} // USCensus

class State implements Comparable<State> {
  String name;
  int pop;
  Double gdp;
  int representative = 1;

  public State(String name, int pop) {
    this.name = name;
    this.pop = pop;
    computeGDP();
  }

  public void computeGDP() {
    gdp = pop / Math.sqrt(representative * (representative+1));
  }

  @Override
  public int compareTo(State o) {
    return o.gdp.compareTo(this.gdp);
  }
}
