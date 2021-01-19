<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <h1 class="text-center">Update category</h1> <br>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-2">


                </div>
                <div class="col-md-4">
                    <div class="py-5">
                        <form action="/category/edit" method="GET"> 
                            <input type="text" name="id"/>
                            <input class="btn-info" type="submit" value="Search"/>
                        </form>
                    </div>
                    <div>
                        <form action="/category/update" method="POST"> 
                            ID : <input class="input-group" type="text" name="cId" value="${cat.cId}"/><br/>
                            Name : <input class="input-group" type="text" name="cName" value="${cat.cName}"/><br/>
                            Description : <input class="input-group" type="text" name="cDescription" value="${cat.cDescription}"/><br/>
                            <input class="btn-info" type="submit" value="Update"/>
                        </form>
                    </div>
                </div>
                <div class="col-md-6">

                </div>
            </div>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
