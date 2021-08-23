import java.util.LinkedList;
import java.util.List;

public class Driver {
  private Trie trie;

  public Driver(){
  trie = new Trie();
  }

  public void constructTrie(String[] sequences){
    for(String sequence : sequences){
      trie.insertSequences(sequence);
    }
  }

  public List<String> matchSequences(String sequence){
    List<String> result = new LinkedList<>();
    return trie.checkSequence(sequence);

  }
}
