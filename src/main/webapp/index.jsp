<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!--  <script src="./main.js"></script> -->

    <style>

        table {
            background-color: #008fff;
            color: white;
            border-collapse: collapse;
            border-color: white;
            margin: 15px;
        }

        td{
            padding: 15px;
        }
    </style>

    <script>
        function getLocation() {
            if (navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(function (position) {
                        alert(position.coords.latitude + ' ' + position.coords.longitude);

                        // $('input[name=latname]').attr('value',position.coords.latitude);
                        // $('input[name=lntname]').attr('value',position.coords.longitude);
                        var lat = position.coords.latitude;
                        document.getElementById("latid").value = lat ;
                        var lnt = position.coords.longitude;
                        document.getElementById("lntid").value = lnt;



                    },
                    function (error) {
                        console.error(error);
                    },
                    {
                        enableHighAccuracy: false,
                        maximumAge: 0,
                        timeout: Infinity
                    });
            } else {
                alert('GPS를 지원하지 않습니다');
            }
        }

    </script>

</head>

<body>
<h1>와이파이 정보 구하기</h1>
<a href="index.jsp">홈</a>
<a href="history.do">위치 히스토리 목록</a>
<a href="wifi.do">Open API 와이파이 정보 가져오기</a>
<br><br>

<div>
    <form action="location.do" method="post">
        <label for="latid">LAT:</label>
        <input type="text" id="latid" name="latname" value="${latname}">


        <label for="lntid">, LNT:</label>
        <input type="text" id="lntid" name="lntname" value="${lntname}">


        <input type="button" value="내 위치 가져오기" onclick="getLocation()">
        <input type="submit" value="근처 WIPI 정보 보기" >
    </form>
</div>

<div>
    <table border="1px">
        <tr>
            <td>거리(Km)</td>
            <td>관리번호</td>
            <td>자치구</td>
            <td>와이파이명</td>
            <td>도로명주소</td>
            <td>상세주소</td>
            <td>설치위치(층)</td>
            <td>설치유형</td>
            <td>설치기관</td>
            <td>서비스구분</td>
            <td>망종류</td>
            <td>설치년도</td>
            <td>실내외구분</td>
            <td>WIFI접속환경</td>
            <td>X좌표</td>
            <td>Y좌표</td>
            <td>작업일자</td>
        </tr>
    </table>
</div>
</body>
</html>