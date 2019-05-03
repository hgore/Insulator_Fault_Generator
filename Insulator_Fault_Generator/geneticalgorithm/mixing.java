package geneticalgorithm;
import java.lang.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;
public class mixing{    //Generates cildren of the first quarter elements, which were the best of the system.
void mixing(int N, int defectnumber, int dimension, int chromo[][], int arraysize, int triangle_number,int centerofmass) throws FileNotFoundException
{
 //Generates cildren of the first quarter elements, which were the best of the system.

int children[][] = new int[N/4][dimension];
generateinput genin = new generateinput();
	for(int i=0;i<N/8;i++){
		//plan is to take the first elements from Q1 and add them %triangle_number maybe randomly subtract? I'll have
		//to use a bunch of logic to do subtraction and keep it in my boundaries. 
		children[2*i][7+arraysize+2] = ((chromo[2*i][7+arraysize+2]+chromo[2*i+1][7+arraysize+2])%triangle_number)/2 +1;
	
		children[2*i+1][7+arraysize+2] = ((chromo[2*i+1][7+arraysize+2]+chromo[2*i][7+arraysize+2])%triangle_number)/2 +1;
	}

//		so we want to find a "center of mass" from which we generate new blobs
//		after some cost threshold choose several points randomly
//		maybe pick a few that are for sure connected, so one randomly and of the
//		ones in the blob only ones connected to it.
//	
//	This gives us a new starter (center of mass of size 1)
//	We can change this to be a group from the previous quarter and use that to get a CoM
//	this is certainly a nuanced issue though and it'll take some time.

          genin.generateinput(N/4,dimension,arraysize,triangle_number,defectnumber,children,centerofmass);

        for(int i=0; i<(N/4);i++){
                for(int j=7+arraysize+2;j<dimension;j++)//-(2*triangle_number+12-1);j++)
                {
//              System.out.print(children[i][j] + "\n");
                chromo[i+(N/4)][j] = children[i][j];
                }
        }


	
	

	//return binaryarray[N][dimension][bitsize];
	
	
}
}
