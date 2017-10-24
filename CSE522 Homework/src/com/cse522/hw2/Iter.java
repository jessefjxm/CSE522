package com.cse522.hw2;

import java.util.Stack;

public class Iter {
	public static void main(String args[]) {
		Tree tr1, tr2;
		tr1 = new Tree(100);
		tr1.insert(50);
		tr1.insert(150);
		tr1.insert(25);
		tr1.insert(75);
		tr1.insert(60);
		tr1.insert(55);
		tr1.insert(175);

		tr2 = new Tree(175);
		tr2.insert(100);
		tr2.insert(50);
		tr2.insert(60);
		tr2.insert(55);
		tr2.insert(25);
		tr2.insert(75);

		System.out.println(tr1.equal(tr2));
		System.out.println("###");
	}
}

class Tree {
	public Tree(int n) {
		value = n;
		left = null;
		right = null;
	};

	public void insert(int n) {
		if (value == n)
			return;
		if (value < n)
			if (right == null)
				right = new Tree(n);
			else
				right.insert(n);
		else if (left == null)
			left = new Tree(n);
		else
			left.insert(n);
	}

	public boolean equal(Tree t2) {
		TreeIterator TI1 = new TreeIterator(this);
		TreeIterator TI2 = new TreeIterator(t2);
		do {
			if (TI1.next() != TI2.next())
				return false;
		} while (TI1.done() != true && TI2.done() != true);
		if (TI1.done() != TI2.done())
			return false;

		return true;
	}

	protected int value;
	protected Tree left;
	protected Tree right;

}

class TreeIterator {
	public TreeIterator(Tree t) {
		this.tree = t;
	}

	public boolean done() {
		return (stack.isEmpty());
	}

	public int next() {
		while (tree != null) {
			stack.push(tree);
			tree = tree.left;
		}

		tree = stack.pop();
		int value = tree.value;
		tree = tree.right;
		
		System.out.println("value: "+value);
		return value;
	}

	private Tree tree;
	private Stack<Tree> stack = new Stack<>();

}
