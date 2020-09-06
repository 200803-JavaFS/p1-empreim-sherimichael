package com.revature.models;

public class inputRDTO {
	
	public int reimId;
	public String amount;
	public String description;
	public String typeId;
	public int statusId;
	public String author;
	
	public inputRDTO() {
		super();
	}

	public inputRDTO(int reimId, String amount, String description, String typeId, int statusId, String author) {
		super();
		this.reimId = reimId;
		this.amount = amount;
		this.description = description;
		this.typeId = typeId;
		this.statusId = statusId;
		this.author = author;
	}
	public inputRDTO(String amount, String description, String typeId, int statusId, String author) {
		super();
		this.amount = amount;
		this.description = description;
		this.typeId = typeId;
		this.statusId = statusId;
		this.author = author;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + reimId;
		result = prime * result + statusId;
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
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
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
		if (typeId == null) {
			if (other.typeId != null)
				return false;
		} else if (!typeId.equals(other.typeId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "inputRDTO [reimId=" + reimId + ", amount=" + amount + ", description=" + description + ", typeId="
				+ typeId + ", statusId=" + statusId + ", author=" + author + "]";
	}
	
}
	
