package timingtest;
import edu.princeton.cs.algs4.Stopwatch;
import org.checkerframework.checker.units.qual.A;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> addList = new AList<>();
        AList<Integer> N = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> ops = new AList<>();
        int count = 0;
        Stopwatch sw = new Stopwatch();
        for (int i = 0; i <= 128000; i++) {
            int op_count = (int)Math.pow(2,count)*1000;
            if (i == op_count) {
                count++;
                times.addLast(sw.elapsedTime());
                N.addLast(op_count);
                ops.addLast(op_count);
            }
            addList.addLast(i);
        }
        printTimingTable(N, times, ops);
    }
}
