import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args)
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

        System.out.println("BFS traversal order Using Adjacency Matrix: ");
        printSearchOrder(graphFirst.getBfsOrder("A"));

        System.out.println("\nDFS traversal order Using Adjacency Matrix: ");

        printSearchOrder(graphFirst.getDFSOrder("A"));
        // graphFirst.getDFSOrder("A");

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

        System.out.println("\nBFS traversal order Using Adjacency List: ");
        printSearchOrder(graphSecond.getBfsOrder("A"));

        System.out.println("\nDFS traversal order Using Adjacency List: ");

        printSearchOrder(graphSecond.getDFSOrder("A"));


        //Graph<String> fourthGraph = new Graph<>("directed",new String[]{"A","B","C","D","E","F","G","H","I"});





    }
    public static void printSearchOrder(ArrayList<String> orderList)
    {
        for (int i=0;i<orderList.size();i++)
        {
            for(int j=0;j<=i;j++)
            {
                System.out.printf(orderList.get(j) +" ");
            }
            System.out.println();
        }

    }
}

