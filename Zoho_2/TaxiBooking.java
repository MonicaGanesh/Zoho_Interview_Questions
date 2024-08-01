import java.util.ArrayList;

class Date
{
    int day;
    int month;
    int year;
    Date(int day,int month,int year)
    {
        this.day=day;
        this.month=month;
        this.year=year;
    }
    public int getDay() {
        return this.day;
    }
    public int getMonth() {
        return this.month;
    }
    public int getYear() {
        return this.year;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setYear(int year) {
        this.year = year;
    }

}
class Employee
{
    static int eid=0;
    int emp_id;
    String emp_name;
    String designation;
    String address;
    double distance;


    public Employee( String emp_name, String designation, String address, double distance) {
        eid++;
        this.emp_id = eid;
        this.emp_name = emp_name;
        this.designation = designation;
        this.address = address;
        this.distance = distance;
    }
    public static int getEid()
    {
        return Employee.eid;
    }
    public int getEmp_id() {
        return this.emp_id;
    }
    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }
    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
    public String getEmp_name() {
        return this.emp_name;
    }
    public String getDesignation() {
        return this.designation;
    }
    public String getAddress() {
        return this.address;
    }
    public double getDistance() {
        return this.distance;
    }
    
}
class Cab
{
    int cab_id;
    String cab_type;
    double price_per_km;
    static int cid=0;
    
    public Cab(String cab_type, double price_per_km) {
        cid++;
        this.cab_id = cid;
        this.cab_type = cab_type;
        this.price_per_km = price_per_km;
    }
    public static int getCid()
    {
        return Cab.cid;
    }
    public int getCab_id() {
        return this.cab_id;
    }
    public String getCab_type() {
        return this.cab_type;
    }
    public void setCab_id(int cab_id) {
        this.cab_id = cab_id;
    }
    public void setCab_type(String cab_type) {
        this.cab_type = cab_type;
    }
    public void setPrice_per_km(double price_per_km) {
        this.price_per_km = price_per_km;
    }
    public double getPrice_per_km() {
        return this.price_per_km;
    }
    
}
class Driver
{
    static int did=0;
    int driver_id;
    String driver_name;
    long phoneno;

    public Driver(String driver_name, long phoneno) {
        did++;
        this.driver_id = did;
        this.driver_name = driver_name;
        this.phoneno = phoneno;
    }
    public static int getDid()
    {
        return Driver.did;
    }
    public int getDriver_id() {
        return this.driver_id;
    }
    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }
    public String getDriver_name() {
        return this.driver_name;
    }
    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }
    public long getPhoneno() {
        return this.phoneno;
    }
    public void setPhoneno(long phoneno) {
        this.phoneno = phoneno;
    }
    
}
class Trip
{
    static int tid=0;
    int trip_id;
    Employee employee;
    Driver driver;
    Cab cab;
    double cost;
    Date date;

    public Trip(Employee employee, Driver driver,Cab cab, Date date) {
        tid++;
        this.trip_id = tid;
        this.employee = employee;
        this.driver = driver;
        this.cab = cab;
        this.cost = employee.distance*cab.price_per_km;;
        this.date = date;
    }
    public int getTrip_id() {
        return this.trip_id;
    }
    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
    }
    public Employee getEmployee() {
        return this.employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public static int getTid() {
        return Trip.tid;
    }
    public static void setTid(int tid) {
        Trip.tid = tid;
    }
    public Driver getDriver() {
        return this.driver;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    public Cab getCab() {
        return this.cab;
    }
    public void setCab(Cab cab) {
        this.cab = cab;
    }
    public double getCost() {
        return this.cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public Date getDate() {
        return this.date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    
}

public class TaxiBooking
{
    static Cab getCab(String desc,ArrayList<Cab> l1)
    {
        String desc_cars[][]={{"CEO","Rolce Royce"},{"Senior Developer","SUV"},{"Developer","Innova"}};
        String ctype="";
        for(int i=0;i<desc_cars.length;i++)
        {
            if(desc_cars[i][0].equals(desc))
            {
                ctype=desc_cars[i][1];
                break;
            }
        }
        for(Cab c:l1)
        {
            if(c.getCab_type().equals(ctype))
            return c;
        }
        return null;
    }
    static double getEarning(int month,Employee e,Trip t[])
    {

        double totcost=0;
        for(Trip trip:t)
        {
            if((trip.getDate()).month==month && (trip.getEmployee())==e)
            {

                totcost+=trip.getCost();
            }
        }
        return totcost;
    }
    public static void main(String[] args) {

        Date dt1= new Date(12,4,2024);
        Date dt2=new Date(12,5,2024);
        Date dt3=new Date(30,4,2024);
        Date dt4=new Date(15,6,2024);
        Date dt5=new Date(15,2,2023);

        Employee e1=new Employee("Harish", "CEO", "Chennai", 20.5);
        Employee e2=new Employee("Priya","Senior Developer","Bangalore",15.25);
        Employee e3=new Employee("Oliver","Senior Developer","Guindy",12.5);
        Employee e4=new Employee("Uma","Developer","Vanarpet",12.25);
        Employee e5=new Employee("Kelvin", "Developer", "Sollinganallur", 25);

        ArrayList<Cab> l1=new ArrayList<>(); 
        Cab c1=new Cab("Rolce Royce", 500);
        Cab c2=new Cab("SUV",250);
        Cab c3=new Cab("SUV",250);
        Cab c4=new Cab("Innova",150);
        Cab c5=new Cab("Innova",150);

        l1.add(c1);
        l1.add(c2);
        l1.add(c3);
        l1.add(c4);
        l1.add(c5);

        Driver d1=new Driver("Gnanavel",9645782346l);
        Driver d2=new Driver("Prabu",9754823487l);
        Driver d3=new Driver("Jaiswal",7685939867l);
        Driver d4=new Driver("Pranav",8459748567l);
        Driver d5=new Driver("Logesh",7854398546l);

        Trip t[]=new Trip[10];
        
        //System.out.println(getCab(e1.designation,l1));

        t[0]=new Trip(e1, d1, getCab(e1.designation,l1), dt1);
        t[1]=new Trip(e1, d2,getCab(e1.designation,l1), dt2);
        t[2]=new Trip(e2, d3,getCab(e2.designation,l1), dt3);
        t[3]=new Trip(e3, d4,getCab(e3.designation,l1), dt4);
        t[4]=new Trip(e3, d5,getCab(e3.designation,l1), dt5);
        t[5]=new Trip(e5, d1,getCab(e5.designation,l1), dt1);
        t[6]=new Trip(e3, d2,getCab(e3.designation,l1), dt2);
        t[7]=new Trip(e1, d3,getCab(e1.designation,l1), dt3);
        t[8]=new Trip(e2, d4,getCab(e2.designation,l1), dt4);
        t[9]=new Trip(e4, d5,getCab(e4.designation,l1), dt5);

        System.out.println("Number of trips:"+Trip.getTid());

        System.out.println("Employee Spending in 4th month:"+getEarning(4,e1,t));
        

    }
}