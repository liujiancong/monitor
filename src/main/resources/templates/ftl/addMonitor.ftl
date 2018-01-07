<!doctype html>
<html lang="en" class="fixed">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>Helsinki</title>
    <link rel="apple-touch-icon" sizes="120x120" href="favicon/apple-icon-120x120.png">
    <link rel="icon" type="image/png" sizes="192x192" href="favicon/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32" href="favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="favicon/favicon-16x16.png">
    <link rel="stylesheet" type="text/css" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.6.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="vendor/animate.css/animate.css">
    <link rel="stylesheet" href="stylesheets/css/style.css">
    <link rel="stylesheet" href="vendor/select2/css/select2.min.css">
    <link rel="stylesheet" href="vendor/select2/css/select2-bootstrap.min.css">
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
                        <li><i class="fa fa-columns" aria-hidden="true"></i><a href="#">监控</a></li>
                        <li><a>新建</a></li>
                    </ul>
                </div>
            </div>
            <div class="row animated fadeInUp">
                <div class="col-sm-12">
                    <h4 class="section-subtitle"><b>新建监控</b></h4>
                    <div class="panel">
                        <div class="panel-content">
                            <div class="row">
                                <div class="col-md-12">
                                    <form id="saveMonitor" action="/saveMonitor" method="POST" class="form-horizontal form-stripe">
                                        <div class="form-group">
                                            <label for="name" class="col-sm-3 control-label">监控系统<span class="required">*</span></label>
 											 <div class="col-sm-6">
                                                <select name="dbId" id="select-system" class="form-control" style="width: 50%">
 													<option value="请选择" label="请选择"></option>
													<#list tbSystemList as d>
														<option value="${d.dbId}" label="${d.name}"></option>
													</#list>
                                            	</select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="username" class="col-sm-3 control-label">监控名称<span class="required">*</span></label>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" id="monitorName" name="monitorName" required>
                                            </div>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label for="dbDriverClass" class="col-sm-3 control-label">监控类型<span class="required">*</span></label>
                                             <div class="col-sm-6">
                                                 <select name="monitorType" id="select-system" class="form-control" style="width: 50%">
 													<option value="请选择" label="请选择"></option>
														<option value="阀值" label="阀值"></option>
                                            	</select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="dbUrl" class="col-sm-3 control-label">监控频率<span class="required">*</span></label>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" id="cornExpression" name="cornExpression" required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="dbUrl" class="col-sm-3 control-label">告警通知人<span class="required">*</span></label>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" id="monitorPerson" name="monitorPerson" required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="dbPassword" class="col-sm-3 control-label">阀值</label>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" id="monitorValue" name="monitorValue">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="dbPassword" class="col-sm-3 control-label">监控脚本</label>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" id="monitorSql" name="monitorSql">
                                            </div>
                                        </div>
                                       
                                        <div class="form-group">
                                            <div class="col-sm-offset-3 col-sm-9">
                                                <button type="Submit" class="btn btn-primary">保存</button>
                                                <a href="/getMonitorList">
                                                <button type="button" class="btn btn-primary">取消</button></a>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
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
<script src="vendor/jquery-validation/jquery.validate.min.js"></script>
<script src="javascripts/examples/forms/validation.js"></script>
<script src="vendor/select2/js/select2.min.js"></script>
<script>
	$(function(){
		$('#jk').addClass('open-item active-item').removeClass('close-item');
		$('#newjk').addClass('active-item');
	});

</script>
</body>

</html>
