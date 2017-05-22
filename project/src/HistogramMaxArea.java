

public class HistogramMaxArea {
    int stackCursor = 0;
    int[] sizeStack;
    int[] posStack;

    int maxSize = 0;
    int currentPosition = 0;

    private void init(int[] hist) {
        int size = hist.length;

        sizeStack = new int[size];
        posStack = new int[size];
    }

    public int compute(int[] hist) {
        init(hist);

        for(; currentPosition < hist.length; currentPosition++) {
            if (stackCursor == 0 || hist[currentPosition] > sizeStack[stackCursor-1] ) {
                sizeStack[stackCursor] = hist[currentPosition];
                posStack[stackCursor++] = currentPosition;
            } else if (hist[currentPosition] < sizeStack[stackCursor-1]) {
                int pos = 0;
                while(stackCursor > 0 && sizeStack[stackCursor-1] > hist[currentPosition]) {
                    pos = popLarger();
                }
                if (stackCursor == 0 || sizeStack[stackCursor-1] < hist[currentPosition]) {
                    sizeStack[stackCursor] = hist[currentPosition];
                    posStack[stackCursor++] = pos;
                }
            }
        }

        while(stackCursor > 0) {
            popLarger();
        }

        return maxSize;
    }

    private int popLarger() {
        int size = sizeStack[--stackCursor];
        int pos = posStack[stackCursor];
        //System.out.println(size + "*(" + currentPosition + "-" + pos + ")");
        int area = size * (currentPosition - pos);
        maxSize = Math.max(area, maxSize);
        return pos;
    }

    public static void main(String[] args) {
        //int[] input = {2, 1, 2, 3, 2, 1, 1, 3};
        int[] input = {9, 7, 7, 9};
        HistogramMaxArea computer = new HistogramMaxArea();
        
        System.out.println(computer.compute(input));

    }


}