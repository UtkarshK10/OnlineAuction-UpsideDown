package com.upsidedown.model;
import java.time.LocalDate;
import java.util.*;



public class ProductForAuction extends Product {
	
	public enum status {
		NEW(0),SOLD(1),UNSOLD(2),OPEN(3);

		private final int statusCode;
		private static Map<Integer,status> bid = new HashMap<>();

		status(int statusCode) {
			this.statusCode = statusCode;
		}

		static {
			for (status bidStatus : status.values()) {
				bid.put(bidStatus.statusCode, bidStatus);
			}
		}

		public static status valueOf(int bidStatus) {
			return (status) bid.get(bidStatus);
		}

		public int getValue() {
			return statusCode;
		}
	}
	
	
	
	private double minBidValue;
	private LocalDate bidStartDate;
	private LocalDate bidEndDate;
	private int buyerId; //@buyerId must be registered with @userId
	private double soldPrice;
	private status bidStatus;
	
	

	public ProductForAuction(double minBidValue, LocalDate bidStartDate, LocalDate bidEndDate, int buyerId, double soldPrice,
			status bidStatus) {
		this.minBidValue = minBidValue;
		this.bidStartDate = bidStartDate;
		this.bidEndDate = bidEndDate;
		this.buyerId = buyerId;
		this.soldPrice = soldPrice;
		this.bidStatus = bidStatus;
	}



	public ProductForAuction() {
		// TODO Auto-generated constructor stub
	}



	public double getMinBidValue() {
		return minBidValue;
	}

	public void setMinBidValue(double minBidValue) {
		this.minBidValue = minBidValue;
	}

	public LocalDate getBidStartDate() {
		return bidStartDate;
	}

	public void setBidStartDate(LocalDate bidStartDate) {
		this.bidStartDate = bidStartDate;
	}

	public LocalDate getBidEndDate() {
		return bidEndDate;
	}

	public void setBidEndDate(LocalDate bidEndDate) {
		this.bidEndDate = bidEndDate;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public double getSoldPrice() {
		return soldPrice;
	}

	public void setSoldPrice(double soldPrice) {
		this.soldPrice = soldPrice;
	}

	public int getBidStatus() {
		return bidStatus.statusCode;
	}

	public void setBidStatus(int i) {
		this.bidStatus = status.valueOf(i);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		double result = 1;
		result = prime * result + ((bidEndDate == null) ? 0 : bidEndDate.hashCode());
		result = prime * result + ((bidStartDate == null) ? 0 : bidStartDate.hashCode());
		result = prime * result + ((bidStatus == null) ? 0 : bidStatus.hashCode());
		result = prime * result + buyerId;
		result = prime * result + minBidValue;
		long temp;
		temp = Double.doubleToLongBits(soldPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return (int) result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductForAuction other = (ProductForAuction) obj;
		if (bidEndDate == null) {
			if (other.bidEndDate != null)
				return false;
		} else if (!bidEndDate.equals(other.bidEndDate))
			return false;
		if (bidStartDate == null) {
			if (other.bidStartDate != null)
				return false;
		} else if (!bidStartDate.equals(other.bidStartDate))
			return false;
		if (bidStatus != other.bidStatus)
			return false;
		if (buyerId != other.buyerId)
			return false;
		if (minBidValue != other.minBidValue)
			return false;
		if (Double.doubleToLongBits(soldPrice) != Double.doubleToLongBits(other.soldPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductForAuction [minBidValue=" + minBidValue + ", bidStartDate=" + bidStartDate + ", bidEndDate="
				+ bidEndDate + ", buyerId=" + buyerId + ", soldPrice=" + soldPrice + ", bidStatus=" + bidStatus + "]";
	}
	
	
	
	
}
