import java.util.ArrayList;
import java.util.List;

/**
 * Class that collects timing information about SLList getLast method.
 */
public class TimeSLList {
    private static void printTimingTable(List<Integer> Ns, List<Double> times, List<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static SLList<Integer> addLast(int n){
        SLList<Integer> slList = new SLList<>();
        for (int i = 0; i < n; i++) {
            slList.addLast(i);
        }
        return slList;
    }

    public static Double timesGetLast(SLList<Integer> slList){
        Stopwatch sw = new Stopwatch();
        for (int i = 0; i < 10000; i++) {
            slList.getLast();
        }
        double timeInSeconds = sw.elapsedTime();
        return timeInSeconds;
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        List<Double> times = new ArrayList<>();

        times.add(timesGetLast(addLast(1000)));
        times.add(timesGetLast(addLast(2000)));
        times.add(timesGetLast(addLast(4000)));
        times.add(timesGetLast(addLast(8000)));
        times.add(timesGetLast(addLast(16000)));
        times.add(timesGetLast(addLast(32000)));
        times.add(timesGetLast(addLast(64000)));
        times.add(timesGetLast(addLast(128000)));


        List<Integer> Ns = new ArrayList<>();
        Ns.add(1000);
        Ns.add(2000);
        Ns.add(4000);
        Ns.add(8000);
        Ns.add(16000);
        Ns.add(32000);
        Ns.add(64000);
        Ns.add(128000);

        List<Integer> opCounts = new ArrayList<>();
        opCounts.add(10000);
        opCounts.add(10000);
        opCounts.add(10000);
        opCounts.add(10000);
        opCounts.add(10000);
        opCounts.add(10000);
        opCounts.add(10000);
        opCounts.add(10000);

        printTimingTable(Ns, times, opCounts);
    }

}
