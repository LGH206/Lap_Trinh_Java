package com.fe.horseracing.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "jockeys")
public class jockey extends user {

	public jockey() {
		super();
	}
}
