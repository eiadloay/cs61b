public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        if (word == null) {
            return null;
        }

        Deque<Character> d = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;

    }

    public boolean isPalindrome(String word) {
        Deque<Character> d = wordToDeque(word);
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != d.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> d = wordToDeque(word);
        for (int i = 0; i < word.length(); i++) {
            if (word.length() % 2 != 0 && i == word.length() / 2) {
                d.removeLast();
                continue;
            }
            if (!cc.equalChars(word.charAt(i), d.removeLast())) {
                return false;
            }
        }
        return true;
    }
}
