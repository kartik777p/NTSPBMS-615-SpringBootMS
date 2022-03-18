<%@page isELIgnored="false"%>
<!-- For loop req for print List,Set,So wrtiting java code in Jsp is not Recomanded  -->
<!-- So use JSTL Tag  -->

<!-- Import JSTL Library -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>Model data is(Product ) :-</h1>
<br>
<c:if test="${!empty productData }">
   Product id :-${productData.id } <br>
   Product Name :-${productData.name }<br> 
   Product Quantity :-${productData.qty } <br>
   Product Rate :-${productData.rate } <br>
</c:if>
