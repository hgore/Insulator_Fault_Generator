package geneticalgorithm;
import java.lang.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
public class GenerateSetOfNumbers {
	void GenerateSetOfNumbers(int arr[], int n, int triangle_number)
{
	int triangle_no = triangle_number;
	//uniform_int_distribution<int> random(0,triangle_number);
	int p[] = new int[triangle_no];
	for(int i=0;i<triangle_no;i++)
	{p[i]=triangle_no-i;}
	for(int i=(triangle_no-1); i>-1; --i)
	{
//		for(int k=0;k<triangle_no;k++)
//			System.out.print(p[k] + "  \n");
		Random rand = new Random();
		int j =1+ rand.nextInt(triangle_no-1);
		//int j = jj*triangle_no%i;
		int temp = p[i];
//		System.out.print(temp + "  temp  " + p[i] + "  p[i]  ");
		p[i] = p[j];
	//	System.out.print(p[i] + "  p[i]  ");
		p[j] = temp;
//		System.out.print(p[j] + "  p[j]  ");
	}
  for (int i=0; i<n; ++i)
  {arr[i] = p[i];/*System.out.print("\n");System.out.print(p[i] + "  elements[i]			there are " + n + " of these");*/
//System.out.print("\n");
	}
}
}