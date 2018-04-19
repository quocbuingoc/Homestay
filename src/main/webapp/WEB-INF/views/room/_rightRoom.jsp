<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-10 col-sm-10">
	<div class="well">

		<h3>List Your Homestay</h3>
		<a class="btn btn-success btn-md"
			href="<c:url value="/host/create/room/${username}&${homestayId}"/>">Create
			Room <span class="glyphicon glyphicon-home"></span>
		</a>
		<hr>
		<div class="table-responsive text-center">
			<table class="table table-striped table-bordered">
				<thead>
					<tr class="bg-primary">
						<th class="text-center">Room Number</th>
						<th class="text-center">Room Type</th>
						<th class="text-center">Number of Guests</th>
						<th class="text-center">Bathroom</th>
						<th class="text-center">Status</th>
						<th class="text-center">Homestay Id</th>
						<th class="text-center">Edit</th>
						<th class="text-center">Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="room" items="${listRoomByHomestayId}"
						varStatus="status">
						<tr>
							<td>${room.roomNumber }</td>
							<td>${room.roomType.roomTypeName}</td>
							<td>${room.numberOfGuest }</td>
							<td>${room.haveBathroom }</td>
							<td>${room.roomStatus }</td>
							<td>${room.homestay.homestayTitle }</td>

							<td><a data-toggle="tooltip" data-placement="top"
								title="Edit" class="btn btn-primary btn-sm"
								href="<c:url value="/host/edit/room/${username}&${room.roomId}" />"><span
									class="glyphicon glyphicon-pencil"></span></a></td>
							<td><a data-toggle="tooltip" data-placement="top"
								title="Delete" class="btn btn-danger btn-sm"
								href="<c:url value=""/>"><span
									class="glyphicon glyphicon-trash"></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>