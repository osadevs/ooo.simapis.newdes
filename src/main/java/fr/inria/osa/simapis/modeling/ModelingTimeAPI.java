/**
 * 
 */
package fr.inria.osa.simapis.modeling;

/**
 * @author odalle
 *
 */
public interface ModelingTimeAPI<U extends Comparable<U>>  extends Comparable<ModelingTimeAPI<U>> {
	
	public boolean isInfinite();
	
	public ModelingTimeAPI<U> getDelayed(U t);

	public boolean isBefore(ModelingTimeAPI<U> other);
	
	public boolean isAfter(ModelingTimeAPI<U> other);

	public U get();

}
