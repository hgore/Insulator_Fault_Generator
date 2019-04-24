package geneticalgorithm;
import java.lang.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
public class tournament{
void tournament(int N, int bitsize, int dimension, int arraysize, int triangle_number, int a[][],double costs[])
{
double newcost[] = new double[N];
	for(int i=0; i<(N/2);i++)
	{
		newcost[i] = costs[i];
	}
	for(int i=0; i<(N/2);i++)
	{
	if(costs[2*i]<costs[2*i+1])
		for(int j=0;j<dimension;j++)
		{
				a[i][j] = a[2*i][j];
				newcost[i] = newcost[2*i];
		}
	else
		for(int j=0;j<dimension;j++)
		{
				a[i][j] = a[2*i+1][j];
				newcost[i] = newcost[2*i+1];
		}
	}
	for(int i=0; i<(N/2);i++)
		for(int j=7+arraysize+2;j<dimension-(2*triangle_number+12-1);j++){
			Random rand = new Random();
			a[i+(N/2)][j]=1+rand.nextInt(triangle_number);
			newcost[i+(N/2)] = 1+rand.nextInt(triangle_number);
}	//this rewrites everything in xy[][] to be 1, if it is in a loser position
for(int i=0;i<N;i++){
	costs[i] = newcost[i];}
}
}
