package com.sb.demo;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,6,7,8,9,10};
		for(int i=a.length-1;i>0;i--) {
			a[i-1]=a[i]+a[i-1];
			a[i]=-1;
		}
		System.out.println(Arrays.toString(a));

	}

}
