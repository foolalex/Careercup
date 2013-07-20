/*
Qustion:
Given an image represented by an NxN matrix, 
where each pixel in the image is 4 bytes, 
write a method to rotate the image by 90 degrees. 
Can you do this in place?
 
Date:2013/07/12
@author Tang Li
 
Test result:
13  9   5   1   
14  10  6   2   
15  11  7   3   
16  12  8   4   
 
3   1   
4   2  
*/
package Careercup.ch1;

public class RotateImage_1_6 {
	public static void main(String[] args) {
		int[][] a=
			{
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
			};
		int[][] b={	{1,2},	{3,4}	};
		rotate(a);
		rotate(b);
		printMatrix(a);
		printMatrix(b);
	}
	public static void printMatrix(int[][] matrix){
		for(int n=0;n<matrix.length;n++)
			for(int i=0;i<matrix.length;i++){
				System.out.printf("%-4d",matrix[n][i]);
				if(i==matrix.length-1) System.out.println("");
			}
		System.out.println("");
	}
	public static void rotate(int[][] matrix){
		int len=matrix.length;
		int top;
		for(int n=0;n<len/2;n++){
			int last=len-1-n;
			int first=n;
			for(int i=n;i<last;i++){
				int offset=i-n;
				top=matrix[first][i]; 
				//left->top
				matrix[first][i]=matrix[last-offset][first]; 
				//bottom->left
				matrix[last-offset][first]=matrix[last][last-offset]; 
				//right->bottom
				matrix[last][last-offset]=matrix[i][last]; 
				//top->right
				matrix[i][last]=top; 				
			}
		}
	}
}
