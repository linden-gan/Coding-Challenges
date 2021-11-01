class NoPrefix {

    /*
     * Complete the 'noPrefix' function below.
     *
     * The function accepts STRING_ARRAY words as parameter.
     */

    public void noPrefix(List<String> words) {
    // Write your code here
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            boolean diff = false;
            for (int i = 0; i < word.length(); i++) {
                if (cur.next.isEmpty() && !diff) {
                   return;
                }
                if (!cur.next.containsKey(word.charAt(i))) {
                    cur.next.put(word.charAt(i), new TrieNode(word.charAt(i)));
                    diff = true;
                }
                cur = cur.next.get(word.charAt(i));
            }
            if (!diff) {
                System.out.println("BAD SET");
                System.out.println(word);
                return;
            }
        }
        System.out.println("GOOD SET");
        return;
    }

    private class TrieNode {
        char val;
        Map<Character, TrieNode> next;
        
        public TrieNode() {
            TrieNode('\0');
        }
        
        public TrieNode(char val) {
            this.val = val;
            this.next = new HashMap<>();
        }
    }
}