<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-10 col-sm-10">
	<div class="well">
		<h3>Your Homestay Image</h3>
		<a class="btn btn-success btn-md"
			href="<c:url value="/host/create/homestay-image/${username}&${homestayId}"/>">Create
			new <span class="glyphicon glyphicon-home"></span>
		</a> <br />
		<br />
		<div class="table-responsive text-center">
			<table class="table table-striped table-bordered">
				<thead>
					<tr class="bg-primary">
						<th class="text-center">Image</th>
						<th class="text-center">SortOrder</th>
						<th class="text-center">Status</th>
						<th class="text-center">Edit</th>
						<th class="text-center">Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="image" items="${listImage}" varStatus="status">
						<tr>
							<td id="img"><img class="img-responsive thumbnail"
								src="<c:url value="/resources/images/homestay/${image.imageUrl}"/>"
								width="70" height="70"></td>
							<td>${image.sortOrder }</td>
							<td>${image.imageStatus }</td>

							<td><a data-toggle="tooltip" data-placement="top"
								title="Edit" class="btn btn-primary btn-sm"
								href="<c:url value="/host/edit/homestay-image/${username}&${image.imageId}&${homestayId}" />"><span
									class="glyphicon glyphicon-pencil"></span></a></td>
							<td><a data-toggle="tooltip" data-placement="top"
								title="Delete" class="btn btn-danger btn-sm"
								href="<c:url value="/host/delete/homestay-image/${username}&${image.imageId}"/>"><span
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