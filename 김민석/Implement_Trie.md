## Implement Trie (Prefix Tree)

https://leetcode.com/problems/implement-trie-prefix-tree/description/

```java
class Node {
    boolean isWord;
    Map<Character, Node> children = new HashMap<>();
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;

        for(int i = 0; i < word.length(); i++){
            Character c = word.charAt(i);
            if(!node.children.containsKey(c)){
                node.children.put(c, new Node());
            } 

            node = node.children.get(c);
            if(i == word.length() - 1){
                node.isWord = true;
            }
        }
    }
    
    public boolean search(String word) {
        Node node = root;

        for(int i = 0; i < word.length(); i++){
            Character c = word.charAt(i);
            if(node.children.containsKey(c)) node = node.children.get(c);
            else return false;
        }
        return node.isWord? true : false;
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;

        for(int i = 0; i < prefix.length(); i++){
            Character c = prefix.charAt(i);
            if(node.children.containsKey(c)) node = node.children.get(c);
            else return false;
        }
        return true;
    }
}
```
