package sample;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

public class MyScheduleTask {
//	@Scheduled(fixedRate = 2000)

	@Value("${jobs.mediafiles.imagesPurgeJob.enable}")
    private boolean imagesPurgeJobEnable;

	@Scheduled(cron = "${jobs.mediafiles.imagesPurgeJob.schedule}")
	public void myFirstTask() {

        if(!imagesPurgeJobEnable){
            return;
        }

		System.out.println(new Date());
	}
}
