package com.agnieszka.tunnel;

import com.agnieszka.stats.*;

public class SimResult {

/* Class of getters returning the Monte-Carlo simulation results 
 * accessible via MCResult class for quantities requested by the user */

	private final MCResult time;
	private final MCResult hits;
	
	public SimResult(MCResult time, MCResult hits) {
		this.time = time;
		this.hits = hits;
	}
	
	public MCResult getTime() {
	return time;
	}

	public MCResult getHits() {
	return hits;
	}
}

