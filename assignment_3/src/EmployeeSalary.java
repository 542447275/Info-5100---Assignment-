public class EmployeeSalary {
    public double employeeSalary( double hours){
        if(hours == 0)
            return 0;
        else if(hours <= 36)
            return hours*15;
        else if(hours <= 41)
            return hours*15 + (hours-36)*15*1.5;
        else if(hours <= 48)
            return hours*15 + (hours-36)*15*1.5 + (hours-41)*15*2;
        return 0;
    }
}
