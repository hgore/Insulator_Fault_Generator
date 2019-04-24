package geneticalgorithm;
import java.lang.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
public class writeinput{
void writeinput(int N, int dimension, int arraysize, int triangle_number,int defectnumber, int input[][], int i) throws FileNotFoundException
{

			PrintWriter inputfile = new PrintWriter("inputfiles/InputFile_" + i + ".txt");
			inputfile.print(input[i][0] + "\n");	//N
			inputfile.print(input[i][1] + "\n");	//xsize
			inputfile.print(input[i][2] + "\n");	//ysize
			inputfile.print(input[i][3] + "\n");	//thickness
			inputfile.print(input[i][4] + "\n");	//x heat cond
			inputfile.print(input[i][5] + "\n");	//y heat cond
			inputfile.print(input[i][6] + "\n");	//temp start
			for(int k=0;k<input[i][0]+1;k++)
				inputfile.print(input[i][7+k] + "\n");	//temp end
			inputfile.print(input[i][7+input[i][0]+1] + "\n");	//defect number
			for(int k=0;k<input[i][7+input[i][0]+1];k++)
				inputfile.print(input[i][7+input[i][0]+2+k] + "\n");	//broken elements after 11 there's a bug where 12 is 2, 13 is an element of the array 14 is 2 15 is not, 16 is 2...
//The above bug is because I can't count, change dimension to ... + 3*defectnumber
			for(int k=(7+input[i][0]+2+input[i][7+input[i][0]+1]);k<2*defectnumber;k++)	//there are 18  defects, but 2s are inserted between them. Was triangle_number but I'm cleaning "dimension"
			{
				//inputfile.print(input[i][44+k]+"\n");
				//inputfile.print(input[i][7+input[i][0]+2+input[i][7+input[i][0]+1]+k] + "\n");
				//inputfile.print(input[i][7+input[i][0]+2*input[i][7+input[i][0]+1]+k] + "\n");
				inputfile.print(input[i][k]);
			}
		inputfile.close();		//this should write input[] to a file, and that's InputFile.txt
/*	for(int j=0;j<dimension;j++)
		genin[i][j] = input[j]*/
}
}













/*	int xsize = 1;
	int ysize = 1;
	int thickness = 1;
	int conductx = 1;
	int conducty = 1;	//these can be different, but they're just constant factors.
	int temp = 100;		//Temp at start, should ask Sabri if this matters or was specific when unit analysis occurs. I think it's in Celcius
	double endtemp = 10;//The fea code doesn't do too well with this varying, but you could generate it with a function and make it an array of size "arraysize". endtemp[arraysize]. I think smooth changes are better, so consider the arraysize and just do something like arraysize[i] = sin^2(ypos[i]). Also this can be a double.
	//defect number :::: this is what it's called. you choose this and which elements are defects. Mesh is broken into 45-45-90 triangles which make squares. there are arraysize^2 squares, so 2*arraysize^2 triangles. Numbered 1-triangle_number. Order is like a numberpad: 1st square is bottom left first triangle is top left of that square, counting right, then newline up. Examine the boxes in the next few comments. Also, even numbers can turn off blocks, odd numbers always have weird edges.
	int elements[] = new int[defectnumber];	//we can't repeat these numbers. So let's use a random shuffle to generate thiese numbers. These again are coming out of the genetic algorithm, so just be sure the GE doesn't repeat entries in the array.
	GenerateSetOfNumbers generator = new GenerateSetOfNumbers();
	int conductairx = 2;
	int conductairy = 2;
	int input[] = new int[dimension];
for(int i=0;i<N;i++)
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
				input[7+k] = endtemp;
			input[7+arraysize] = defectnumber;
			for(int k=0;k<defectnumber;k++)
				input[7+arraysize+1+k] = elements[i];
			for(int k=0;k<triangle_number;k++)
			{
				input[7+arraysize+1+defectnumber+k] = conductairx;
				input[7+arraysize+1+2*defectnumber+k] = conductairy;
			}*/
						//so now input[] is full
						//input[j] is xy[i][j]
