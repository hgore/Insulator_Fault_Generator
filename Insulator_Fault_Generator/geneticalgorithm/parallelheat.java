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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class parallelheat {	
public void parallelheat(int N, int elementscalc, double temper[][], double tempstore[][], int nn, int epoch, double newkval) throws FileNotFoundException, InterruptedException
{
/*this.elementscalc = elementscalc;
}

protected void compute(){
	if(arraysize <10)
		computeDirectly();
	else{
	HeatTransfer heat = new HeatTransfer();
	heat.HeatTransfer()
	
}
}*/
HeatTransfer heat = new HeatTransfer();
Thread[] threads = new Thread[N];
	for(int i=0;i<elementscalc;i++){
			final int p = i;
			final int q = epoch;
			final double kval = newkval;
		threads[i] = new Thread(new Runnable(){
			public void run(){
				try{
//long heattimeri = System.nanoTime();
				heat.HeatTransfer(temper, p, kval);
//	PrintWriter threadtime = new PrintWriter("checkfolder/time/threadime_" + q + "_" + p +  ".txt");
//	long heattimerf = System.nanoTime();
//	double heattime = (double) (heattimerf - heattimeri)/1000000000;
//	threadtime.print("Heat " + p + " took " + heattime + " seconds. \n");
//					System.out.print("HEATCALCULATED" + p + "\n");
				//for(int i=0;i<elementscalc;i++)
				//{	
//				File outputFile = new File("outputfiles/outputfile_" + p + ".txt");
//				Scanner output = new Scanner(outputFile);
//				for(int j=0;j<nn;j++)
//					temper[p][j] = (double) output.nextDouble();
				for(int j=0;j<nn;j++){
//					System.out.print(temper[p][j]);
					tempstore[p][j] = temper[p][j];}
				//}
				}
				catch(FileNotFoundException e){
					e.printStackTrace();
				}
		}});
		threads[i].start();
	threads[i].join();
//	System.out.print("thread joined?" + i + "\n");
	}
	//for(int i=0;i<elementscalc;i++){
//for(Thread thread : threads){
//}
	
	
//	void parallelheat() throws InterruptedException, ExecutionException,FileNotFoundException {
		/*Callable<HeatTransfer> tasks = new ArrayList<>();
		//HeatTransfer heat = new HeatTransfer();
		for(int i=0;i<elementscalc;i++){
			tasks.add(new HeatTransfer(i));
		}
		int numthreads = N;
	//	List<Future<HeatTransfer>> results = executor.invokeAll(tasks);
		for(Future<HeatTransfer> result : results){
		Future<Void> future = executor.submit(new tasks<HeatTransfer>(i));
			HeatTransfer heat = heat.get();
		}
	executor.shutdown();*/
	}}
