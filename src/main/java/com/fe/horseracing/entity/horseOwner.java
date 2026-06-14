package com.fe.horseracing.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "horse_Owners")
public class horseOwner {
	
	@OneToMany(mappedBy = "owner")
	private List<horse> horses;
	
	public horseOwner() {
		super();
	}
	
	public List<horse> getHorses() {
	    return horses;
	}

	public void setHorses(List<horse> horses) {
	    this.horses = horses;
	}
}
