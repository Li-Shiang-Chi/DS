package other;

public class binarytree<T> {
	
	private node root;
	
	public binarytree(){
		root = null;
	}
	public binarytree(node root){
		this.root = root;
	}
	public binarytree(T data , binarytree<T> leftTree , binarytree<T> rightTree){
		root = new node(data);
		if(leftTree != null)
			root.left = leftTree.root;
		else
			root.left = null;
		if(rightTree != null)
			root.right = rightTree.root;
		else
			root.right = null;
		
	}
	public T getData(){
		return  (T) root.data;
	}
	// get left sub tree
	public binarytree<T> getLeftSubTree(){
		if(root != null && root.left != null){
			return new binarytree(root.left);
		}
		else{
			return null;
		}
	}
	// get right sub tree
	public binarytree<T> getRightSubTree(){
		if(root != null && root.right != null){
			return new binarytree(root.right);
		}
		else{
			return null;
		}
	}
	
	public class node<T>{
		T data;
		node<T> left;
		node<T> right;
		
		public node(T data){
			this.data = data;
			left = null;
			right = null;
		}
	}
}
