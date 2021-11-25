import java.util.ArrayList;

public interface GraphInterface<T> {
    void addEdge(T src, T dtn);
    int getNumberOfNodes();
    T indexToVertex(int index);
    int vertexToIndex(T node);
    ArrayList<String> getBfsOrder(T root);
    ArrayList<String> getDFSOrder(T root);

}
