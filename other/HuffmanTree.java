package other;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.*;

public class HuffmanTree {
	//Huff node
	public static class HuffData implements Serializable
	{
		private double weight;
		private Character symbol;
		
		public HuffData(double weight , Character symbol){
			this.weight = weight;
			this.symbol = symbol;
		}
	}
	
	private binarytree<HuffData> huffTree;
	
	//comparator
	private static class CompareHuffmanTrees implements Comparator<binarytree<HuffData>>
	{
		@Override
		public int compare(binarytree<HuffData> treeLeft, binarytree<HuffData> treeRight) {
			double wLeft = treeLeft.getData().weight;
			double wRight = treeRight.getData().weight;
			return Double.compare(wLeft, wRight);
		}
		
	}
	public void buildTree(HuffData[] symbols)
	{
		//use priorityqueue to sorting
		Queue<binarytree<HuffData>> theQueue 
		= new PriorityQueue<binarytree<HuffData>>(symbols.length , new CompareHuffmanTrees());
		// load the queue with the leaves
		for(int i=0;i<symbols.length;i++){
			binarytree<HuffData> aBinaryTree = new binarytree<HuffData>(symbols[i] , null , null);
			theQueue.offer(aBinaryTree);
		}
		// build the tree
		while(theQueue.size() > 1)
		{
			binarytree<HuffData> left = theQueue.poll();
			binarytree<HuffData> right = theQueue.poll();
			
			double wLeft = left.getData().weight;
			double wRight = right.getData().weight;
			HuffData sum  = new HuffData(wLeft + wRight , null);
			
			binarytree<HuffData> newTree = new binarytree<HuffData>(sum , left , right);
			
			theQueue.offer(newTree);
		}
		// the queue should now contain only one item
		huffTree = theQueue.poll();
	}
	// print the huffman symbol code
	public void printCode(PrintStream out , String code ,binarytree<HuffData> tree)
	{
		HuffData theData = tree.getData();
		
		if(theData.symbol != null)
		{
			if(theData.symbol.equals(" "))
			{
				out.println("space: " + code);
			}
			else
				out.println(theData.symbol +": " + code);
		}
		else{
			printCode(out , code + "0" , tree.getLeftSubTree());
			printCode(out , code + "1" , tree.getRightSubTree());
		}
	}
}
