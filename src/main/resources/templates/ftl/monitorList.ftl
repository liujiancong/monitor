<!doctype html>
<html lang="en" class="fixed">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>系统详情</title>
    <link rel="apple-touch-icon" sizes="120x120" href="favicon/apple-icon-120x120.png">
    <link rel="icon" type="image/png" sizes="192x192" href="favicon/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32" href="favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="favicon/favicon-16x16.png">
    <link rel="stylesheet" type="text/css" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.6.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="vendor/animate.css/animate.css">
    <link rel="stylesheet" href="vendor/data-table/media/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="stylesheets/css/style.css">
</head>

<body>
<div class="wrap">

    <#include "pageHeader.ftl">
    
    <div class="page-body">
    
       <#include "lefter.ftl">
       
        <div class="content">
            <div class="content-header">
                <div class="leftside-content-header">
                    <ul class="breadcrumbs">
                        <li><i class="fa fa-table" aria-hidden="true"></i><a href="#">监控</a></li>
                        <li><a>监控列表</a></li>
                    </ul>
                </div>
            </div>
            <div class="row animated fadeInRight">
                <div class="col-sm-12">
                    <h4 class="section-subtitle"><b>列表展示</b></h4>
                    <div class="panel">
                        <div class="panel-content">
                            <div class="table-responsive">
                                <table id="basic-table" class="data-table table table-striped nowrap table-hover" cellspacing="0" width="100%">
                                    <thead>
                                    <tr>
                                        <th>监控名称</th>
                                        <th>监控类型</th>
                                        <th>状态</th>
                                        <th>创建时间</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    
                                    <#list tbMonitorList as p>
									<tr>
										<td>${p.monitorName}</td>
                                        <td>${p.monitorType}</td>
                                        <td>${p.status}</td>
                                        <td>${p.create_time?string('yyyy.MM.dd HH:mm:ss')}</td>
                                        <td>
                                        	<a href="/viewMonitor?id=${p.id}">查看</a>
											<a href="/editMonitor?id=${p.id}">编辑</a>
											<a href="javascript:;" data-id="19" data-opt="del" onclick="showDialog('${p.id}')">删除</a>
										</td>
									</tr>
                                    </#list>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modal-error-label" style="display: none;">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header state modal-danger">
                        <button type="button" onclick="closeDialog()" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="modal-error-label"><i class="fa fa-warning"></i>Danger</h4>
                    </div>
                    <div class="modal-body">
                        	确认删除？
                    </div>
                    <div class="modal-footer">
                        <button id="confirmButton" type="button" class="btn btn-danger" data-dismiss="modal" onclick="deleteMonitor()">确认</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="closeDialog()">取消</button>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="modal fade" id="info-modal" tabindex="-1" role="dialog" aria-labelledby="modal-success-label">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header state modal-success">
                        <button type="button" onclick="closeInfo()" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="modal-success-label"><i class="fa fa-check"></i>Success</h4>
                    </div>
                    <div class="modal-body">
                        	删除成功！
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-success" data-dismiss="modal" onclick="closeInfo()">Ok</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="closeInfo()">Close</button>
                    </div>
                </div>
            </div>
        </div>
                            
        <#include "righter.ftl">

        <a href="#" class="scroll-to-top"><i class="fa fa-angle-double-up"></i></a>
    </div>
</div>
<script src="javascripts/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="vendor/nano-scroller/nano-scroller.js"></script>
<script src="javascripts/template-script.min.js"></script>
<script src="javascripts/template-init.min.js"></script>
<script src="vendor/data-table/media/js/jquery.dataTables.min.js"></script>
<script src="vendor/data-table/media/js/dataTables.bootstrap.min.js"></script>
<script src="javascripts/examples/tables/data-tables.js"></script>

<script>

$(function(){
	$('#jk').addClass('open-item active-item').removeClass('close-item');
	$('#jkList').addClass('active-item');
});

function showDialog(id){
	$("#delete-modal").addClass('in').css('display', 'block');
	$("#confirmButton").val(id)
}

function closeDialog(){
	$("#delete-modal").removeClass('in').css('display', 'none');
}

function closeInfo(){
	$("#info-modal").removeClass('in').css('display', 'none');
	window.location.reload()
}
 
function deleteMonitor(){
	//异步提交
	$.ajax({ 
		url: "/deleteMonitor", 
		data: {
			"id": $("#confirmButton").val()
		}, 
		success: function(){
       		 $("#info-modal").addClass('in').css('display', 'block');
     	}});
	closeDialog()
}


</script>
</body>








</html>
