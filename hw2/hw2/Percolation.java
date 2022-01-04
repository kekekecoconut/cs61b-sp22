package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int[][] grid;

    private int size;

    public Percolation(int N) {

        if (N < 0 || N == 0){
            throw new IllegalArgumentException();
        }
        grid = new int[N][N];
        size = N;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = 0;
            }
        }

    }               // create N-by-N grid, with all sites initially blocked

    public void open(int row, int col) {

        if (row > size-1 || col > size-1) {
            throw new IndexOutOfBoundsException();
        }
    }       // open the site (row, col) if it is not open already

    public boolean isOpen(int row, int col) {
        if (row > size-1 || col > size-1) {
            throw new IndexOutOfBoundsException();
        }

        return false;
    }  // is the site (row, col) open?

    public boolean isFull(int row, int col) {
        if (row > size-1 || col > size-1) {
            throw new IndexOutOfBoundsException();
        }

        return false;

    }  // is the site (row, col) full?

    public int numberOfOpenSites() {

        return 0;
    }          // number of open sites

    public boolean percolates() {

        return false;
    }              // does the system percolate?
    public static void main(String[] args) {

    }  // use for unit testing (not required, but keep this here for the autograder)
}
