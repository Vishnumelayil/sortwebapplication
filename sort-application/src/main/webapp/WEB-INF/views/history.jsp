<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
<table class="table table-responsive" class=".th-lg">
<c:forEach items="${sorthistory}" var="sorHis">
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
</table>
</div>



<%@ include file="common/footer.jspf"%>