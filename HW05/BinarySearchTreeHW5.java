//KyleHix
//Copyright 2024


public class BinarySearchTreeHW5<T extends Comparable<T>>  {
	
	
	private class Node
	{
		T value;
		Node leftChild;
		Node rightChild;
		
		
		 Node(T newvalue)
		{
			this.value=newvalue;
			this.leftChild=null;
			this.rightChild=null;
		}

	}//End of Node Class
	
	//Instance Variable
	 private Node root; 
	 
	 //Constructor
	 public BinarySearchTreeHW5()
	 {
		 this.root=null;
	 }
	 
	 
	 
	 //Add value
	 public void AddValue(T newValue)//User called method
	 {
		 this.root=AddValue(this.root, newValue);
	 }
	 
	 private Node AddValue(Node subTreeRoot, T newValue)
	 {
		 if(subTreeRoot==null)
			 subTreeRoot= new Node(newValue);
		 
		
		 else if(newValue.compareTo(subTreeRoot.value)<=0)
			 subTreeRoot.leftChild= AddValue(subTreeRoot.leftChild, newValue);
			 
		
		 else 
			 subTreeRoot.rightChild= AddValue(subTreeRoot.rightChild, newValue);
		 
		 return subTreeRoot;
	 }
	 
	 
	 //Inorder
	 public String inorder()
	 {
		 return inorder(this.root);
		 
	 }
	 private String inorder(Node subTree)
	 {
		 if (subTree==null)
			 return " ";
		 return inorder(subTree.leftChild)+ subTree.value.toString()+ " "+ inorder(subTree.rightChild);
	 }
	 
	 
	 
	//Remove Method
	 
	 public void remove(T val)
	 {
		 this.root= remove(this.root, val);
	 }
	 private Node remove(Node subTree, T val)
	 {
		 if(subTree==null)
			 return null;

		 if(val.compareTo(subTree.value)<0)
			 subTree.leftChild= remove(subTree.leftChild, val);
		 else if(val.compareTo(subTree.value)>0)
			 subTree.rightChild=remove(subTree.rightChild, val);
		 else
		 {
			 if(subTree.leftChild==null)
			 {
				 return subTree.rightChild;
			 }
			 else if(subTree.rightChild==null)
				 return subTree.leftChild;
			 else 
			 {
				T smallValue= findSmallest(subTree.rightChild);
				 subTree.value=smallValue;
				 subTree.rightChild=remove(subTree.rightChild,smallValue);
			 }
		 }
		return subTree;
			 
	 }
	 
	 private T findSmallest(Node subTree) 
	 {
		 if(subTree==null)
			 return null;
		 else if(subTree.leftChild==null)
			 return subTree.value;
		 else
			 return findSmallest(subTree.leftChild);
	 }
	 
	 //Max	 
	public T maxChild()
	{
		Node temp=root;
		while(temp.rightChild!=null)
		{
			if(temp.rightChild==null)
			return temp.value;
		else
			temp=temp.rightChild;
		}
		return temp.value;
		
	}
	
	//Min
	public T minChild()
	{
		Node temp=root;
		while(temp.leftChild!=null)
		{
			if(temp.leftChild==null)
			return temp.value;
		else
			temp=temp.leftChild;
		}
		return temp.value;
	}
	
	//Descending Order

		 public String descendOrder()
		 {
			 return descendOrder(this.root);
			 
		 }
		 private String descendOrder(Node subTree)
		 {
			 if (subTree==null)
				 return " ";
			 return descendOrder(subTree.rightChild)+ subTree.value.toString()+ " "+ descendOrder(subTree.leftChild);
		 }
	
	
	
	 
	 
	 
	

}
