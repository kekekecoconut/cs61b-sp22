public class Palindrome {

    public LinkedListDeque<Character> wordToDeque(String word){

        char[] chars = word.toCharArray();
        LinkedListDeque<Character> characterLinkedListDeque =  new LinkedListDeque<>();
        for (char c :
                chars) {
            characterLinkedListDeque.addLast(c);
        }
        return characterLinkedListDeque;
    }

    public String dequeToWord(LinkedListDeque linkedListDeque){
        return linkedListDeque.dequeToWord(linkedListDeque);
    }

    public boolean isPalindrome(String word){

        LinkedListDeque<Character> characterDeque = wordToDeque(word);
        characterDeque.reverse();
        String result = dequeToWord(characterDeque);
    //    System.out.println("result:"+result);
        if(result.equals(word)){
            return true;
        }
        return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        if (word ==  null)
            return false;

        if (cc == null)
            return isPalindrome(word);

        char[] words = word.toCharArray();

        int length = words.length;

        int sub = words[0] - words[length-1];

        for (int i = 0; i < (int) length / 2; i++) {
            int innerSub = words[i] - words[length-i-1];
            if(sub != innerSub){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome p =  new Palindrome();
        CharacterComparator cc = null;
        String str = "abadc";
        if(str.equals("")){
            System.out.println("yes");
        }else{
            if(p.isPalindrome(str, cc)){
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
        }

    }
}
