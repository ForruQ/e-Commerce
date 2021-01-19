<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Blue Blood</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="robots" content="all,follow">
        <!-- Bootstrap CSS-->
        <link rel="stylesheet" href="/resources/home/vendor/bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome CSS-->
        <link rel="stylesheet" href="/resources/home/vendor/font-awesome/css/font-awesome.min.css">
        <!-- Google fonts - Roboto -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700">
        <!-- owl carousel-->
        <link rel="stylesheet" href="/resources/home/vendor/owl.carousel/assets/owl.carousel.css">
        <link rel="stylesheet" href="/resources/home/vendor/owl.carousel/assets/owl.theme.default.css">
        <!-- theme stylesheet-->
        <link rel="stylesheet" href="/resources/home/css/style.default.css" id="theme-stylesheet">
        <!-- Custom stylesheet - for your changes-->
        <link rel="stylesheet" href="/resources/home/css/custom.css">
        <!-- Favicon-->
        <link rel="shortcut icon" href="/resources/home/img/favicon.png">

    </head>
    <body>

        <%--<jsp:include page="/WEB-INF/jsp/home/navbar.jsp" />--%>

        <div id="all">
            <div id="content">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <!-- breadcrumb-->
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                                    <li aria-current="page" class="breadcrumb-item active">Shopping cart</li>
                                </ol>
                            </nav>
                        </div>
                        <div id="basket" class="col-lg-9">
                            <div class="box">
                                <form method="post" action="/home/checkout1">
                                    <h1>Shopping cart</h1>
                                    <p class="text-muted">You currently have 3 item(s) in your cart.</p>
                                    <div class="table-responsive">

                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th colspan="2">Product</th>
                                                    <th>Quantity</th>
                                                    <th>Unit price</th>
                                                    <th>Discount</th>
                                                    <th colspan="2">Total</th>
                                                </tr>
                                            </thead>
                                            <tbody>

                                                <c:forEach var="b" items="${map.bList}">
                                                    <tr>  
                                                        <td><a href="#"><img src="/resources/product/img/${b.pPhoto}" alt="${b.pName}"></a></td>
                                                        <td><a href="#">${b.pName}</a></td>
                                                        <td>
                                                            <input type="number" name="qty" id="qty"></td>
                                                        <!--${b.qty}-->
                                                        <td >
                                                            <input type="number" id="pPrice" name="pPrice"/>
                                                            <!--${b.pPrice}-->
                                                        </td>
                                                        <td >
                                                            <input type="hidden" id="discount" name="discount" value="${b.discount}"/>
                                                            <!--${b.discount}-->
                                                        </td>
                                                        <td>
                                                            <input type="number" id="total" name="total"/>

                                                        </td>

                                                        <td><a href="#"><i class="fa fa-trash-o"></i></a></td>
                                                    </tr>

                                                </c:forEach>

                                            </tbody>
                                            <tfoot>
                                                <tr>
                                                    <th colspan="5">Total</th>
                                                    <th colspan="2">$446.00</th>

                                                </tr>
                                            </tfoot>
                                        </table>

                                    </div>
                                    <!-- /.table-responsive-->
                                    <div class="box-footer d-flex justify-content-between flex-column flex-lg-row">
                                        <div class="left"><a href="/home/category" class="btn btn-outline-secondary"><i class="fa fa-chevron-left"></i> Continue shopping</a></div>
                                        <div class="right">
                                            <button class="btn btn-outline-secondary"><i class="fa fa-refresh"></i> Update cart</button>
                                            <button type="submit" class="btn btn-primary">Proceed to checkout <i class="fa fa-chevron-right"></i></button>
                                        </div>
                                    </div>
                                </form>
                                //Testing purpose
                                <form>
                                    <input type="number" id="ab" name="ab"/>
                                    <input type="number" id="bc" name="bc"/>
                                    <input type="number" id="cd" name="cd"/>
                                </form>
                                <p>If you click on me, I will disappear.</p>
                                <p>Click me away!</p>
                                <p>Click me too!</p>
                            </div>
                            <!-- /.box-->
                            <div class="row same-height-row">
                                <div class="col-lg-3 col-md-6">
                                    <div class="box same-height">
                                        <h3>You may also like these products</h3>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-6">
                                    <div class="product same-height">
                                        <div class="flip-container">
                                            <div class="flipper">
                                                <div class="front"><a href="/home/details"><img src="/resources/home/img/product2.jpg" alt="" class="img-fluid"></a></div>
                                                <div class="back"><a href="/home/details"><img src="/resources/home/img/product2_2.jpg" alt="" class="img-fluid"></a></div>
                                            </div>
                                        </div><a href="/home/details" class="invisible"><img src="/resources/home/img/product2.jpg" alt="" class="img-fluid"></a>
                                        <div class="text">
                                            <h3>Fur coat</h3>
                                            <p class="price">$143</p>
                                        </div>
                                    </div>
                                    <!-- /.product-->
                                </div>
                                <div class="col-md-3 col-sm-6">
                                    <div class="product same-height">
                                        <div class="flip-container">
                                            <div class="flipper">
                                                <div class="front"><a href="/home/details"><img src="/resources/home/img/product1.jpg" alt="" class="img-fluid"></a></div>
                                                <div class="back"><a href="/home/details"><img src="/resources/home/img/product1_2.jpg" alt="" class="img-fluid"></a></div>
                                            </div>
                                        </div><a href="/home/details" class="invisible"><img src="/resources/home/img/product1.jpg" alt="" class="img-fluid"></a>
                                        <div class="text">
                                            <h3>Fur coat</h3>
                                            <p class="price">$143</p>
                                        </div>
                                    </div>
                                    <!-- /.product-->
                                </div>
                                <div class="col-md-3 col-sm-6">
                                    <div class="product same-height">
                                        <div class="flip-container">
                                            <div class="flipper">
                                                <div class="front"><a href="/home/details"><img src="/resources/home/img/product3.jpg" alt="" class="img-fluid"></a></div>
                                                <div class="back"><a href="/home/details"><img src="/resources/home/img/product3_2.jpg" alt="" class="img-fluid"></a></div>
                                            </div>
                                        </div><a href="/home/details" class="invisible"><img src="/resources/home/img/product3.jpg" alt="" class="img-fluid"></a>
                                        <div class="text">
                                            <h3>Fur coat</h3>
                                            <p class="price">$143</p>
                                        </div>
                                    </div>
                                    <!-- /.product-->
                                </div>
                            </div>
                        </div>
                        <!-- /.col-lg-9-->
                        <div class="col-lg-3">
                            <div id="order-summary" class="box">
                                <div class="box-header">
                                    <h3 class="mb-0">Order summary</h3>
                                </div>
                                <p class="text-muted">Shipping and additional costs are calculated based on the values you have entered.</p>
                                <div class="table-responsive">
                                    <table class="table">
                                        <tbody>
                                            <tr>
                                                <td>Order subtotal</td>
                                                <th>$446.00</th>
                                            </tr>
                                            <tr>
                                                <td>Shipping and handling</td>
                                                <th>$10.00</th>
                                            </tr>
                                            <tr>
                                                <td>Tax</td>
                                                <th>$0.00</th>
                                            </tr>
                                            <tr class="total">
                                                <td>Total</td>
                                                <th>$456.00</th>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="box">
                                <div class="box-header">
                                    <h4 class="mb-0">Coupon code</h4>
                                </div>
                                <p class="text-muted">If you have a coupon code, please enter it in the box below.</p>
                                <form>
                                    <div class="input-group">
                                        <input type="text" class="form-control"><span class="input-group-append">
                                            <button type="button" class="btn btn-primary"><i class="fa fa-gift"></i></button></span>
                                    </div>
                                    <!-- /input-group-->
                                </form>
                            </div>
                        </div>
                        <!-- /.col-md-3-->
                    </div>
                </div>
            </div>
        </div>

        <%--<jsp:include page="/WEB-INF/jsp/home/footer1.jsp" />--%>
        <script>
            $("#qty").onchange(function () {

                var qty = $("#qty").val();
                alert(qty);
                var pPrice = $("#pPrice").val();
                var total = $("#total").val();
                var totals = parseInt(pPrice) * parseInt(qty);
                $("#total").text()("");
                $("#total").text()(qty);
            });

            $("#pPrice").focusout(function () {
                var qty = $("#qty").val();
                var pPrice = $("#pPrice").val();
                var total = $("#total").val();
                var totals = parseInt(pPrice) * parseInt(qty);
                $("#total").text()("");
                $("#total").text()(totals);
            });

            $("#bc").focusout(function () {
                var ab = $("#ab").val();
                var bc = $("#bc").val();
                var cd = $("#cd").val();
                var cds = parseInt(ab) * parseInt(bc);
                $("#cd").text()("");
                $("#cd").text()(cds);
            });

            $(document).ready(function () {
                $("p").click(function () {
                    $(this).hide();
                });
            });
        </script>
        <!--<script src="/resources/home/vendor/jquery/jquery.min.js"></script>-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="/resources/home/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="/resources/home/vendor/jquery.cookie/jquery.cookie.js"></script>
        <script src="/resources/home/vendor/owl.carousel/owl.carousel.min.js"></script>
        <script src="/resources/home/vendor/owl.carousel2.thumbs/owl.carousel2.thumbs.js"></script>
        <script src="/resources/home/js/front.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.4.0/leaflet.js"></script>
        <script src="/resources/home/js/map.js"></script>
    </body>
</html>