<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh" class="e7u_back">
<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta http-equiv="X-UA-Compatible" content="ie=edge" />
	<title>Login</title>
	<link rel="stylesheet" type="text/css" href="css/allcss.css"/>
	<link rel="stylesheet" type="text/css" href="js/layui/css/layui.css"/>
  </head>
  <body>
  <!-- 登录页面 -->
  <div class="login_box">
  <fieldset class="layui-elem-field site-demo-button" style="margin-top: 30px;">
  <legend align="center">登录</legend>
    <form action="" method="post" id="login_form">
    
	    <div class="form-box" class="layui-form layui-form-pane">
	     
	      <div class="layui-form-item">
	      	<label class="layui-form-label">用户名</label>
	      	<div class="layui-input-inline">
	          	<input id="signin-inp1" type="text" name="userName" class="layui-input">
	        	</div>    
	      </div>
	      <div class="layui-form-item">
	      	<label class="layui-form-label">密码</label>
	      	<div class="layui-input-inline">
	          	<input id="signin-inp2"type="text" name="passWord" class="layui-input">
	        </div>  
	      </div>
	      <div style="margin-left:200px;" id="checks">
		  	<input type="checkbox" id="stud"><span>学生</span>
		  	<input type="checkbox" id="teac"><span>系统管理员</span>
		  </div>
	    </div>
    </form>
    <div class="layui-form-item" align="center">          
    	<input type="submit" name="" id="frmSubmit" value="提交" class="submit_button" onclick="login()"/>
    </div>
    </fieldset>
  </div>
  
  <!-- 学生页面-->
  
  <div class="stu" style="display:none" id="student">
	<div class="stu_top" id="stu_top">
		<span style="font-size: 20px;padding: 0 20px;">学生</span>
		<span class="stu_top_letter" onclick="stu_class_search()">开课情况查询</span>
		<span class="stu_top_letter" onclick="stu_grade_search()">学生成绩查询</span>
		<span class="stu_top_letter" onclick="help1()">帮助</span>
	</div>
	
	<div class="demoTable"  id="stu_search" style="display:none">
 		 搜索：
  		<div class="layui-inline">
    		<input name="id" class="layui-input" id="demo1" autocomplete="off">
  		</div>
		<div class="layui-inline">
		<button class="layui-btn" id="btn1" onclick="stu_KcSelect()">搜索</button>
  		<button class="layui-btn" id="btn2" onclick="stu_Cjcxselect()" style="display:none">搜索</button>
  		</div>
	</div>
	         <div id="help1" style="display:none">
	<pre>
	介绍：
		登录：
			学生登录：账号密码为 学号
			登录附有错误提示
			进入后，右上角会显示进入的用户名，点击用户名退出
			
		查询：
			查询默认按照学号或者课程号进行查询	
	</pre>
	</div>    
	<div id="hide_table">       
	<table class="layui-hide" id="test" ></table>
      </div>
   </div>
   
   
   <!-- 管理员页面  -->
   
   <div class="stu" style="display:none" id="teacher">
	<div class="stu_top" id="tea_top">
		<span style="font-size: 20px;padding: 0 20px;">系统管理员</span>
		<span class="stu_top_letter" onclick="class_search()">开课情况查询</span>
		<span class="stu_top_letter" onclick="grade_search()">学生成绩查询</span>
		<span class="stu_top_letter" onclick="xx_search()">学生信息查询</span>
		<span class="stu_top_letter" onclick="grade_update()">学生成绩维护</span>
		<span class="stu_top_letter" onclick="xx_update()">学生记录维护</span>
		<span class="stu_top_letter" onclick="help2()">帮助</span>
	</div>


	 <div class="demoTable" style="display:none" id="tea_search">
 		 搜索ID：
  		<div class="layui-inline">
    		<input name="id" class="layui-input" id="demoReload1" autocomplete="off">
  		</div>
  		<div class="layui-inline">
  		<button class="layui-btn" id="button1" onclick="KcSelect()" style="display:none">搜索</button>
  		<button class="layui-btn" id="button2" onclick="CjcxSelect()" style="display:none">搜索</button>
  		<button class="layui-btn" id="button3" onclick="StuSelect()" style="display:none">搜索</button>
  		</div>
	</div>    
	    
	
	 <div  class="demoTable" style="display:none" id="gradesearch" >
 		 sno：
  		<div class="layui-inline">
    		<input id="gradesno" name="sno" class="layui-input"  autocomplete="off">
  		</div>
  		 cno：
  		<div class="layui-inline">
    		<input id="gradecno" name="cno" class="layui-input"  autocomplete="off">
  		</div>
  		grade：
  		<div class="layui-inline">
    		<input id="gradegrade" name="grade" class="layui-input" autocomplete="off">
  		</div>
  		<div class="layui-inline">
  		<button class="layui-btn" onclick="insertgrade()">增加</button>
  		<button class="layui-btn" onclick="deletegrade()">删除</button>
  		<button class="layui-btn" onclick="updategrade()">修改</button>
  		</div>
  		
	</div>  

	 <div class="demoTable" style="display:none" id="xsxxsearch" >
 		 学号：
  		<div class="layui-inline">
    		<input id="xsxxsno" name="sno" class="layui-input" id="demoReload1" autocomplete="off">
  		</div>
  		姓名 ：
  		<div class="layui-inline">
    		<input id="xsxxname" name="sname" class="layui-input" id="demoReload1" autocomplete="off">
  		</div>
  		性别：
  		<div class="layui-inline">
    		<input id="xsxxsex" name="sex" class="layui-input" id="demoReload1" autocomplete="off">
  		</div>
  		班级：
  		<div class="layui-inline">
    		<input id="xsxxclass" name="class" class="layui-input" id="demoReload1" autocomplete="off">
  		</div>
  		年龄：
  		<div class="layui-inline">
    		<input id="xsxxage" name="age"class="layui-input" id="demoReload1" autocomplete="off">
  		</div>
  		
  		<div class="layui-inline">
  		<button class="layui-btn" onclick="insertxsxx()">增加</button>
  		<button class="layui-btn" onclick="deletexsxx()">删除</button>
  		<button class="layui-btn" onclick="updatexsxx()">修改</button>
  		</div>
  		
	</div>  
	<div id="help2" style="display:none">
	<pre>
	介绍：
		登录：
			系统管理员登录：账号，密码为 123456
			登录附有错误提示
			进入后，右上角会显示进入的用户名，点击用户名退出
			新增加一个学生，该学生可以通过其学号登录该系统
			
		查询：
			查询默认按照学号或者课程号进行查询
		
		增加和修改：
			增加修改时，不允许输入框内容为空
			
		删除：
			删除课程时，需要填入学号和课程号
			删除学生信息时，只需要输入学生学号即可		
	</pre>
	</div>   
	<div id="hide_table1">          
<table class="layui-hide" id="test1" style="display:none"></table>
  </div> 
	</div>
	
	
  </body>
  <script src="js/jquery-2.1.0.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/layui/layui.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/click.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/change.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/select.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/jquery.validate.js" type="text/javascript" charset="utf-8"></script>
  <script type="text/javascript">
    $(function(){
        $("#login_form").validate({
          rules: {
            userName: {
              required: true, //该项表示该字段为必填项
              number: true ,//表示该字段必须为数字
              digits:true
            //  remote:"check_login.java"
            },
            passWord: {
              required: true
            }
           
          },
          messages: {
            userName: {
              required: "学号不能为空",
              number: "请输入数字",
              digits:"学号不存在，请重新输入！"
            },
            passWord: {
              required: "*必填"
            }
          
          }          
        })   ;
     
        $('#checks').find('input[type=checkbox]').bind('click', function(){
        	$('#checks').find('input[type=checkbox]').not(this).attr("checked", false);	
        });
      });


  </script>
  	
</html>

	
  