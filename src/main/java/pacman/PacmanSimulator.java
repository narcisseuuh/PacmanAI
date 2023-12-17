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
         this.state.move(pacman.chooseAction(state));
         this.pv.update(state);
         long time = System.currentTimeMillis();
         for (long i = time ; i < time + refreshPeriod ; i++);
      }
      System.out.println(state.getScore());
   }
}
