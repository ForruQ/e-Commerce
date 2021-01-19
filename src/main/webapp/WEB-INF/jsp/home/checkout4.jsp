<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/home/header.jsp" />
<jsp:include page="/WEB-INF/jsp/home/navbar.jsp" />
<div id="all">
    <div id="content">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <!-- breadcrumb-->
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="/home/home">Home</a></li>
                            <li aria-current="page" class="breadcrumb-item active">Checkout - Order review</li>
                        </ol>
                    </nav>
                </div>
                <div id="checkout" class="col-lg-9">
                    <div class="box">
                        <form method="post" action="/orders/save">
                            <h1>Checkout - Order review</h1>
                            <div class="nav flex-column flex-sm-row nav-pills"><a href="/home/checkout1" class="nav-link flex-sm-fill text-sm-center"> <i class="fa fa-map-marker">                  </i>Address</a><a href="/home/checkout2" class="nav-link flex-sm-fill text-sm-center"> <i class="fa fa-truck">                       </i>Delivery Method</a><a href="/home/checkout3" class="nav-link flex-sm-fill text-sm-center"> <i class="fa fa-money">                      </i>Payment Method</a><a href="#" class="nav-link flex-sm-fill text-sm-center active"> <i class="fa fa-eye">                     </i>Order Review</a></div>
                            <div class="content">
                                <div class="table-responsive">
                                    <table class="table" id="basket">
                                        <thead>
                                            <tr>
                                                <th colspan="2">Product</th>
                                                <th>Quantity</th>
                                                <th>Unit price</th>
                                                <th>Discount</th>
                                                <th>Total</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="t" items="${map.tList}">
                                                <tr class="MyClass">
                                                    <td><a href="#"><img src="/resources/product/img/${t.pPhoto}" alt="White Blouse Armani"></a></td>
                                                    <td><a href="#">${t.pName}</a></td>
                                                    <td>${t.qty}</td>
                                                    <td>${t.pPrice}</td>
                                                    <td>${t.discount}</td>
                                                    <td>${t.total}</td>
                                                </tr>
                                            <td>
                                                <input type="text" name="ids[]" value="${t.id}"/>
                                                <input type="text" name="pId[]" value="${t.pId}"/>
                                                <input type="text" name="pName[]" value="${t.pName}"/>
                                                <input type="text" name="pCode[]" value="${t.pCode}"/>
                                                <input type="text" name="pPhoto[]" value="${t.pPhoto}"/>
                                                <input type="text" name="pPrice[]" class="p-price" value="${t.pPrice}"/>
                                                <input type="text" name="discount[]" class="p-discount" value="${t.discount}"/>
                                                <input type="text" name="qty[]" value="${t.qty}"/>
                                                <input type="text" name="total[]" id="total" class="p-total" value="${t.total}"/>
                                                <input type="text" name="cId[]" id="" value="${t.cId}"/>

                                            </td>
                                        </c:forEach>
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <th colspan="5">Total</th>
                                                <th class="lblTotal" id="lblTotal"></th>
                                            </tr>
                                        </tfoot>
                                        <input type="text" name="subtotal" id="subtotal"/>
                                        <input type="text" name="vat" id="vat" value="5"/>
                                        <input type="text" name="dCharge" id="dCharge" value="150"/>
                                        <input type="text" name="grandTotal" id="grandTotal"/>
                                    </table>
                                </div>
                                <!-- /.table-responsive-->
                            </div>
                            <!-- /.content-->
                            <div class="box-footer d-flex justify-content-between"><a href="/home/checkout3" class="btn btn-outline-secondary"><i class="fa fa-chevron-left"></i>Back to payment method</a>
                                <button type="submit" class="btn btn-primary">Place an order<i class="fa fa-chevron-right"></i></button>

                            </div>
                        </form>
                    </div>
                    <!-- /.box-->
                </div>
                <!-- /.col-lg-9-->
                <div class="col-lg-3">
                    <div id="order-summary" class="card">
                        <div class="card-header">
                            <h3 class="mt-4 mb-4">Order summary</h3>
                        </div>
                        <div class="card-body">
                            <p class="text-muted">Shipping and additional costs are calculated based on the values you have entered.</p>
                            <div class="table-responsive">
                                <table class="table">
                                    <tbody>
                                        <tr>
                                            <td>Order subtotal</td>
                                            <th class="sub-total"></th>
                                        </tr>
                                        <tr>
                                            <td>Vat</td>
                                            <th>5</th>
                                        </tr>
                                        <tr>
                                            <td>Delivery charge</td>
                                            <th>150</th>
                                        </tr>
                                        <tr>
                                            <td>Total</td>
                                            <th class="grand-total"></th>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.col-lg-3-->
            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/jsp/home/footer1.jsp" />



<jsp:include page="/WEB-INF/jsp/home/footer.jsp" />
<script>
    var sum = 0;
    function calcTotal() {
        sum = 0;
        $('#basket tbody tr').each(function () {
            $(this).find('.p-total').each(function () {
                var combat = parseInt($(this).val());
                calc(combat);
            });
            $("#lblTotal").text(sum);
            //After working
            var lblTotal = $("#lblTotal").text();
            $("#sub").text(lblTotal);
            var vat = parseFloat(lblTotal) * 0.05;
            var intotal = parseInt(lblTotal) + vat;
            var grandTotal = intotal + 150;
            console.log(grandTotal);
            $("#grandTotal").val(grandTotal);
            $("#subtotal").val(lblTotal);
            $("#grandTotal").text(grandTotal);
            $(".grand-total").text(grandTotal);
            $(".sub-total").text(lblTotal);

        });

    }
    function calc(a) {
        sum += a;
        console.log(sum)
    }

    calcTotal();
</script>