package com.solid.lsp;

public class Square extends Shape {
	private int side;

	Square() {
    }

    Square(int side) {
        this.setSide(side);
    }

    public void setSide(int side) {
		this.side = side;
    }

	public void getSide() {
		return side;
    }
	
	public int getArea() {
        return side * side;
    }
	
}
