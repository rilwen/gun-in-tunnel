package com.agnieszka.stats;

public class RunStats {

/* Collection of methods calculating data statistics:
 * mean, variance, skewness, kurtosis, standard deviation
 * of the sample and Monte-Carlo error */

	private long i = 0;
	private double M1, M2, M3, M4;
	
	/* Fetch new data and update the statistics */	
	public void fetch(double x) {
		double dx, dx1, dx2, tmp;
		long i1 = i;
		i++;
		dx = x - M1;
		dx1 = dx/i;
		dx2 = dx1 * dx1;
		tmp = dx * dx1 * i1;
		M1 += dx1;
		M4 += tmp * dx2 * (i*i - 3*i + 3) + 6 * dx2 * M2 - 4 * dx1 * M3;
		M3 += tmp * dx1 * (i - 2) - 3 * dx1 * M2;
		M2 += tmp;
	}

    /* Return a mean of the sample */	
	public double mean() {	
		return (i > 0) ? M1 : 0.0;  // a cat --> =^0.0^=
	}

	/* Return a variance of the sample */	
	public double variance() {
		return ( (i > 1) ? M2/(i - 1) : 0.0 );
	}
	
	/* Return a standard deviation of the sample */	
	public double stdDev() {
		return Math.sqrt(variance());
	}
	
	/* Return a Monte Carlo estimation error */
	public double MCErr() {
		return Math.sqrt(variance()/i);
	}
	
	/* Return a skewness of the sample */	
	public double skewness() {
		return Math.sqrt(1.0*i)*M3/Math.pow(M2,1.5);
	}
	
	/* Return a kurtosis of the sample */	
	public double kurtosis() {
		return 1.0*i*M4 / M2 / M2 - 3.0;
	}
}

