/**
 * 
 */

//学生开课查询

function stu_class_search(){
	$("#btn2").css("display","none");
	$("#help1").css("display","none");
	$("#btn1").css("display","block");
	$("#stu_search").css("display","block");
	$("#hide_table").css("display","block");
	$.ajax({

        type : "post",
        //url 要写正确
        url : "KcService",
        success : function(data) {
        	 var da = eval("(" + data + ")");
        	 console.log(da[0]);
        	layui.use('table', function(){
      		  var table = layui.table;
      		  
      		  table.render({
      		    elem: '#test'
      		    ,url:''
      		    ,data:da
      		    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
      		    ,cols: [[
      		      {field:'cno',  title: '课程号'}
      		      ,{field:'cname', title: '课程名'}
      		      ,{field:'credit',  title: '学分'}
      		    ]],
      		    id:"testReload"
      		    ,page: true
      		  });
    
      		}); 
        },
        complete : function(argument) {

        },
        error : function(argument) {
            alert('error');
        }
    });

}

function class_search(){
	$("#xsxxsearch").css("display","none");
	$("#gradesearch").css("display","none");
	$("#help2").css("display","none");
	$("#button3").css("display","none");
	$("#button2").css("display","none");
	$("#button1").css("display","block");
	$("#tea_search").css("display","block");
	$("#hide_table1").css("display","block");
	$.ajax({

        type : "post",
        //url 要写正确
        url : "KcService",
        success : function(data) {
        	 var da = eval("(" + data + ")");
        	 console.log(da[0]);
        	layui.use('table', function(){
      		  var table = layui.table;
      		  
      		  table.render({
      		    elem: '#test1'
      		    ,url:''
      		    ,data:da
      		    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
      		    ,cols: [[
      		      {field:'cno',  title: '课程号'}
      		      ,{field:'cname',  title: '课程名'}
      		      ,{field:'credit',  title: '学分'}
      		    ]]
      		  
      		    ,page: true
      		  });
    
      		}); 
        },
        complete : function(argument) {

        },
        error : function(argument) {
            alert('error');
        }
    });

}


//学生成绩查询
function stu_grade_search(){
	$("#btn1").css("display","none");
	$("#help1").css("display","none");
	$("#btn2").css("display","block");
	$("#stu_search").css("display","block");
	$("#hide_table").css("display","block");
	$.ajax({

        type : "post",
        //url 要写正确
        url : "CjcxService",
        success : function(data) {
        	 var da = eval("(" + data + ")");
        	 console.log(da[2]);
        	 layui.use('table', function(){
       		  var table = layui.table;
       		  
       		  table.render({
       		    elem: '#test'
       		    ,url:''
       		    ,data:da
       		    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
       		    ,cols: [[
       		      {field:'sno',  title: '学号', sort: true}
       		      ,{field:'sname', title: '姓名'}
       		      ,{field:'sclass', title: '班级'}
       		      ,{field:'total',title:'总分'}
       		      ,{field:'rank', title: '排名'}
       		      ,{field:'001' , title:'线形代数'}
       		      ,{field:'002' , title:'政治经济原理'}
       		      ,{field:'003' , title:'数据结构'}
       		      ,{field:'004' , title:'英语'}
       		      ,{field:'005' , title:'C++'}        
       		      ,{field:'006' , title:'电子技术'}
       		      ,{field:'007' , title:'计算机组成原理'}
       		      ,{field:'008' , title:'计算机网络'}
       		      ,{field:'009' , title:'哲学原理'}
       		      ,{field:'010' , title:'数值分析'}
       		      ,{field:'011' , title:'体育'}
       		    ]]
       		   ,page:true
       		  });
       		
       		});
     
        },
        complete : function(argument) {

        },
        error : function(argument) {
            alert('error');
        }
    });
}
//老师成绩查询
function grade_search(){
	$("#xsxxsearch").css("display","none");
	$("#gradesearch").css("display","none");
	$("#help2").css("display","none");
	$("#button3").css("display","none");
	$("#button1").css("display","none");
	$("#button2").css("display","block");
	$("#tea_search").css("display","block");
	$("#hide_table1").css("display","block");
	$.ajax({

        type : "post",
        //url 要写正确
        url : "CjcxService",
        success : function(data) {
        	 var da = eval("(" + data + ")");
        	 console.log(da[2]);
        	 layui.use('table', function(){
       		  var table = layui.table;
       		  
       		  table.render({
       		    elem: '#test1'
       		    ,url:''
       		    ,data:da
       		    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
       		    ,cols: [[
       		      {field:'sno',  title: '学号', sort: true}
       		      ,{field:'sname', title: '姓名'}
       		      ,{field:'sclass', title: '班级'}
       		      ,{field:'total',title:'总分'}
       		      ,{field:'rank', title: '排名'}
       		      ,{field:'001' , title:'线形代数'}
       		      ,{field:'002' , title:'政治经济原理'}
       		      ,{field:'003' , title:'数据结构'}
       		      ,{field:'004' , title:'英语'}
       		      ,{field:'005' , title:'C++'}        
       		      ,{field:'006' , title:'电子技术'}
       		      ,{field:'007' , title:'计算机组成原理'}
       		      ,{field:'008' , title:'计算机网络'}
       		      ,{field:'009' , title:'哲学原理'}
       		      ,{field:'010' , title:'数值分析'}
       		      ,{field:'011' , title:'体育'}
       		    ]]
       		   ,page:true
       		  });
       		
       		});
     
        },
        complete : function(argument) {

        },
        error : function(argument) {
            alert('error');
        }
    });
}

