package com.glaucus.task.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity Class to map attributes to columns on the database table.
 */
@Entity
@Table(name="NUMBER")
public class NumberIncrement implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;

	@Column(name="number")
	Integer number;

	public NumberIncrement() {
	}

	public NumberIncrement(Integer id, Integer number) {
		super();
		this.id = id;
		this.number = number;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "NumberIncrement [" + (id != null ? "id=" + id + ", " : "") + (number != null ? "number=" + number : "")
				+ "]";
	}
}