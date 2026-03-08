package kdt.kdt4.parallel;

import java.math.BigInteger;

public class Result {

    private final String fname;
    private final BigInteger biggest;
    private final BigInteger sum;

    public Result(String fname, BigInteger biggest, BigInteger sum) {
        this.fname = fname;
        this.biggest = biggest;
        this.sum = sum;
    }

    public String getFname() {return fname;}

    public BigInteger getBiggest() {return biggest;}

    public BigInteger getSum() {return sum;}
}
