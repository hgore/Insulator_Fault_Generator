package geneticalgorithm;
import java.lang.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;
public class mixing{    //Generates cildren of the first quarter elements, which were the best of the system.
void mixing(int N, int bitsize, int dimension, int chromo[][], int arraysize, int triangle_number) //Generates cildren of the first quarter elements, which were the best of the system.
{
	for(int i=0;i<N/8;i++)
	{
	/*	for(int j=7+arraysize+2;j<(dimension-(2*triangle_number+12-1))/2;j++)
		{
			chromo[2*i+N/4][j] = chromo[2*i][j];
			chromo[2*i+N/4][j+(dimension-(2*triangle_number+12-1))/2] = chromo[2*i+1][j+(dimension-(2*triangle_number+12-1))/2];

			chromo[2*i+N/4+1][j] = chromo[2*i+1][j];
			chromo[2*i+N/4+1][j+(dimension-(2*triangle_number+12-1))/2] = chromo[2*i][j+(dimension-(2*triangle_number+12-1))/2];
		}*/
		//plan is to take the first elements from Q1 and add them %triangle_number maybe randomly subtract? I'll have
		//to use a bunch of logic to do subtraction and keep it in my boundaries. 
		chromo[2*i+N/4][7+arraysize+2] = ((chromo[2*i][7+arraysize+2]+chromo[2*i+1][7+arraysize+2])%triangle_number)/2 +1;
		
		chromo[2*i+N/4+1][7+arraysize+2] = ((chromo[2*i+1][7+arraysize+2]+chromo[2*i][7+arraysize+2])%triangle_number)/2 +1;
	}
	//return binaryarray[N][dimension][bitsize];
	
	
}
}
