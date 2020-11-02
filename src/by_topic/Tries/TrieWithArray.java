package by_topic.Tries;

import org.junit.Assert;
import org.junit.Test;

public class TrieWithArray {

    private static class Trie {
        Trie[] node = new Trie[26];
        boolean isWord;
    }

    Trie root;

    public void TrieWithArrayInitialize() {
        root = new Trie();
    }

    public void insert(String word){
        char[] charWordArr = word.toCharArray();
        Trie node = root;
        for(char c : charWordArr) {
            if(node.node[c-'a'] == null) {
                node.node[c-'a'] = new Trie();
            }
            node = node.node[c-'a'];
        }
        node.isWord = true;
    }

    public boolean isWordPresent(String word){
        if (word == null || word.length() == 0)
                return false;
        return isWordPresent(word.toCharArray(), 0, root);
    }

    private boolean isWordPresent(char[] charWord, int k, Trie rootNode) {
        if (k == charWord.length)
                return rootNode.isWord;
        if (charWord[k] == '.') {
            for(int i=0; i<rootNode.node.length;i++) {
                if (rootNode.node[i] !=null && isWordPresent(charWord, k+1, rootNode.node[i])){
                    return true;
                }
            }
        }
        else {
            return rootNode.node[charWord[k]-'a']!=null &&
                    isWordPresent(charWord, k + 1, rootNode.node[charWord[k]-'a']);
        }
        return false;
    }

    @Test
    public void verifyTrie(){
        TrieWithArray trieWithArray = new TrieWithArray();
        trieWithArray.TrieWithArrayInitialize();
        trieWithArray.insert("egg");
        Assert.assertTrue(trieWithArray.isWordPresent("egg"));
        Assert.assertFalse(trieWithArray.isWordPresent("eggs"));
        trieWithArray.insert("eggs");
        Assert.assertTrue(trieWithArray.isWordPresent("eggs"));

        trieWithArray.insert("zipper");
        Assert.assertTrue(trieWithArray.isWordPresent("zipper"));
        Assert.assertFalse(trieWithArray.isWordPresent("zipp"));
        Assert.assertFalse(trieWithArray.isWordPresent("zippers"));

        Assert.assertTrue(trieWithArray.isWordPresent("e.g"));
        Assert.assertTrue(trieWithArray.isWordPresent("..g"));
        Assert.assertTrue(trieWithArray.isWordPresent("zip..r"));
        Assert.assertTrue(trieWithArray.isWordPresent("egg."));
    }
}
