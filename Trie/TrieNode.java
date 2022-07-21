package Trie;
import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character,TrieNode> child;
    boolean endOfString;

    public TrieNode(){
        child=new HashMap<>();
        endOfString=false;
    }
}
