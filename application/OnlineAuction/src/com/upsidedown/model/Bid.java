package com.upsidedown.model;

import java.util.HashMap;
import java.util.Map;


public class Bid {
	
	public enum status {
		OPEN(0),LOST(1),WON(2);

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
	
	
	
	private int bidId;
	private int bidderId; // @bidderId must be registered with @userId
	private int bidProdutId; // @bidProductId must be registered with @productId
	private double bidValue;
	private status bidStatus;
	
	public Bid() {
		
	}

	public Bid( int bidderId, int bidProdutId, double bidValue, status bidStatus) {
		this.bidderId = bidderId;
		this.bidProdutId = bidProdutId;
		this.bidValue = bidValue;
		this.bidStatus = bidStatus;
	}

	public int getBidId() {
		return bidId;
	}

	public void setBidId(int bidId) {
		this.bidId = bidId;
	}

	public int getBidderId() {
		return bidderId;
	}

	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}

	public int getBidProdutId() {
		return bidProdutId;
	}

	public void setBidProdutId(int bidProdutId) {
		this.bidProdutId = bidProdutId;
	}

	public double getBidValue() {
		return bidValue;
	}

	public void setBidValue(double bidValue) {
		this.bidValue = bidValue;
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
		int result = 1;
		result = prime * result + bidId;
		result = prime * result + bidProdutId;
		result = prime * result + ((bidStatus == null) ? 0 : bidStatus.hashCode());
		long temp;
		temp = Double.doubleToLongBits(bidValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + bidderId;
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
		Bid other = (Bid) obj;
		if (bidId != other.bidId)
			return false;
		if (bidProdutId != other.bidProdutId)
			return false;
		if (bidStatus != other.bidStatus)
			return false;
		if (Double.doubleToLongBits(bidValue) != Double.doubleToLongBits(other.bidValue))
			return false;
		if (bidderId != other.bidderId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bid [bidId=" + bidId + ", bidderId=" + bidderId + ", bidProdutId=" + bidProdutId + ", bidValue="
				+ bidValue + ", bidStatus=" + bidStatus + "]";
	}
	
	
	
	
}
