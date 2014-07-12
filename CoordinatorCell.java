import java.util.HashSet;


public class CoordinatorCell extends Cell {

  public CoordinatorCell(Cell child) {
    this.children = new HashSet<Cell>();
    this.children.add(child);
    child.parents = new HashSet<Cell>();
    child.parents.add(this);
    this.parents = new HashSet<Cell>();
  }
  
  public CoordinatorCell(HashSet<Cell> children) { 
    this.children = children;
  }
  
  @Override
  public void excite(int potential) {
    for (Cell child : children) { child.excite(potential / children.size()); }
  }

  @Override
  public void tick() {
    for (Cell child : children) { child.tick(); }
  }
  
}
