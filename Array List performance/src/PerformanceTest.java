import java.util.List;
import java.util.ArrayList;
public class PerformanceTest {
    private int EmployeeSalary;
    public static class Employee{
        int EmployeeId;
        private String name;
        private int EmployeeSalary;
        public Employee(int EmployeeId, String name, int EmployeeSalary){
            this.EmployeeId = EmployeeId;
            this.name = name;
            this.EmployeeSalary = EmployeeSalary;
    }
}
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<Employee>();
        int size=100;
        for (int i = 0; i <= size; i++) {
            Object name;
            list.add(new Employee(1000,"Kamal",50000));
        }
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Size of the stored object: " + 1000 + " bytes");
        int objSize=4;
        int calculatedSize = objSize*size;

        System.out.println("Size of the stored collection: " + calculatedSize + " bytes");
        System.out.println("Used memory: " + memory + " bytes");
        System.out.println("Memory overhead: " + (memory-calculatedSize) + " bytes");
    }
}