package other;

public class binarysearchtree {

	treenode root;
	int count = 0;
	public binarysearchtree(){
	}
	
	public boolean isBST(treenode root){
		if (root == null) 
		    return true; 
		     
		  /* false if left is > than node */
		  if (root.left != null && root.left.value > root.value) 
		    return false; 
		     
		  /* false if right is < than node */
		  if (root.right != null && root.right.value < root.value) 
		    return false; 
		   
		  /* false if, recursively, the left or right is not a BST */
		  if (!isBST(root.left) || !isBST(root.right)) 
		    return false; 
		     
		  /* passing all that, it's a BST */
		  return true; 
		
		
		
	}
	public int getDepth(treenode root){
		if(root == null){return 0;}
		else
		{
			int leftDepth = getDepth(root.left);
			int rightDepth = getDepth(root.right);
			
			if(leftDepth > rightDepth){
				return leftDepth+=1;
			}
			else{
				return rightDepth+=1;
			}
		}
	}
	public void add(int value)
	{
		treenode node = new treenode(value);
		if(count==0){root = node;count++;}
		else
		{
			treenode temp = root;
			while(true)
			{
				if(node.value < temp.value)
				{
					if(temp.left==null){
						temp.left = node;
						break;
					}
					else{
						temp = temp.left;
					}
				}
				else if(node.value > temp.value)
				{
					if(temp.right==null){
						temp.right = node;
						break;
					}
					else
						temp = temp.right;
				}
			}
			count++;
		}
	}
}
