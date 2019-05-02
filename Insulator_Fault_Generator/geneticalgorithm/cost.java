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

/*        real[0] = 85.88116297377292;
        real[1] = 76.17504909136568;
        real[2] = 67.07185628038243;
        real[3] = 58.605444791695554;
        real[4] = 42.63585148762085;
        real[5] = 27.13829851561587;
        real[6] = 11.986728823092252;
        real[7] = 90.29339073858728;
        real[8] = 75.8735885556537;
        real[9] = 66.75346561923426;
        real[10] = 58.284368233929214;
        real[11] = 42.39983132158598;
        real[12] = 26.965306875875186;
        real[13] = 11.83515913056863;
        real[14] = 93.54522286926873;
        real[15] = 79.09111117413501;
        real[16] = 65.78404940697172;
        real[17] = 57.26085310398495;
        real[18] = 41.71379868891868;
        real[19] = 26.48793853573025;
        real[20] = 11.423293947431876;
        real[21] = 95.70527839021752;
        real[22] = 81.16158386464588;
        real[23] = 67.58454782125682;
        real[24] = 55.2377791801025;
        real[25] = 40.706571794373566;
        real[26] = 25.84935463069526;
        real[27] = 10.882139587698376;
        real[28] = 96.95272296230947;
        real[29] = 82.2653980729742;
        real[30] = 68.15477883330718;
        real[31] = 54.387607038853446;
        real[32] = 40.025354677777806;
        real[33] = 25.32076860497884;
        real[34] = 10.406555141971118;
        real[35] = 97.57481731307189;
        real[36] = 82.79250663163428;
        real[37] = 68.38156240014428;
        real[38] = 54.13251546422629;
        real[39] = 39.68647127290538;
        real[40] = 25.001809969471193;
        real[41] = 10.10254377022838;
        real[42] = 97.76153302670939;
        real[43] = 82.94824874034683;
        real[44] = 68.44644867140934;
        real[45] = 54.07442114500203;
        real[46] = 39.586204980146235;
        real[47] = 24.897456229772153;
        real[48] = 10.0;
*/

real[0] = 94.2162119313418;
real[1] = 79.42641745071424;
real[2] = 65.06954921701514;
real[3] = 51.070953719128106;
real[4] = 36.92013967796984;
real[5] = 22.43423883762573;
real[6] = 7.601958597669764;
real[7] = 94.00600641196927;
real[8] = 79.20995432725;
real[9] = 64.89041284910911;
real[10] = 51.14706299076372;
real[11] = 37.08768307756277;
real[12] = 22.607428537431666;
real[13] = 7.769678357713785;
real[14] = 93.3879050620352;
real[15] = 78.5169805972074;
real[16] = 64.13508486140759;
real[17] = 51.53920231725491;
real[18] = 37.67610110408583;
real[19] = 23.13811387682438;
real[20] = 8.261897758322005;
real[21] = 92.51165264175664;
real[22] = 77.33497813813679;
real[23] = 61.59374368205896;
real[24] = 53.198560312762496;
real[25] = 38.939405144701254;
real[26] = 24.00702810745803;
real[27] = 9.00168492192547;
real[28] = 91.98874922871768;
real[29] = 76.71753563152411;
real[30] = 60.59893775083662;
real[31] = 52.84981888275286;
real[32] = 40.87593105449865;
real[33] = 24.94890848638102;
real[34] = 9.730785714463822;
real[35] = 92.00827301006572;
real[36] = 76.94747740840539;
real[37] = 61.773598012628895;
real[38] = 51.936291281611986;
real[39] = 40.77864779003236;
real[40] = 25.181889069103566;
real[41] = 10.023640963167749;
real[42] = 92.14938799473427;
real[43] = 77.29050297940279;
real[44] = 63.117669106066124;
real[45] = 51.63297741960389;
real[46] = 39.54165800912544;
real[47] = 24.976359036833145;
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
