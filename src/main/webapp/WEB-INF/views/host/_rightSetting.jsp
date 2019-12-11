<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="col-md-10 col-sm-10">
	<div class="well">
	<h2>Account Profile</h2>
	<a class="btn btn-primary right" href="<c:url value="/host/edit/account/${username}"/>">Edit your profile</a>
	<hr/>
		<form:form class="form-horizontal" commandName="Account">
			<div class="form-group">
				<label class="control-label col-sm-2">Full Name:</label>
				<div class="col-sm-9">
					<form:input path="fullName" type="text" class="form-control" readonly="true" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Username:</label>
				<div class="col-sm-9">
					<form:input path="userName" type="text" class="form-control" readonly="true" />
				</div>
				
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Password:</label>
				<div class="col-sm-9">
					<form:input path="passWord" type="password" class="form-control" readonly="true" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Email:</label>
				<div class="col-sm-9">
					<form:input path="emailAddress" type="email" class="form-control" readonly="true"  />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Gender:</label>
				<div class="col-sm-9">
					<form:input path="gender" type="text" class="form-control" readonly="true"  />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Phone Number:</label>
				<div class="col-sm-9">
					<form:input path="phoneNumber" type="text" class="form-control" readonly="true"  />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Date Of Birth:</label>
				<div class="col-sm-9">
					<form:input path="dateOfBirth" type="text" class="form-control" readonly="true"  />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Place Of Birth:</label>
				<div class="col-sm-9">
					<form:input path="placeOfBirth" type="text" class="form-control" readonly="true"  />
				</div>
			</div>
		</form:form>
	</div>
</div>