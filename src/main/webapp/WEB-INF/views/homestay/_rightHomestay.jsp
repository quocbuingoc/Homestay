<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-10 col-sm-10">
	<div class="well">
		<h3>Your Homestay</h3>
		<c:choose>
			<c:when test="${!empty listHomestay}">
				<a class="btn btn-success btn-md disabled">Create new <span
					class="glyphicon glyphicon-home"></span>
				</a>
				<br />
			</c:when>
			<c:otherwise>
				<a class="btn btn-success btn-md"
					href="<c:url value="/host/create/homestay/${username}"/>">Create
					new <span class="glyphicon glyphicon-home"></span>
				</a>
				<br />
			</c:otherwise>
		</c:choose>
		<br />
		<div class="table-responsive text-center">
			<table class="table table-striped table-bordered">
				<thead>
					<tr class="bg-primary">
						<th class="text-center">Image</th>
						<th class="text-center">Title</th>
						<th class="text-center">City</th>
						<th class="text-center">Address</th>
						<th class="text-center">Smoke</th>
						<th class="text-center">Created Date</th>
						<th class="text-center">Edit</th>
						<th class="text-center">Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="homestay" items="${listHomestay}"
						varStatus="status">
						<tr>
							<td id="img"><img class="img-responsive thumbnail"
								src="<c:url value="/resources/images/homestay/${homestay.imageUrl}"/>"
								width="70" height="70"></td>
							<td>${homestay.homestayTitle }</td>
							<td>${homestay.homestayCity }</td>
							<td>${homestay.homestayAddress }</td>
							<td>${homestay.homestaySmoke }</td>
							<td>${homestay.createdDate }</td>

							<td><a data-toggle="tooltip" data-placement="top"
								title="Edit" class="btn btn-primary btn-sm"
								href="<c:url value="/host/edit/homestay/${username}&${homestay.homestayId}" />"><span
									class="glyphicon glyphicon-pencil"></span></a></td>
							<td><a
								data-toggle="tooltip" data-placement="top" title="Delete"
								class="btn btn-danger btn-sm"
								href="<c:url value="/host/delete/homestay/${username}&${homestay.homestayId}"/>"><span
									class="glyphicon glyphicon-trash"></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>


	</div>

</div>
<script>
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>