package other;

import java.util.LinkedList;
import java.util.Queue;



public class binaryTreeTraversal {

	/************Depth First Search*************/
	public void prefix(treenode root) // root -> left -> right
	{
		if(root==null){return;}
		System.out.print(root.value+" ");
		prefix(root.left);
		prefix(root.right);
	}
	public void postfix(treenode root) // left -> right -> root
	{
		if(root==null){return;}
		postfix(root.left);
		postfix(root.right);
		System.out.print(root.value+" ");
		
	}
	public void infix(treenode root) // left -> root -> right
	{
		if(root==null){return;}
		infix(root.left);
		System.out.print(root.value+" ");
		infix(root.right);
	}
	
	
	/**********Bread First Search***************/
	public void levelOrderTraverse(treenode root)
	{
		Queue<treenode> queue = new LinkedList<treenode>();
		if(root == null){return;}
		queue.add(root);
		
		while(!queue.isEmpty()){
			treenode temp = queue.remove();
			System.out.print(temp.value + " ");
			if(temp.left != null)
			{
				queue.add(temp.left);
			}
			if(temp.right != null)
			{
				queue.add(temp.right);
			}
			
		}		
	}
}


