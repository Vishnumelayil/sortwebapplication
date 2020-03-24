<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	
    <div class="col-md-8 order-md-1" >
      <h4 class="mb-3">Sort data</h4>
      <form:form class="needs-validation" method="post" modelAttribute="sortData" action="/sortData">
        <div class="row">
          <div class="col-md-6 mb-3">
            <form:label path="listOfnumbers">Enter the no's to sort : </form:label>
            <form:textarea path="listOfnumbers" class="md-textarea form-control" rows="3"></form:textarea>
            <div class="invalid-feedback">
              ${errodetails}
            </div>
          </div>
         </div>
        <button type="submit" class="btn btn-success">Sort</button>
      </form:form>
    </div>
 <div class="row">
    <div class="col-md-8 order-md-4 mb-6">
      <h4 class="d-flex justify-content-between align-items-center mb-3">
        <span class="text-muted">Result data</span>
      </h4>
      <ul class="list-group mb-3">
        <li class="list-group-item d-flex justify-content-between lh-condensed">
          <div>
            <ul class="list-group mb-6">
            <li class="list-group-item d-flex justify-content-between lh-condensed">
             <span class="text-muted">
             <small class="text-muted">Before Sort : </small>
             <small class="text-muted">${sortedDetails.listOfnumbers}</small>
             </span>
             </li>
             <li class="list-group-item d-flex justify-content-between lh-condensed">
              <span class="text-muted">
             <small class="text-muted">After Sort : </small>
             <small class="text-muted">${sortedDetails.afterSort}</small>
             </span>
             </li>
             <li class="list-group-item d-flex justify-content-between lh-condensed">
              <span class="text-muted">
             <small class="text-muted">Time took for sort : </small>
             <small class="text-muted">${sortedDetails.timeTakenToSort} Nano Seconds</small>
             </span>
             </li>
             <li class="list-group-item d-flex justify-content-between lh-condensed">
              <span class="text-muted">
             <small class="text-muted">No of positions changed : </small>
             <small class="text-muted">${sortedDetails.noSteps}</small>
             </span>
             </li>
             </ul>
          </div>         
        </li>        
      </ul>
    </div>
  </div>   
    
</div>
<%@ include file="common/footer.jspf"%>