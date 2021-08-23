import java.util.HashMap;
import java.util.Map;

/**
 * Node class which holds the word and the branches from that word.
 */
public class Node {
  private String word;
  private Map<String,Node> nodeList;
  private boolean isEndNode;

  /**
   * Initializes the node with the word and a hashmap of all the other words
   * branching from it.
   * @param word
   */
  public Node(String word){
    this.word = word;
    nodeList = new HashMap<String,Node>();
  }

  @Override
  public boolean equals(Object o){
    if(o == this){
      return true;
    }
    if(!(o instanceof Node)){
      return  false;
    }
    return this.word.equals(((Node) o).word);
  }

  public Node insertWord(String word){
    if(this.nodeList.containsKey(word)){
      return nodeList.get(word);
    }
    Node current = new Node(word);
    nodeList.put(word,current);
    return current;
  }

  /**
   * Marks the word as the end of a sentence.
   */
  public void setEnd(){
    this.isEndNode = true;
  }
  @Override
  public String toString(){
    return this.word;
  }

  /**
   * Checks if the word is at the end of a sentence.
   * @return
   */
  public boolean isEnd(){
    return this.isEndNode;
  }

  /**
   * Check if the node is equal to a given word.
   * @param word
   * @return
   */
  public Node getMatch(String word){
   return this.nodeList.get(word);
  }

}
