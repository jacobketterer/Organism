import java.util.HashSet;


public class Neuron extends Cell {
  
  final static int REST_POTENTIAL = 0;
  final static int REST_FOOD = 500;
  
  public Neuron(Cell child) {
    this.children = new HashSet<Cell>();
    this.children.add(child);
    child.parents = new HashSet<Cell>();
    child.parents.add(this);
    food = REST_FOOD;
    potential = REST_POTENTIAL;
  }
  
  public Neuron(HashSet<Cell> children) {
    this.potential = REST_POTENTIAL;
    this.children = children;
    for (Cell child : this.children) { child.parents.add(this); }
    food = REST_FOOD;
    potential = REST_POTENTIAL;
  }
  
  public void excite(int potential) {
    this.potential += potential;
    if (children.size() != 0 && this.potential >= 20) {
      this.potential += 50;
      this.food -= 50;
    }
  }
  
  public void tick() {
    if (potential < 0) { potential /= 4; }
    if (food <= 0) { apoptose(); }
    if (potential >= 70) {
      for (Cell child : children) { child.excite(this.potential / children.size()); }
      potential -= 90;
    }
    for (Cell child : children) { child.tick(); }
  }
  
  public void print() {
    System.out.println("Potential: " + potential);
    System.out.println("Food: " + food + "\n");
    for (Cell child : children) { child.print(); }
  }
}
