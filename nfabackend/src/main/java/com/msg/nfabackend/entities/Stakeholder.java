package com.msg.nfabackend.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
@Table(name ="stakeholder")
public class Stakeholder {
	public Stakeholder() {}
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name ="stakeholder_id")
	private Long stakeholder_id;
	
	@Column (name ="stakeholder_name")
	private String stakeholder_name;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "stakeholder_factor", joinColumns = @JoinColumn(name = "stakeholder_id"), inverseJoinColumns = @JoinColumn(name = "factor_id"))
	private Set<NfaFactor> stakeholderFactors = new HashSet<NfaFactor>();

	public Long getStakeholder_id() {
		return stakeholder_id;
	}

	public void setStakeholder_id(Long stakeholder_id) {
		this.stakeholder_id = stakeholder_id;
	}

	public String getStakeholder_name() {
		return stakeholder_name;
	}

	public void setStakeholder_name(String stakeholder_name) {
		this.stakeholder_name = stakeholder_name;
	}

	public Set<NfaFactor> getStakeholderFactors() {
		return stakeholderFactors;
	}

	public void setStakeholderFactors(Set<NfaFactor> stakeholderFactors) {
		this.stakeholderFactors = stakeholderFactors;
	}
	
	
	
	
}