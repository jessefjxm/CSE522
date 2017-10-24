package com.cse522.hw2;

abstract class A {
	public int f() {
		return 250;
	}

	public void g() {
		answer = j + f();
		System.out.println(answer);
	}

	protected int j = 14;
	protected int k;
	protected int answer;
}

class B extends A {
	public int f() {
		h();
		return k * 2;
	}

	public void h() {
		k = i * i + super.f();
	}

	protected int i = 2;
}

class C extends A {
	public int f() {
		h();
		return k * 3;
	}

	public void h() {
		k = i * i * i + super.f();
	}

	protected int i = 3;
}

class ABC {
	public static void main(String args[]) {
		A a, a1;
		B b;
		C c;

		b = new B();
		a = b;
		a.g();

		c = new C();
		a1 = c;
		a1.g();
	}
}

interface IA2 {
	default public int f() {
		return 250;
	}

	public void g();
}

interface IB2 extends IA2 {
	public int f();

	public void h();
}

interface IC2 extends IA2 {
	public int f();

	public void h();
}

class A2 implements IA2 {
	public int f() {
		return 250;
	}

	public void g() {
		answer = j + ia2.f();
		System.out.println(answer);
	}

	public A2(IA2 ia2) {
		if (ia2 != null)
			this.ia2 = ia2;
	}

	private int j = 14;
	private int k;
	private int answer;
	private IA2 ia2 = this;
}

class B2 implements IB2 {
	public B2() {
		ia2 = new A2(this);
	}

	public int f() {
		h();
		return k * 2;
	}

	public void h() {
		k = i * i + ia2.f();
	}

	private int i = 2;
	private int k;
	private IA2 ia2;

	public void g() {
		ia2.g();
	}
}

class C2 implements IC2 {
	public C2() {
		ia2 = new A2(this);
	}

	public int f() {
		h();
		return k * 3;
	}

	public void h() {
		k = i * i * i + ia2.f();
	}

	private int i = 3;
	private int k;
	private IA2 ia2;

	public void g() {
		ia2.g();
	}
}

// Note: In the code below, the interfaces for A2 B2, and C2
// are named as IA2, IB2 and IC2 respectively.

class ABC2 {
	public static void main(String args[]) {
		A a, a1;
		B b;
		C c;

		b = new B();
		a = b;
		a.g();

		c = new C();
		a1 = c;
		a1.g();

		IA2 a2, a21;
		IB2 b2;
		IC2 c2;

		b2 = new B2();
		a2 = b2;
		a2.g();

		c2 = new C2();
		a21 = c2;
		a21.g();
		System.out.println("###");
	}
}