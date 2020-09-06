package com.revature.models;

public class inputRDTO {
	
	private int reimId;
	private double amount;
	private String description;
	private int typeId;
	private int statusId;
	public String author;
	
	public inputRDTO() {
		super();
	}

	public inputRDTO(double amount, String description, int typeId,int statusId, String author) {
		super();
		this.amount = amount;
		this.description = description;
		this.typeId = typeId;
		this.statusId = statusId;
		this.author = author;		
	}
	
	public inputRDTO(int reimId, double amount, String description, int typeId,
			int statusId, String author) {
		super();
		this.reimId = reimId;
		this.amount = amount;
		this.description = description;
		this.typeId = typeId;
		this.statusId = statusId;
		this.author = author;
	}

	public int getReimId() {
		return reimId;
	}

	public void setReimId(int reimId) {
		this.reimId = reimId;
	}
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + reimId;
		result = prime * result + statusId;
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
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (reimId != other.reimId)
			return false;
		if (statusId != other.statusId)
			return false;
		if (typeId != other.typeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "inputRDTO [reimId=" + reimId + "amount=" + amount + ", description=" + description + ", typeId=" + typeId + "statusId=" + statusId + "author=" + author + "]";
	}
}
