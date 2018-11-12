<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false"%>
<h2>Basic TreeGrid</h2>
<p>TreeGrid allows you to expand or collapse group rows.</p>
<div style="margin:20px 0;"></div>
<table title="Folder Browser" class="easyui-treegrid" style="width:700px;height:250px"
       data-options="
				url: '${pageContext.request.contextPath}/Album/finAllAlbum',
				method: 'post',
				rownumbers: true,
				idField: 'id',
				treeField: 'title'
			">
    <thead>
    <tr>
        <th data-options="field:'id'" width="220" hidden:true>Name</th>
        <th data-options="field:'title'" width="100" align="">Size</th>
        <th data-options="field:'duration'" width="150">Modified Date</th>
        <th data-options="field:'downPath'" width="150">Modified Date</th>
    </tr>
    </thead>
</table>
