<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!--  <script src="./main.js"></script> -->
</head>
<body>
<h1>와이파이 정보 구하기</h1>
<a href="">홈</a>
<a href="">위치 히스토리 목록</a>
<a href="data-load.do">Open API 와이파이 정보 가져오기</a>
<br><br>

<div>
    <label for="latt">LAT:</label>
    <input type="text" id="latt" value="" >

    <label for="lntt">, LNT:</label>
    <input type="text" id="lntt">

    <input type="button" value="내 위치 가져오기" onclick="navigator.geolocation.getCurrentPosition(onGeoOk,onGeoError)">
    <input type="submit" value="근처 WIPI 정보 보기">

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

<script>
    function onGeoOk(position){
        const lat = position.coords.latitude;
        const lnt = position.coords.longitude;
        document.getElementById("latt").innerHTML=lat;
        document.getElementById("lntt").innerHTML=lnt;
        console.log("You live in", lat, lng);
    }
    function onGeoError(){
        alert("Can't find you. No weather for you.");
    }
</script>

</body>
</html>