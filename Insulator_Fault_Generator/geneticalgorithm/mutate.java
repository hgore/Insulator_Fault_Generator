package geneticalgorithm;
import java.lang.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
public class mutate{
void mutate(int N,int dimension, int arraysize, int triangle_number, int defectnumber, int bitsize,int chromo[][],int centerofmass,int epoch,int maxepoch) throws FileNotFoundException
{
	generateinput genin = new generateinput();
	convertbinary aconvertbinary = new convertbinary();
	int randelements[][] = new int[N/4][dimension];
	//int randelementsarray[][][] = new int[N/4][dimension][bitsize];	//array with N/4 random binary strings


	//If we have a center of mass we can generate mutants.
	//The mutants are a finer change to the previous generation
	//So every time we meet a threshold of cost we choose some group to generate off of
	//ideally narrowing in on the lowest cost
	//
	for(int i=0;i<(N/4);i++)				//this array will give us mutants and rand at end.
	{
		for(int L=0;L<centerofmass;L++)
		randelements[i][7+arraysize+2 + L] = chromo[i+N/4][7+arraysize+2 + L];




	//	System.out.print(randelements[i][7+arraysize+2] + "\n");
//			randelements[i][7+arraysize+2] = chromo[N/4+i][7+arraysize+2];
	//	System.out.print(randelements[i][7+arraysize+2] + "\n");}
//		for(int j=0;j<dimension;j++){
	}
		if(epoch == maxepoch/2){
		Random rand = new Random();
		centerofmass = defectnumber/(rand.nextInt(defectnumber) +1);
                genin.generateinput(N/4,dimension,arraysize,triangle_number,defectnumber,randelements,centerofmass);
		}
		else
		genin.generateinput(N/4,dimension,arraysize,triangle_number,defectnumber,randelements,centerofmass);
//		}
	//}
	//aconvertbinary.convertbinary(N, bitsize, arraysize, dimension, triangle_number, randelements,randelementsarray,(N/4));
	for(int i=0; i<(N/4);i++)
	{
		for(int j=7+arraysize+2;j<dimension;j++)//-(2*triangle_number+12-1);j++)
		{		
	//		System.out.print(randelements[i][j] + "\n");
			chromo[i+(N/2)][j] = randelements[i][j];
		}
	}
	//multiply by -1 and subtract if this doesn't work
	//so what I want to do is use the children's first elements as bases for new generation, and those will be mutants.
	//genin.generateinput(N/4,dimension,arraysize,triangle_number,defectnumber,chromo) but chromo needs to be in the right
	//range. generateinput() works on N/4 things, 
		
//return int binarray[][dimension][bitsize];
}
}
