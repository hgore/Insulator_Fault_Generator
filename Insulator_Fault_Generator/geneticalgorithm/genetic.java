package geneticalgorithm;
import java.lang.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;
import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.ExecutorService;
public class genetic {
	public static void main(String argv[]) throws FileNotFoundException, InterruptedException
	{
		 cost acost = new cost();	//takes in an independant and dependant variable and calculates the dependant variable
		 tournament atournament = new tournament();	//pairwise comparison to find smallest elements of a[] with respect to c[]
		 convertbinary aconvertbinary = new convertbinary(); //takes in the sorted array of ind. vars. and converts them into a binary matrix
		 rdmarray ardmarray = new rdmarray(); //randomizes the elements of y[][] and s[] the same way, and only the array elements between miny and maxy (ie elements 3-7, or 0-N)
		 mixing amixing = new mixing(); //Generates cildren of the first quarter elements, which were the best of the system.
		 mutate amutate = new mutate();	//swaps the first half of binarry's binary number with the second half of the next element's and vice versa. Creates the 3rd quarter of new imputs.
		 randquarter arandquarter = new randquarter();	//makes the 4th quarter of your new imputs random so that you always check the whole domain and don't get trapped in a local minimum.
		 debinary adebinary = new debinary();	//converts the binary array to a decimal array.
	generateinput genin = new generateinput();
	writeinput writein = new writeinput();
	    PrintWriter allcosts = new PrintWriter("allcosts");
		int N = 64;					//size of gene pool
		int bitsize = 8;			//size of binary numbers (max is sizeof(double)
		int arraysize = 6;			//bitsize and arraysize have a relationship of
									//2*arraysize^2 = bitsize^2 only integer soln's
									//but bitsize needs to be a power of 2, do "arraysize = 4k" "arraysize = n"
									//2(4k)^2 = arraysize^2
									//soln's are k={5,7,9,...},n={1,2,4,16,...}
		int triangle_number = (2*arraysize*arraysize);
		int defectnumber = 8;//defectno.nextInt(triangle_number);
		int dimension = (7+arraysize+1+3*defectnumber);//+2*triangle_number)+12;
		long timestart;
		long timeend;
		int xy[][] = new int[N][dimension];	//xy[0][0] = x0, and xy[0][1] = y0
		double costs[] = new double[N];
		int binaryrep[][][] = new int[N][dimension][bitsize];
		
		int maxepoch = 10;

		timestart = System.currentTimeMillis();
	double newkval = 2; //I am having an issue with i/o in the generateinput() and writeinput() functions, so this replaces the new value that the defect takes. This should be the same for each one anyway so here's a workaround.
    long timeBFi = System.nanoTime();
//Random rand = new Random();
for(int i=0;i<N;i++){
	Random rand = new Random();
	xy[i][7+arraysize+2] = rand.nextInt(triangle_number) +1;
//	System.out.print(xy[i][7+arraysize+2] + ":element " + i + ":i \n" );
	}

	genin.generateinput(N,dimension,arraysize,triangle_number,defectnumber,xy,1);//"0" is the center of mass, which is the bonus positions used in later calculations.
PrintWriter checkfirst = new PrintWriter("checkfolder/firstgene/firstgen_0");
        for(int i=0;i<N;i++){
		for(int j=7+arraysize+2;j<dimension;j++)
			checkfirst.print(xy[i][j] + "\n");
	checkfirst.print("\n");
	}
//checkfirst.flush();
checkfirst.close();
	System.out.print(triangle_number + "\n");
		
		for(int epoch=0;epoch<maxepoch;epoch++)
		{
			long timestartin = System.nanoTime();
	PrintWriter checkfile = new PrintWriter("checkfolder/genes/checkfile_" + epoch);
	PrintWriter outfolder = new PrintWriter("checkfolder/costs/costcheck_" + epoch);
//	PrintWriter afterrdm = new PrintWriter("checkfolder/rdm/afterrdm_" + epoch);
//	PrintWriter nordm = new PrintWriter("checkfolder/nordm/checkgene_" + epoch);
	PrintWriter postrdmcost = new PrintWriter("checkfolder/postrdmcosts/rdmcostcheck_" + epoch);
			acost.cost(N,bitsize,dimension,arraysize,triangle_number,defectnumber,xy,costs, N, epoch,newkval);
        for(int i=0;i<N;i++)
                outfolder.print(costs[i] + "\n");
        outfolder.flush();        
	outfolder.close();
			atournament.tournament(N, bitsize, dimension, arraysize, triangle_number, xy,costs);		
			atournament.tournament(N/2, bitsize, dimension, arraysize, triangle_number, xy,costs);		


//newsort xy and costs, replacing tournament.
/*		int tempxy[] = new int[dimension];
		double tempcosts;
//	for(int l=0;l<N;l++){		
		for(int i=1;i<costs.length;i++){
			for(int j=i;j>0;j--){
				for(int k=i;k<dimension;k++)
					if(costs[j] < costs[j-1]){
					tempcosts = costs[j];
                                        tempxy[k] = xy[j][k];

					costs[j] = costs[j-1];
                                        xy[j][k] = xy[j-1][k];

					costs[j-1] = tempcosts;
                                        xy[j-1][k] = tempxy[k];

//					tempxy[k] = xy[j][k];
//					xy[j][k] = xy[j-1][k];
//					xy[j-1][k] = tempxy[k];
					}
				}
			}*/
//	}
//for(int i=0;i<N;i++)
//System.out.print(costs[i]+"\n");


//			makeblob blob = new makeblob();
//		for(int j=0;j<dimension;j++){
//			if(xy[i][j]>72 && xy[i][j]<100){
//			System.out.print(xy[i][j] + "\n");}}


			ardmarray.rdmarray(N, bitsize, dimension, binaryrep,xy,0,(N/4));
//			//makes a random input so it needs to run generateinput

        for(int i=0;i<N;i++)
                postrdmcost.print(costs[i] + "\n");
        postrdmcost.flush();
        postrdmcost.close();



			amixing.mixing(N, defectnumber, dimension, xy, arraysize, triangle_number,1);			
			amutate.mutate(N,dimension,arraysize,triangle_number,defectnumber,bitsize,xy,1,epoch,maxepoch);
					//gen new rand array
			arandquarter.randquarter(N, bitsize, dimension, arraysize, triangle_number, defectnumber, xy,1);

//	for(int i = 0; i<N;i++)
//		for(int j=0;j<dimension;j++){
//			if(xy[i][j]>72 && xy[i][j]<100){
//			System.out.print(xy[i][j] + "\n");}}



			long timeendin = System.nanoTime();
			double epochtime = (double) ( timeendin - timestartin ) / 1000000000;
	System.out.printf("	\n");
				System.out.print(epochtime/60 + "min and " + epochtime%60 + " sec for epoch " + epoch);

				System.out.printf("	\n\n");


	//Something is happening that's not keeping all the winners.
	//I expect to have a lot of ~ 150 costs at the end,
	//and get 700 -> 100
	//Look into saving the first quarter somehow?
	//It's really strange that it's not working.
	//Also see if you can make sure each gene does not
	//contain any repeated triangles.

	//Really i just worry that I'll get the right one, 
	//and it'll be deleted.
		}
 //------------------------END of epoch---------------------------------
	acost.cost(N,bitsize,dimension,arraysize,triangle_number,defectnumber,xy,costs,N, 9991,newkval);

for(int i=0;i<N;i++){
	allcosts.print(costs[i]);
	if(i == N/4-1 || i == N/2-1 || i == 3*N/4-1 || i == N-1)
	allcosts.print("	@@@@@__" + (i+1) + "__@@@@@\n");
	else
	allcosts.print("\n");
}
allcosts.print("\n");
for(int i=0;i<N;i++)
	for(int j=0;j<dimension;j++)
		allcosts.print(xy[i][j] + "\n");

allcosts.print("\n");
allcosts.flush();
allcosts.close();
long lastmintimestart = System.nanoTime();
for(int i=0;i<(Math.log(N)/Math.log(2));i++)
{
	long lastmintimestartin = System.nanoTime();
	atournament.tournament(N, bitsize, dimension, arraysize, triangle_number, xy, costs);
	acost.cost(N,bitsize,dimension,arraysize,triangle_number,defectnumber,xy,costs,N/(i+1), (9992+i),newkval);
PrintWriter enddata = new PrintWriter("endgene_" + i);
for(int j=0;j<N;j++){
	enddata.print(costs[j] +"\n");
	for(int k=0;k<dimension;k++)
	enddata.print(xy[j][k] + "\n");
	}
enddata.flush();
enddata.close();
	long lastmintimeendin = System.nanoTime();
	double lastmintimein = (double) ( lastmintimeendin - lastmintimestartin ) / 1000000000;
	System.out.printf("	\n");
	System.out.print(lastmintimein/60 + "min and " + lastmintimein%60 + " sec for last minimization loop" + i);

	System.out.printf("	\n\n");

}
		long lastmintimeend = System.nanoTime();
		double lastmintime = (double) ( lastmintimeend - lastmintimestart ) / 1000000000;
	System.out.printf("	\n");
			System.out.print(lastmintime/60 + "min and " + lastmintime%60 + " sec for last minimization ");

			System.out.printf("	\n\n");
	System.out.printf("\n	%.10f", costs[0]);
PrintWriter lastcost = new PrintWriter("LASTCOST");
lastcost.printf("%.10f",costs[0]);
lastcost.flush();
lastcost.close();
PrintWriter lastin = new PrintWriter("lastinput.txt");
for(int i=0; i<dimension;i++)
	lastin.print(xy[0][i] + "\n");
lastin.flush();
lastin.close();

writein.writeinput(N,dimension,arraysize,triangle_number,defectnumber,xy,0);
	    long timeBFf = System.nanoTime();
		System.out.printf("	\n\n");
		timeend = System.currentTimeMillis();
		double boundaryFluxTime = (double) ( timeBFf - timeBFi ) / 1000000000;
		System.out.print(boundaryFluxTime/60 + "min and " + boundaryFluxTime%60 + " sec");
		System.out.printf("	\n\n");
	
}
}
