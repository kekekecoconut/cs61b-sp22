public class OffByN implements CharacterComparator{

    private int n;

    public OffByN(int n) {
        this.n = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int abs = Math.abs(x - y);
        if (abs == n)
            return true;
        return false;
    }


}
