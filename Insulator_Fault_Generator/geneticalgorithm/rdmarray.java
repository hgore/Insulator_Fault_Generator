package geneticalgorithm;
import java.lang.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;
import java.util.Random;

public class rdmarray{
void rdmarray(int N, int bitsize, int dimension, int binry[][][],int s[][], int minn, int maxn)	
{
//Random random = new Random();
//	double randomNumber = random.nextDouble(1+1-N/4)+N/4;
//uniform_int_distribution<int> randomr(0,((N/4)-1));
int temp;
int randxy;
int temps;
	Random random = new Random();
//double n = new double.valueOf(N);
	for(int i=minn; i<(maxn);i++)
	{
		randxy = (int)random.nextInt(maxn);
		for(int j=0; j<dimension;j++)
		{
/*			for(int k=0; k<bitsize;k++)
			{
				temp = binry[i][j][k];
				binry[i][j][k] = binry[randxy][j][k];
				binry[randxy][j][k]=temp;
			}*/
				temps = s[i][j];
				s[i][j] = s[randxy][j];
				s[randxy][j] = temps;
				
			//will be worthwile to keep track of this randomness at least for the final epoch. That way I know what has changed between checkfolder/costs/costcheck_* and inputfiles/InputFile_*.txt
		}
	}
}
}
