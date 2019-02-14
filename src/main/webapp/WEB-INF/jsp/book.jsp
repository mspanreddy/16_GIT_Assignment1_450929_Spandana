<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>Book Details</h3>
<br>
<form>
    <table class="table table-hover">
                <thead>
                    <tr>
                        <th>BookId</th>
                        <th>Title</th>
                        <th>Price</th>
                        <th>Volume</th>
                        <th>Publish Date</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${book.bookId}</td>
                        <td>${book.title}</td>
                        <td>${book.price}</td>
                        <td>${book.volume}</td>
                        <td>${book.publishDate}</td>
                    </tr>
                </tbody>
            </table>
</form>