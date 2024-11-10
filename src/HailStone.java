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
 * types in the number -1 (a sentinel value).
 * The program will need methods for the following
 * - Accept the user input.
 * - When printing the sequence, the program will use a loop until the sequence number 1.
 * - the sequence will print 10 numbers on a line, then go to the next line.
 * - Print a count for the number of times the loop had to run to make the sequence.
 * - You need to decide on the use of field or local variables.
 * 
 * Testing Plan: 
 * 
 * The user has to put a value from 1-10000 and when entered -1 the program will stop
 * and when entered a negative value and zero the program will also stop
 */

import java.util.Scanner;
public class HailStone
{
	private int inputtedValue;
	private int printInOneLine;
	private int executedTimes;
	private int highestValue;
	public HailStone()
	{
		inputtedValue = 0;
		printInOneLine = 0;
		executedTimes = 0;
		highestValue = 0;
	}
	public static void main (String[] args)
	{
		HailStone hail = new HailStone();
		hail.findIt();
	}

	public void findIt()
	{
		input();
		System.out.print("\t" + inputtedValue);
		executedTimes++;
		if(inputtedValue > highestValue)
		{
			highestValue = inputtedValue;
		}
		do
		{
			calculate();
			print();
		}while(inputtedValue > 1);
	}
	public void input()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("\n\n\nEnter a positive value (1 - 10000). To quit, enter -1:\t");
		inputtedValue = in.nextInt();
		System.out.print("\n\n");
		in.close();
	}
	public void calculate()
	{
		if(inputtedValue % 2 == 1)
		{
			inputtedValue = 3 * inputtedValue + 1;
		}
		else if (inputtedValue % 2 == 0)
		{
			inputtedValue = inputtedValue / 2;
		}
		else if (inputtedValue == -1)
		{
			print();
		}
		
		if(inputtedValue > highestValue)
		{
			highestValue = inputtedValue;
		}
	}
	public void print()
	{
		if (printInOneLine <= 7 && inputtedValue > 1) 
		{
			System.out.printf("\t%,d", inputtedValue);
			printInOneLine++;
			executedTimes++;
		}
		else if (printInOneLine > 7 || inputtedValue < 1)
		{
			System.out.printf("\t%,d\n\n", inputtedValue);
			printInOneLine = 0;
			executedTimes++;
		}
		else
		{
			System.out.printf("\t\n\n%,d\n\n\n\n", inputtedValue);
			executedTimes++;
		}
		if(inputtedValue == 1)
		{
			System.out.printf("The loop executed %,d times.\n", executedTimes);
			System.out.printf("The highest value was: %,d\n\n\n\n",highestValue);
		}
	}
}