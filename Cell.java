import java.util.*;

public abstract class Cell {

  protected int potential, food;
  protected HashSet<Cell> children, parents;

  public void addChild(Cell child) {
    food -= child.getFood();
    children.add(child);  
  }
  
  public void apoptose() {
    for (Cell child : children) {
      this.children.remove(child);
      if (child.parents.size() == 1) { child.apoptose(); } 
      else { child.parents.remove(this); }
    }
    for (Cell parent : parents) {
      this.parents.remove(parent);
      parent.children.remove(this);
    }
    System.out.println("Apoptosed");
  }
  
  public void feed(int food) {
    this.food = food;
  }
  
  public int getFood() {
    return food;
  }
  
  public int hashCode() {
    int hash = 5 * food * potential;
    return hash;
  }
  
  public void print() {
    for (Cell child : children) { child.print(); }
  }
  
  public abstract void excite(int potential);
  
  public abstract void tick();
  
}
