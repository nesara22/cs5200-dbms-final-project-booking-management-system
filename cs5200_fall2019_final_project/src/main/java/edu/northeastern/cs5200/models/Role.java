package edu.northeastern.cs5200.models;

public enum Role {
	admin(1), vendor(2), customer(3);
	private int value;

	private Role(int value) {
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public static Role getRole(int id) {
		Role[] r = new Role[Role.values().length];
		r = Role.values();
		return r[id-1];
	}

}
