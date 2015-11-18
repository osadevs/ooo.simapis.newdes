package fr.inria.osa.simapis.simulation;

import org.objectweb.fractal.fraclet.annotations.Interface;

import fr.inria.osa.simapis.simulation.SimulationControlAPI;

@Interface(name = "superschedulercontrol")
public interface SuperSchedulerControlItf extends SharedSuperSchedulerItf,
		SimulationControlAPI {

}
