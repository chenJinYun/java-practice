package com.kim;

import java.util.Arrays;

public class Fun {
//	public static void main(String[] args) {
//		int[] arr = {3,67,9,20,12,344,6,9};
////		bubbleSort(arr);
//		selectSort(arr);
//		int tar=binarySearch(arr,344);
//		System.out.println(tar);
//	}

	public void bubbleSort(int[] arr) {
		int temp = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	public void selectSort(int[] arr) {
		int minIndex=0;
		int temp=0;
		for (int i = 0; i < arr.length-1; i++) {
			minIndex=i;
			for (int j = i+1; j < arr.length; j++) {
				if(arr[j]<=arr[minIndex]) {
					minIndex=j;
				}
			}
			if(i!=minIndex) {
				temp=arr[i];
				arr[i]=arr[minIndex];
				arr[minIndex]=temp;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	public int binarySearch(int[] arr, int data) {
		int pos=-1;
		int start=0;
		int end=arr.length-1;
		while(start<=end) {
			int mem=(start+end)/2;
			if(data>arr[mem]) {
				start=mem+1;
			} else if(data<arr[mem]) {
				end=mem-1;
			} else {
				pos=mem;
				break;
			}
		}
		return pos;
	}
}
