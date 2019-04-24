package geneticalgorithm;
import java.lang.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;
public class convertbinary{
void convertbinary(int N, int bitsize,  int arraysize, int dimension,int triangle_number, int sortedind[][], int binaryno[][][],int n) //converts a decimal in (0,1) to binary w/ 16 digit accuracy
{	//this gives you your first quarter in binary
	int b = 0;
	for(int i=0; i<n;i++)
	{
		for(int j=7+arraysize+2; j<dimension-(2*triangle_number+12-1);j++)
		{
			for(int k=bitsize; k>0; k--)
			{
				//Integer.toString(sortedind[i][j],2);
				b = sortedind[i][j] - (int)Math.pow(2,k);
				if(b>0)
				{
					binaryno[i][j][bitsize-k]=1;
					sortedind[i][j] = b;
				}
				else if(b<0)
				binaryno[i][j][bitsize-k]=0;
			}
			//cout<<i<<"	"<<j<<"	"<<binaryno[i][j]<<endl;
		}
	//cout<<sortedind[i]<<endl;
	}
}
}