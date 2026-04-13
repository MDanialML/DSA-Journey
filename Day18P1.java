class TrieNode{
        TrieNode children[] = new TrieNode[26]; //
        boolean isEndOfWord = false;

    }

class Trie{
    TrieNode root = new TrieNode();

    public void insert(String word)
    {
        TrieNode curr = root; //create a new pointer protect the root position
        for(char ch : word.toCharArray()){ //create a array of letter from word
            int index = ch - 'a'; //get the index number of current charactor
            if(curr.children[index]  == null){ //if index pointing to null 
                curr.children[index] = new TrieNode(); // create new node the charactor and point to that
            }
            curr = curr.children[index]; //this is not clear
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word){
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(curr.children[index] == null) return false;
            curr = curr.children[index];
        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String word){
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(curr.children[index] == null) return false;
            curr = curr.children[index];
        }
        return true;
    }

}

public class Day18P1{

    //driver function
    public static void main(String[] args){


        Trie trie = new Trie();

        trie.insert("cat");
        trie.insert("car");
        trie.insert("card");
        trie.insert("care");
        trie.insert("dog");


        System.out.println(trie.search("car"));
        System.out.println(trie.search("cat"));
        System.out.println(trie.startsWith("ca"));
        System.out.println(trie.search("ca"));
        System.out.println(trie.search("dot"));
        System.out.println(trie.startsWith("do"));
        System.out.println(trie.startsWith("cat"));
    }
}