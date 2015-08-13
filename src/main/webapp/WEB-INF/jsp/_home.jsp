<%--
  Created by IntelliJ IDEA.
  User: existmaster
  Date: 2015. 8. 13.
  Time: 오후 3:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>사다리게임</title>
</head>
<body>
사다리게임 메인 입니다.

<div class="content">

  <h3>회원카드관리</h3>
  <hr>
  <button class="btn btn-primary" type="button" onclick="insertForm();">게임시작</button>

  <table class="table table-striped table-bordered">
    <caption>회원카드목록</caption>
    <thead>
    <tr>
      <th>NO</th>
      <th>회원명</th>
      <th>카드명</th>
      <th>현재 적립금</th>
      <th>설정</th>
    </tr>
    </thead>
    <tbody>
    #foreach ($memberCard in $!{memberCards})
    <tr>
      <td><a href="/memberCard/memberCardDetail?id=$memberCard.id">$memberCard.id</a></td>
      <td>$memberCard.member.name</a></td>
      <td>$memberCard.card.name</td>
      <td>$memberCard.totalPoint</td>
      <td><button class="btn btn-danger" type="button" onclick="payMoney($memberCard.id);">결제하기</button></td>
    </tr>
    #end
    </tbody>
  </table>


</div>

</body>
</html>
