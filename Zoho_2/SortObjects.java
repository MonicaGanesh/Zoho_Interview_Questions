class Student{
    String name;
    double maths;
    double physics;
    double chemistry;
    double cutoff;
    double totalMark;
    public Student(String name, double maths, double physics, double chemistry, double totalMark) {
        this.name = name;
        this.maths = maths;
        this.physics = physics;
        this.chemistry = chemistry;
        this.cutoff = maths+((physics+chemistry)/2.0);
        this.totalMark = totalMark;
    }
    public String getName() {
        return name;
    }
    public double getMaths() {
        return maths;
    }
    public double getPhysics() {
        return physics;
    }
    public double getChemistry() {
        return chemistry;
    }
    public double getCutoff() {
        return cutoff;
    }
    public double getTotalMark() {
        return totalMark;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMaths(double maths) {
        this.maths = maths;
    }
    public void setPhysics(double physics) {
        this.physics = physics;
    }
    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }
    public void setCutoff(double cutoff) {
        this.cutoff = cutoff;
    }
    public void setTotalMark(double totalMark) {
        this.totalMark = totalMark;
    }
    public int compare(Student other)
    {
        if(this.getCutoff()>other.getCutoff())
        {
            return 1;
        }
        else if(this.getCutoff()<other.getCutoff())
        {
            return -1;
        }
        else
        {
            if(this.getMaths()>other.getMaths())
            {
                return 1;
            }
            else if(this.getMaths()<other.getMaths())
            {
                return -1;
            }
            else
            {
                if(this.getPhysics()>other.getPhysics())
                {
                    return 1;
                }
                else if(this.getPhysics()<other.getPhysics())
                {
                    return -1;
                }
                else
                {
                    if(this.getChemistry()>other.getChemistry())
                    {
                        return 1;
                    }
                    else if(this.getChemistry()<other.getChemistry())
                    {
                        return -1;
                    }
                    else
                    {
                        if(this.getTotalMark()>=other.getTotalMark())
                        {
                            return 1;
                        }
                        else
                        {
                            return -1;
                        }
                    }
                }
            }
        }
    }
    public void printStudent()
    {
        System.out.println("Name:"+this.getName());
        System.out.println("Cutoff:"+this.getCutoff()+" Maths:"+this.getMaths()+" Physics:"+this.getPhysics()+" Chemistry:"+this.getChemistry()+" Total:"+this.getTotalMark()+"\n");
    }
}
public class SortObjects {
    public static void main(String[] args) {
        Student list[] = {
            new Student("Sania",85,78,90,553),
            new Student("Gokul",85,78,90,554),
            new Student("Nakul",90,80,85,542),
            new Student("David",85,78,90,540),
            new Student("Mary",90,85,80,550),
            new Student("Mahi",80,90,85,545),
            new Student("Ram",85,78,90,530),
            new Student("Mohan",90,85,80,550),
            new Student("Kelvin",80,90,85,542),
            new Student("Jack",85,78,90,550)
        };
        int len=list.length;
        for(int i=0;i<len-1;i++)
        {
            for(int j=i+1;j<len;j++)
            {
                if(list[i].compare(list[j])==-1)
                {
                    Student s=list[i];
                    list[i]=list[j];
                    list[j]=s;
                }
            }
        }
        for(int i=0;i<len;i++)
        {
            list[i].printStudent();
        }
    }
}
