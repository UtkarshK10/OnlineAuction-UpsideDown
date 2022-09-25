package com.upsidedown.model;

public class Product {
	private int productId;
	private String productName;
	private String productCategory;
	private String productDescription;
	private double productPrice;
	private int productQuantity;
	private String productimage;
	private int sellerId; // @sellerId must be registered with @userId
	
	public Product() {
		
	}

	public Product( String productName, String productCategory, String productDescription,
			double productPrice, int productQuantity, String productimage, int sellerId) {
		this.productName = productName;
		this.productCategory = productCategory;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.productimage = productimage;
		this.sellerId = sellerId;
	}
	
	

	public Product(int productId, String productName) {
		this.productId = productId;
		this.productName = productName;
	}

	public Product(String productName, String productCategory, String productDescription, double productPrice,
			int productQuantity, int sellerId) {
		this.productName = productName;
		this.productCategory = productCategory;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.sellerId = sellerId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductimage() {
		return productimage;
	}

	public void setProductimage(String productimage) {
		this.productimage = productimage;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productCategory == null) ? 0 : productCategory.hashCode());
		result = prime * result + ((productDescription == null) ? 0 : productDescription.hashCode());
		result = prime * result + productId;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(productPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + productQuantity;
		result = prime * result + ((productimage == null) ? 0 : productimage.hashCode());
		result = prime * result + sellerId;
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
		Product other = (Product) obj;
		if (productCategory == null) {
			if (other.productCategory != null)
				return false;
		} else if (!productCategory.equals(other.productCategory))
			return false;
		if (productDescription == null) {
			if (other.productDescription != null)
				return false;
		} else if (!productDescription.equals(other.productDescription))
			return false;
		if (productId != other.productId)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (Double.doubleToLongBits(productPrice) != Double.doubleToLongBits(other.productPrice))
			return false;
		if (productQuantity != other.productQuantity)
			return false;
		if (productimage == null) {
			if (other.productimage != null)
				return false;
		} else if (!productimage.equals(other.productimage))
			return false;
		if (sellerId != other.sellerId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", productDescription=" + productDescription + ", productPrice=" + productPrice
				+ ", productQuantity=" + productQuantity + ", productimage=" + productimage + ", sellerId=" + sellerId
				+ "]";
	}
	
	
	
}
