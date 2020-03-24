<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
<div class="row">
    <div class="col-md-8 order-md-4 mb-6">
      <h4 class="d-flex justify-content-between align-items-center mb-3">
        <span class="text-muted">History data</span>
      </h4>
      <c:forEach items="${sorthistory}" var="sorHis">
      <ul class="list-group mb-3">
        <li class="list-group-item d-flex justify-content-between lh-condensed">
          <div>
            <h6 class="my-2">Created Date : ${sorHis.createdDate}</h6>
            <ul class="list-group mb-6">
            <li class="list-group-item d-flex justify-content-between lh-condensed">
             <span class="text-muted">
             <small class="text-muted">Before Sort : </small>
             <small class="text-muted">${sorHis.listOfnumbers}</small>
             </span>
             </li>
             <li class="list-group-item d-flex justify-content-between lh-condensed">
              <span class="text-muted">
             <small class="text-muted">After Sort : </small>
             <small class="text-muted">${sorHis.afterSort}</small>
             </span>
             </li>
             <li class="list-group-item d-flex justify-content-between lh-condensed">
              <span class="text-muted">
             <small class="text-muted">Time took for sort : </small>
             <small class="text-muted">${sorHis.timeTakenToSort} Nano Seconds</small>
             </span>
             </li>
             <li class="list-group-item d-flex justify-content-between lh-condensed">
              <span class="text-muted">
             <small class="text-muted">No of positions changed : </small>
             <small class="text-muted">${sorHis.noSteps}</small>
             </span>
             </li>
             </ul>
          </div>         
        </li>        
      </ul>
      </c:forEach>
    </div>
  </div>

</div>



<%@ include file="common/footer.jspf"%>