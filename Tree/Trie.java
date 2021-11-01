class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (!cur.next.containsKey(word.charAt(i))) {
                cur.next.put(word.charAt(i), new TrieNode(word.charAt(i)));
            }
            cur = cur.next.get(word.charAt(i));
        }
        cur.end = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (!cur.next.containsKey(word.charAt(i))) {
                return false;
            }
            cur = cur.next.get(word.charAt(i));
        }
        return cur.end;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!cur.next.containsKey(prefix.charAt(i))) {
                return false;
            }
            cur = cur.next.get(prefix.charAt(i));
        }
        return true;
    }
    
    private class TrieNode {
        char val;
        Map<Character, TrieNode> next;
        boolean end;
        
        public TrieNode() {
            this('\0');
        }
        
        public TrieNode(char val) {
            this.val = val;
            this.next = new HashMap<>();
            end = false;
        }
    }
}