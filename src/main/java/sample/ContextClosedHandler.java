package sample;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class ContextClosedHandler implements
		ApplicationListener<ContextClosedEvent> {
	TaskExecutor taskExecutor;

	public ContextClosedHandler(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	public void onApplicationEvent(ContextClosedEvent event) {
		((ThreadPoolTaskExecutor) taskExecutor).shutdown();
	}
}