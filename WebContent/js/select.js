/**
 * 
 */
//学生成绩查询
function stu_KcSelect(){

	 var cno = $('#demo1').val();
	$.ajax({

        type : "post",
        //url 要写正确
        url : "KcSelectService?cno=" + cno,
        success : function(data) {
        	 var da = eval("[" + data + "]");
        	 console.log(da);
        	layui.use('table', function(){
      		  var table = layui.table;
      		  
      		  table.render({
      		    elem: '#test'
      		    ,url:''
      		    ,data:da
      		    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
      		    ,cols: [[
      		      {field:'cno',  title: '课程号'}
      		      ,{field:'cname',  title: '课程名'}
      		      ,{field:'credit', title: '学分'}
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

function stu_Cjcxselect(){
	
	 var sno = $('#demo1').val();
	
	$.ajax({

        type : "post",
        //url 要写正确
        url : "CjcxSelectService?sno=" + sno,
        success : function(data) {
        	 var da = eval("[" + data + "]");
       // 	 console.log(da[0]);
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

function KcSelect(){
	
	
	 var cno = $('#demoReload1').val();
	 console.log(cno);
	$.ajax({

       type : "post",
       //url 要写正确
       url : "KcSelectService?cno=" + cno,
       success : function(data) {
       	 var da = eval("[" + data + "]");
       	 console.log(da);
       	layui.use('table', function(){
     		  var table = layui.table;
     		  
     		  table.render({
     		    elem: '#test1'
     		    ,url:''
     		    ,data:da
     		    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
     		    ,cols: [[
     		      {field:'cno', width:250, title: '课程号'}
     		      ,{field:'cname', width:250, title: '课程名'}
     		      ,{field:'credit', width:250, title: '学分'}
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

function CjcxSelect(){
	
	 var sno = $('#demoReload1').val();
	
	 $.ajax({

	        type : "post",
	        //url 要写正确
	        url : "CjcxSelectService?sno=" + sno,
	        success : function(data) {
	        	 var da = eval("[" + data + "]");
	       // 	 console.log(da[0]);
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
function StuSelect(){
	
	
	 var sno = $('#demoReload1').val();
//	 console.log(cno);
	$.ajax({

      type : "post",
      //url 要写正确
      url : "StuSelectService?sno=" + sno,
      success : function(data) {
      	 var da = eval("[" + data + "]");
      	 console.log(da);
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

