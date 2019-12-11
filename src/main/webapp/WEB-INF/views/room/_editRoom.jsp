<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="col-md-10 col-sm-10">
	<div class="well">
		<c:url var="updateAction"
			value="/host/update/room/${username}&${roomId}"></c:url>
		<form:form action="${updateAction}" commandName="editRoom"
			class="form-horizontal" style="padding:15px;"
			enctype="multipart/form-data">
			<div class="row">
				<div class="col-md-6">
					<div class="form-group col-md-12">
						<label for="type">Room Type:</label>
						<form:select path="roomType.roomTypeId" class="form-control">
							<c:forEach var="type" items="${roomType}">
								<form:option value="${type.roomTypeId }">
									<c:out value="${type.roomTypeName}" />
								</form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group col-md-12">
						<label for="title">Room Number:</label>
						<form:input type="text" class="form-control" path="roomNumber" />
					</div>
				</div>
				<div class="col-md-6 ">
					<div class="form-group col-md-12">
						<label>Number Of Guest:</label>
						<form:input type="text" class="form-control" path="numberOfGuest" />
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group col-md-12">
						<label>Have Bathroom:</label> <br /> <label class="radio-inline">
							<form:radiobutton path="haveBathroom" name="optradio" value="Yes" />Yes
						</label> <label class="radio-inline"> <form:radiobutton
								path="haveBathroom" name="optradio" value="No" />No
						</label>
					</div>
				</div>
			</div>


			<div class="form-group col-md-12">
				<label>Room Description:</label>
				<form:textarea type="text" class="form-control" rows="4"
					path="roomDescription"></form:textarea>
			</div>
			<div class="form-group col-md-12">
				<label>Room Status:</label>
				<form:input type="text" class="form-control"
					path="roomStatus"></form:input>
			</div>
			<div class="form-group col-md-12">
				<label>Create Date:</label>
				<form:input type="text" class="form-control" path="createdDate"
					/>
			</div>
			<div class="form-group col-md-12">
				<label>Image:</label>
				<form:input type="text" class="form-control"
					path="imageUrl"></form:input>
			</div>
			<div class="form-group col-md-12">
				<label for="image">Edit Room Image:</label> <input type="file"
					class="form-control" name="imageUpload" id="image" accept="image/*">
			</div>

			<div class="form-group">
				<form:input type="hidden" class="form-control"
					path="homestay.homestayId" value="${homestayId}" />
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form:form>
	</div>

</div>