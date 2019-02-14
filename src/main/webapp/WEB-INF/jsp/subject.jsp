<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>Subject Details</h3>
<br>
<form>
    <table class="table table-hover">
                <thead>
                    <tr>
                        <th>SubjectId</th>
                        <th>Subject Title</th>
                        <th>DurationInHours</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${subject.subjectId}</td>
                        <td>${subject.subtitle}</td>
                        <td>${subject.durationInHours}</td>
                    </tr>
                </tbody>
            </table>
</form>