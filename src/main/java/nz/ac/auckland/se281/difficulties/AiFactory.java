package nz.ac.auckland.se281.difficulties;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.strategies.Random;

// Factory class used to create the correct AI difficulty instance
public class AiFactory {

  // Method that returns the AI difficulty instances
  public static AiDifficulty createAi(Difficulty difficulty) {

    // If difficulty is easy, then the easy difficulty instance is returned
    if (difficulty == Difficulty.EASY) {
      return new EasyDifficulty(new Random());

      // If difficulty is medium, then the medium difficulty instance is returned
    } else if (difficulty == Difficulty.MEDIUM) {
      return new MediumDifficulty(new Random());

      // If difficulty is hard, then the hard difficulty instance is returned
    } else if (difficulty == Difficulty.HARD) {
      return new HardDifficulty(new Random());

      // If difficulty is master, then the master difficulty instance is returned
    } else if (difficulty == Difficulty.MASTER) {
      return new MasterDifficulty(new Random());
    } else { // If difficulty is not easy, medium, hard or master, then null is returned
      return null;
    }
  }
}
