package fr.inria.osa.simapis.modeling;


public abstract class AbstractModelingTime<U extends Comparable<U>> implements ModelingTimeAPI<U> {

	private U time_;
	
	public boolean isBefore(ModelingTimeAPI<U> other) {
		return (time_.compareTo(other.get()) < 0);
	}

	public boolean isAfter(ModelingTimeAPI<U> other) {
		return (time_.compareTo(other.get()) > 0);
	}
	
	protected AbstractModelingTime(final U t) {
		this.time_ = t;
	}

	public int compareTo(ModelingTimeAPI<U> o) {
		if (isInfinite() && o.isInfinite()) return 0;
		if (isInfinite()) return 1;
		if (o.isInfinite()) return -1;
		return time_.compareTo(o.get());
	}

	public abstract boolean isInfinite();

	public abstract ModelingTimeAPI<U> getDelayed(U t);
	
	public U get() {
		return this.time_;
	}
	
	public String toString() {
		return time_.toString();
	}

}
