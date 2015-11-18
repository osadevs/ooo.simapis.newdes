package fr.inria.osa.simapis.wrappers.llong;

import fr.inria.osa.simapis.exceptions.IllegalEventMethodException;
import fr.inria.osa.simapis.exceptions.UnknownEventMethodException;
import fr.inria.osa.simapis.modeling.AbstractProcessModel;
import fr.inria.osa.simapis.modeling.ModelingTimeAPI;
import fr.inria.osa.simapis.simulation.SimulationLoggerItf;


/**
 * A wrapper implementation of the generic AbstractProcessModel<U> using the Long
 * type.
 * 
 * <p>The only purpose of this wrapper is to make the code more compact without impact much
 * of its genericity: Multiple versions of this class can be provided for various types in
 * separate java packages.
 * 
 * @author odalle
 *
 */
public class ProcessModel extends AbstractProcessModel<Long> {

	
	public ProcessModel(SimulationLoggerItf<Long> logger) {
		super(logger);
	}

	public ModelingTimeAPI<Long> getSimulationTime() {
		return this.getSimProcessApi().getSimulationTime();
	}

	public long scheduleEventMyself(String methodName, Object[] parameters,
			ModelingTimeAPI<Long> time) throws UnknownEventMethodException,
			IllegalEventMethodException {
		return this.getSimProcessApi().scheduleEventMyself(methodName, parameters, time);
	}
	
	public long scheduleEventMyselfNoE(String methodName, Object[] parameters,
			ModelingTimeAPI<Long> time) {
		try {
			return this.getSimProcessApi().scheduleEventMyself(methodName, parameters, time);
		} catch (IllegalEventMethodException e) {
			logger_.error("Illgal event method",e);
			throw new RuntimeException(e);
		} catch (UnknownEventMethodException e) {
			logger_.error("Unknown event method",e);
			throw new RuntimeException(e);
		}
	}

	public void waitForDelay(ModelingTimeAPI<Long> delay) {
		this.getSimProcessApi().waitForDelay(delay);
	}

	public String waitOnConditionForDelay(String condition, ModelingTimeAPI<Long> delay)
			throws InterruptedException {
		return this.getSimProcessApi().waitOnConditionForDelay(condition, delay);
	}
	
	
	public String waitOnConditionForDelayNoE(String condition, ModelingTimeAPI<Long> delay) {
		try {
			return this.getSimProcessApi().waitOnConditionForDelay(condition, delay);
		} catch (InterruptedException e) {
			logger_.error("Interrupted Exception",e);
			throw new RuntimeException(e);
		}
	}

	public boolean cancelEvent(long eventId) {
		return this.getSimProcessApi().cancelEvent(eventId);
	}

	public boolean releaseOneOnCondition(String condition, String param) {
		return this.getSimProcessApi().releaseOneOnCondition(condition, param);
	}

	public int releaseAllOnCondition(String condition, String param) {
		return this.getSimProcessApi().releaseAllOnCondition(condition, param);
	}

	public long scheduleProcessMyself(String methodName, Object[] parameters,
			ModelingTimeAPI<Long> time) throws UnknownEventMethodException,
			IllegalEventMethodException {
		return this.getSimProcessApi().scheduleProcessMyself(methodName, parameters, time);
	}
	
	public long scheduleProcessMyselfNoE(String methodName, Object[] parameters,
			ModelingTimeAPI<Long> time) {
		try { 
			return this.getSimProcessApi().scheduleProcessMyself(methodName, parameters, time);
		} catch (IllegalEventMethodException e) {
			logger_.error("Illgal event method",e);
			throw new RuntimeException(e);
		} catch (UnknownEventMethodException e) {
			logger_.error("Unknown event method",e);
			throw new RuntimeException(e);
		}
	}

}
