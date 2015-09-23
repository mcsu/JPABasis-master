package com.univ;

import javax.persistence.Entity;

@Entity
public class Van extends Vehicule{

	int maxWeight;

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}
	
}
