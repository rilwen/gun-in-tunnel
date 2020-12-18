package com.agnieszka.stats;

import java.util.Random;

public final class RandDist implements RandomDistributions {

/* Utility class for generating a pseudorandom real number 
 * from an exponential and a uniform distribution */

    private Random random;    // pseudorandom number generator
	
	public RandDist() {
		this(17);		
	}
	
	public RandDist(long s) {
		setSeed(s);
	}
	
	/* Initialise the psedurandom number generator with a new seed. */
    public void setSeed(long s) {		
        random = new Random(s);
    }
	
    /* Return a real number from U[0,1] */
    @Override
	public double uniform() {
        return random.nextDouble();
    }

    /* Return a real number from U[a,b] */
    @Override
	public double uniform(double a, double b) {
        return (b - a)*random.nextDouble() + a;
    }

    /* Return a real number from an exponential distribution S with rate lambda. */
    @Override
	public double exponential(double lambda) {
        return -Math.log(1 - uniform()) / lambda; // F(s) = 1 - exp^(-lambda*s), S = F^-1(U[0,1])
    }
	
	/* Test */
    public static void main(String[] args) {		
		RandDist rng = new RandDist();
        int N = Integer.parseInt(args[0]);
		if (args.length == 2) rng.setSeed(Long.parseLong(args[1]));

        for (int i = 0; i < N; i++) {
            System.out.printf("%1.5f ", rng.uniform());
			System.out.printf("%1.5f ", rng.uniform(2,5));
            System.out.printf("%1.5f ", rng.exponential(1/0.15));
            System.out.println();
        }
        System.out.println();
    }

}


