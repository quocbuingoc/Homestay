<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="col-md-10 col-sm-10">
	<div class="well">
		<c:choose>
			<c:when test="${!empty listHomestay}">
				<h4 style="color:red;">You had already create a Homestay, Please go back !</h4>
			</c:when>
			<c:otherwise>
				<h3>Create new Homestay</h3>
				<c:url var="addAction" value="/host/add/homestay/${username}"></c:url>
				<form:form action="${addAction}"  commandName="newHome"
					class="form-horizontal" style="padding:15px;"
					enctype="multipart/form-data">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group col-md-12">
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
							<div class="form-group col-md-12">
								<label for="title">Title:</label>
								<form:input type="text" class="form-control"
									path="homestayTitle" />
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group col-md-12">
								<label for="city">City:</label>
								<form:select class="form-control" id="type" path="homestayCity">
									<form:option value="Da Nang">Da Nang</form:option>
									<form:option value="Ho Chi Minh">Ho Chi Minh</form:option>
									<form:option value="Ha Noi">Ha Noi</form:option>
								</form:select>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group col-md-12">
								<label for="address">Address:</label>
								<form:input type="text" class="form-control"
									path="homestayAddress" />
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group col-md-12">
								<label>Create Date:</label>
								<form:input type="text" class="form-control" path="createdDate"
									value="${getDate}" id="datepicker" />
							</div>
						</div>
					</div>

					<div class="form-group col-md-12">
						<label for="about">About the Homestay:</label>
						<form:textarea type="text" class="form-control" rows="4"
							path="homestayAbout" id="about"></form:textarea>
					</div>

					<div class="form-group col-md-12">
						<label for="rule">Your Homestay Rules:</label>
						<form:textarea type="text" class="form-control" rows="4" id="rule"
							path="homestayRule"></form:textarea>
					</div>

					<div class="form-group col-md-12">
						<label for="rule">Can guests smoke in your homestay?</label> <br>
						<label class="radio-inline"><form:radiobutton
								path="homestaySmoke" name="optradio" value="Yes" />Yes</label> <label
							class="radio-inline"><form:radiobutton
								path="homestaySmoke" name="optradio" value="No" />No</label>
					</div>

					<div class="form-group col-md-12">
						<label for="image">Image:</label> <input type="file"
							class="form-control" name="imageUpload" id="image"
							accept="image/*">
					</div>

					<div class="form-group">
						<form:input type="hidden" class="form-control"
							path="acc.accountId" value="${accountId}" />
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</form:form>
			</c:otherwise>
		</c:choose>

	</div>

</div>