<%--
  Created by IntelliJ IDEA.
  User: gril
  Date: 2018/12/28
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        //服务器端返回数据格式：xml，存储在responseXML属性中。
        function chuli() {
            if (myXmlHttpRequest.readyState == 4) {
                if (myXmlHttpRequest.status ==200) {
                    var cities=myXmlHttpRequest.responseXML.getElementsByTagName("city");
                    //若不清零，上次访问的结果还在呢。
                    $('city').length = 0;
                    var myOption =document.createElement("option");
                    myOption.innerText ="--市--";
                    $('city').appendChild(myOption);
                    for (var i = 0; i <cities.length; i++) {
                        var city_name = cities[i].childNodes[0].nodeValue;
                        //创建一个新元素option
                        var myOption = document.createElement("option");
                        myOption.value = city_name;
                        myOption.innerText = city_name;
                        //将新元素添加到……
                        $('city').appendChild(myOption);

                    }
                }
            }
        }
        //服务器端返回数据格式：json，存储在responseText属性中。
        function aa() {
            //通过eval()函数，将返回的json数据转换成JS能够操作的数组对象。
            var res_object =eval("("+myXmlHttpRequest.responseText+")");
            $('ny').innerText = res_object[0].price;
            $('sh').innerText = res_object[1].price;
            $('bl').innerText = res_object[2].price;
        }
        //服务器端返回数据格式：文本格式，存储在responseText属性中
        function exam(){
            var name=document.getElementById("text").value;
            var app;
            if(window.XMLHttpRequest){
                app=new XMLHttpRequest();
            }else{
                app=new ActiveXObject("Microsoft.XMLHTTP");
            }
            app.onreadystatechange=function(){

                if(app.readyState==4 && app.status==200){
                    var ss=app.responseText;
                    if(ss=="error"){
                        document.getElementById("mm").innerHTML="用户名已存在";
                    }else if(ss=="success"){
                        document.getElementById("mm").innerHTML="noproblem";
                    }

                }
                app.open("post", "<%=request.getContextPath()%>/operationServletController?method=xmlHttpRequestText",true);
                app.setRequestHeader("Content-type","application/x-www-form-urlencoded");
                app.send("text"+text);

            }
        }
        function ch() {
            return true;
        }

        /**
         * json，测试
         */
        var app;
        function aa() {
            //创建xhr对象
            if(window.XMLHttpRequest){
                app=new XMLHttpRequest();
            }else{
                app=new ActiveXObject("Microsoft.XMLHTTP");
            }
            //注册onreadystatechange事件
            app.onreadystatechange=callback;
            //发送请求
            app.open("POST","<%=request.getContextPath()%>/operationServletController?method=xmlHttpRequestJson",true);
            app.setRequestHeader("Content-type","application/x-www-form-urlencoded");
            app.send("");
        }
        function callback() {
            if (app.readyState==4 && app.status==200){
                var ss=eval("("+app.responseText+")");
                var html="<table border='1'>";
                for(var i in ss){
                    html+="<tr><td>"+ss[i].name+"</td><td>"+ss[i].age+"</td><td><button onclick='toUpdate("+'"'+ss[i].name+'"'+")'>更新</button></td></tr>";

                }
                html+="</table>";
                document.getElementById("div").innerHTML=html;
            }
        }
        function toUpdate(name) {
            var name=name;
            var age=12;
            document.getElementById("name").value=name;
            document.getElementById("age").value=age;
            document.getElementById("cc").style.display="inline";
        }
        function update() {
            document.getElementById("cc").style.display="none";
        }
    </script>
</head>

<body>
    <br>

    <br>
    <button onclick="aa()">点点</button>
    <div id="div"></div>
    <div id="cc">
        <input type="text" name="name" id="name">用户名<br>
        <input type="text" name="age" id="age" >年龄<br>
        <button onclick="update()">更新</button>

    </div>
    <form action="<%=request.getContextPath()%>/operationServletController?method=xmlHttpRequestText" method="post" onsubmit="return ch()">
        姓名<input type="text" id="text" onblur="exam()" />
        <p style="color: blue;" id="mm"></p>
        <br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
