package Trie;
public class Trie {
    private TrieNode root;

    public Trie(){
        root=new TrieNode();
        System.out.println("Created");
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i=0; i<word.length(); i++) {
          char ch = word.charAt(i);
          TrieNode node = current.child.get(ch);
          if (node == null) {
            node = new TrieNode();
            current.child.put(ch, node);
          }
          current = node;
        }
        current.endOfString = true;
        System.out.println("Successfully inserted " + word+ " in Trie");
      }

      public boolean search(String word) {
        TrieNode currentNode = root;
        for (int i =0; i<word.length(); i++) {
          char ch = word.charAt(i);
          TrieNode node = currentNode.child.get(ch);
          if (node == null) {
            System.out.println("Word: "+word+ " does not exist in Trie");
            return false;
          }
          currentNode = node;
        }
        if (currentNode.endOfString == true) {
          System.out.println("Word: "+word+ " exists in Trie");
            return true;
        } else {
          System.out.println("Word: "+word+ " does not exist in Trie. But it is a prefix of another string");
        }
        return currentNode.endOfString;
      }
}
