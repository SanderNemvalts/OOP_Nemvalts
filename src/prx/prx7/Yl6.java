package prx.prx7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Yl6 {

    static void main() throws InterruptedException{

        List<String> fnamesArray = List.of(new File("data", "prx7").list());

        BlockingQueue<String> fnames = new ArrayBlockingQueue<>(fnamesArray.size());
        BlockingQueue<Integer> sums = new ArrayBlockingQueue<>(fnamesArray.size());

        fnames.addAll(fnamesArray);

        Thread t1 = new Thread(new Summeerija(fnames, sums));
        Thread t2 = new Thread(new Summeerija(fnames, sums));
        Thread t3 = new Thread(new Summeerija(fnames, sums));
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

        for (int i = 0; i < fnamesArray.size(); i++) {
            System.out.println(sums.take());
        }
    }

}

class Summeerija implements Runnable {

    private BlockingQueue<String> fnames;
    private BlockingQueue<Integer> sums;

    public Summeerija(
            BlockingQueue<String> fnames,
            BlockingQueue<Integer> sums) {
        this.fnames = fnames;
        this.sums = sums;
    }

    @Override
    public void run() {
        try {
            while(true) {
                String fname = fnames.poll();
                if (fname == null) break;

                int sum = 0;
                Scanner scanner = new Scanner(new File("data"+ File.separatorChar+"prx7"+File.separatorChar+fname));
                String[] numbers = scanner.nextLine().split(" ");
                for (String num : numbers) sum += Integer.parseInt(num);

                sums.put(sum);
            }
        }catch (FileNotFoundException | InterruptedException e) {throw new RuntimeException(e);}
    }

}
