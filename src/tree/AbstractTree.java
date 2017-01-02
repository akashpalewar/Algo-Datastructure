package tree;

import tree.LinkedBinaryTree.Node;

public abstract class AbstractTree<E> implements Tree<E> {
	public boolean isInternal(Position<E> p) {return numChildren(p) > 0;}
	public boolean isExternal(Position<E> p) { return numChildren(p) == 0; } 
	public boolean isRoot(Position<E> p) { return p == root( ); } 
	public boolean isEmpty( ) { return size( ) == 0; }
	
	public int depth(Position<E> p){
		if(isRoot(p)){
			return 0;
		}else{
				return 1+ depth(parent(p));
			}
		}

	private int heightBad(){
		int h = 0;
		for(Position<E> p : positions())
			if(isExternal(p))
				h = Math.max(h,depth(p));
		return h;
	}
	
	public int height(Position<E> p){
		int h=0;
		for(Position<E> c : children(p))
			h =  Math.max(h, 1 + height(c));
			return h;
	}

	
	public static int maxDepth(Node root){
		if(root ==null){
			return 0;
		}
		return 1+ Math.max(maxDepth(root.getLeft()), maxDepth(root.getRight()));
	}
	
	public static int minDepth(Node root){
		if(root==null){
			return 0;
		}
		return 1+ Math.min(minDepth(root.getLeft()), minDepth(root.getRight()));
	}
	
	public boolean isBalanced(Node root){
		return (maxDepth(root) - minDepth(root) <=1);
		
	}
}