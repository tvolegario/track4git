package org.ssglobal.training.codes;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Divide {
	private static Logger logger = Logger.getLogger(Divide.class.getName());
	
	public Divide() {
		logger.setLevel(Level.INFO);
	}
	
	public int div(int x, int y) throws ArithmeticException, Exception{
		logger.info("execute div");
		
		logger.info("validation: denominator should not be 0");
		if (y == 0) {
			logger.severe("Error: division by zero not allowed");
			// no need to put exit with errors
			throw new ArithmeticException("division by zero not allowed");
		} else {
			logger.info("exit without errors div");
			return x/y;
		}
	}
}
