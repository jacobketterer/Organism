import java.util.LinkedList;


public class CoordinatorCell extends Cell {

  public CoordinatorCell(Cell child) {
    this.children = new LinkedList<Cell>();
    this.children.add(child);
    child.parents = new LinkedList<Cell>();
    child.parents.add(this);
    this.parents = new LinkedList<Cell>();
  }
  
  public CoordinatorCell(LinkedList<Cell> children) { 
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
