package com.agnieszka.stats;

public class MCResult {

/* Class of getters returning the statistics requested by the user */

	private final double mean;
	private final double variance;
	private final double stdDev;
	private final double skewness;
	private final double kurtosis;
	private final double MCError;
		
	public MCResult(RunStats rs) {
		mean = rs.mean();
		variance = rs.variance();
		stdDev = rs.stdDev();
		skewness = rs.skewness();
		kurtosis = rs.kurtosis();
		MCError = rs.MCErr();
	}
	
	public double getMean() {
	return mean;
	}
	
	public double getVariance() {
	return variance;
	}
	
	public double getStdDev() {
	return stdDev;
	}
	
	public double getSkewness() {
	return skewness;
	}
	
	public double getKurtosis() {
	return kurtosis;
	}
	
	public double getMCError() {
	return MCError;
	}
	
}

