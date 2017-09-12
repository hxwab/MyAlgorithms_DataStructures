package com.newcode;

public class Fibonacci {
	
	public static void main(String[] args) {
		new Fibonacci().test();
	}
	
	
	public void test(){
		System.out.println(Fibonacc(5));
		System.out.println(Fibonacci(5));
		System.out.println(Fibonacc2(5));	
	}
	
	/**
	 * 递归层数太多
	 * @param n
	 * @return
	 */
	public int Fibonacci(int n) {
		if(n<=0){
			return 0;
		}else if(n==1||n==2){
        	return 1;
        }
        else {
        	return Fibonacci(n-1)+Fibonacci(n-2);
        }
    }
	
	/**
	 * 采用动态规划
	 * @param n
	 * @return
	 */
	public int Fibonacc(int n) {
		
		int [] f = new int [n];
		if(n<=0){
			return 0;
		}
		 if(n==1||n==2){
        	return 1;
        }
        else {
            f[0]=1;
            f[1]=1;
            for(int i=2;i<n;i++){
            	f[i]=f[i-1]+f[i-2];
            }
            return f[n-1];

        }
    }
	
	
	public int Fibonacc2(int n){
		if(n<=0){
			return 0;
		}
		
		if(n==1||n==2){
			return 1;
		}
		int fa =1;
		int fb = 1;
		int fc = fa +fb;
		for(int i = 3;i<n;i++){
			fa = fb;
			fb =fc;
			fc = fa +fb;
		}
		return fc;
	}
	
	
	

}
