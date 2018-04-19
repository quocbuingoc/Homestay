<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- Modal -->
<div class="modal fade" id="myHome" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<c:url var="addAction" value="/host/${name}/homestay/add"></c:url>
	<form:form action="${addAction}" commandName="newHome"
		class="modal-dialog" role="form">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Add new Homestay</h4>
			</div>
			<div class="modal-body">
				<form role="form">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="type">Homestay Type:</label>
								<form:select path="type.typeId" class="form-control">
									<c:forEach var="type" items="${HomeType}">
										<form:option value="${type.typeId }">
											<c:out value="${type.typeName}" />
										</form:option>
									</c:forEach>
								</form:select>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="title">Title:</label>
								<form:input type="text" class="form-control"
									path="homestayTitle" />
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="city">City:</label>
								<form:select class="form-control" id="type" path="homestayCity">
									<form:option value="0">Da Nang</form:option>
									<form:option value="1">Ho Chi Minh</form:option>
									<form:option value="2">Ha Noi</form:option>
									<form:option value="3">Hai Phong</form:option>
								</form:select>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="address">Address:</label>
								<form:input type="text" class="form-control"
									path="homestayAddress" />
							</div>
						</div>
					</div>
					<div class="form-group">
						<label>AccountId:</label>
						<form:input type="text" class="form-control" path="acc.accountId"
							value="${accountId}" />
					</div>
					
					<div class="form-group">
						<label for="about">About the Homestay:</label>
						<form:textarea type="text" class="form-control" rows="4" path="homestayAbout" id="about"></form:textarea>
					</div>
					
					<div class="form-group">
						<label for="phone">Phone Number:</label>
						<form:input type="text" class="form-control" path="homestayPhone" />
					</div>
					
					<div class="form-group">
						<label for="rule">Your Homestay Rules:</label>
						<form:textarea type="text" class="form-control" rows="4" id="rule" path="homestayRule"></form:textarea>
					</div>
					
					<div class="form-group">
						<label for="rule">Can guests smoke in your homestay?</label> <br>
						<label class="radio-inline"><form:radiobutton path="homestaySmoke" name="optradio" />Yes</label> 
						<label class="radio-inline"><form:radiobutton path="homestaySmoke" name="optradio" />No</label>
					</div>
					
					<div class="form-group">
						<label for="image">Image:</label> <input type="file"
							class="form-control" id="image">
					</div>
					
					<div class="form-group">
						<input type="hidden" class="form-control" value="">
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="submit" class="btn btn-primary">Save changes</button>
			</div>
		</div>
	</form:form>
</div>
