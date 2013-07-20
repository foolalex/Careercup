/*
Qustion:
Implement a method to perform basic string compression using the counts of repeated characters. 
For example, the string aabcccccaaa would become a2b1c5a3. 
If the "compressed" string would not become smaller than the original string, 
your method should return the original string.
 
Date:2013/07/12
@ author Tang Li
 
Test result:
a1
a1b1
a2b2c2d4
aabbccdd
 
aa
*/
package Careercup.ch1;

public class StrCompression_1_5 {
	public static void main(String[] args) {
		String a="abc";
		String b="a";
		String c="ab";
		String d="aabbccdddd";
		String e="aabbccdd";
		System.out.println(compression(a));
		System.out.println(compression(b));
		System.out.println(compression(c));
		System.out.println(compression(d));
		System.out.println(compression(e));
		System.out.println(compression(""));
		System.out.println(compression("aa"));		
	}
public static String compression(String str){
	if(str==null)  return str;
	StringBuilder res=new StringBuilder();
	for(int n=0;n<str.length();n++){
		int count=1;
		res.append(str.charAt(n));		
		for(int i=n+1;i<str.length();i++){
			if(str.charAt(n)!=str.charAt(i))
				break;
			count++;
			n++;
		}
		res.append(count);	
	}
	if(res.length()==str.length())
	return str;
	return res.toString();
}
}
