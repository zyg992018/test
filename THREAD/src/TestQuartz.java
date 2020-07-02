import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.sql.Date;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class TestQuartz {
    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = null;
        try {
            sched = sf.getScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        JobDetail job = newJob(HelloJob.class).withIdentity("job1","group1").build();
        Trigger trigger = newTrigger().withIdentity("trigger1","group1")
                .startAt(new Date(System.currentTimeMillis())).build();
        try {
            sched.scheduleJob(job,trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        try {
            sched.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sched.shutdown();
    }
}

class HelloJob implements Job{
    public void execute(JobExecutionContext context){
        System.out.println("----------start----------");
        System.out.println("-------Hello Word!-------");
        System.out.println("-----------end-----------");
    }
}
