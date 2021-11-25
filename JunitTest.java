import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class JunitTest {

    @Test
    public void testBfsDfsUsingAdjMatrix()
    {
        Graph<String> graphFirst = new Graph<>("directed",new String[]{"A","B","C","D","E","F","G","H","I"});

        graphFirst.addEdge("A","B");
        graphFirst.addEdge("A","D");
        graphFirst.addEdge("A","E");
        graphFirst.addEdge("B","E");
        graphFirst.addEdge("C","B");
        graphFirst.addEdge("D","G");
        graphFirst.addEdge("E","F");
        graphFirst.addEdge("E","H");
        graphFirst.addEdge("F","H");
        graphFirst.addEdge("F","C");
        graphFirst.addEdge("G","H");
        graphFirst.addEdge("H","I");
        graphFirst.addEdge("I","F");

        ArrayList<String> actualBfs = graphFirst.getBfsOrder("A");
        ArrayList<String> expectedBfs = new ArrayList<>();
        expectedBfs.add("A");
        expectedBfs.add("B");
        expectedBfs.add("D");
        expectedBfs.add("E");
        expectedBfs.add("G");
        expectedBfs.add("F");
        expectedBfs.add("H");
        expectedBfs.add("C");
        expectedBfs.add("I");

        Assertions.assertEquals(expectedBfs,actualBfs);

        ArrayList<String> actualDfs = graphFirst.getDFSOrder("A");
        ArrayList<String> expectedDfs = new ArrayList<>();
        expectedDfs.add("A");
        expectedDfs.add("B");
        expectedDfs.add("E");
        expectedDfs.add("F");
        expectedDfs.add("C");
        expectedDfs.add("H");
        expectedDfs.add("I");
        expectedDfs.add("D");
        expectedDfs.add("G");

        Assertions.assertEquals(expectedDfs,actualDfs);

    }
    @Test
    public void testBfsDfsUsingAdjList()
    {
        GraphList<String> graphSecond = new GraphList<>("directed",new String[]{"A","B","C","D","E","F","G","H","I"});

        graphSecond.addEdge("A","B");
        graphSecond.addEdge("A","D");
        graphSecond.addEdge("A","E");
        graphSecond.addEdge("B","E");
        graphSecond.addEdge("C","B");
        graphSecond.addEdge("D","G");
        graphSecond.addEdge("E","F");
        graphSecond.addEdge("E","H");
        graphSecond.addEdge("F","C");
        graphSecond.addEdge("F","H");
        graphSecond.addEdge("G","H");
        graphSecond.addEdge("H","I");
        graphSecond.addEdge("I","F");

        ArrayList<String> actualBfs = graphSecond.getBfsOrder("A");
        ArrayList<String> expectedBfs = new ArrayList<>();
        expectedBfs.add("A");
        expectedBfs.add("B");
        expectedBfs.add("D");
        expectedBfs.add("E");
        expectedBfs.add("G");
        expectedBfs.add("F");
        expectedBfs.add("H");
        expectedBfs.add("C");
        expectedBfs.add("I");

        Assertions.assertEquals(expectedBfs,actualBfs);

        ArrayList<String> actualDfs = graphSecond.getDFSOrder("A");
        ArrayList<String> expectedDfs = new ArrayList<>();
        expectedDfs.add("A");
        expectedDfs.add("B");
        expectedDfs.add("E");
        expectedDfs.add("F");
        expectedDfs.add("C");
        expectedDfs.add("H");
        expectedDfs.add("I");
        expectedDfs.add("D");
        expectedDfs.add("G");

        Assertions.assertEquals(expectedDfs,actualDfs);

    }

}

