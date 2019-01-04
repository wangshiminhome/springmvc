<%@page import="com.resj12.date.sysdate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>新用户注册</title>
 <link rel="stylesheet"	type="text/css"	href="css/global.css"	/>
 <link rel="stylesheet"	type="text/css"	href="css/layout.css"	/>
 <script type="text/JavaScript" src="js/func.js"></script>
   <script type="text/javascript">
   	
		   
		   
          function validate() {
              var pwd1 = document.getElementById("pass").value;
              var pwd2 = document.getElementById("rpass").value;
              if(pwd1 != pwd2) {
            	  alert("两次密码不相同,请修改后提交！ ");
                  document.getElementById("submit").disabled = true;
              }
              else {
                  document.getElementById("submit").disabled = false;
              }
          }
      </script>
</head>
<body>
<div id="container">
	<iframe id="header" src="header.html" width="980" height="136" frameborder="0" scrolling="no"></iframe>
    <form id="form1" method="post" action="doregister">
    <table class="reg" cellspacing="0px" cellpadding="0px">
      <tbody>
      <tr>
        <td class="a_r w15p"><label for="fname">请输入注册信息：</label></td>
				<td class="w500"><input type="hidden" name="fname" id="fname" type="text" /></td>
        <td class="protocol" rowspan="11">
    		  <h4><img src="images/read.gif" alt="alt" />阅读睿德Web聊天室服务协议 </h4>
        	<textarea name="textarea" cols="35" rows="15">欢迎阅读服务条款协议，本协议阐述之条款和条件适用于您使用本网站的各种工具和服务。

  本服务协议双方为睿德与睿德聊天室用户，本服务协议具有合同效力。 
  睿德的权利和义务
    1.睿德有义务在现有技术上维护整个网上聊天平台的正常运行，并努力提升和改进技术，使用户网上聊天活动的顺利。 
    2.对用户在注册使用睿德网上平台中所遇到的与聊天或注册有关的问题及反映的情况，睿德应及时作出回复。 
    3.对于在睿德网网上聊天平台上的不当行为或其它任何睿德认为应当终止服务的情况，睿德有权随时作出删除相关信息、终止服务提供等处理，而无须征得用户的同意。 
    4.因网上聊天平台的特殊性，睿德没有义务对所有用户的注册资料、所有的聊天行为以及与聊天有关的其他事项进行事先审查。 	
				  </textarea>
    	  </td> 				
      </tr>
      <tr>
				<td class="a_r" ><label for="sname">登录名：</label></td>
        <td><input name="sname" id="sname" type="text" />（可包含 a-z、0-9 和下划线）</td>
      </tr>
      <tr>
        <td class="a_r"><label for="pass">密码：</label></td>
        <td><input name="pass" id="pass" type="password" />（至少包含 4 个字符）</td>
      </tr>
      <tr>
        <td class="a_r"><label for="rpass">再次输入密码：</label></td>
        <td><input name="rpass" id="rpass" type="password" onblur="validate()" /></td>
      </tr>
      <tr>
        <td class="a_r"><label for="email">电子邮箱：</label></td>
        <td><input name="email" id="email" type="text" />（必须包含 @  字符）</td>
      </tr>
	<tr>
        <td class="a_r"><label for="email">QQ：</label></td>
        <td><input name="qq" id="email" type="text" />（您当前使用的qq号码）</td>
      </tr>
	<tr>
        <td class="a_r"><label for="email">地址：</label></td>
        <td>
			<select name="address">
				<option value="山东省">山东省</option>
				<option value="河北省">河北省</option>
				<option value="甘肃省">甘肃省</option>
				<option value="黑龙江省">黑龙江省</option>
			</select>
		</td>
      </tr>

      <tr>
        <td class="a_r"><label for="gender">性别：</label></td>
				<td>
					<input name="sex" id="gender" class="b0" type="radio" value="男" checked="checked" />
    	    <img src="images/male.gif" alt="" />男&nbsp; 
    	    <input name="sex" class="b0" type="radio" value="女" />
    	    <img src="images/female.gif" alt="" />女

        </td>
      </tr>
      <tr>
        <td class="a_r"><label for="hobby">爱好：</label></td>
        <td>
	   	  	<input class="b0" type="checkbox" name="hobby" id="hobby" value="运动" />&nbsp;运动&nbsp;&nbsp;
  	  	  <input class="b0" type="checkbox" name="hobby" value="聊天" />&nbsp;聊天&nbsp;&nbsp;
    			<input class="b0" type="checkbox" name="hobby" value="玩游戏" />&nbsp;玩游戏

    		</td>
      </tr>
      <tr>
        <td class="a_r"><label for="nYear">出生日期：</label></td>
        <td>
    		<input name="year" id="nYear" class="w40" value="2018" maxlength="4" />&nbsp;年&nbsp;&nbsp;
    	   <select name="month">
    	     <option value="01">一</option>
    	     <option value="02">二</option>
    	     <option value="03">三</option>
    	     <option value="04">四</option>
    	     <option value="05">五</option>
    	     <option value="06">六</option>
    	     <option value="07">七</option>
    	     <option value="08">八</option>
    	     <option value="09">九</option>
    	     <option value="10">十</option>
    	     <option value="11">十一</option>
    	     <option value="12">十二</option>
    	   </select>月
    	  <input name="day" value="10" class="w20" maxlength="2" />日

    	</td>
      </tr>
      <tr>
        <td colspan="2">
			<table>
				<tr>
					<td>
						<input type="image" name="submit" class="b0" src="images/submit.gif" id="submit" />
					</td>
					<td>
						<input type="reset" name="submit"  value="" style="background-image:url(images/reset.gif);width:80px;height:34px;border:0px;" />
					</td>
				</tr>
			</table>
		</td>
      </tr>
      </tbody>
    </table>	
    </form>		
	</div><!--container	end-->

</body>
</html>