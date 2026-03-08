package kdt.kdt4.parallel;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    static void main(String[] args){

        BlockingQueue<String> fnames = new ArrayBlockingQueue<>(args.length);
        BlockingQueue<Result> results = new ArrayBlockingQueue<>(args.length);

        List<String> fnamesList = Arrays.asList(args);
        fnames.addAll(fnamesList);

        List<Thread> threads = new ArrayList<>();
        int cores = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < cores; i++) {
            threads.add(new Thread(new Worker(fnames, results)));
        }
        threads.forEach(Thread::start);


        BigInteger global_sum = new BigInteger("0");
        Result global_biggest = null;
        Result global_smallest = null;
        for (int i = 0; i < args.length;) {
            Result result = results.poll();
            if (result != null) {
                global_sum = global_sum.add(result.getSum());
                if (global_biggest == null || result.getBiggest().compareTo(global_biggest.getBiggest()) > 0) {
                    global_biggest = result;
                }
                if (global_smallest == null || result.getSum().compareTo(global_smallest.getSum()) < 0) {
                    global_smallest = result;
                }
                i++;
            }
        }

        System.out.println("kogusumma\t| " + global_sum);
        System.out.println("suurim arv failist" + global_biggest.getFname() + " | " + global_biggest.getBiggest());
        System.out.println("Vähim summa failist" + global_smallest.getFname());



    }
}
