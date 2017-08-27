package com.datastruct.sort;

import javax.xml.ws.Dispatch;

public class Test {
	
	public static void main(String[] args) {
		
		int [] array = new int[]{3,5, 2,4 ,1};
		Sort sort ;
		/*sort = new BubbleSort();
		sort = new SelectSort();
		sort = new InsertSort()*/;
		//sort = new QuickSort();
		/*sort = new MergeSort();
		sort = new Buket();*/
		//sort.sort(array);
		
		Test test = new Test();
		test.bubbleSort(new int[]{1,3,2,5,4});
		//test.quickSort(array, 0, array.length-1);
		
		
		test.mergeSort(array, 0,  array.length-1);
		
		test.play(array);
	}
	
	
	/**
	 * 轮询，比较相邻的两个元素，把较大的交换到末尾
	 * 优化，加一个交换标志位，若在整个过程没有出现交换，说明已经有序，此时可以不用遍历和比较
	 * @param a
	 */
	public void bubbleSort(int []a ){
		
		int cmp = 0;
		int swap = 0;
		
		for(int i =0;i<a.length;i++){
			boolean isSorted = true;
			for(int j=1;j<a.length-i;j++){
				cmp++;
				if(a[j-1]>a[j]){
					swap(a, j-1, j);
					isSorted = false;
					swap++;
				}
			}
			if(isSorted){
				break;
			}
		}
		play(a);
		System.out.println(cmp+" "+swap);
	}
	
	
	/**
	 * 快速排序。以某一个元素为参照物，将大于它的排到右边，小于它的排到左边。然后将该参照元素插入到合适的位置，以该位置将数组分为两部分，分别做以上操作。
	 * @param a
	 * @param left
	 * @param right
	 */
	public void quickSort(int [] a ,int left , int right){
		
		if(left<=right){
			int part  = partitionInt(a, left, right);
			quickSort(a, left, part-1);
			quickSort(a, part+1, right);
		}
	}
	
	public int partitionInt(int [] a , int left , int right){
		if(a.length<=right||a.length<=left||right<left){
			return -1;
		}
		
		int base = a[right];
		int start = left;
		int end = right -1;
		
		while(start<=end&&start>=0){
			
			while(start<=end&&a[start]<base){
				start++;
			}
			
			while(end>=start&&a[end]>base){
				end--;
			}
			if(start<=end&&start>=0){
				swap(a, start, end);
			}
		}
		swap(a, start, right);
		return start;
		
	}
	
	public void mergeSort(int[] a , int left, int right){
		if(left<right){
			int mid = (right+left)/2;
			mergeSort(a, left, mid);
			mergeSort(a, mid+1, right);
			merge(a, left, mid, right);
		}
		
	}
	
	/**
	 * 将两个有序的数组拼接为一个有序的数组
	 * @param a
	 * @param left
	 * @param midd
	 * @param right
	 */
	public void merge(int [] a , int left , int midd , int right){
		
		int start = left;
		int mid  = midd+1;
		int  end = right;
		int [] temp = new int[right-left+1];
		int index =0;
		
		//根据两个数组元素的大小选择拼接的元素
		while(start<= midd&&mid<=end){
			if(a[start]<a[mid]){
				temp[index++]=a[start++];
			}else{
				temp[index++]=a[mid++];
			}
		}
		
		//若前面有还有未拼接的元素，直接加上去
		while(start<=midd){
			temp[index++] = a[start++];
		}
		//若后面还有未拼接的元素，直接加上去
		while(mid<=right){
			temp[index++] = a[mid++];
		}
		//以上两种情况只会存在一种，不可能同时存在两种
		
		for(int i = 0;i<temp.length;i++){
			a[i+left]= temp[i];
		}
		
	}
	
	
	
	
	public void swap(int [] a , int i ,int j){
		if(a==null||a.length==0||a.length<=i||a.length<=j){
			return;
		}
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public void play(int[] a){
		for(int t :a){
			System.out.print(t+" ");
		}
		System.out.println();
	}

}
