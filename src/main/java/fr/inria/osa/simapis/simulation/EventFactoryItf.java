package fr.inria.osa.simapis.simulation;

import fr.inria.osa.simapis.modeling.ModelingTimeAPI;

public interface EventFactoryItf<U extends Comparable<U>> {
	
	public AbstractEvent<U> create(String method, Object[] params, ModelingTimeAPI<U> time, Object instance);

}
