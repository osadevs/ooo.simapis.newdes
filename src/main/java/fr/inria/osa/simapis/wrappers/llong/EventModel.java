package fr.inria.osa.simapis.wrappers.llong;

import fr.inria.osa.simapis.exceptions.IllegalEventMethodException;
import fr.inria.osa.simapis.exceptions.UnknownEventMethodException;
import fr.inria.osa.simapis.modeling.AbstractEventModel;
import fr.inria.osa.simapis.modeling.ModelingTimeAPI;
import fr.inria.osa.simapis.simulation.SimulationLoggerItf;

/**
 * A wrapper implementation of the generic AbstractEventModel<U> using the Long
 * type.
 * 
 * <p>The only purpose of this wrapper is to make the code more compact without impact much
 * of its genericity: Multiple versions of this class can be provided for various types in
 * separate java packages.
 * 
 * @author odalle
 *
 */
public class EventModel extends AbstractEventModel<Long> {

	
	public EventModel(final SimulationLoggerItf<Long> logger) {
		super(logger);
	}

	/**
	 * Delegate method for {@link fr.inria.osa.simapis.modeling.EventModelingAPI#getSimulationTime()}.
	 * 
	 * 
	 * @see {@link fr.inria.osa.simapis.modeling.EventModelingAPI#getSimulationTime()}
	 */
	public ModelingTimeAPI<Long> getSimulationTime() {
		return this.getSimEventApi().getSimulationTime();
	}

	/**
	 * Delegate method for {@link fr.inria.osa.simapis.modeling.EventModelingAPI#scheduleEventMyself(String, Object[], ModelingTimeAPI)}
	 * 
	 * @see {@link fr.inria.osa.simapis.modeling.EventModelingAPI#scheduleEventMyself(String, Object[], ModelingTimeAPI)
	 */
	public long scheduleEventMyself(String methodName, Object[] parameters,
			ModelingTimeAPI<Long> time) throws UnknownEventMethodException,
			IllegalEventMethodException {
		return this.getSimEventApi().scheduleEventMyself(methodName, parameters, time);
	}
	
	
	/**
	 * Delegate method for {@link fr.inria.osa.simapis.modeling.EventModelingAPI#scheduleEventMyself(String, Object[], ModelingTimeAPI)}
	 * 
	 * <p>
	 * No Exception version: exceptions are trapped and handled in this wrapper.
	 * 
	 * @see {@link fr.inria.osa.simapis.modeling.EventModelingAPI#scheduleEventMyself(String, Object[], ModelingTimeAPI)
	 */
	public long scheduleEventMyselfNoE(String methodName, Object[] parameters,
			ModelingTimeAPI<Long> time) {
		try {
			return this.getSimEventApi().scheduleEventMyself(methodName, parameters, time);
		} catch (IllegalEventMethodException e) {
			logger_.error("Illgal event method",e);
			throw new RuntimeException(e);
		} catch (UnknownEventMethodException e) {
			logger_.error("Unknown event method",e);
			throw new RuntimeException(e);
		}
	}

	public boolean cancelEvent(long eventId) {
		return this.getSimEventApi().cancelEvent(eventId);
	}
	

}
