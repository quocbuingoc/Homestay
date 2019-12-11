<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="col-md-10 col-sm-10">
	<div class="well">
		<h3>Booking Page</h3>
		<hr />
		<c:url value="/booking/add/${roomId}" var="addAction"/>
		<form:form action="${addAction}" commandName="newBooking"
			class="form-horizontal" style="padding:15px;">
			<div class="form-group">
				<label class="control-label col-sm-2">Host Name:</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" value="${HostName}"
						readonly />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Homestay Title:</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" value="${HsTitle}" readonly />
				</div>
			</div>
			<form:input path="r.roomId" type="hidden" class="form-control"
				value="${roomId}" readonly="true" />


			<form:input path="hs.homestayId" type="hidden" class="form-control"
				value="${homestayId}" readonly="true" />


			<form:input path="acc.accountId" type="hidden" class="form-control"
				value="${AccountId}" readonly="true" />

			<div class="form-group">
				<label class="control-label col-sm-2">Guest Name:</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" value="${fullname}"
						readonly />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Room Number:</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" value="${RoomNumber}"
						readonly />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Room Price:</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" value="${price}" readonly  id="price"/>
				</div>
			</div>
			<form:input type="hidden" path="bookingDate" class="form-control" value="${getDate }" />

			<div class="form-group">
				<label class="control-label col-sm-2">Check-In Date:</label>
				<div class="col-sm-9">
					<form:input type="text" path="checkInDate" class="form-control" id="checkIn" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2">Check-Out Date:</label>
				<div class="col-sm-9">
					<form:input type="text" path="checkOutDate" class="form-control" id="checkOut" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Total Amount:</label>
				<div class="col-sm-9">
					<form:input type="text" path="totalAmount" class="form-control" id="total" />
				</div>
			</div>
			<div class="form-group">

				<div class="col-sm-offset-2 col-sm-9">
					<button class="btn btn-primary">Booking</button>
				</div>
				
			</div>
		</form:form>
	</div>
</div>