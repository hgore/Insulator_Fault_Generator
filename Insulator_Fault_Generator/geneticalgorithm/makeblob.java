package geneticalgorithm;
import java.lang.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
public class makeblob {
	void makeblob(int input[], int n, int arraysize, int defectnumber, int triangle_number)
{

//do ... while here to check repeats at end and redo those elements
Random rand = new Random();
int choice[] = new int[defectnumber];
//input[7+arraysize+2] = rand.nextInt(triangle_number)+1;
//System.out.print("\n" + input[7+arraysize+2] + " input_0 \n");
	//rand number [1,23)
		for(int k=1;k<defectnumber;k++){
					boolean check = false;
			do{
				check = false;		
			int j = rand.nextInt(k)+1;
			if( (k-j) < 0)
				j=1;
				//System.out.print(j + "j's value \n");
//System.out.print("\n" + j + " j_" + k + "\n");
	//			do{
				choice[k] = rand.nextInt(3) +1;
				choice[0] = choice[1];
	//System.out.print(choice[0] + " " + choice[k] + " choice[" + k + "]\n");
				if(choice[k] == 1){
					input[7+arraysize+2+k] = input[7+arraysize+2+(k-j)] + 1;
					if(input[7+arraysize+2+k] == triangle_number+1)
						input[7+arraysize+2+k] = triangle_number;	//prevents wrap-around
					else if(input[7+arraysize+2+k]%(2*arraysize) == 1)
						input[7+arraysize+2+k] = input[7+arraysize+2+k] -1;
				}
				else if(choice[k] == 2){
					input[7+arraysize+2+k] = input[7+arraysize+2+(k-j)] - 1;
					if(input[7+arraysize+2+k] == 0)
						input[7+arraysize+2+k] = 1;			//prevents wrap-around
					else if(input[7+arraysize+2+k]%(2*arraysize) == 0)
						input[7+arraysize+2+k] = input[7+arraysize+2+k] +1;
				}
				else if(choice[k] == 3 && (input[7+arraysize+2+(k-j)])%2 == 0){
						 input[7+arraysize+2+k] = input[7+arraysize+2+(k-j)] - (2*arraysize+1);
					if(input[7+arraysize+2+k]<1)
						{
						input[7+arraysize+2+k] = input[7+arraysize+2+k]+(2*arraysize+1);
					//	continue;	//prevents wrap-around
						}
				}
				else if(choice[k] == 3 && (input[7+arraysize+2+(k-j)])%2 == 1){
					input[7+arraysize+2+k] = (input[7+arraysize+2+(k-j)] + (2*arraysize)+1);
					if(input[7+arraysize+2+k] > triangle_number)
					{
						input[7+arraysize+2+k] = input[7+arraysize+2+k] -(2*arraysize+1);
					//	continue;	//prevents wrap-around
					}
				}
//System.out.print("\n");
	//		for(int w =0; w<k+1;w++)	
	//	System.out.print(input[7+arraysize+2+(k-w)] + "  \n"); //debug
	//	System.out.print(input[7+arraysize+2+(k-j)] + " previous " + input[7+arraysize+2+k] + " current \n"); //debug
	//	System.out.print( (choice[k] == choice[k-j] && k>1) + " while 1 \n");
			          //    System.out.print(k + " \n");
	//			}
	//			while(choice[k] == choice[k-j] && k>1);
	//	for(int w=0;w<k+1;w++)		//check this with w=-1 Make sure the initiator isn't being overwritten
        //       System.out.print(input[7+arraysize+2+(k-w)] + "  \n"); //debug
        //        System.out.print(input[7+arraysize+2+(k-j)] + " previous " + input[7+arraysize+2+k] + " current \n"); //debug
        //        System.out.print( (choice[k] == choice[k-j] && k>1) + " while 1 \n");


//				System.out.print(input[7+arraysize+2+k] + " input[" + k + "] \n");
				for(int m=1;m<k+1 &&k>1 ;m++){
//		System.out.print(m + " m \n");
	check = false;
//	System.out.print(input[7+arraysize+2+k] + " " + input[7+arraysize+2+(k-m)] + "\n");
					if(input[7+arraysize+2+k] == input[7+arraysize+2+(k-m)]){
						check = true;
//				System.out.print(m + "m[" + k + "] " + check + " \n");
						m = k+2;
					}
					else{
//		System.out.println("\n\n\n\n\n\n\n\n"+"FUCK"+"\n\n\n\n\n\n\n\n");			
	check = false;
//						System.out.print(m + "m[" + k + "] " + check + " \n");
					}
				}
		                               //            System.out.print("hi \n");
//	System.out.print((check && k>1) +" while 2 \n");	
			}
			while(check && k>1);
                                           //  System.out.print(k +  "for end \n");

		//	while(input[7+arraysize+2+k] != input[7+arraysize+2+(k-m)] );
		} //close for loop, k++ here, before this brace if while is false
//	System.out.print("DONE");
	}
}
