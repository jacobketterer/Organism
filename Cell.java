import java.util.LinkedList;

public abstract class Cell {

  protected int food;
  protected int potential;
  public LinkedList<Cell> children, parents;

  public void addChild(Cell child) {
    children.add(child);  
  }
  
  public void apoptose() {
    System.out.println("Apoptosed");
    for (Cell child : children) {
      this.children.remove(child);
      if (child.parents.size() == 1) { child.apoptose(); } 
      else { child.parents.remove(this); }
    }
    for (Cell parent : parents) {
      this.parents.remove(parent);
      parent.children.remove(this);
    }
  }
  
  public void feed(int food) {
    this.food = food;
  }
  
  public void print() {
    for (Cell child : children) { child.print(); }
  }
  
  public abstract void excite(int potential);
  
  public abstract void tick();
  
}
