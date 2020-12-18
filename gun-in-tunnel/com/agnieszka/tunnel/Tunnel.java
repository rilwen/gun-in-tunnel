package com.agnieszka.tunnel;

import java.lang.Math;

public class Tunnel { 

/* Simulation of the quant task calculating the statistics of a particle flight
 * in the tunnel: average time and number of reflections, and the respective 
 * errors of Monte-Carlo method*/

public static void main(String[] args) {
	if (args.length < 1) {
		System.out.println("Usage: Tunnel <Monte-Carlo iteration number> [average eta]");
		return;
	}
	int iterMC = Integer.parseInt(args[0]); // set number of MC iterations
	double avgEta = Simulate.AVG_ETA; // modify the average eta (default is 0.15)
	if (args.length == 2) avgEta = Double.parseDouble(args[1]);	
	Simulate simulation = new Simulate();
	SimResult output = simulation.simulate(iterMC, avgEta);	// MC simulation
	System.out.printf("Iteration %d --> Time: %-1.5f+/-%-1.5f; Reflections: %-1.5f+/-%-1.5f\n", iterMC, output.getTime().getMean(), output.getTime().getMCError(), output.getHits().getMean(), output.getHits().getMCError()); // average time of flight and the MC error
	}	
}

