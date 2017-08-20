package com.algorithm;

/**
 * 打印回型数组
 * @author admin
 *
 */
public class PrintHuiArray {

	public static void main(String[] args) {
		int [][] arr = new int[3][4];
		//System.out.println(arr.length +"" +arr[0].length);
		
		PrintHuiArray p = new PrintHuiArray();
		p.init(arr);
		p.print(arr);
		
	}
	
	
	public void init(int [][] arr){
		int index=0;
		for(int i= 0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				arr[i][j]=++index;
			}
		}
	}
	
	public void print(int [][] arr){
		
		int x =0;
		int y = 0;
		int endx = arr.length;
		int endy = arr[0].length;
		int count =0;
		int total = endx*endy;
		int circle=0;
		
		while(count<total){
			
			
			if(x<endx-circle){
				for(y=circle;y<endy-circle;y++){
					if(count<total){
						count++;
						System.out.print(arr[x][y] + " ");
					}else {
						break;
					}
				}
				System.out.println();
				y--;
			}
			
			
			if(y<endy){
				for(x=circle+1;x<endx-circle;x++){
					if(count<total){
						System.out.print(arr[x][y] +" ");
						count++;
					}else{
						break;
					}
				}
				System.out.println();
				x--;
			}
			
			
			for(y=endy-circle-2;y>=circle;y--){
				if(count<total){
					System.out.print(arr[x][y]+" ");
					count++;
				}else{
				break;
			}
		}
			y++;
			System.out.println();
			
			
		for(x=endx-circle-2;x>circle;x--){
			if(count<total){
				System.out.print(arr[x][y]+" ");
				count++;
			}else{
			break;
			}
		}
		x++;
		System.out.println();
		circle++;
	}
	
 }
	
}
