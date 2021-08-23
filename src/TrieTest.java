import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class TrieTest {

  @Test
  public void testTrieConstruction(){
    Driver driver = new Driver();
    driver.constructTrie(new String[]{"the dog", "the dog store", "the boy"});
    assertEquals(driver.matchSequences("the dog"), Arrays.asList("the dog"));
    assertEquals(driver.matchSequences("the dog friend"), Arrays.asList("the " +
                    "dog"));
    assertEquals(driver.matchSequences("the dog store"),Arrays.asList("the " +
            "dog","the dog store"));
    assertEquals(driver.matchSequences("the dog friend bob the boy the dog " +
                    "store" ),Arrays.asList("the " +
            "dog","the boy", "the dog","the dog store"));
    assertEquals(driver.matchSequences("").size(),0);
    assertEquals(driver.matchSequences("the dog friend the dog "+
            "store" ).size(),3);
    assertEquals(driver.matchSequences("hey the dog friends"),Arrays.asList(
            "the " +
            "dog"));
    assertEquals(driver.matchSequences("the dog the friend store"),
            Arrays.asList(
            "the dog"));
    System.out.println("That's all folks!");
  }
}