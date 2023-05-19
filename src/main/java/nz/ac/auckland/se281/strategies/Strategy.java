package nz.ac.auckland.se281.strategies;

import nz.ac.auckland.se281.Input;

// Strategy interface that allows the strategy to be changed at runtime
public interface Strategy {

  // Method that returns the strategy to be used
  Input useStrategy();
}
