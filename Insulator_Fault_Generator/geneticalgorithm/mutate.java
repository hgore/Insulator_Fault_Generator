package geneticalgorithm;
import java.lang.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;
public class mutate{
void mutate(int N,int dimension, int arraysize, int triangle_number, int defectnumber, int bitsize,int chromo[][]) throws FileNotFoundException
{
	generateinput genin = new generateinput();
	convertbinary aconvertbinary = new convertbinary();
	int randelements[][] = new int[N/4][dimension];
	//int randelementsarray[][][] = new int[N/4][dimension][bitsize];	//array with N/4 random binary strings
	for(int i=0;i<(N/4);i++)				//this array will give us mutants and rand at end.
	{
			randelements[i][7+arraysize+2] = chromo[N/4+i][7+arraysize+2];
//		for(int j=0;j<dimension;j++){
			genin.generateinput(N/4,dimension,arraysize,triangle_number,defectnumber,randelements);
//		}
	}
	//aconvertbinary.convertbinary(N, bitsize, arraysize, dimension, triangle_number, randelements,randelementsarray,(N/4));
	for(int i=0; i<(N/4);i++)
	{
		for(int j=7+arraysize+2;j<dimension-(2*triangle_number+12-1);j++)
		{		
			chromo[i+(N/2)][j] = randelements[i][j];
										//multiply by -1 and subtract if this doesn't wor
	//so what I want to do is use the children's first elements as bases for new generation, and those will be mutants.
	//genin.generateinput(N/4,dimension,arraysize,triangle_number,defectnumber,chromo) but chromo needs to be in the right
	//range. generateinput() works on N/4 things, 
		}
//return int binarray[][dimension][bitsize];
	}
}
}
