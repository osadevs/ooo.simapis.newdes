package fr.inria.osa.simapis.simulation;

import org.objectweb.fractal.fraclet.annotations.Interface;

@Interface(name = "simulationcontrol")
public interface SimulationControlAPI {
	
	/**
	 * This method is used to launch the simulation once all the components
	 * are instantiated and deployed.
	 */
	void startSimulation();

}
