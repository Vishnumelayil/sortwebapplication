<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

<head>
<title>Sort Application</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
<div class="container">
<table class="table table-responsive" class=".th-lg">
	<tr>
						<c:forEach items="${sorthistory}" var="sorHis">
<div class="card" style="width: 18rem;">
<p>
  <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample${sorHis.id}" aria-expanded="false" aria-controls="collapseExample">
    Button with data-target
  </button>
</p>
<div class="collapse" id="collapseExample${sorHis.id}">
  <div class="card card-body">
    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident.
  </div>
</div>
</div>
</c:forEach>

					</tr>


</table>
</div>



<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>

</html>
