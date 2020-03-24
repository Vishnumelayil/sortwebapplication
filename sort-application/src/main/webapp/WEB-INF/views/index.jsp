<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<form:form method="post" modelAttribute="sortData" action="/sortData">
		<form:hidden path="id" />
		<fieldset class="form-group">
			<form:label path="listOfnumbers">Enter the no's to sort : </form:label>
			<form:textarea path="listOfnumbers"></form:textarea>
			<form:errors path="listOfnumbers" cssClass="text-warning" />
		</fieldset>

		<button type="submit" class="btn btn-success">Search</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>