//学生信息查询
function xx_search(){
	$("#xsxxsearch").css("display","none");
	$("#gradesearch").css("display","none");
	$("#help2").css("display","none");
	$("#button1").css("display","none");
	$("#button2").css("display","none");
	$("#button3").css("display","block");
	$("#tea_search").css("display","block");
	$("#hide_table1").css("display","block");
	$.ajax({

        type : "post",
        //url 要写正确
        url : "StuService",
        success : function(data) {
        	 var da = eval("(" + data + ")");
        	 console.log(da[0]);
        	layui.use('table', function(){
      		  var table = layui.table;
      		  
      		  table.render({
      		    elem: '#test1'
      		    ,url:''
      		    ,data:da
      		    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
      		    ,cols: [[
      		      {field:'sno', width:250, title: '学号', sort: true}
      		      ,{field:'sname', width:250, title: '姓名'}
      		      ,{field:'sex', width:250, title: '性别'}
      		      ,{field:'sclass', width:250, title: '班级'}
      		      ,{field:'sage', title: '年龄', width:250,sort: true} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
      		    
      		    ]]
      		,page:true
      		  });
      		 
      		}); 
        },
        complete : function(argument) {

        },
        error : function(argument) {
            alert('error');
        }
    });
	
}
function help2(){
	
	$("#xsxxsearch").css("display","none");
	$("#gradesearch").css("display","none");
	$("#tea_search").css("display","none");
	$("#hide_table1").css("display","none");
	$("#help2").css("display","block");
}
function help1(){
	
	$("#stu_search").css("display","none");
	$("#hide_table").css("display","none");
	$("#help1").css("display","block");
}
function login() {

    var username = $("#signin-inp1").val();
    var password = $("#signin-inp2").val();
    
    if( $("#stud").is(":checked") == true){
    //	alert("djask");
    	$.ajax({
            type : "post",
            //url 要写正确
            url : "UserService?username=" + username,
            success : function(data) {
                var da = eval("(" + data + ")");   
                var html = "";
                if (da != null && da["password"].trim() == password) {
                	$(".login_box").css("display","none");
                	$("#teacher").css("display","none");
                    $("#student").css("display","block");
                    html+="<a href='' class='stu_top_letter  layui-layout-right'>"+username+"</a>";
                    $("#stu_top").append(html);
                } else {
                	alert('用户名或密码错误！');
                   // $("#signin-error").html("用户名或密码错误！")
                }
            },
            complete : function(argument) {

            },
            error : function(argument) {
                alert('学号不存在');
            }
        });	
    }
    
    if($("#teac").is(":checked") == true){
   // 	alert("tsad");
    	$.ajax({
            type : "post",
            url : "ManagerService?username=" + username,
            success : function(data) {
                var da = eval("(" + data + ")");
                var html = "";
                if (da != null && da["password"].trim() == password) {
                	$(".login_box").css("display","none");
                	$("#student").css("display","none");
                	$("#teacher").css("display","block");
                	html+="<a href='' class='stu_top_letter  layui-layout-right '>"+username+"</a>";
                	$("#tea_top").append(html);
                } else {
                	alert('用户名或密码错误！');
                   // $("#signin-error").html("用户名或密码错误！")
                }
            },
            complete : function(argument) {

            },
            error : function(argument) {
                alert('用户不存在');
            }
        });
    }
    
}

