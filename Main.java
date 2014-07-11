public class Main {

  final static int LIMIT = 50;
  
  public static void main(String[] args) {
    CoordinatorCell c = new CoordinatorCell(new Neuron(new Analyzer()));
    for (int i = 0; i < LIMIT; i++) {
      c.excite(20);
      c.tick();
    }
  }

}
