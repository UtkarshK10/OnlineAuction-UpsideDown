<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Schedule Auction</title>
<style><%@include file="../resources/css/style.css"%></style>
<style><%@include file="../resources/css/seller/SellerPage.css"%></style>
</head>
<body>
<body>
	<%@ include file="../common/navbar.jsp"%>
	
	<div style="height:70px"></div>
	<section class="wrapper">
		<div class="form-container">
			<div class="schedule-form">
				<a href="/OnlineAuction/sellerhistory">
					<button class="back">Back</button>
				</a>
				<form id="scheduleAuctionForm" method="POST" action="schedule">
					<h2>Schedule An Auction</h2>
					<div>
						<label for="products">Products</label>
						<select class="product-dropdown" name="products" required>
							<option value="" disabled selected hidden>Choose a product</option>
							
								<option value="1">IFB Washing Machine</option>
								<option value="2">LG Television</option>
								<option value="3">Sony Headphones</option>
							
						</select>
						<p id="productsError" style="margin-top: 4px; color: red"></p>
					</div>
					<div>
					    <label for="minimumBidValue">Bid Value</label>
						<input class="bid-value" type="text" name="minimumBidValue"
							placeholder="Minimum Bid Value">
						<p id="minimumBidValueError" style="margin-top: 4px; color: red"></p>
					</div>
					<div>
						<label for="startDate"><i class="zmdi zmdi-calendar"></i>Bid Start Date</label>
						<input class="start-date" type="date" name="startDate">
						<p id="startDateError" style="margin-top: 4px; color: red"></p>
					</div>
					<div>
						<label for="endDate"><i class="zmdi zmdi-calendar"></i>Bid End Date</label>
						<input type="date" class="end-date" name="endDate">
						<p id="endDateError" style="margin-top: 4px; color: red"></p>
					</div>
					<div>
						<button class="submit btn" type="submit">Schedule Auction</button>
					</div>
				</form>

			</div>
		</div>
	</section>
	<br/><br/>
	<div style="height:150px"></div>
	<%@ include file="../common/footer.jsp"%>
	<script> <%@include file="../resources/js/index.js"%></script>
	<script> <%@include file="../resources/js/utility/inputValidation.js"%></script>
	<script> <%@include file="../resources/js/seller/scheduleAuction.js"%></script>
</body>
</html>