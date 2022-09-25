<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>

<style><%@include file="../resources/css/style.css"%></style>
<style><%@include file="../resources/css/seller/addProducts.css"%></style>

</head>
<body>
<%@ include file="../common/navbar.jsp"%>
	
	<div class="text-center">
		<h1>Add Product</h1>
	</div>
	<div class="container">
		<form id="addProductForm" method="POST" action="/addproduct" enctype="multipart/form-data">
			<div class="form-group">
				<label for="productName"><b>Name</b></label> <input
					class="form-input" type="text" placeholder="Product Name"
					name="productName" id="productName" required>
				<p id="productNameError" style="margin-top: 4px; color: red"></p>
			</div>
			<div class="form-group">
				<label for="category"><b>Category</b></label> 
				<select	class="form-input" id="category" name="category" required>
					<option value="" disabled selected hidden>Choose a category</option>
       				 <option value="electronics">electronics</option>
       				 <option value="appliances">appliances</option>

					</select>
				<p id="categoryError" style="margin-top: 4px; color: red"></p>
			</div>
			<div class="form-group">
				<label for="productDescription"><b>Description</b></label>
				<textarea class="form-input" id="productDescription"
					name="productDescription" rows="4" cols="30" form="addProductForm"
					placeholder="Product Description" required></textarea>
				<p id="descriptionError" style="margin-top: 4px; color: red"></p>
			</div>
			<div class="form-group">
				<label for="actualPrice"><b> Actual Price</b></label> <input
					class="form-input" type="text" placeholder="Price"
					name="actualPrice" id="actualPrice" required>
				<p id="actualPriceError" style="margin-top: 4px; color: red"></p>
			</div>
			<div class="form-group">
				<label for="quantity"><b>Quantity</b></label> <input
					class="form-input" type="text" placeholder="Product Quantity"
					name="quantity" id="quantity" required>
				<p id="quantityError" style="margin-top: 4px; color: red"></p>
			</div>
			<div class="form-group" id='imagePreview'>
				<label for="img"><b>Upload Product Image</b></label> <input
					class="form-input" type="file" id="file" name="file">
				<p id="imageError" style="margin-top: 4px; color: red"></p>
			</div>
			<div class="text-center">
				<button class="addproduct-btn" type="submit">Add Product</button>
			</div>
		</form>
	</div>
	<div style="height: 100px"></div>
	

	<%@ include file="../common/footer.jsp"%>
	<script> <%@include file="../resources/js/index.js"%></script>
	<script> <%@include file="../resources/js/utility/inputValidation.js"%></script>
	<script> <%@include file="../resources/js/seller/addProducts.js"%></script>

</body>
</html>