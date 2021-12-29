import java.util.ArrayList;
import java.util.List;

/**
 * Class that collects timing information about AList construction.
 */
public class TimeAList {
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

    public static Double timesAddAList(int n){
        Stopwatch sw = new Stopwatch();
        AList<Integer> aList1 = new AList<>();
        for (int i = 0; i < n; i++) {
            aList1.addLast(i);
        }
        double timeInSeconds = sw.elapsedTime();
        return timeInSeconds;
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
     //   printTimingTable();
        List<Double> times = new ArrayList<>();

        times.add(timesAddAList(1000));
        times.add(timesAddAList(2000));
        times.add(timesAddAList(4000));
        times.add(timesAddAList(8000));
        times.add(timesAddAList(16000));
        times.add(timesAddAList(32000));
        times.add(timesAddAList(64000));
        times.add(timesAddAList(128000));

        List<Integer> Ns = new ArrayList<>();
        Ns.add(1000);
        Ns.add(2000);
        Ns.add(4000);
        Ns.add(8000);
        Ns.add(16000);
        Ns.add(32000);
        Ns.add(64000);
        Ns.add(128000);

        printTimingTable(Ns, times, Ns);



    }


}
