/**
 * 
 */
//老师成绩修改
function grade_update(){
	$("#tea_search").css("display","none");
	$("#xsxxsearch").css("display","none");
	$("#help2").css("display","none");
	$("#gradesearch").css("display","block");
	$("#hide_table1").css("display","block");
	$.ajax({

        type : "post",
        //url 要写正确
        url : "ScService",
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
       		      {field:'sno', width:300, title: '学号', sort: true}
       		      ,{field:'cno', width:300, title: '课程号'}
       		      ,{field:'grade', width:300, title: '成绩', sort: true}
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
function insertgrade(){
	var sno = $("#gradesno").val();
//	alert(sno);
	var cno = $("#gradecno").val();
//	alert(cno);
	var grade = $("#gradegrade").val();
//	alert(grade);
	var new_url = "insertScService?sno="+sno+"&cno="+cno+"&grade="+grade;
	$.ajax({

        type : "post",
        //url 要写正确
        url : new_url,
        success : function(data) {
        	if(data == "error1"){
        		alert("输入有误");
        	}
        	if(data == "error"){
        		alert("学号不存在或者课程号错误");
        	}
        	if(data == "success"){
        		alert("学生成绩增加成功");
        		$.ajax({

        	        type : "post",
        	        //url 要写正确
        	        url : "ScService",
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
        	       		      {field:'sno', width:300, title: '学号', sort: true}
        	       		      ,{field:'cno', width:300, title: '课程号'}
        	       		      ,{field:'grade', width:300, title: '成绩', sort: true}
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
        	
     
        },
        complete : function(argument) {

        },
        error : function(argument) {
            alert('error');
        }
    });
	
	
}

function deletegrade(){
	var sno = $("#gradesno").val();
//	alert(sno);
	var cno = $("#gradecno").val();
//	alert(cno);
	var grade = $("#gradegrade").val();
//	alert(grade);
	var new_url = "deleteScService?sno="+sno+"&cno="+cno;
	$.ajax({

        type : "post",
        //url 要写正确
        url : new_url,
        success : function(data) {
        	if(data == "error"){
        		alert("输入有误");
        	}
        	if(data == "success"){
        		alert("学生成绩删除成功");
        		$.ajax({

        	        type : "post",
        	        //url 要写正确
        	        url : "ScService",
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
        	       		      {field:'sno', width:300, title: '学号', sort: true}
        	       		      ,{field:'cno', width:300, title: '课程号'}
        	       		      ,{field:'grade', width:300, title: '成绩', sort: true}
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
     
        },
        complete : function(argument) {

        },
        error : function(argument) {
            alert('error');
        }
    });
	
	
}


function updategrade(){
	var sno = $("#gradesno").val();
//	alert(sno);
	var cno = $("#gradecno").val();
//	alert(cno);
	var grade = $("#gradegrade").val();
//	alert(grade);
	var new_url = "updateScService?sno="+sno+"&cno="+cno+"&grade="+grade;
	$.ajax({
        type : "post",
        //url 要写正确
        url : new_url,
        success : function(data) {
        	if(data == "error"){
        		alert("输入有误");
        	}
        	if(data == "error1"){
        		alert("学号不存在，请重新输入");
        	}
        	if(data == "success"){
        		alert("学生成绩修改成功");
        		$.ajax({

        	        type : "post",
        	        //url 要写正确
        	        url : "ScService",
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
        	       		      {field:'sno', width:300, title: '学号', sort: true}
        	       		      ,{field:'cno', width:300, title: '课程号'}
        	       		      ,{field:'grade', width:300, title: '成绩', sort: true}
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
     
        },
        complete : function(argument) {

        },
        error : function(argument) {
            alert('error');
        }
    });
}

function xx_update(){
	$("#tea_search").css("display","none");
	$("#gradesearch").css("display","none");
	$("#help2").css("display","none");
	$("#xsxxsearch").css("display","block");
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
function insertxsxx(){
	var sno = $("#xsxxsno").val();
	var sname=$("#xsxxname").val();
	var sex = $("#xsxxsex").val();
	var sclass = $("#xsxxclass").val();
	var sage = $("#xsxxage").val();
	var new_url = "insertStuService?sno="+sno+"&sname="+sname+"&sex="+sex+"&sclass="+sclass+"&sage="+sage;
	$.ajax({

        type : "post",
        //url 要写正确
        url : new_url,
        success : function(data) {
        	if(data=="error"){
        		alert("学号已存在");
        	}
        	if(data=="error1"){
        		alert("学号不存在，请重新输入");
        	}
        	if(data == "success"){
        		alert("学生信息插入成功");
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
        },
        complete : function(argument) {

        },
        error : function(argument) {
            alert('error');
        }
    });
}

function deletexsxx(){
	var sno = $("#xsxxsno").val();
	var new_url = "deleteStuService?sno="+sno;
	$.ajax({

        type : "post",
        //url 要写正确
        url : new_url,
        success : function(data) {
        	if(data=="error"){
        		alert("学号不存在");
        	}
        	if(data == "success"){
        		alert("学生信息删除成功");
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
        },
        complete : function(argument) {

        },
        error : function(argument) {
            alert('error');
        }
    });
}

function updatexsxx(){
	var sno = $("#xsxxsno").val();
	var sname=$("#xsxxname").val();
	var sex = $("#xsxxsex").val();
	var sclass = $("#xsxxclass").val();
	var sage = $("#xsxxage").val();
	var new_url = "updateStuService?sno="+sno+"&sname="+sname+"&sex="+sex+"&sclass="+sclass+"&sage="+sage;
	$.ajax({

        type : "post",
        //url 要写正确
        url : new_url,
        success : function(data) {
        	if(data=="error"){
        		alert("学号不存在");
        	}
        	if(data == "success"){
        		alert("学生信息修改成功");
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
        },
        complete : function(argument) {

        },
        error : function(argument) {
            alert('error');
        }
    });
}
