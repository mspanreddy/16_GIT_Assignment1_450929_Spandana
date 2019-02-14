<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>Subject Details</h3>
<br>
<head>
<script >
function searchSubject(){
	var text = document.getElementById('subjectId');
	var value = encodeURIComponent(text.value); //encode special characters
	location.href = 'http://localhost:8080/subject/'+value; //goto URL
	console.log(newHref)
}

</script>
</head>
<form action='/subject/' method='post'>
 
    <table class='table table-hover table-responsive table-bordered'>
 
        <tr>
            <td><b>Subject Title</b></td>
            <td><input type='text' name='subtitle' class='form-control'/></td>
        </tr>
 
        <tr>
            <td><b>DurationInHours</b></td>
            <td><input type='text' name='durationInHours' class='form-control' size="20"/></td>
            
        </tr>

        <tr>
            <td></td>
            <td>
                <button type="submit" class="btn btn-primary">Add Subject</button>
            </td>
        </tr>
 
    </table>
    
    <table class="table table-hover">
                <thead>
                    <tr>
                        <th>SubjectId</th>
                        <th>Subject Title</th>
                        <th>DurationInHours</th>
                        <th width="100"></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${subjects}" var="subject">
                    <tr>
                        <td>${subject.subjectId}</td>
                        <td>${subject.subtitle}</td>
                        <td>${subject.durationInHours}</td>
                        <td><a href="<c:url value='/delsub/${subject.subjectId}' />" class="btn btn-success 
custom-width">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
</form>
<div>
            <input type="number" id="subjectId" autocomplete="off"/>
    		<button onclick='searchSubject()'>Search By Subject Id</button>
</div>
 
