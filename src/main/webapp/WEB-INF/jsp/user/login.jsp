
<jsp:include page="/WEB-INF/jsp/common/header.jsp" />
<jsp:include page="/WEB-INF/jsp/common/navbar.jsp" />


<div class="container">
    <div class="row"> 
        <div class="col-md-6 offset-md-3">
            <div class="card mt-5 bg-light">
                <div class="card-header bg-info text-white"> 
                    <h3 class="text-center">Login here</h3>
                </div>
                <div class="card-body mx-5">  
                    <form>
                        <div class="form-group">
                            <label for="email">User Email</label>
                            <input type="email" class="form-control" placeholder="Enter your Email" name="email" id="email"/>
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" placeholder="Enter your Password" name="password" id="passwords"/>
                        </div>
                        <a href="#" class="text-center d-block" >Don't have an account? Click here!</a>
                        <div class="container text-center">
                            <button class="btn btn-info">Submit</button>
                        </div>
                    </form>
                </div>
                <div class="card-footer">  
                </div>
            </div>
        </div>   
    </div>
</div>


<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />