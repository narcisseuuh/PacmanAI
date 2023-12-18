package pacman;


public class PacmanSimulator {
   private PacmanState state;
   private Pacman pacman;
   private int refreshPeriod;
   private PacmanVisualizer pv;

   public PacmanSimulator(PacmanState state, Pacman pacman, int refreshPeriod) {
      this.state = state;
      this.pacman = pacman;
      this.refreshPeriod = refreshPeriod;
      this.pv = new PacmanVisualizer(state.getHeight(), state.getWidth());
   }

   public void gameLoop() {
      while (!state.isFinalState()) {
         state = state.move(pacman.chooseAction(state));
         pv.update(state);
         long time = System.currentTimeMillis();
         while (System.currentTimeMillis() < time + refreshPeriod) {}
      }
      System.out.println(state.getScore());
   }
}
