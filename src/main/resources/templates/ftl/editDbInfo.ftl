
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
                        <li><i class="fa fa-columns" aria-hidden="true"></i><a href="#">Forms</a></li>
                        <li><a>Validation</a></li>
                    </ul>
                </div>
            </div>
            <div class="row animated fadeInUp">
                <div class="col-sm-12">
                    <h4 class="section-subtitle"><b>编辑数据源</b></h4>
                    <div class="panel">
                        <div class="panel-content">
                            <div class="row">
                                <div class="col-md-12">
                                    <form id="updateDbInfo" action="/updateDbInfo" method="POST" class="form-horizontal form-stripe">
                                    <input type="hidden" name="id" value="${dbinfo.id}">
                                        <div class="form-group">
                                            <label for="name" class="col-sm-3 control-label">system<span class="required">*</span></label>
                                            <input type="text" class="form-control" id="system" name="system" value="${system}" placeholder="Disabled input" disabled="disabled" style="width: 50%">
                                        </div>
                                        <div class="form-group">
                                            <label for="username" class="col-sm-3 control-label">dbName<span class="required">*</span></label>
                                            <select name="dbName" id="select-dbName" class="form-control" style="width: 50%">
												<#list tbDictionaryList as d>
													<#if d.type=='dbName'>
														<option value="${d.value}" label="${d.value}"></option>
													</#if>
												</#list>
                                            </select>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label for="dbDriverClass" class="col-sm-3 control-label">dbDriverClass<span class="required">*</span></label>
                                            <select name="dbDriverClass" id="select-dbDriverClass" class="form-control" style="width: 50%">
												<#list tbDictionaryList as d>
													<#if d.type=='dbDriverClass'>
														<option value="${d.value}" label="${d.value}"></option>
													</#if>
												</#list>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="dbUrl" class="col-sm-3 control-label">dbUrl<span class="required">*</span></label>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" id="dbUrl" name="dbUrl" required value="${dbinfo.dbUrl}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="dbUser" class="col-sm-3 control-label">dbUser<span class="required">*</span></label>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" id="dbUser" name="dbUser" required value="${dbinfo.dbUser}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="dbPassword" class="col-sm-3 control-label">dbPassword</label>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" id="dbPassword" name="dbPassword" value="${dbinfo.dbPassword}">
                                            </div>
                                        </div>
                                       
                                        <div class="form-group">
                                            <div class="col-sm-offset-3 col-sm-9">
                                                <button type="Submit" class="btn btn-primary">保存</button>
                                                <a href="/getDbInfo">
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
<script>
	$(function(){
		$("#select-system   option[value='${system}']").attr("selected",true);
		$("#select-dbName   option[value='${dbinfo.dbName}']").attr("selected",true);
		$("#select-dbDriverClass   option[value='${dbinfo.dbDriverClass}']").attr("selected",true);
	
		$('#systemInfo').addClass('open-item active-item').removeClass('close-item');
		$('#systemList').addClass('active-item');
	
	});

</script>
</body>

</html>
