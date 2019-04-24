package geneticalgorithm;
import java.lang.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
public class generateinput{
void generateinput(int N, int dimension, int arraysize, int triangle_number,int defectnumber,int genin[][]) throws FileNotFoundException
{
	int xsize = 1;
	int ysize = 1;
	int thickness = 1;
	int conductx = 1;
	int conducty = 1;	//these can be different, but they're just constant factors.
	int temp = 100;		//Temp at start, should ask Sabri if this matters or was specific when unit analysis occurs. I think it's in Celcius
	double endtemp = 10;//The fea code doesn't do too well with this varying, but you could generate it with a function and make it an array of size "arraysize". endtemp[arraysize]. I think smooth changes are better, so consider the arraysize and just do something like arraysize[i] = sin^2(ypos[i]). Also this can be a double.
	//defect number :::: this is what it's called. you choose this and which elements are defects. Mesh is broken into 45-45-90 triangles which make squares. there are arraysize^2 squares, so 2*arraysize^2 triangles. Numbered 1-triangle_number. Order is like a numberpad: 1st square is bottom left first triangle is top left of that square, counting right, then newline up. Examine the boxes in the next few comments. Also, even numbers can turn off blocks, odd numbers always have weird edges.
	int elements[] = new int[defectnumber];	//we can't repeat these numbers. So let's use a random shuffle to generate thiese numbers. These again are coming out of the genetic algorithm, so just be sure the GE doesn't repeat entries in the array.
	GenerateSetOfNumbers generator = new GenerateSetOfNumbers();
	makeblob blob = new makeblob();
	int conductairx = 2;
	int conductairy = 2;
	int input[] = new int[dimension];
for(int i=0;i<N;i++)		//this fills out input which is our chromosome
{
		generator.GenerateSetOfNumbers(elements,defectnumber,triangle_number);
			input[0] = arraysize;
			input[1] = xsize;
			input[2] = ysize;
			input[3] = thickness;
			input[4] = conductx;
			input[5] = conducty;
			input[6] = temp;
			for(int k=0;k<arraysize+1;k++)
				input[7+k] = (int)endtemp;
			input[7+arraysize+1] = defectnumber;	//defect # 13;18
	/*
			for(int k=0;k<defectnumber;k++)		//broken elements 18;33
			{	input[7+arraysize+2+k] = elements[k]; System.out.print(7+arraysize+1+k + " @@ " + elements[k] + " \n");
			}*/
			input[7+arraysize+2] = genin[i][7+arraysize+2];
			blob.makeblob(input,N,arraysize,defectnumber,triangle_number);
//	System.out.print(2*defectnumber);
			for(int k=(7+arraysize+2+defectnumber);k<(defectnumber);k++) //was k<triangle_no but I'm cleaning "dimension"
			{//44 and up
				input[k] = 2;//conductairx;  //(7+arraysize+2+defectnumber)   7+arraysize+2+defectnumber+k
				input[2*k] = conductairy;//7+arraysize+2+defectnumber+2*k
				//input[44+k] = 2;
			}
	for(int j=0;j<dimension;j++)
	{genin[i][j] = input[j];	/*System.out.print(genin[i][j] + "\n");*/
	}	
}
}}
