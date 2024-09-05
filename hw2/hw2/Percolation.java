package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final WeightedQuickUnionUF wquf;
    private final int[][] sites;
    private final int N;
    private int numberOfOpenSites;

    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("Size of gird must be bigger than 0");
        }

        wquf = new WeightedQuickUnionUF(N * N + 1);
        sites = new int[N][N];

        for (int i = 1; i <= N; i++) {
            wquf.union(0, i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sites[i][j] = 0;
            }
        }
        this.N = N;
        numberOfOpenSites = 0;
    }

    public void open(int row, int col) {
        validateIndexBounds(row, col);
        int up = (row > 0) ? (row - 1) * N + col + 1 : -1;
        int down = (row < N - 1) ? (row + 1) * N + col + 1 : -1;
        int left = (col > 0) ? row * N + (col - 1) + 1 : -1;
        int right = (col < N - 1) ? row * N + (col + 1) + 1 : -1;

        if (up != -1 && isOpen(row - 1, col)) {
            wquf.union(row * N + col + 1, up);
        }
        if (down != -1 && isOpen(row + 1, col)) {
            wquf.union(row * N + col + 1, down);
        }
        if (left != -1 && isOpen(row, col - 1)) {
            wquf.union(row * N + col + 1, left);
        }
        if (right != -1 && isOpen(row, col + 1)) {
            wquf.union(row * N + col + 1, right);
        }
        sites[row][col] = 1;
        numberOfOpenSites++;
    }

    public boolean isOpen(int row, int col) {
        validateIndexBounds(row, col);
        return sites[row][col] == 1;
    }

    public boolean isFull(int row, int col) {
        validateIndexBounds(row, col);
        return isOpen(row, col) && wquf.connected(0, row * N + col + 1);
    }

    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    public boolean percolates() {
        for (int i = N * N; i > i - N; i--) {
            if (wquf.connected(0, i)) {
                return true;
            }
        }
        return false;
    }

    private void validateIndexBounds(int row, int col) {
        if ((row < 0 || row >= N) || (col < 0 || col >= N)) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

}
