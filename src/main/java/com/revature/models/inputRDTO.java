package com.revature.models;

public class inputRDTO {
	
	public int reimId;
	public String amount;
	public String description;
	public String typeId;
	public int statusId;
	public String author;
	public String resolver;
	
	
	
	public inputRDTO() {
		super();
	}



	public inputRDTO(int reimId, String amount, String description, String typeId, int statusId, String author,
			String resolver) {
		super();
		this.reimId = reimId;
		this.amount = amount;
		this.description = description;
		this.typeId = typeId;
		this.statusId = statusId;
		this.author = author;
		this.resolver = resolver;
	}



	public inputRDTO(String amount, String description, String typeId, int statusId, String author, String resolver) {
		super();
		this.amount = amount;
		this.description = description;
		this.typeId = typeId;
		this.statusId = statusId;
		this.author = author;
		this.resolver = resolver;
	}



	public int getReimId() {
		return reimId;
	}



	public void setReimId(int reimId) {
		this.reimId = reimId;
	}



	public String getAmount() {
		return amount;
	}



	public void setAmount(String amount) {
		this.amount = amount;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getTypeId() {
		return typeId;
	}



	public void setTypeId(String typeId) {
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



	public String getResolver() {
		return resolver;
	}



	public void setResolver(String resolver) {
		this.resolver = resolver;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + reimId;
		result = prime * result + ((resolver == null) ? 0 : resolver.hashCode());
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
		if (resolver == null) {
			if (other.resolver != null)
				return false;
		} else if (!resolver.equals(other.resolver))
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
				+ typeId + ", statusId=" + statusId + ", author=" + author + ", resolver=" + resolver + "]";
	}
	
	

}