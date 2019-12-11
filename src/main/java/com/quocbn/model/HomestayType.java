package com.quocbn.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "HOMESTAYTYPES")
public class HomestayType {
	private int typeId;
	private String typeName;
	private String typeDescription;
	private Set<Homestay> homestays;
	
	@OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
	public Set<Homestay> getHomestays() {
		return homestays;
	}
	public void setHomestays(Set<Homestay> homestays) {
		this.homestays = homestays;
	}
	
	@Id
    @Column(name = "HOMESTAYTYPEID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	
	@Column(name = "HOMESTAYTYPENAME")
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	@Column(name = "DESCRIPTION")
	public String getTypeDescription() {
		return typeDescription;
	}
	public void setTypeDescription(String typeDescription) {
		this.typeDescription = typeDescription;
	}
}