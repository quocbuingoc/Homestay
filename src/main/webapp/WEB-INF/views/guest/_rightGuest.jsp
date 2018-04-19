<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-10 col-sm-10">
	<div class="well">
		<div class="table-responsive" id="shopcart">
			<table id="cart" class="table table-hover table-condensed">
				<thead>
					<tr>
						<th style="width: 10%">Image</th>
						<th style="width: 10%">Room</th>
						<th style="width: 15%">Host</th>
						<th style="width: 20%">Homestay</th>
						<th style="width: 10%">Check-in Date</th>
						<th style="width: 10%">Check-out Date</th>
						<th style="width: 10%">Price</th>
						<th style="width: 22%" class="text-center">Subtotal</th>
						<th style="width: 10%"></th>
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
							<td>${booking.hs.acc.fullName}</td>
							<td>${booking.hs.homestayTitle}</td>
							<td>${booking.checkInDate}</td>
							<td>${booking.checkOutDate}</td>
							<td data-th="Price">${booking.r.roomType.roomPrice}</td>
							<td data-th="Subtotal" class="text-center">${booking.totalAmount}</td>
							<td class="actions" data-th="">
								<a class="btn btn-primary btn-sm" href="<c:url value="/downloadPdf/${booking.bookingId}" />">
									<i class="fa fa-floppy-o"></i>
								</a>
							</td>
							<td class="actions" data-th="">
								<a class="btn btn-danger btn-sm" href="<c:url value="/booking/delete/${booking.bookingId}&${username}&${booking.r.roomId}" />">
									<i class="fa fa-trash-o"></i>
								</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
				<!-- <tfoot>
					<tr>
						<td colspan="6" class="hidden-xs"></td>
						<td class="hidden-xs text-center"><strong>Total
								$1.99</strong></td>
								<td></td>
						<td><a href="#" class="btn btn-success btn-block">Checkout
								<i class="fa fa-angle-right"></i>
						</a></td>
					</tr>
				</tfoot> -->
			</table>
		</div>
	</div>
</div>