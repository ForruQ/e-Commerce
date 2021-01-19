
<jsp:include page="/WEB-INF/jsp/home/header.jsp" /> 
<jsp:include page="/WEB-INF/jsp/home/navbar.jsp" />

<div class="container-fluid">
    <div class="row my-5">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-body px-5 bg-light">
                    <h1 class="text-center">Sign up here</h1>
                    <form action="/user/save" method="Post">
                        <div class="form-group">
                            <label for="uName">User Name</label>
                            <input type="text" class="form-control" placeholder="Enter your Name" name="uName" id="uName"/>
                        </div>
                        <div class="form-group">
                            <label for="uEmail">User Email</label>
                            <input type="uEmail" class="form-control" placeholder="Enter your Email" name="uEmail" id="uEmail"/>
                        </div>
                        <div class="form-group">
                            <label for="uPassword">Password</label>
                            <input type="password" class="form-control" placeholder="Enter your Password" name="uPassword" id="uPassword"/>
                        </div>
                        <div class="form-group">
                            <label for="uPhone">Phone</label>
                            <input type="text" class="form-control" placeholder="Enter your Phone Number" name="uPhone" id="uPhone"/>
                        </div>
                        <div class="form-group">
                            <label for="uAddress">User Address</label>
                            <textarea style="height: 100px;" type="text" class="form-control" placeholder="Enter your Address" name="uAddress" id="uAddress"> 
                            </textarea>
                        </div>
                        <div class="container">
                            <button class="btn btn-outline-info ml-auto">Register</button>
                            <button class="btn btn-outline-warning"><a href="/user/login">Login</a></button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/jsp/home/footer1.jsp" />
<jsp:include page="/WEB-INF/jsp/home/footer.jsp" />