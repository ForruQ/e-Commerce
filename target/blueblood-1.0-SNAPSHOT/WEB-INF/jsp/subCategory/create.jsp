
<jsp:include page="/WEB-INF/jsp/common/header.jsp" />

<h1 class="text-center">Create Category</h1> <br>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
     <jsp:include page="/WEB-INF/jsp/common/dashboard.jsp" />
        </div>
         <div class="col-md-10">
             <table border="1" width="45" cellspacing="10">
                 <thead>
                     <tr>
                         <th>Id</th>
                         <th>Name</th>
                     </tr>
                 </thead>
                 <tbody>
                     <c:forEach var="cat" items="${map.catList}">
                     <tr>
                         <td>${cat.id}</td>
                         <td>${cat.name}</td>
                     </tr>
                     </c:forEach>
                 </tbody>
             </table>

             
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />

