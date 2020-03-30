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

	<nav role="navigation" class="navbar navbar-default">
		<div class="">
			<p class="navbar-brand">Sort Application</p>
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
					<label for="sortData">Enter the no's to
						sort</label>
					<textarea class="form-control" id="sortData"
						rows="3"></textarea>
						<ul>
					<li><span class="label label-warning " id="valComma">Please enter comma seperated interger values</span></li>
					<li><span class="label label-warning" id="valLimit">User can enter max of 50 no's between 0 to 100 </span></li>	
					</ul>		
				</div>
				
				<button type="button" class="btn btn-outline-primary" id="sortButton">Sort</button>
				<button type="button" class="btn btn-outline-primary" id="clearButton">Clear</button>
			</div>
			<div class="col-md-6" id="result">				
			</div>
		</div>
		<div class="row">
		<button type="button" class="btn btn-primary" id="historyButton">History</button>
		<div class="col-md-6" id="history">
		
		</div>
		</div>
		
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="js/app.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</div>

</body>
</html>