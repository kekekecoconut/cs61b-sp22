public class LinkedListDequeTest {

    public static void main(String[] args) {
        String word = "apple";
        char[] chars = word.toCharArray();
        System.out.println(chars);
        LinkedListDeque<Character> characterLinkedListDeque =  new LinkedListDeque<>();
        for (char c :
                chars) {
            characterLinkedListDeque.addLast(c);
        }
        characterLinkedListDeque.printDeque();
        System.out.println("size:"+characterLinkedListDeque.size());
        characterLinkedListDeque.reverse();
        characterLinkedListDeque.printDeque();
    }
}
