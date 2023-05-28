<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Student List</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
  <div class="container">
    <h1>Student List</h1>
    <table class="table">
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Total Marks</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="student" items="${students}">
          <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.totalMarks}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <div class="text-center">
      <c:if test="${totalPages > 1}">
        <nav>
          <ul class="pagination justify-content-center">
            <li class="page-item ${currentPage == 1 ? 'disabled' : ''}">
              <a class="page-link" href="?page=${currentPage - 1}">Previous</a>
            </li>
            <c:forEach var="pageNum" begin="1" end="${totalPages}">
              <li class="page-item ${pageNum == currentPage ? 'active' : ''}">
                <a class="page-link" href="?page=${pageNum}">${pageNum}</a>
              </li>
            </c:forEach>
            <li class="page-item ${currentPage == totalPages ? 'disabled' : ''}">
              <a class="page-link" href="?page=${currentPage + 1}">Next</a>
            </li>
          </ul>
        </nav>
      </c:if>
    </div>
    <form class="my-4" action="${pageContext.request.contextPath}/filter" method="post">
      <div class="form-row">
        <div class="col-md-4">
          <input type="text" class="form-control" name="nameFilter" placeholder="Filter by Name">
        </div>
        <div class="col-md-4">
          <input type="number" class="form-control" name="marksFilter" placeholder="Filter by Total Marks">
        </div>
        <div class="col-md-4">
          <button type="submit" class="btn btn-primary">Apply Filters</button>
        </div>
      </div>
    </form>
  </div>
</body>
</html>
