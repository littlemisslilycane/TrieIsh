import java.util.LinkedList;
import java.util.List;

/**
 * This class represents a tree of words forming. Each branch in the trie
 * forms a sentences. For example:
 * (root)
 *   |
 * (the)
 *   |   \
 *  (boy*) (dog*)
 *          |
 *          (store*)
 *  The above tree contains three sentences "the boy", "the dog" and "the dog
 *  store"
 */
public class Trie {

  private Node root;

  /**
   * A trie is initialized with an empty root node.
   */
  public Trie (){
    root = new Node("");
  }

  /**
   * This is a method to insert a sentence into the trie.
   * @param sentence
   */
  public void insertSequences(String sentence){

    String[] words = sentence.split(" ");
    Node current = root;
    for(String w : words){
      current = current.insertWord(w);
    }
    //At the end of the sentence, mark it with end flag.
    current.setEnd();
  }

  /**
   * Checks if any sequence in the given sentences matches the one present in
   * the trie. For example, given a sequence "the boy friend the dog", it
   * matches with "the boy" & "the dog" from the trie.
   * @param sequence
   * @return list of sentences present in the trie.
   */
  public List<String> checkSequence(String sequence){
    Node current = root;
    List<String> result = new LinkedList<>();
    StringBuilder builder = new StringBuilder();
    for(String word: sequence.split(" ")){
      //Check each word in the sentence in the current branch
     current = checkSequenceHelper(word,current,builder,result);
     if(current ==null)
     {
       //If current branch has no match, check again from the root.
       //TO FIX: There is some redundancy here. If the current branch is
       // already the root, it checks the root again.
       builder = new StringBuilder();
       current = checkSequenceHelper(word, root,builder,result);
       if(current ==null){
         //Suppose the word is not present in the root, then skip over to the
         // next word starting from the root again.
         current = root;
       }
     }
    }
    return result;

  }

  /**
   * Helper method. Gets the node matching the word and adds the word to the
   * result list.
   * @return current node in the branch.
   */
  private Node checkSequenceHelper(String word, Node node,
                                   StringBuilder builder, List<String> result){
    Node current=  node.getMatch(word);
    if(current !=null){
      builder.append(" "+ word);
      if(current.isEnd()){
        result.add(builder.toString().trim());
      }
    }
    return current;
  }



}
