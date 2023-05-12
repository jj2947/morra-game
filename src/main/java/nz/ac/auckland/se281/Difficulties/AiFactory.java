package nz.ac.auckland.se281.Difficulties;

import nz.ac.auckland.se281.Main.Difficulty;

public class AiFactory {

  public static AiDifficulty createAi(Difficulty difficulty) {
    if (difficulty == Difficulty.EASY) {
      return new Easy();
    } else if (difficulty == Difficulty.MEDIUM) {
      return new Medium();
    } else if (difficulty == Difficulty.HARD) {
      return new Hard();
    } else if (difficulty == Difficulty.MASTER) {
      return new Master();
    } else {
      return null;
    }
  }
}
