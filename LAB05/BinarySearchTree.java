//KyleHix
//Copyright 2024
//Lab05
//Pulled from in-class lecture
public class BinarySearchTree<T extends Comparable<T>> 
{
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
	 public BinarySearchTree()
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
	 
	 //PreOrder Traversal
	 public String preorder()
	 {
		 return preorder(this.root);
	 }
	 	
	 private String preorder(Node subTree)
	 {
		 if(subTree==null)
			 return "" ;
			 
		 
		 return subTree.value.toString()+" "+preorder(subTree.leftChild) + preorder(subTree.rightChild);
	 }
	 
	 
	 //PostOrder Traversal
	 public String postorder()
	 {
		 return postorder(this.root);
	 }
	 //recursive
	 private String postorder(Node subTree)
	 {
		 if(subTree==null)
			 return "";
		 
		 return postorder(subTree.leftChild) + postorder(subTree.rightChild) + subTree.value.toString()+" ";
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
	 
	 
	 //Search Method
	 public boolean search(T searchValue)
	 {
		 return search(this.root, searchValue);
	 }
	
	 private boolean search(Node subTree, T searchValue)
	 {
		 if(subTree==null)
			 return false;
		 if(searchValue.compareTo(subTree.value)==0)
			 return true;
		 else if (searchValue.compareTo(subTree.value)<0)
			 return search(subTree.leftChild, searchValue);
		 else 
			 return search(subTree.rightChild, searchValue);
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
	 
	
	
	
}
