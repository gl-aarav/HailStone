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
	private int InputtedValue;
	private int printInOneLine;
	public HailStone()
	{
		InputtedValue = 0;
		printInOneLine = 0;
	}
	public static void main (String[] args)
	{
		HailStone hail = new HailStone();
		hail.findIt();
	}

	public void findIt()
	{
		input();
		do
		{
			calculate();
			print();
		}while(InputtedValue > 1);
	}
	public void input()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("\n\n\nEnter a positive value (1 - 10000). To quit, enter -1:\t");
		InputtedValue = in.nextInt();
		System.out.println("\n\n\nHere is the Sequence\n\n");
		in.close();
	}
	public void calculate()
	{
		if(InputtedValue % 2 == 1)
		{
			InputtedValue = 3 * InputtedValue + 1;
		}
		else if (InputtedValue % 2 == 0)
		{
			InputtedValue = InputtedValue / 2;
		}
		else if (InputtedValue == -1)
		{
			print();
		}
	}
	public void print()
	{
		if (printInOneLine<=10) 
		{
			System.out.print(InputtedValue + " -> ");
			printInOneLine++;
		}
		else if (printInOneLine>10 || )
		{
			System.out.println(InputtedValue + "\n\n");
			printInOneLine = 0;
		}
	}
}