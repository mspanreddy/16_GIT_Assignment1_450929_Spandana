<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>Book Details</h3>
<br>
<head>
<script >
function searchBook(){
	var text = document.getElementById('bookId');
	var value = encodeURIComponent(text.value); //encode special characters
	location.href = 'http://localhost:8080/book/'+value; //goto URL
	console.log(newHref)
}

</script>
</head>
<form action='/book/' method='post'>
 
    <table class='table table-hover table-responsive table-bordered'>
 
        <tr>
            <td><b>Title</b></td>
            <td><input type='text' name='title' class='form-control'/></td>
        </tr>
 
        <tr>
            <td><b>Price</b></td>
            <td><input type='text' name='price' class='form-control' size="20"/></td>
            
        </tr>
        <tr>
            <td><b>Volume</b></td>
            <td><input type='text' name='volume' class='form-control' size="20"/></td>
            
        </tr>

        <tr>
            <td></td>
            <td>
                <button type="submit" class="btn btn-primary">Add Book</button>
            </td>
        </tr>
 
    </table>
</form>
 
    <table class="table table-hover">
                <thead>
                    <tr>
                        <th>BookId</th>
                        <th>Title</th>
                        <th>Price</th>
                        <th>Volume</th>
                         <th>Publish Date</th>
                        <th width="100"></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${books}" var="book">
                    <tr>
                        <td>${book.bookId}</td>
                        <td>${book.title}</td>
                        <td>${book.price}</td>
                        <td>${book.volume}</td>
                        <td>${book.publishDate}</td>
                        <td><a href="<c:url value='/delbook/${book.bookId}' />" class="btn btn-success 
custom-width">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <br>
            <br>
    <div>
            <input type="number" id="bookId" autocomplete="off"/>
    		<button onclick='searchBook()'>Search By BookId</button>
    </div>
