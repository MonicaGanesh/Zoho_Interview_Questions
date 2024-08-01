import java.util.*;
class Person
{
    private String name;
    private char gender;
    private Person mother;
    private Person father;
    private ArrayList<Person> children=new ArrayList<>();
    private ArrayList<Person> siblings=new ArrayList<>();
    private ArrayList<Person> sons=new ArrayList<>();
    private ArrayList<Person> daughters=new ArrayList<>();
    private ArrayList<Person> brothers=new ArrayList<>();
    private ArrayList<Person> sisters=new ArrayList<>();
    Person(String name,char gender,Person father,Person mother) 
    {
        this.name=name;
        this.gender=gender;
        this.father=father;
        this.mother=mother;
    }
    Person(String name,char gender) 
    {
        this.name=name;
        this.gender=gender;        
    }
    public String getName() {
        return name;
    }
    public char getGender() {
        return gender;
    }
    public Person getMother() {
        return mother;
    }
    public Person getFather() {
        return father;
    }
    public void setName(String name) {
        this.name=name;
    }
    public ArrayList<Person> getChildren() {
        return children;
    }
    public ArrayList<Person> getSons() {
        return sons;
    }
    public ArrayList<Person> getDaughters() {
        return daughters;
    }
    public ArrayList<Person> getSiblings() {
        return siblings;
    }
    public ArrayList<Person> getBrothers() {
        return brothers;
    }
    public ArrayList<Person> getSisters() {
        return sisters;
    }
    public void setChildren(ArrayList<Person> children) {
        this.children=children;
    }
    public void setSons(ArrayList<Person> sons) {
        this.sons=sons;
    }
    public void setDaughters(ArrayList<Person> daughters) {
        this.daughters=daughters;
    }
    public void addChildren(Person child) {
        this.children.add(child);
        if(child.getGender()=='F')
        {
            this.daughters.add(child);
        }
        else
        {
            this.sons.add(child);
        }
    }
    public void addSibling(Person sibling) {
        if(!this.siblings.contains(sibling) && sibling!=this)
        {
            this.siblings.add(sibling);
            sibling.addSibling(this);
        }
        if(sibling.getGender()=='F' && (!this.sisters.contains(sibling)) && sibling!=this)
        {
            this.sisters.add(sibling);
        }
        else if(sibling.getGender()=='M' && (!this.brothers.contains(sibling)) && sibling!=this)
        {
            this.brothers.add(sibling);
        }
    }
    public void setGender(char gender) {
        this.gender=gender;
    }
    public void setMother(Person mother) {
        this.mother=mother;
    }
    public void setFather(Person father) {
        this.father=father;
    }
}
public class Relationship {
    static ArrayList<Person> getPair(String name,Person list[],int index)
    {
        ArrayList<Person> pair2=new ArrayList<>();

        Person pair1=list[checkPresence(name, list, index)];

        ArrayList<Person> fathers_sisters=new ArrayList<>();
        ArrayList <Person>mothers_brothers=new ArrayList<>();

        if(pair1.getFather()!=null && pair1.getFather().getSisters().size()!=0)
        {
            fathers_sisters=pair1.getFather().getSisters();
        }
        if(pair1.getMother()!=null && pair1.getMother().getBrothers().size()!=0)
        {
            mothers_brothers=pair1.getMother().getBrothers();
        }
        char pair1_gender=pair1.getGender();

        if(fathers_sisters.size()!=0)
        {
            for(Person p:fathers_sisters)
            {
                if(pair1_gender=='F')
                {
                    pair2.addAll(p.getSons());
                }
                else
                {
                    pair2.addAll(p.getDaughters());
                }
            }
        }
        if(mothers_brothers.size()!=0)
        {
            for(Person p:mothers_brothers)
            {
                if(pair1_gender=='F')
                {
                    pair2.addAll(p.getSons());
                }
                else
                {
                    pair2.addAll(p.getDaughters());
                }
            }
        }
        return pair2;
    }
    static int checkPresence(String name,Person list[],int index)
    {
        for(int i=0;i<index;i++) 
        {
            if(list[i].getName().equals(name)) 
            {
                return i;
            }
        }
            return -1;
    }

