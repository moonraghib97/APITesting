package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {

	@JsonProperty("id")
	private int id;

	@JsonProperty("name")
	private String name;

	// Getters
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}
