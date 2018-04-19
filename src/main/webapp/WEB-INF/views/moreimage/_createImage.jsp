<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="col-md-10 col-sm-10">
	<div class="well">
		<h3>Create new Image</h3>
		<c:url var="addAction" value="/host/add/homestay-image/${username}"></c:url>
		<form:form action="${addAction}" commandName="newImage"
			class="form-horizontal" style="padding:15px;"
			enctype="multipart/form-data">
			
			<div class="form-group col-md-12">
				<label for="image">Image:</label> <input type="file"
					class="form-control" name="imageUpload" id="image" accept="image/*">
			</div>
			
			<div class="form-group col-md-12">
				<label for="about">HomestayId:</label>
				<form:input type="text" class="form-control" path="homestay.homestayId" value="${homestayId }" />
			</div>
			
			<div class="form-group col-md-12">
				<label for="about">Sort Order:</label>
				<form:input type="text" class="form-control" path="sortOrder" />
			</div>
			
			<div class="form-group col-md-12">
				<label for="about">Status:</label>
				<form:input type="text" class="form-control" path="imageStatus" />
			</div>
			
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form:form>

	</div>

</div>