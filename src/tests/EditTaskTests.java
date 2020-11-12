package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.BoardPage;
import pageObject.EditTaskPage;
import pageObject.TimeLinePage;

public class EditTaskTests extends BaseTest{
	
	@Test (description = "Thith test checks if you can add a new task")
	public void tc01_addTaskTest() {
		TimeLinePage tp = new TimeLinePage(driver);
		tp.goToBoardPage();
		BoardPage bp = new BoardPage(driver);
		bp.openTask();
		EditTaskPage etp = new EditTaskPage(driver);
		etp.addTask("My first task", "Dvori", "Dvori");		
		Assert.assertEquals(bp.checkIfTaskExist("My first task"), true);
	}
	
	@Test (description = "Thith test checks if you can delete tasks")
	public void tc02_deleteTaskTest() {
		BoardPage bp = new BoardPage(driver);
		bp.openTask();
		EditTaskPage etp = new EditTaskPage(driver);
		etp.addTask("Delete task test", "Delete task test", "Delete task test");
		bp.deleteTask("Delete task test");		
		Assert.assertEquals(bp.checkIfTaskExist("Delete task test"), false);
	}
	
	@Test (description = "Thith test checks if you can edit tasks")
	public void tc03_editTask() {
		BoardPage bp = new BoardPage(driver);
		bp.openTask();
		EditTaskPage etp = new EditTaskPage(driver);
		etp.addTask("Edit task test", "Edit task", "Edit task");		
		bp.editTask("Edit task test");
		etp.changeNameAndStatus("Dvori's task");		
		Assert.assertEquals(bp.checkIfTaskExist("Dvori's task"), true);
	}
	
	@Test (description = "Thith test checks if you can move all task from one status to another status")
	public void tc04_MoveAllTasks() {
		BoardPage bp = new BoardPage(driver);
		bp.moveAllTasks();
	}	
}
