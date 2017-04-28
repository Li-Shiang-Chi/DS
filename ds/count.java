package ds;
import java.util.*;

public class count {
	
	static String[] operator = {"+","-","*","/" , "(" , ")"};
	static int precedence(String input){
		switch(input)
		{
			case "*":
				return 2;
			case "/":
				return 2;
			case "+":
				return 1;
			case "-":
				return 1;
			case "(":
				return 0;
			case ")":
				return 0;
		}
		return -1;
	}
	static double cal(String operator , double a , double b){
		switch(operator){
			case "+":
				return b+a;
			case "-":
				return b-a;
			case "*":
				return b*a;
			case "/":
				return b/a;
		}
		return 0;
	}
	static boolean isOperator(String input){
		for(int i=0;i<operator.length;i++){
			if(input.equals(operator[i]))
				return true;
		}
		return false;
	}
	static void infixToPostfixWithP(String infix)
	{
		String[] array = infix.split(" ");
		Stack<String> opStack = new Stack<String>();
		String result = "";
		for(int i=0;i<array.length;i++)
		{
			System.out.println(opStack.toString());
			if(isOperator(array[i]))
			{
				if(opStack.isEmpty()){
					opStack.push(array[i]);
					continue;
				}
				else if(array[i].equals("(")){
					opStack.push("(");
					continue;
				}
				if(array[i].equals(")"))
				{
					while(!opStack.isEmpty())
					{
						String temp = opStack.pop();
						if(temp.equals("(")){
							break;
						}
						else{
							result+=temp;
						}
					}
				}
				else
				{
					int topPrecedence = precedence(opStack.peek());
					int currentPrecedence = precedence(array[i]);
					if(currentPrecedence > topPrecedence)
					{
						opStack.push(array[i]);
					}
					else
					{
						while(!opStack.isEmpty() && currentPrecedence <= topPrecedence)
						{
							topPrecedence = precedence(opStack.peek());
							result += opStack.pop();
						}
						if(!array[i].equals(")"))
							opStack.push(array[i]);
					}
				}
			}
			else{
				result += array[i];
			}
		}
		while(!opStack.isEmpty()){
			result += opStack.pop();
		}
		System.out.println(result);
	}
	static void infixToPostfix(String infix){
		String[] array = infix.split(" ");
		Stack<String> opStack = new Stack<String>();
		String result = "";
		for(int i=0;i<array.length;i++)
		{
			System.out.println(opStack.toString());
			if(isOperator(array[i]))
			{
				if(opStack.isEmpty())
				{
					opStack.add(array[i]);
				}
				else
				{
					int topPrecedence = precedence(opStack.peek());
					int currentPrecedence = precedence(array[i]);
					if(currentPrecedence > topPrecedence){
						opStack.push(array[i]);
					}
					else
					{
						while(!opStack.isEmpty() && currentPrecedence <= topPrecedence)
						{
							result += opStack.pop();
							topPrecedence = precedence(opStack.peek());
						}
						opStack.push(array[i]);
					}
				}
			}
			else{
				result += array[i];
			}
		}
		while(!opStack.isEmpty()){
			result += opStack.pop();
		}
		System.out.println(result);
	}
	/*static void countPrefix(String prefix)
	{
		ArrayList<String> array = new ArrayList<String>();
		String[] input = prefix.split(" ");
		for(int i=0;i<input.length;i++)
		{
			array.add(input[i]);
		}
		
		while(array.size() > 1)
		{
			System.out.println(array.toString());
			for(int i=0;i<array.size();i++)
			{
				if(isOperator(array.get(i)) && i+2 < array.size())
				{
					if(isOperator(array.get(i+1)) == false && isOperator(array.get(i+2)) == false)
					{
						int result = cal(array.get(i) , Integer.parseInt(array.get(i+1)) , Integer.parseInt(array.get(i+2)));
						array.remove(i+1);
						array.remove(i+1);
						array.set(i, Integer.toString(result));
					}
				}
			}
		}
		System.out.println(array.get(0));
		
		
	}*/
	static void countPostfix(String postfix){
		Stack<String> stack = new Stack<String>();
		
		String[] array = postfix.split(" ");
		
		for(int i=0;i<array.length;i++)
		{
			System.out.println(stack.toString());
			if(isOperator(array[i]) == false)
			{
				stack.push(array[i]);
			}
			else
			{
				double a1 = Double.parseDouble(stack.pop());
				double a2 = Double.parseDouble(stack.pop());
				double result = cal(array[i] , a1 , a2);
				stack.push(Double.toString(result));
			}
		}
		
		System.out.println(stack.pop());
		
	}
	public static void main(String[] args){
		countPostfix("2 4 4 - 5 + / 6 2 - * 4 *");
		//2 4 4 - 5 + / 6 2 - * 4 *
	}
}