    public static void main(String[] args) {
        String input[][]={{"Mahi","F","Gokul","Sania"},{"Gokul","M","Shanmugam","Saraswathy"},{"Sania","F","Raj","Pushpa"},
                          {"Nakul","M","Gokul","Sania"},{"Ram","M","Raj","Pushpa"},{"Ishu","F","Hari","Hema"},
                          {"Shiva","M","Raj","Pushpa"},{"Latha","F","Anto","Mercy"},{"Devi","F","Ram","Ishu"},
                          {"Mohan","M","Ram","Ishu"},{"Neha","F","Shiva","Latha"},{"Charu","F","Shiva","Latha"},
                          {"Sakthi","M","Shanmugam","Saraswathy"},{"Selvi","F","Rahul","Rani"},{"Gowtham","M","Sakthi","Selvi"},
                          {"Maria","F","Shanmugam","Saraswathy"},{"Kevin","M","Giresh","Keerthi"},{"Vignesh","M","Kevin","Maria"},
                          {"Jenny","F","Kevin","Maria"}};
        int len=input.length;
        int index=0;
        Person list[]=new Person[len*2];
        int check_child=-1,check_father=-1,check_mother=-1;
        for(int i=0;i<len;i++)
        {
            check_child=checkPresence(input[i][0], list,index);
            check_father=checkPresence(input[i][2], list,index);
            check_mother=checkPresence(input[i][3], list,index);

            if(check_father==-1)
            {
                list[index++]=new Person(input[i][2],'M');
                check_father=index-1;
            }
            if(check_mother==-1)
            {
                list[index++]=new Person(input[i][3],'F');
                check_mother=index-1;
            }
            if(check_child==-1)
            {
                list[index++]=new Person(input[i][0],input[i][1].charAt(0),list[check_father] ,list[check_mother]);
                check_child=index-1;
            }
            else
            {
                list[check_child].setFather(list[check_father]);
                list[check_child].setMother(list[check_mother]);
            }
            list[check_father].addChildren(list[check_child]);
            list[check_mother].setChildren(list[check_father].getChildren());
            list[check_mother].setSons(list[check_father].getSons());
            list[check_mother].setDaughters(list[check_father].getDaughters());

            if(list[check_father]!=null)
            {
                ArrayList<Person> siblings=list[check_father].getChildren();
                for(Person p:siblings)
                {
                    list[check_child].addSibling(p);
                }
            }
            if(list[check_mother]!=null)
            {
                ArrayList<Person> siblings=list[check_mother].getChildren();
                for(Person p:siblings)
                {
                    list[check_child].addSibling(p);
                }
            }
        }
        for(int i=0;i<index;i++)
        {
            System.out.print("Name:"+list[i].getName()+"  Gender:"+list[i].getGender()+"  ");
            if(list[i].getFather()!=null && list[i].getMother()!=null)
            {
                System.out.println("Father:"+list[i].getFather().getName()+"  Mother:"+list[i].getMother().getName());
            }
            else
            {
                System.out.println("null null");
            }
            System.out.print("Siblings: ");
            for(Person p:list[i].getSiblings())
            {
                System.out.print(p.getName()+" ");
            }
            System.out.println();
            System.out.print("Brothers: ");
            for(Person p:list[i].getBrothers())
            {
                System.out.print(p.getName()+" ");
            }
            System.out.println();
            System.out.print("Sisters: ");
            for(Person p:list[i].getSisters())
            {
                System.out.print(p.getName()+" ");
            }
            System.out.println();
            System.out.print("Children: ");
            for(Person p:list[i].getChildren())
            {
                System.out.print(p.getName()+" ");
            }
            System.out.println();
            System.out.print("Sons: ");
            for(Person p:list[i].getSons())
            {
                System.out.print(p.getName()+" ");
            }
            System.out.println();
            System.out.print("Daughters: ");
            for(Person p:list[i].getDaughters())
            {
                System.out.print(p.getName()+" ");
            }
            System.out.println("\n");
        }
        int pair_index=checkPresence("Nakul", list, index);
        System.out.println("Pairs of "+list[pair_index].getName()+" "+list[pair_index].getGender());
        ArrayList<Person> possible_pairs=getPair(list[pair_index].getName(),list,index);
        if(possible_pairs.size()==0)
        {
            System.out.println("No possible pairs!");
        }
        for(Person p:possible_pairs)
        {
            if(p!=null)
            {
                System.out.println("Name:"+p.getName()+" Gender:"+p.getGender());
            }
        }
    }
}
