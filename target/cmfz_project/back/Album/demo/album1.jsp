<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
	var toolbar= [{
		iconCls: 'icon-edit',
		text:'专辑详情',
		handler: function(){
			var selectRow1=$("#album").treegrid("getSelected");
		if(selectRow1!=null){
			if(selectRow1.size==null){
				$("#album_dialog").dialog("open");
				$("#album_form").form("load",selectRow1);
				$("#album_img").prop("src",selectRow1.img);
			}else{
				alert('请选择您要了解的专辑');
			}	
		}else{
			alert('请选择您要了解的专辑');
		}
			
		}
	},'-',
	{
		iconCls: 'icon-add',
		text:'添加专辑',
		handler: function(){
			alert('帮助按钮')
		}
	},'-',
	
	{
		iconCls: 'icon-add',
		text:'添加章节',
		handler: function(){
			var selectRow1=$("#album").treegrid("getSelected");
			if(selectRow1==null){
				alert('请选中一行数据');
			}else{
				if(selectRow1.size==null){
					$("#chapter_dialog").dialog("open");
					$("#album_id").textbox("setValue",selectRow1.id);					
				}else{
					alert('请选中一张专辑');
				}
				
			}
		}
	},'-',
	{	
		iconCls: 'icon-undo',
		text:'下载音频',
		handler: function(){alert('帮助按钮')}
	}]
	

	$(function(){		
			$("#album").treegrid({    
			    url:"${pageContext.request.contextPath}/json/album.json",    
			    idField:'id',    
			    treeField:'name',   
			    fit:true,
			    fitColumns:true,
			    toolbar:toolbar,
			    pagination:true,
			     
			    columns:[[    
			        {field:'name',title:'名称',width:60,align:'right'},    
			        {field:'size',title:'大小',width:80},    
			        {field:'time',title:'时间',width:80},    
			        {field:'url',title:'路径',width:80},    
			    ]]    
});  
		 			
 	
 	});
	
</script>

<table id="album"></table>  

<div id="album_dialog" class="easyui-dialog" title="专辑详情展示" style="width:400px;height:200px;"   
        data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true"> 
        
    <form id="album_form" method="post">   
		    <div>   
		        <label for="name">专辑名称:</label>   
		        <input class="easyui-validatebox" type="text" id="name" name="name" />   
		    </div>   
		    <div>   
		        <label for="count">专辑集数:</label>   
		        <input class="easyui-validatebox" type="text" name="count" id="count" />   
		    </div>   
		    <div>   
		        <label for="album_img">专辑封面:</label>   
		        <img id="album_img" src="" />   
		    </div>   
    
	</form>   
</div>  
<div id="chapter_dialog" class="easyui-dialog" title="专辑详情展示" style="width:400px;height:200px;"   
        data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'SAVE',
				iconCls:'icon-save',
				handler:function(){
					$('#chapter_form').form('submit',{
						url:'${pageContext.request.contextPath}/chapter/add.do'	
					})
				}
			},{
				text:'CLOSE',
				iconCls:'icon-cancel',
				handler:function(){
					$('#chapter_dialog').dialog('close');
				}
			}]">
			
	 <form id="chapter_form" method="post" enctype="multipart/form-data">   
		    <div>   
		        <label for="album_id">id:</label>   
		        <input class="easyui-textbox"  id="album_id" name="id" />   
		    </div>   
		    <div>   
		        <label for="file">章节上传:</label>   
		        <input class="easyui-filebox"  name="file" id="file" />   
		    </div>   		        
	</form>   
        
</div>  
