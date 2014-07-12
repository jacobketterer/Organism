import java.util.HashSet;


public class SupportCell extends Cell {

  final static int REST_FOOD = 100;
  final static int REST_POTENTIAL = 0;
  
  public SupportCell(Cell child) {
    this.children = new HashSet<Cell>();
    this.children.add(child);
    child.parents = new HashSet<Cell>();
    child.parents.add(this);
    food = REST_FOOD;
    potential = REST_POTENTIAL;
    
  }
  
  public SupportCell(HashSet<Cell> children) {
    this.children = children;
    for (Cell child : this.children) { child.parents.add(this); }
    food = REST_FOOD;
    potential = REST_POTENTIAL;
  }
  
  public void excite(int potential) {
    this.potential += potential;
  }

  @Override
  public void tick() {
    if (food <= 0) { apoptose(); }
    if (potential >= 10) {
      int distribution = 100;
      this.food -= 100;
      for (Cell child : children) { child.feed(distribution / children.size()); }
    }
    for (Cell child : children) { child.tick(); }
  }
  
}
