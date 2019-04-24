package geneticalgorithm;
import java.lang.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
public class debinary{
void debinary(int N, int bitsize, int dimension, int arraysize, int triangle_number, int binarry[][][], int b[][], int n)
{
	for(int i=0; i<n;i++)
	{	
		for(int j=7+arraysize+2;j<dimension-(2*triangle_number+12-1);j++)
			for(int k=bitsize;k>0;k--)
				b[i][j] += binarry[i][j][bitsize-k]*Math.pow(2,k);
	}
for(int i=0; i<n;i++)
	{	
		for(int j=7+arraysize+2;j<dimension-(2*triangle_number+12-1);j++)
		{
			if(b[i][j]>triangle_number)
			{
				Random randint = new Random();
				int randtriangle = 1 + randint.nextInt(triangle_number-1);
				b[i][j] = randtriangle;
			}
			/*if(b[i][j]==0)
			{
				Random randint = new Random();
				int randtriangle = randint.nextInt(triangle_number);
				b[i][j] = randtriangle;
			}*/	
		}
	}
}
}