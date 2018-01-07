package com.gmcc.monitor.controller;

import java.util.List;
import java.util.Map;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmcc.monitor.dao.TbJobDao;
import com.gmcc.monitor.entity.TbJob;
import com.gmcc.monitor.job.BaseJob;

@RestController
@RequestMapping(value="/job")
public class JobController 
{
    @Autowired
    private TbJobDao tbJobDao;

    @Autowired 
    @Qualifier("Scheduler")
    private Scheduler scheduler;

    private static Logger log = LoggerFactory.getLogger(JobController.class);  

    //启动定时器
    @PostMapping(value="/addjob")
    public void addjob(String jobName, String jobClassName, String jobGroupName, 
    		String triggerName, String cronExpression) throws Exception{
        // 启动调度器  
        scheduler.start(); 
        //构建job信息
        JobDetail jobDetail = JobBuilder.newJob(getClass(jobClassName).
        		getClass()).withIdentity(jobName, jobGroupName).build();
        //表达式调度构建器(即任务执行的时间)
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
        //按新的cronExpression表达式构建一个新的trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerName, jobGroupName)
            .withSchedule(scheduleBuilder).build();
        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            System.out.println("创建定时任务失败"+e);
            throw new Exception("创建定时任务失败");
        }
    }

    //暂停定时器
    @PostMapping(value="/pausejob")
    public void pausejob(String jobName, String jobGroupName) throws Exception{           
        scheduler.pauseJob(JobKey.jobKey(jobName, jobGroupName));
    }


    //重新启动定时器
    @PostMapping(value="/resumejob")
    public void resumejob(String jobName, String jobGroupName) throws Exception{           
        scheduler.resumeJob(JobKey.jobKey(jobName, jobGroupName));
    }


    //重新设置定时时间
    @PostMapping(value="/reschedulejob")
    public void rescheduleJob(String jobName, String jobGroupName, 
    		String cronExpression) throws Exception{           
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroupName);
            // 表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

            // 按新的cronExpression表达式重新构建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).
            		withSchedule(scheduleBuilder).build();

            // 按新的trigger重新设置job执行
            scheduler.rescheduleJob(triggerKey, trigger);
        } catch (SchedulerException e) {
            System.out.println("更新定时任务失败"+e);
            throw new Exception("更新定时任务失败");
        }
    }


    @PostMapping(value="/deletejob")
    public void deletejob(String jobName, String jobGroupName) throws Exception{           
        scheduler.pauseTrigger(TriggerKey.triggerKey(jobName, jobGroupName));
        scheduler.unscheduleJob(TriggerKey.triggerKey(jobName, jobGroupName));
        scheduler.deleteJob(JobKey.jobKey(jobName, jobGroupName));             
    }


    @GetMapping(value="/queryjob")
    public Map<String, Object> queryjob(Map<String, Object> map) {           
    	List<TbJob> tbJobList = (List<TbJob>) tbJobDao.findAll();
        map.put("tbJobList", tbJobList);
        return map;
    }

    public static BaseJob getClass(String classname) throws Exception {
        Class<?> class1 = Class.forName(classname);
        return (BaseJob)class1.newInstance();
    }


}