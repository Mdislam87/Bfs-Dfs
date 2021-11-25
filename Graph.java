import java.util.*;

public class Graph<T> implements GraphInterface<T>{
    private HashMap<T, Integer> map;
    private boolean adjMatrix[][];
    private boolean isUndirected = true;

    public Graph(String graphType, T[] nodes) {
        map = new HashMap<>();
        initGraph(nodes);
        if (graphType.equals("directed")) {
            isUndirected = false;
        }

    }

    private void initGraph(T[] nodes) {
        int l = nodes.length;
        adjMatrix = new boolean[l][l];
        for (int i = 0; i < l; i++) {
            map.put(nodes[i], i);
        }
    }



    public ArrayList<Integer> breathFirstSearch(T root) {
        boolean[] visited = new boolean[getNumberOfNodes()];

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> bfsNodes = new ArrayList<>();

        int rootValue = vertexToIndex(root);

        queue.add(rootValue);

        visited[rootValue] = true;

        while (!queue.isEmpty()) {
            int visitedNode = queue.peek();

            queue.remove();

            bfsNodes.add(visitedNode);

            for (int i = 0; i < getNumberOfNodes(); i++) {
                if (adjMatrix[visitedNode][i] == true && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                }

            }

        }
        return bfsNodes;
    }


    public ArrayList<Integer> depthFirstSearch(T root)
    {
        ArrayList<Integer> dfs = new ArrayList<>();

        boolean[] visited = new boolean[getNumberOfNodes()];

        Stack<Integer> stack = new Stack<>();

        int rootValue = vertexToIndex(root);


        stack.push(rootValue);
        visited[rootValue] = true;
        dfs.add(rootValue);

        while (!stack.empty())
        {
            int top = stack.peek();

            int firstChild = findFirstChild(top,visited);
            if(firstChild != -1)
            {
                dfs.add(firstChild);
                visited[firstChild] = true;
                stack.add(firstChild);
            }
            else {
                stack.pop();
            }

        }
        return dfs;
    }

    int findFirstChild(int top,boolean[] visited)
    {
        int firstChild = -1;
        for(int i=0;i<visited.length;i++)
        {
            if(adjMatrix[top][i]==true && visited[i]==false)
            {
                firstChild = i;
                break;
            }
        }
        return firstChild;
    }


    private ArrayList<Integer> getNeighbours(int element)
    {
        ArrayList<Integer> neighBours = new ArrayList<>();
        for(int i=0;i<getNumberOfNodes();i++)
        {
            if(adjMatrix[element][i] == true)
            {
                neighBours.add(i);
            }
        }
        return neighBours;

    }


    @Override
    public void addEdge(T src, T dtn) {
        int source = vertexToIndex(src);
        int dest = vertexToIndex(dtn);
        if (isUndirected) {
            adjMatrix[source][dest] = true;
            adjMatrix[dest][source] = true;
        }
        else
        {
            adjMatrix[source][dest] = true;
        }

    }

    @Override
    public int getNumberOfNodes() {
          return map.size();
    }

    @Override
    public T indexToVertex(int index) {
        T node = null;
        for (Map.Entry m : map.entrySet()) {
            if(m.getValue().equals(index))
            {
                node = (T) m.getKey();
            }
        }

        return node;
    }
    @Override
    public int vertexToIndex(T node)
    {
        int val = 0;
        for (Map.Entry m : map.entrySet()) {
            //System.out.println(m.getKey() + "  " + m.getValue());
            if(m.getKey()==node)
            {
                val = (int) m.getValue();
            }
        }

        return val;
    }

    @Override
    public ArrayList<String> getBfsOrder(T root) {
        ArrayList<Integer> bfs = breathFirstSearch(root);

        //System.out.printf("BFS In Order Using Adjacency List: ");
        ArrayList<String> bfsString = new ArrayList<>();

        for (int i=0;i<bfs.size();i++)
        {
            //System.out.printf(indexToVertex(bfs.get(i))+" ");
            String s = (String) indexToVertex(bfs.get(i));
            bfsString.add(s);
        }
        //System.out.println();
        return bfsString;
    }

    @Override
    public ArrayList<String> getDFSOrder(T root) {
        ArrayList<Integer> dfs = depthFirstSearch(root);
        ArrayList<String> dfsString = new ArrayList<>();
        //System.out.printf("DFS In Order Using Adjacency Matrix: ");
        for (int i=0;i<dfs.size();i++)
        {
            //  System.out.printf(indexToVertex(dfs.get(i))+" ");
            String s = (String) indexToVertex(dfs.get(i));
            dfsString.add(s);

        }
        return dfsString;
        // System.out.println();
    }
}