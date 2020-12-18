package com.agnieszka.tunnel;

import com.agnieszka.stats.*;

class Simulate {

	/* Method simulating the experiment */

	// Experiment parameters
	public final static double LENGTH = 100;
	public final static double HEIGHT = 5;
	public final static double VELOCITY = 1;
	public final static double AVG_ETA = 0.15;
	private final RandomDistributions rng;

	Simulate(RandomDistributions rng) {
		this.rng = rng;
	}

	Simulate() {
		this(new RandDist());
	}

		/* Method simulating the Monte-Carlo paths */
		SimResult simulate(long N, double avgEta) {
		double lambda = 1/avgEta;
		RunStats rsTime = new RunStats();
		RunStats rsHits = new RunStats();
		for (int i = 1; i <= N; i++) {
			double alpha = rng.uniform(0,Math.PI/4);
			double S = HEIGHT/Math.tan(alpha); // accumulated distance travelled from the tunnel entry
			double vTrv = VELOCITY*Math.sin(alpha); // transversal velocity
			final double vLng = VELOCITY*Math.cos(alpha); // longitudinal velocity
			final double t = LENGTH/vLng; // time of flight
			rsTime.fetch(t);
			rsHits.fetch(countHits(S, vTrv, vLng, lambda));
		}
		MCResult MCTime = new MCResult(rsTime);
		MCResult MCHits = new MCResult(rsHits);
		return new SimResult(MCTime, MCHits);
	}
		
		/* Method counting reflections during each flight */
	private int countHits(double S, double vTrv, double vLng, double lambda) {	
		int hit = 0;
		while (S <= LENGTH && S >=0) {
			hit += 1; // Number of reflections accumulated in all flights
			double eta = rng.exponential(lambda);
			vTrv = vTrv*(1 - eta/(1 + eta));
			double dt = HEIGHT/vTrv;
			S += dt*vLng;
		}
		return hit;
	}
}

