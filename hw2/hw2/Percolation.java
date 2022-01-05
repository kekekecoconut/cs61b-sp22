package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int[][] grid;

    private int topSite;

    private int bottomSite;

    private int size;

    private int openNum;

    private WeightedQuickUnionUF weightedQuickUnionUF1;

    public Percolation(int N) {
        if (N < 0 || N == 0){
            throw new IllegalArgumentException();
        }
        grid = new int[N][N];
        size = N;
        openNum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = 0;
            }
        }

        weightedQuickUnionUF1 = new WeightedQuickUnionUF(N*N+2);
        topSite = N*N;
        bottomSite = N*N+1;

        for (int i = 0; i < size; i++) {
            weightedQuickUnionUF1.union(topSite, xyTo1D(0,i));
        }

        for (int i = 0; i < size; i++) {
            weightedQuickUnionUF1.union(bottomSite, xyTo1D(size-1, i));
        }

    }               // create N-by-N grid, with all sites initially blocked

    public void open(int row, int col) {
        if (row > size-1 || col > size-1) {
            throw new IndexOutOfBoundsException();
        }

        if (grid[row][col] == 1 || grid[row][col] == 2) {
            return;
        }

        if(row == 0){
            grid[row][col] = 2;
            openNum++;
            return;
        }

        if (row - 1>=0){
            if (grid[row-1][col] == 1 || grid[row-1][col] == 2) {
                weightedQuickUnionUF1.union(xyTo1D(row, col), xyTo1D(row-1, col));
                grid[row][col] = 2;
                grid[row-1][col] = 2;
            }
        }

        if (row+1<size){
            if (grid[row+1][col] == 1 || grid[row+1][col] == 2) {
                weightedQuickUnionUF1.union(xyTo1D(row, col), xyTo1D(row+1, col));
                grid[row][col] = 2;
                grid[row+1][col] = 2;
            }
        }

        if (col+1<size){
            if (grid[row][col+1] == 1 || grid[row][col+1] == 2) {
                weightedQuickUnionUF1.union(xyTo1D(row, col), xyTo1D(row, col+1));
                grid[row][col] = 2;
                grid[row][col+1] = 2;
            }
        }

        if (col-1>=0){
            if (grid[row][col-1] == 1 || grid[row][col-1] == 2) {
                weightedQuickUnionUF1.union(xyTo1D(row, col), xyTo1D(row, col-1));
                grid[row][col] = 2;
                grid[row][col-1] = 2;
            }
        }

        if (grid[row][col] == 0){
            grid[row][col] = 1;
        }

        openNum++;
    }       // open the site (row, col) if it is not open already


    public boolean isOpen(int row, int col) {
        if (row > size-1 || col > size-1) {
            throw new IndexOutOfBoundsException();
        }

        if (grid[row][col] == 1  || grid[row][col] == 2)
            return true;

        return false;
    }  // is the site (row, col) open?

    public boolean isFull(int row, int col) {
        if (row > size-1 || col > size-1) {
            throw new IndexOutOfBoundsException();
        }

        if (grid[row][col] == 2)
            return true;

        return false;

    }  // is the site (row, col) full?

    public int numberOfOpenSites() {
        return openNum;
    }          // number of open sites

    public boolean percolates() {
        if (weightedQuickUnionUF1.connected(topSite,  bottomSite))
            return true;
        return false;
    }              // does the system percolate?

    public int xyTo1D(int r, int c){
        return size * r + c;
    }

    public void print(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.println(grid[i][j]);
            }
        }
    }
    public static void main(String[] args) {

        Percolation percolation =  new Percolation(3);

        percolation.open(0,2);

        percolation.open(1,2);

        percolation.open(1,0);
        percolation.open(2,0);
        percolation.open(1,1);

        percolation.print();
        if (percolation.isFull(1,2)){
            System.out.println("1,2 is Full!");
        }

        if (percolation.percolates()){
            System.out.println("percolates!");
        }


    }  // use for unit testing (not required, but keep this here for the autograder)
}
