import org.testng.Assert;
import org.testng.annotations.Test;

public class ClassroomTaskTest {

    @Test
    public void testSum() {
        ClassroomTask classroomTask = new ClassroomTask();
        Assert.assertEquals(classroomTask.sum(10.00, 25.00), 35.00, "Incorrect result! Please check method implementation");
    }

    @Test
    public void testSubtract() {
        ClassroomTask classroomTask = new ClassroomTask();
        Assert.assertEquals(classroomTask.sum(40.00, 15.00), 25.00);
    }

    @Test
    public void testMultiply() {
        ClassroomTask classroomTask = new ClassroomTask();
        Assert.assertEquals(classroomTask.multiply(4.00, 5.00), 20.00);
    }

    @Test
    public void testDivide() {
        ClassroomTask classroomTask = new ClassroomTask();
        Assert.assertEquals(classroomTask.divide(15.00, 3.00), 5.00);
    }
}
