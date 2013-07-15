package Careercup.ch1;
import java.util.*;

public class setZeroes_1_7 {
	public static void main(String[] args) {
		int[][] a={{1,2,3,4},{5,6,7,8},{3,0,6,0}};
		int[][] b={{1,0,3,4},{5,0,7,8},{3,0,6,0}};
		int[][] c={{1,0},{1,0}};
		int[][] d={{0}};
		int[][] e={{1}};
		int[][] f={{1,0,3,4},{5,4,7,8},{3,1,6,2},{3,6,7,0}};
		int[][] g={};
		printMatrix(a);
		set0(a);
		printMatrix(a);
		printMatrix(b);
		set0(b);
		printMatrix(b);
		printMatrix(c);
		set0(c);
		printMatrix(c);
		printMatrix(d);
		set0(d);
		printMatrix(d);
		printMatrix(e);
		set0(e);
		printMatrix(e);
		printMatrix(f);
		set0(f);
		printMatrix(f);
		printMatrix(g);
		set0(g);
		printMatrix(g);
	}
	public static void printMatrix(int[][] matrix){
		int height=matrix.length;
		if(height==0) return;
		int length=matrix[0].length;

		for(int n=0;n<height;n++)
			for(int i=0;i<length;i++){
				System.out.printf("%-4d",matrix[n][i]);
				if(i==length-1) System.out.println("");
			}
		System.out.println("");
	}
	public static void set0(int[][] matrix){
		int height=matrix.length;
		if(height==0) return;
		int length=matrix[0].length;
		LinkedList<Integer> indexes=new LinkedList<Integer>();
		for(int n=0;n<height;n++)
			for(int i=0;i<length;i++)
				if(matrix[n][i]==0) indexes.add(Integer.valueOf(n*10+i));
		Iterator<Integer> it=indexes.iterator();
		while(it.hasNext()){
			int index= it.next().intValue();
			int y=index/10;
			int x=index%10;
			for(int n=0;n<length;n++)
				matrix[y][n]=0;
			for(int n=0;n<height;n++)
				matrix[n][x]=0;
		}
	}
}
