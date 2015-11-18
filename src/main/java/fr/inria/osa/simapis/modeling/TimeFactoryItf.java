package fr.inria.osa.simapis.modeling;

public interface TimeFactoryItf<U extends Comparable<U>> {
	
	public ModelingTimeAPI<U> create(U val);
	
	public ModelingTimeAPI<U> create();
	
	public ModelingTimeAPI<U> create(String symbol);

}
