<%@page isELIgnored="false"%>
<!-- For loop req for print List,Set,So wrtiting java code in Jsp is not Recomanded  -->
<!-- So use JSTL Tag  -->

<!-- Import JSTL Library -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>Model data is(Products ) :-</h1>
<br>
<!-- check list id empty or not if not empty print One by one  
<c:if test="${!empty  productList}"> -->
	<!-- use forEach to print record
  <c:forEach var="product" items="${productList }">
    Product id :- ${product.id }<br>
    Product Name :- ${product.name }<br>
    Product Quantity :- ${product.qty }<br>
    Product Rate  :- ${product.rate }
    <br>
    <br>
  </c:forEach>
</c:if>   -->

	<table
		style="color: red; background-color: yellow; text-align: center;border: 2px">
		<thead>
			<tr>
				<th>PID</th>
				<th>PNAME</th>
				<th>QUANTITY</th>
				<th>PRICE</th>
			</tr>
		</thead>
		<tbody>
		 <c:if test="${!empty  productList}"> 
		  <c:forEach var="product" items="${productList }">
		  <br>
		  <td>${product.id }</td>
		  <td>${product.name }</td>
		  <td>${product.qty }</td>
		  <td>${product.rate }</td>
		  </c:forEach>
		 </c:if>
		</tbody>
	</table>