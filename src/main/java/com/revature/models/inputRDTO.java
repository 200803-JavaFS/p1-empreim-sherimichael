package com.revature.models;

public class inputRDTO {
	
	private int reimId;
	private double amount;
	private String description;
	private ReimbursementType typeId;
	private ReimbursementStatus statusId;
	public User author;
	
	public inputRDTO() {
		super();
	}

	public inputRDTO(double amount, String description, ReimbursementType typeId,ReimbursementStatus statusId, User author) {
		super();
		this.amount = amount;
		this.description = description;
		this.typeId = typeId;
		this.statusId = statusId;
		this.author = author;		
	}
	
	public inputRDTO(int reimId, double amount, String description, ReimbursementType typeId,
			ReimbursementStatus statusId, User author) {
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

	public ReimbursementType getTypeId() {
		return typeId;
	}

	public void setTypeId(ReimbursementType typeId) {
		this.typeId = typeId;
	}

	public ReimbursementStatus getStatusId() {
		return statusId;
	}

	public void setStatusId(ReimbursementStatus statusId) {
		this.statusId = statusId;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
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
		result = prime * result + ((statusId == null) ? 0 : statusId.hashCode());
		result = prime * result + ((typeId == null) ? 0 : typeId.hashCode());
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
		if (statusId == null) {
			if (other.statusId != null)
				return false;
		} else if (!statusId.equals(other.statusId))
			return false;
		if (typeId == null) {
			if (other.typeId != null)
				return false;
		} else if (!typeId.equals(other.typeId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "inputRDTO [reimId=" + reimId + "amount=" + amount + ", description=" + description + ", typeId=" + typeId + "statusId=" + statusId + "author=" + author + "]";
	}
}
