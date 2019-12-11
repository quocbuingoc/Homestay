<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="col-md-10 col-sm-10">
	<div class="well">
		<h2>Edit Your Profile</h2>
		<hr />
		<c:url var="updateAction" value="/host/update/account/${username}"></c:url>
		<form:form class="form-horizontal" action="${updateAction}" commandName="editProfile" enctype="multipart/form-data">
			<div class="form-group">
				<label class="control-label col-sm-2">Avatar:</label>
				<div class="col-sm-9">
					<img src="<c:url value="${imageUrl}" />" width="60" height="60" />
				</div>
			</div>
			<form:input path="accountId" type="hidden" />
			<form:input path="imageUrl" type="hidden" />
			<div class="form-group">
				<label class="control-label col-sm-2">Change Avatar:</label>
				<div class="col-sm-9">
					<input type="file" class="form-control" name="imageUpload"
						accept="image/*">
				</div>
			</div>
			<hr/>
			<div class="form-group">
				<label class="control-label col-sm-2">Full Name:</label>
				<div class="col-sm-9">
					<form:input path="fullName" type="text" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Username:</label>
				<div class="col-sm-9">
					<form:input path="userName" type="text" class="form-control" />
				</div>

			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Password:</label>
				<div class="col-sm-9">
					<form:input path="passWord" type="password" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Email:</label>
				<div class="col-sm-9">
					<form:input path="emailAddress" type="email" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Gender:</label>
				<div class="col-sm-9">
					<form:input path="gender" type="text" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Phone Number:</label>
				<div class="col-sm-9">
					<form:input path="phoneNumber" type="text" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Date Of Birth:</label>
				<div class="col-sm-9">
					<form:input path="dateOfBirth" type="text" class="form-control"
						id="datepicker" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Place Of Birth:</label>
				<div class="col-sm-9">
					<form:input path="placeOfBirth" type="text" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary col-sm-offset-2">Update</button>
			</div>
		</form:form>
	</div>
</div>