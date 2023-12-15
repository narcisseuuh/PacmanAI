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
      this.pv = PacmanVisualizer(state.getHeight(), state.getWidth());
   }

   public void gameLoop() {
      while (!state.isFinalState()) {
         this.state = pacman.chooseAction(this.state);
         this.pv.update(this.state);
         int time = System.currentTimeMillis();
         for (int i = time ; i < time + this.refreshPeriod ; i++);
      }
      System.out.println(state.getScore());
   }
}
