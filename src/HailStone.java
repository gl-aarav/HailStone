/*
 * Aarav Goyal
 * HailStone.java
 * 11/6/2024
 * 
 * This program displays the Hailstone Sequence proposed by German mathematician
 * Lothar Collatz. The sequence always ends in a 1, although it has yet to be proven.
 * The sequence works this way: pick a number, if it is even then half it, if it is odd
 * then multiply by 3 and add one. Continue this process until the number becomes one.
 * - In main, create an instance and use it to call findIt().
 * - In findIt(), make a loop to call the other methods. The program will terminate when the user
 *   types in the number -1 (a sentinel value).
 * The program will need methods for the following:
 * - Accept the user input.
 * - When printing the sequence, the program will use a loop until the sequence number reaches 1.
 * - The sequence will print 10 numbers per line, then move to the next line.
 * - Print a count for the number of times the loop had to run to generate the sequence.
 * - You need to decide on the use of field or local variables.
 * 
 * Testing Plan: 
 * - The user has to input a value between 1 and 10,000. When -1 is entered, the program stops.
 * - The program will stop if a negative value or zero is entered as well.
 */

import java.util.Scanner;

public class HailStone
{
    // Declare instance variables
    private int inputtedValue;      // Holds the current value for the sequence
    private int printInOneLine;     // Keeps track of how many numbers have been printed on the current line
    private int executedTimes;      // Tracks the number of steps taken to reach 1 in the sequence
    private int highestValue;       // Tracks the highest value encountered during the sequence

    // Constructor to initialize instance variables
    public HailStone()
    {
        inputtedValue = 0;           // Default value for user input
        printInOneLine = 1;          // Start printing from the first position on a line
        executedTimes = 0;           // Initialize the step counter
        highestValue = 0;            // Initialize the highest value
    }

    // Main method to create an instance of HailStone and call the findIt() method
    public static void main (String[] args)
    {
        // Create an instance of HailStone
        HailStone hail = new HailStone();
        // Call findIt() method to start the sequence process
        hail.findIt();
    }

    // Method to start the sequence process, handling user input and processing the sequence
    public void findIt()
    {
        // Accept user input
        input();
        
        // Update highest value encountered if the current inputted value is greater
        if(inputtedValue > highestValue)
        {
            highestValue = inputtedValue;
        }
        
        // If the input is valid, start the sequence process
        if(inputtedValue > 1)
        {
            // Print the initial input value
            System.out.printf("\t%,d", inputtedValue);
            executedTimes++; // Increment the executed time counter
            // Continue calculating and printing the sequence until the value reaches 1
            while(inputtedValue > 1)
            {
                calculate(); // Perform sequence calculations
                print();     // Print the current value
            }
        }
        // Handle termination condition (user enters -1)
        else if (inputtedValue == -1)
        {
            print(); // Print and exit
        }
        // Handle invalid input (negative or zero)
        else
        {
            printInOneLine = -100; // Set printInOneLine to an invalid value to handle errors
            print(); // Print an error message
        }
    }

    // Method to accept user input (positive value between 1-10000)
    public void input()
    {
        // Create a Scanner object to read user input
        Scanner in = new Scanner(System.in);
        System.out.print("\n\n\nEnter a positive value (1 - 10000). To quit, enter -1:\t");
        // Read the input value
        inputtedValue = in.nextInt();
        System.out.print("\n\n");
        // Close the scanner to prevent resource leaks
        in.close();
    }

    // Method to perform the calculation based on the Collatz conjecture
    public void calculate()
    {
        // If the value is odd, multiply by 3 and add 1
        if(inputtedValue % 2 == 1)
        {
            inputtedValue = 3 * inputtedValue + 1;
        }
        // If the value is even, divide by 2
        else if (inputtedValue % 2 == 0)
        {
            inputtedValue = inputtedValue / 2;
        }

        // If the input value exceeds the highest value, update highest value
        if(inputtedValue > highestValue)
        {
            highestValue = inputtedValue;
        }
    }

    // Method to print the current value and track the sequence
    public void print()
    {
        // Print numbers on a single line until 10 numbers are printed, then move to the next line
        if (printInOneLine < 8 && inputtedValue > 1) 
        {
            System.out.printf("\t%,d", inputtedValue);
            printInOneLine++; // Increment the counter for numbers printed in one line
            executedTimes++;  // Increment the number of executed steps
        }
        // After printing 10 numbers on one line, move to the next line
        else if (printInOneLine >= 8 && inputtedValue > 1)
        {
            System.out.printf("\t%,d\n\n", inputtedValue);
            printInOneLine = 0; // Reset the counter for the next line
            executedTimes++;    // Increment the step counter
        }
        // When reaching the final value of 1, print the sequence details
        else if (inputtedValue == 1 && printInOneLine > 7)
        {
            System.out.printf("\t%,d\n\n", inputtedValue);
            executedTimes++;
            System.out.printf("The loop executed %,d times.\n", executedTimes);  // Print the number of steps
            System.out.printf("The highest value was: %,d.\n\n\n\n", highestValue); // Print the highest value encountered
        }
        // If the sequence reaches 1 and is on the same line, print it and show results
        else if (inputtedValue == 1 && printInOneLine <= 7)
        {
            System.out.printf("\t%,d\n\n\n", inputtedValue);
            executedTimes++;
            System.out.printf("The loop executed %,d times.\n", executedTimes);  // Print the number of steps
            System.out.printf("The highest value was: %,d.\n\n\n\n", highestValue); // Print the highest value encountered
        }
        // If the user enters an invalid value, prompt for correct input
        else if (inputtedValue == -1)
        {
            System.out.println("Thank you for playing Hailstone.\n\n\n"); // Thank the user and exit
        }
        // Handle invalid input (out of range or incorrect value)
        else
        {
            System.out.println("Enter a value within the range, please!"); // Error message for invalid input
        }
    }
}
