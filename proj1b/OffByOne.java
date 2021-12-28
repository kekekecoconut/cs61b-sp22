public class OffByOne implements CharacterComparator{

    @Override
    public boolean equalChars(char x, char y) {
        if (Math.abs(x-y)==1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println("r:"+new OffByOne().equalChars('a','c'));
    }
}
