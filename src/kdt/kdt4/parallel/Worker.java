package kdt.kdt4.parallel;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class Worker implements Runnable{

    private final BlockingQueue<String> fnames;
    private final BlockingQueue<Result> results;

    public Worker(BlockingQueue<String> fnames, BlockingQueue<Result> results) {
        this.fnames = fnames;
        this.results = results;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String fname = fnames.poll();
                if (fname == null) break;

                BigInteger biggest = new BigInteger("0");
                BigInteger sum = new BigInteger("0");
                Scanner scn = new Scanner(new File(fname));

                while (scn.hasNext()) {
                    BigInteger current = new BigInteger(scn.next());
                    sum = sum.add(current);
                    if (current.compareTo(biggest) > 0) biggest = current;
                }

                results.put(new Result(fname, biggest, sum));
            }
        } catch (FileNotFoundException | InterruptedException e) {throw new RuntimeException(e);}
    }
}
