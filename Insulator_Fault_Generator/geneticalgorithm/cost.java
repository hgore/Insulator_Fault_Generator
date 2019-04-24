package geneticalgorithm;
import java.lang.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.lang.Thread;
import java.util.concurrent.ExecutorService;

public class cost {
void cost(int N, int bitsize, int dimension,int arraysize, int triangle_number,int defectnumber, int ind[][], double V[], int elementscalc, int epoch, double newkval) throws FileNotFoundException, InterruptedException	//is being evaluated on the interval [-1,1]
{
/*	double pi = 3.14159265359;
for(int i=0; i<N; i++)
			V[i] = ind[i][1]*Math.sin(4*pi*ind[i][0])+ 2*ind[i][0]*Math.cos(8*pi*ind[i][1]);
*/

	int nn = ( arraysize + 1 ) * ( arraysize + 1 );
	int p = nn - 1;
	writeinput writer = new writeinput();
	double temper[][] = new double[N][nn];
	double tempstore[][] = new double[N][nn];
	double real[] = new double[nn];
	double tempsum[] = new double[N];
	double realsum = 0;
	/*realbreak realdata = new realbreak();
	realdata.realbreak(N,dimension,arraysize,triangle_number,defectnumber,real);
	//this fills out real, which is just somethine to input into the fea code
	HeatTransfer realheat = new HeatTransfer();	//I don't think I need two of these, but I'm being safe
	realheat.HeatTransfer(real);	//this fills out realtemp*/
			//feaheat in the above folder will generate these lines for you to copy and paste, I 'm not making a new one every time. It's called "outvector" in the above folder.

real[0] = 94.32754481943579; 
real[1] = 78.00872538980585; 
real[2] = 67.2635322517469; 
real[3] = 58.20132293505703; 
real[4] = 42.029287233155436; 
real[5] = 26.518218048638257; 
real[6] = 11.37455292780453; 
real[7] = 95.64636424906563; 
real[8] = 80.59450881304981; 
real[9] = 66.42204034106234; 
real[10] = 57.55052862456433; 
real[11] = 41.69880397446323; 
real[12] = 26.334516016796524; 
real[13] = 11.230887806970802; 
real[14] = 97.068894550727; 
real[15] = 82.30090527226544; 
real[16] = 68.3096114807018; 
real[17] = 55.63886845880836; 
real[18] = 40.88088402333661; 
real[19] = 25.890154237113816; 
real[20] = 10.879966266485628; 
real[21] = 98.02740340931138; 
real[22] = 83.23060624458316; 
real[23] = 68.87663185067106; 
real[24] = 54.85861962375272; 
real[25] = 40.29570942296105; 
real[26] = 25.4652506418365; 
real[27] = 10.508668784744069; 
real[28] = 98.57950659735208; 
real[29] = 83.71748444608475; 
real[30] = 69.10769005364655; 
real[31] = 54.62326876257041; 
real[32] = 39.97808340291841; 
real[33] = 25.166470122527063; 
real[34] = 10.224207588817627; 
real[35] = 98.85565408792725; 
real[36] = 83.95213488875727; 
real[37] = 69.21337515525993; 
real[38] = 54.548681969963994; 
real[39] = 39.82688530361511; 
real[40] = 24.99833885653572; 
real[41] = 10.055221325472278; 
real[42] = 98.93883997684223; 
real[43] = 84.02202586575716; 
real[44] = 69.2449937086719; 
real[45] = 54.531198658410545; 
real[46] = 39.7824369850423; 
real[47] = 24.94477867452844; 
real[48] = 10.0;


	
for(int i=0;i<elementscalc;i++)
{
	writer.writeinput(N,dimension,arraysize,triangle_number,defectnumber,ind,i);
//	System.out.print("input_" + i);

}
	
	//parallelheat Paraheat = new parallelheat();
	//Paraheat.parallelheat(elementscalc);
/*	
for(int i=0;i<elementscalc;i++)
{
	final int a = i;
//	Runnable heat = new HeatTransfer(elementscalc);
	//HeatTransfer heat = new HeatTransfer();
//	heat.HeatTransfer(temper); //uses InputFile_i.txt, so writer above is making each one
	//new Thread(heat).start();
	Thread heat = new Thread(){
	public void run(){
		HeatTransfer hea = new HeatTransfer();
		hea.HeatTransfer(a);
	};
	};
	heat.start();
	heat.join();
}	*/
	
//ForkJoinPool pool = new ForkJoinPool();
	//pool.invoke(new parallelheat());
parallelheat paraheat = new parallelheat();
	paraheat.parallelheat(N,elementscalc,temper,tempstore,nn,epoch, newkval);
//for(int i=0;i<nn;i++)	
//	realsum += real[i]*real[i];
//I need to foce the rest of this program to wait for the previous loop to end.

/*for(int i=0;i<elementscalc;i++)
{	
	File outputFile = new File("outputfiles/outputfile_" + i + ".txt");
	Scanner output = new Scanner(outputFile);
	for(int j=0;j<nn;j++)
		temper[i][j] = (double) output.nextDouble();*/

/*	}
}
for(int i=0;i<elementscalc;i++)
{*/
	
/*	writer.writeinput(N,dimension,arraysize,triangle_number,defectnumber,ind,i);
	PrintWriter costcheck = new PrintWriter("bugcost");
PrintWriter costcheck = new PrintWriter("bugcost");
costcheck.print("On you to find the cost function it broke on\n and figure out which array broke it\n and why. Good luck.\n");
	
costcheck.print("elementscalc:	" + elementscalc + "\n");
costcheck.print(i + "\n");
costcheck.close();
	
	HeatTransfer heat = new HeatTransfer();
	heat.HeatTransfer(temper);	//uses InputFile.txt, so writer above is making each one
		//for parallelization, this whole for loop is the function
		//each i is a new instance on a new processor
		//need elementscalc processors then?
		//The max of that # is N
		//I bet I can call elementscalc processors, or something
*/	/*for(int j=0;j<nn;j++){
		System.out.print(temper[i][j]);
		tempstore[i][j] = temper[i][j];}
}*/
//	System.out.print("HELLO@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	for(int i=0;i<elementscalc;i++)
		for(int j=0;j<nn;j++)
			tempsum[i] += (tempstore[i][j]-real[j])*(tempstore[i][j]-real[j]);

	for(int i=0;i<elementscalc;i++)
		V[i] = Math.abs(tempsum[i]);
	//for(int i=0;i<N;i++)
	//	V[i]++;
			
}
}
