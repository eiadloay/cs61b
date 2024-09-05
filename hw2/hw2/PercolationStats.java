package hw2;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private final int N;
    private final int T;
    private Percolation P;
    private final double[] stats;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }
        this.N = N;
        this.T = T;
        this.stats = new double[T];

        for (int i = 0; i < T; i++) {
            this.P = pf.make(N);
            stats[i] = doStats();
        }
    }

    private double doStats() {
        while (!P.percolates()) {
            int a = StdRandom.uniform(N);
            int b = StdRandom.uniform(N);
            P.open(a, b);
        }
        return (double) P.numberOfOpenSites() / (N * N);
    }

    public double mean() {
        return StdStats.mean(stats);
    }

    public double stddev() {
        return StdStats.stddev(stats);
    }

    public double confidenceLow() {
        return mean() - 1.96 * stddev() / Math.sqrt(T);
    }

    public double confidenceHigh() {
        return mean() + 1.96 * stddev() / Math.sqrt(T);
    }
}
