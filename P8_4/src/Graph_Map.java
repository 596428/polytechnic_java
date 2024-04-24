import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;


public class Graph_Map
{
	public Node rootNode;
	public ArrayList nodes=new ArrayList();
//	public Map<Node, List> nodes = new HashMap();
//	public int[][] adjMatrix;//Edges will be represented as adjacency Matrix
	public Map<Node, List> adjMatrix = new HashMap();
//	int size;
	public void setRootNode(Node n)
	{
		this.rootNode=n;
	}
	
	public Node getRootNode()
	{
		return this.rootNode;
	}
	
	public void addNode(Node n)
	{
		nodes.add(n);
	}
	
	//This method will be called to make connect two nodes
	public void connectNode(Node start,Node end)
	{

		List nodeList = adjMatrix.get(start);
		if(nodeList == null) {
			nodeList = new ArrayList();
		}
		nodeList.add(end);
		adjMatrix.put(start, nodeList);
		
	}
	
	private Node getUnvisitedChildNode(Node n)
	{
		List nodeList = adjMatrix.get(n);
		for(int i=0; ((nodeList != null) && (i < nodeList.size())); i++){
			Node tmpNode = (Node) nodeList.get(i);
			if(tmpNode.visited == false) {
				return tmpNode;
			}
		}	
		return null;
	}
	
	//BFS traversal of a tree is performed by the bfs() function
	public void bfs()
	{
		
		//BFS uses Queue data structure
		Queue q=new LinkedList();
		q.add(this.rootNode);
		printNode(this.rootNode);
		rootNode.visited=true;
		while(!q.isEmpty())
		{
			Node n=(Node)q.remove();
			Node child=null;
			while((child=getUnvisitedChildNode(n))!=null)
			{
				child.visited=true;
				printNode(child);
				q.add(child);
			}
		}
		//Clear visited property of nodes
		clearNodes();
	}
	
	//DFS traversal of a tree is performed by the dfs() function
	public void dfs()
	{
		//DFS uses Stack data structure
		Stack s=new Stack();
		s.push(this.rootNode);
		rootNode.visited=true;
		printNode(rootNode);
		while(!s.isEmpty())
		{
			Node n=(Node)s.peek();
			Node child=getUnvisitedChildNode(n);
			if(child!=null)
			{
				child.visited=true;
				printNode(child);
				s.push(child);
			}
			else
			{
				s.pop();
			}
		}
		//Clear visited property of nodes
		clearNodes();
	}
	
	
	//Utility methods for clearing visited property of node
	private void clearNodes()
	{
		/*
		for (Object element : nodes) {
            Node n = (Node) element;
            n.visited = false;
        }
        */
		
		/*
        for (int i = 0; i < nodes.size(); i++) {
            Node n = (Node) nodes.get(i);
            n.visited = false;
        }
        */
        
		/*
        nodes.forEach((element) -> {
            Node n = (Node) element;
            n.visited = false;
        });
        */
		
		/*
        Iterator<Node> it = nodes.iterator();
        while (it.hasNext()) {
        	Node n = (Node) it.next();
        	n.visited = false;
        }
        */
		
        nodes.stream().forEach((element) -> {
        	Node n = (Node) element; 
        	n.visited = false;
        });
		
	}
	
	//Utility methods for printing the node's label
	private void printNode(Node n)
	{
		System.out.print(n.label+" ");
	}

	
	
	

}
