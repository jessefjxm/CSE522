package com.cse522.hw1;

//*************** Client Program *************

class BST {
	public static void main(String args[]) {
		Tree tr;
		tr = new Tree(100);
		tr.insert(50);
		tr.insert(125);
		tr.insert(150);
		tr.insert(25);
		tr.insert(75);
		tr.insert(20);
		tr.insert(90);
		tr.delete(20);
		tr.delete(20);
		tr.delete(125);
		tr.delete(150);
		tr.delete(100);
		tr.delete(50);
		tr.delete(75);
		tr.delete(25);
		tr.delete(90);
		return;
	}
}

class Tree { // Defines one node of a binary search tree

	public Tree(int n) {
		value = n;
		left = null;
		right = null;
	}

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

	public boolean delete(int n) {
		return delete(n, null);
	}

	public boolean delete(int n, Tree parent) {
		if (n < this.value) {
			if (left != null)
				return left.delete(n, this);
			else
				return false;
		} else if (n > this.value) {
			if (right != null)
				return right.delete(n, this);
			else
				return false;
		} else {
			if (left != null && right != null) {
				this.value = right.min();
				right.delete(this.value, this);
			} else if (parent == null) {
				if (left == null && right == null) {
					this.value = -1;
				} else if (left != null) {
					this.value = left.value;
					this.right = left.right;
					this.left = left.left;
				} else {
					this.value = right.value;
					this.left = right.left;
					this.right = right.right;
				}
			} else if (this == parent.left) {
				parent.left = (left != null) ? left : right;
			} else if (this == parent.right) {
				parent.right = (left != null) ? left : right;
			}
			return true;
		}
	}

	public int max() {
		if (right != null)
			return right.max();
		else
			return value;
	}

	public int min() {
		if (left != null)
			return left.min();
		else
			return value;
	}

	protected int value;
	protected Tree left;
	protected Tree right;
}
