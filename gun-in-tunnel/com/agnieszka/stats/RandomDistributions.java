package com.agnieszka.stats;

public interface RandomDistributions {

	/* Return a real number from U[0,1] */
    public double uniform();
    
    /* Return a real number from U[a,b] */
    public double uniform(double a, double b);

    /* Return a real number from an exponential distribution S with rate lambda. */
    public double exponential(double lambda);
	
}

