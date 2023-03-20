import java.util.ArrayList;

public interface Algorithm {
     default void doAlgorithm(ArrayList<Process> processArrayList){}

     default String getAlgorithmName() {
          return "Algorithm";
     }

}
