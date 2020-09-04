package com.revature.models;

public class inputRDTO {
	
	private double amount;
	private String description;
	private int typeId;
	
	public inputRDTO() {
		super();
	}

	public inputRDTO(double amount, String description, int typeId) {
		super();
		this.amount = amount;
		this.description = description;
		this.typeId = typeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + typeId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		inputRDTO other = (inputRDTO) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (typeId != other.typeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "inputRDTO [amount=" + amount + ", description=" + description + ", typeId=" + typeId + "]";
	}
}
