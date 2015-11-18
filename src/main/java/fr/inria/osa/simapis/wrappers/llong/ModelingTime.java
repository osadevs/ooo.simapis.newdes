package fr.inria.osa.simapis.wrappers.llong;

import fr.inria.osa.simapis.modeling.AbstractModelingTime;
import fr.inria.osa.simapis.modeling.ModelingTimeAPI;
import fr.inria.osa.simapis.modeling.ModelingTimeSymbols;
import fr.inria.osa.simapis.modeling.TimeFactoryItf;

public class ModelingTime extends AbstractModelingTime<Long> {
	
	public static class IllegalModelingTimeException extends RuntimeException {

		private static final long serialVersionUID = 1091703170731L;
		
		public IllegalModelingTimeException(String format, Object value) {
			super(String.format(format,value));
		}
	}
	
	
	public static class ModelingTimeFactory implements TimeFactoryItf<Long> {

		public ModelingTimeAPI<Long> create(Long val) {
			return new ModelingTime(val);
		}

		public ModelingTimeAPI<Long> create() {
			return new ModelingTime(0L);
		}

		public ModelingTimeAPI<Long> create(String symbol) {
			switch (ModelingTimeSymbols.valueOf(symbol)) {
			case INFINITY:
				return new ModelingTime(-1L);
			case ZERO:
				return new ModelingTime(0L);
			default:
				throw new RuntimeException("Invalid Modeling time symbol:"+symbol);
			
			}
		}
		
	}

	
	public static ModelingTimeFactory getFactory() {
		return new ModelingTimeFactory();
	}

	
	private ModelingTime(final Long t) {
		super(t);
	}

	@Override
	public boolean isInfinite() {
		return (get() == -1L);
	}
	
	public static boolean isInfinite(ModelingTime t) {
		return (t.get() == -1L);
	}

	@Override
	public ModelingTimeAPI<Long> getDelayed(Long t) {
		return new ModelingTime(get() + t);
	}
	
	public static ModelingTimeAPI<Long> getDelayed(ModelingTime t1, Long delay) {
		return t1.getDelayed(delay);
	}
	
}
