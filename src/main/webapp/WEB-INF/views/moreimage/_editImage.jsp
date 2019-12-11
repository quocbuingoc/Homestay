<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="col-md-10 col-sm-10">
	<div class="well">
		<c:url var="updateAction"
			value="/host/update/homestay-image/${username}"></c:url>
		<form:form action="${updateAction}" commandName="editImage"
			class="form-horizontal" style="padding:15px;"
			enctype="multipart/form-data">

			<div class="form-group">
				<div class="col-sm-9">
					<img src="<c:url value="/resources/images/homestay/${imageUrl}" />"
						width="100" height="80" />
				</div>
			</div>
			
			<form:input path="imageId" type="hidden" />
			<form:input path="imageUrl" type="hidden" />

			<div class="form-group col-md-12">
				<label for="image">Image:</label> <input type="file"
					class="form-control" name="imageUpload" id="image" accept="image/*">
			</div>
			
			<hr/>
			<form:input type="hidden" class="form-control"
				path="homestay.homestayId" />

			<div class="form-group col-md-12">
				<label>Sort Order:</label>
				<form:input type="text" class="form-control" path="sortOrder" />
			</div>

			<div class="form-group col-md-12">
				<label>Status:</label>
				<form:input type="text" class="form-control" path="imageStatus" />
			</div>

			<div class="form-group">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form:form>
	</div>

</div>