Name:Preksha Raj Shimoga Basavaraja
Email:rajshimo@usc.edu
Project:Conway's Game of Life

Instructions to run:
Install JDK on through the bash.
Then follow these instructions;
Navigate through the folder:
1. cd Conway/src/
Then compile the project using:
2.#javac JavaLife.java
After Compilation of the Java file Run the Project by
3.# java JavaLife

This should run the main package that has all the java files following the OOP format of the Conway's game of Life.
Once JavaLife is run, The user has to input the initial state of the World:
You have to enter the number of rows followed by the number of columns.
Then you have to enter the 2D array of the initial state-Seed as a space seperated integers.

Then you have to enter the number of iterations.

The next step would be to enter the expected state in the same manner as the Seed (The initial state of the Game).
The program asks for the user input to test the Game. If entered Y , the program runs the test function following the signature:
test_game(seed, num_of_iterations, expected_state)

-Seed is a 2D array of integers. Where 0 means dead cell, and 1 means live.
-num_of _iterations is an integer, and this will be the number of times the world moves to the next state.
-Expected_state is similar to seed. And this is the expected state of the world after num_of_iterations state transitions.
-The method returns a boolean. True if the expected_state matches the seed after num_of_iterations state transitions. False otherwise.
The program also considers square(NxN) and rectange matrices(NxM) as input.

The Package has the following files:
-JavaLife.java-The Program that takes user input and contains the test_game function to test the initial state against the expected state 
  and return true or flase based on the comparison.
-World.java- The world, a 2D array of Cells-living and dead.
-Cell.java- Representaion of a cell-Its state, xloc and yloc
-State.java- Enum represenation of the cell-Alive or dead.



