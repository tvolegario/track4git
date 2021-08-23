package org.ssglobal.training.codes;


public class Mathematics {
	
	private Divide divide;
	
	public Mathematics(Divide divide) {
		this.divide = divide;
	}
	
	public double complexOp(int x, int y) {
		double formula = 2000.00 / divide.div(x, y) - divide.div(x, y);
		return formula;
	}

}
