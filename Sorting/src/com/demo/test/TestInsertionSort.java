package com.demo.test;

import java.util.Arrays;

public class TestInsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {20,11,90,23,56,70};
		System.out.println("Before sorting");
		System.out.println(Arrays.toString(arr));
		insertionSort(arr);
		System.out.println("After sorting");
		System.out.println(Arrays.toString(arr));
	}

	private static void insertionSort(int[] arr) {
		// TODO Auto-generated method stub
		int n = arr.length;
		
		for(int i=1; i<n; i++) {
			int key = arr[i];
			int j = i-1;
			while(j>=0 && arr[j]>key ) {
				arr[j+1] = arr[j];
				j=j-1;
			}
			arr[j+1] = key;
		}
	}

}
