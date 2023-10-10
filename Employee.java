import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Employee {
    private LocalDateTime startTime2;

    private List<String> employees;
    private Map<String, Double> salaries;
    private Instant lastEmployeePaymentTime;
    Catalog catalog;

    public Employee() {
        this.employees = new ArrayList<>();
        this.salaries = new HashMap<>();
        this.lastEmployeePaymentTime = Instant.now();
        this.catalog = new Catalog();
        this.startTime2 = LocalDateTime.now();
    }

    void setStartTime2(LocalDateTime startTime2){
        this.startTime2 = startTime2;
    }

    LocalDateTime getStartTime2(){
        return  startTime2;
    }

    /*void setStartTime1(LocalDateTime startTime1){
        this.startTime1 = startTime1;
    }

    LocalDateTime getStartTime1(){
        return  startTime1;
    }*/

    public void addEmployee(String employeeName, double salary){
        employees.add(employeeName);
        salaries.put(employeeName, salary);
    }

    public static int times;
    public void payEmployees(){
        double salary;
        double totalSalary = 0;
        LocalDateTime startTime1 = LocalDateTime.now();


        if(times > 0){
            Duration duration = Duration.between(startTime1, startTime2);
            long minutesDifference = duration.toMinutes();

            for (String employee : employees){

                salary = salaries.get(employee);
                double newSalary = salary * minutesDifference;
                System.out.println(employee + " is paid " + "$" +newSalary);
                totalSalary += newSalary;
                catalog.recordEmployeePayment(totalSalary);
                startTime1 = LocalDateTime.now();

            }
        }
        else{
            for (String employee : employees){

                salary = salaries.get(employee);
                /*double newSalary = salary * minutesDifference;*/
                System.out.println(employee + " is paid " + "$" +salary);
                totalSalary += salary;
                catalog.recordEmployeePayment(totalSalary);
                /*LocalDateTime startTime1 = LocalDateTime.now();*/
                times++;
            }startTime1 = LocalDateTime.now();

        }


        System.out.println("Salary paid successfully!");
    }
}
