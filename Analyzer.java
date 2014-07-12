import java.util.HashSet;


public class Analyzer extends Cell {

  final static int REST_POTENTIAL = 0;
  
  public Analyzer() {  
    this.parents = new HashSet<Cell>();
    this.children = new HashSet<Cell>();
    this.potential = REST_POTENTIAL;
  }
  
  @Override
  public void excite(int potential) {
    this.potential += potential;
  }

  @Override
  public void tick() {
    if (potential >= 50) {
      System.out.println(potential + " V");
      potential -= 50;
    }
  }
  
  

}
