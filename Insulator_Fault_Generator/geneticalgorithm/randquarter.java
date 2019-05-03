package geneticalgorithm;
import java.lang.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
public class randquarter{
void randquarter(int N, int bitsize, int dimension, int arraysize, int triangle_number, int defectnumber, int binar[][],int centerofmass) throws FileNotFoundException
{
	generateinput genin = new generateinput();
	convertbinary aconvertbinary = new convertbinary();
	int randelementsquarter[][] = new int[N/4][dimension];
//initiate this to zero	
//for(int i=0;i<N/4;i++)
//	for(int j=(7+arraysize+2);j<defectnumber;j++)
//		randelementsquarter[i][j] = 0;
//randelementsquarter[][]

//System.out.print("hello");
//	Random rand = new Random();
//	int randelementsarrayquarter[][][] = new int[N/4][dimension][bitsize];	//array with N/4 random binary strings
	for(int i=0;i<(N/4);i++){				//this array will give us mutants and rand at end.
//		System.out.print(randelementsquarter[i][7+arraysize+2] + "\n");	
		Random rand = new Random();
		randelementsquarter[i][7+arraysize+2] = (rand.nextInt(triangle_number) +1);
		System.out.print("\n"+randelementsquarter[i][7+arraysize+2]+"\n");
//		for(int j=0;j<dimension;j++)i
//		System.out.print(randelementsquarter[i][7+arraysize+2] + "\n");
	}
		genin.generateinput(N/4,dimension,arraysize,triangle_number,defectnumber,randelementsquarter,centerofmass);

//	}
//	aconvertbinary.convertbinary(N, bitsize, arraysize, dimension,triangle_number, randelementsquarter,randelementsarrayquarter,(N/4));
	for(int i=0; i<(N/4);i++)
	{
		for(int j=(7+arraysize+2);j<dimension;j++)
		{
//			System.out.print(randelementsquarter[i][j] + "\n");
			binar[(i+((3*N)/4))][j] = randelementsquarter[i][j];
	//cout<<randelementsarrayquarter[i][j];
		}
	}
}
}
