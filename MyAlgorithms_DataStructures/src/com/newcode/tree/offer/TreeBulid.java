package com.newcode.tree.offer;


public class TreeBulid {

	/**
	 * 
	 * @param sequence
	 * @param start
	 * @param end
	 * @return
	 */
	public boolean verifyBST(int [] sequence , int start ,int end){
		
		if(sequence==null||start>end) return false;
		int root = sequence[end];
	
		//BST左子树的节点小于跟节点
		int i=0;//左节点个数
		for(;i<end;i++){
			if(sequence[i]>root){
				break;
			}
		}
		
		//BST右子树节点大于跟节点
		int j=i;
		for(;j<end;j++){
			if(sequence[j]<root)
				return false;
		}
		
		//判断左子树是不是BST
		boolean left = true;
		if(i>0){
			left = verifyBST(sequence,  start, i);
		}
		
		/**
		 * 判断右子树是不是BST
		 */
		boolean right =true;
		if(i<end){
			right =verifyBST(sequence, i+1, end-1);
		}
		
		return left&&right;
		
	}
	
	public void mirror(Node root){
		
		if(root==null) return ;
		
		if(root.right==null&&root.left==null) return ;
		
		Node tmp = root.left;
		 root.left = root.right;
		 root.right =tmp;
		 
		 mirror(root.left);
		 mirror(root.right);
	}
	
	
	/**
	 * 根据先序遍历和中序遍历重建二叉树
	 * @param preOrder
	 * @param preStartIndex
	 * @param preEndIndex
	 * @param inOrder
	 * @param inStartIndex
	 * @param inEndIndex
	 * @return
	 */
	public Node constructCore(int [] preOrder ,int preStartIndex,int preEndIndex,
			                  int [] inOrder,int inStartIndex,int inEndIndex){
		
		
		int rootValue =preOrder[preStartIndex];
		Node root = new Node(rootValue);
		
		//只有一个元素
		if(preStartIndex==preEndIndex){
			if(inStartIndex==inEndIndex){
				return root;
			}
		}else {
			new Throwable("invalid input");
		}
		
		
		//中序遍历中找到根节点的值
		int rootInOrderIndex =inStartIndex;
		while(rootInOrderIndex<=inEndIndex&&inOrder[rootInOrderIndex]!=rootValue)
			rootInOrderIndex++;
		
		if(inOrder[rootInOrderIndex]!=rootValue){
			new Throwable("invalid input");
		}
		
		int leftLength = rootInOrderIndex - inStartIndex;
		int leftPreOrderEnd = preStartIndex +leftLength;
		
		//有左子树
		if(leftLength>0){
			root.left = constructCore(preOrder, preStartIndex+1, leftPreOrderEnd, inOrder, inStartIndex, rootInOrderIndex-1);
		}
		
		//如果有右子树
		if(leftLength<preEndIndex - preStartIndex){
			root.right =constructCore(preOrder, leftPreOrderEnd+1, preEndIndex, inOrder, rootInOrderIndex+1, inEndIndex);
		}
		
		return root;
	}
	
	
	
	static class Node  {
		 int value;
		 Node left ;
		 Node right ;
		 public Node(int value) {
			 this.value =value;
			 left = null;
			 right = null;
		}
		
	}
}
