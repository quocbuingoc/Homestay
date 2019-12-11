<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="col-md-10 col-sm-10">

	<div class="well">
		<div class="table-responsive" id="shopcart">
			<table id="cart" class="table table-hover table-condensed">
				<thead>
					<tr>
						<th style="width: 10%">Image</th>
						<th style="width: 10%">Room</th>
						<th style="width: 15%">Guest</th>
						<th style="width: 15%">Check-in Date</th>
						<th style="width: 15%">Check-out Date</th>
						<th style="width: 15%" class="text-center">Subtotal</th>
						<th style="width: 10%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listBooking}" var="booking">
						<tr>
							<td><img
								src="<c:url value="/resources/images/room/${booking.r.imageUrl}"/>"
								width="50" height="50"></td>
							<td data-th="Product">${booking.r.roomNumber}</td>
							<td>${booking.acc.fullName}</td>
							<td>${booking.checkInDate}</td>
							<td>${booking.checkOutDate}</td>
							<td data-th="Subtotal" class="text-center">${booking.totalAmount}</td>

							<td class="actions" data-th="">
								<c:choose>
									<c:when test="${booking.bookingStatus == false }">
										<a href="<c:url value="/checkin/${username}&${booking.bookingId}&${booking.r.roomId}" />" class="btn btn-primary btn-xs" type="submit">Check-In</a>
									</c:when>
									<c:otherwise>
										<a href="<c:url value="/checkin/${username}&${booking.bookingId}&${booking.r.roomId}" />"  class="btn btn-success btn-xs" type="submit">Check-Out</a>
									</c:otherwise>
								</c:choose>
								
							</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>

</div>