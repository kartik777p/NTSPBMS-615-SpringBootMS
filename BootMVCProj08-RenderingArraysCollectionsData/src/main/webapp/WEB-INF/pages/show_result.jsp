<%@page isELIgnored="false"%>
<!-- For loop req for print List,Set,So wrtiting java code in Jsp is not Recomanded  -->
<!-- So use JSTL Tag  -->

<!-- Import JSTL Library -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>Model data is(Arrays,Collections ) :-</h1>
<br>
<h2>Favoriate Colors(Array) :-</h2>
<!-- check favColors are not empty -->
<c:if test="${!empty favColors }">
	<c:forEach var="color" items="${favColors }">
		<!-- each time will get one color and we are printing that color  -->
      ${color }<br>
	</c:forEach>
</c:if>
<br>

<h2>Nick Names(List) :- </h2>
<!-- check nickNames are not empty -->
<c:if test="${!empty nickNames }">
 <c:forEach var="nickName" items="${nickNames }">
  ${nickName }<br>
 </c:forEach>
</c:if>
<br>

<h2>phone Numbers(Set) :- </h2>
<!-- check phone Numbers are not empty -->
<c:if test="${!empty phoneNumbers }">
    <c:forEach var="phone" items="${phoneNumbers }">
         ${phone }<br>
    </c:forEach>
</c:if>
<br>

<!-- print only value  of the map -->
<h2>Id Details (Map)(only value print ) :- </h2>
<c:if test="${!empty idDetails }">
   <!-- submit key and get values -->
   ${idDetails.AdharNo }<br>
   ${idDetails.panNo }
</c:if>
<br>

<!-- print only value  of the map -->
<h2>Id Details (Map)printing Key,value :-</h2>
<c:if test="${!empty idDetails }">
<c:forEach var="id" items="${idDetails }">
   ${id.key }----------> ${id.value } <br>
   </c:forEach>
</c:if>
 