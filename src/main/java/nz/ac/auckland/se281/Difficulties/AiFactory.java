package nz.ac.auckland.se281.difficulties;

import nz.ac.auckland.se281.Main.Difficulty;

public class AiFactory {

  public static AiDifficulty createAi(Difficulty difficulty) {
    if (difficulty == Difficulty.EASY) {
      return new EasyDifficulty();
    } else if (difficulty == Difficulty.MEDIUM) {
      return new MediumDifficulty();
    } else if (difficulty == Difficulty.HARD) {
      return new HardDifficulty();
    } else if (difficulty == Difficulty.MASTER) {
      return new MasterDifficulty();
    } else {
      return null;
    }
  }
}
