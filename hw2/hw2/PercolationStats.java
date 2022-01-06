package hw2;

import edu.princeton.cs.introcs.StdStats;
import edu.princeton.cs.introcs.StdRandom;

public class PercolationStats {

    private double[] rate;

    private int T;
    public PercolationStats(int N, int T, PercolationFactory pf) {

        if (N<=0 || T<=0){
            throw new IllegalArgumentException();
        }

        this.T =  T;
        rate = new double[T];
        for (int i = 0; i < T; i++) {

            Percolation percolation = pf.make(N);
            while (!percolation.percolates()) {
                int row,col;
                do {
                    row = StdRandom.uniform(0,N);
                    col = StdRandom.uniform(0,N);
                } while (percolation.isOpen(row,col));

                percolation.open(row, col);

            }

            rate[i] = (double) percolation.numberOfOpenSites()/(N*N);
        }
    }
    // perform T independent experiments on an N-by-N grid

    public double mean() {

        return StdStats.mean(rate);
    }
    // sample mean of percolation threshold

    public double stddev() {
        return StdStats.stddev(rate);
    }
    // sample standard deviation of percolation threshold

    public double confidenceLow() {
        return mean()-1.96*stddev()/Math.sqrt(T);
    }
    // low endpoint of 95% confidence interval

    public double confidenceHigh() {
        return mean()+1.96*stddev()/Math.sqrt(T);
    }                                // high endpoint of 95% confidence interval

    public static void main(String[] args) {
        PercolationStats ps = new PercolationStats(20, 5, new PercolationFactory());
        System.out.println(ps.mean());
        System.out.println(ps.stddev());
    }
}
