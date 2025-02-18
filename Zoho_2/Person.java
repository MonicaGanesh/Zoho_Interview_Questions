import java.util.*;
public class Person
{
    private static ArrayList<Person> family=new ArrayList<>();
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
    private Person(String name,char gender) 
    {
        this.name=name;
        this.gender=gender;    
    }
    private String getName() {
        return name;
    }
    private char getGender() {
        return gender;
    }
    private Person getMother() {
        return mother;
    }
    private Person getFather() {
        return father;
    }
    private ArrayList<Person> getChildren() {
        return children;
    }
    private ArrayList<Person> getSons() {
        return sons;
    }
    private ArrayList<Person> getDaughters() {
        return daughters;
    }
    private ArrayList<Person> getBrothers() {
        return brothers;
    }
    private ArrayList<Person> getSisters() {
        return sisters;
    }
    private void setMother(Person mother) {
        this.mother=mother;
    }
    private void setFather(Person father) {
        this.father=father;
    }
    private void addChildren(Person child) {
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
    private void addSibling(Person sibling) {
        if(!this.siblings.contains(sibling) && sibling!=this)
        {
            this.siblings.add(sibling);
            sibling.addSibling(this);
            if(sibling.getGender()=='F')
            {
                this.sisters.add(sibling);
            }
            else
            {
                this.brothers.add(sibling);
            }
        }
    }
    private static Person findPerson(String name)
    {
        Person p=null;
        for(int i=0;i<family.size();i++) 
        {
            p=family.get(i);
            if(p.getName().equals(name)) 
            {
                return p;
            }
        }
        return p;
    }
    public static void findMatch(String name)
    {
        Person pair1=findPerson(name);
        if(pair1==null)
        {
            System.out.println("Not Part of Family");
            return;
        }
        else
        {
            ArrayList<Person> pair2=new ArrayList<>();

            ArrayList<Person> fathers_sisters=new ArrayList<>();
            ArrayList <Person>mothers_brothers=new ArrayList<>();

            if(pair1.getFather()!=null)
            {
                fathers_sisters=pair1.getFather().getSisters();
            }
            if(pair1.getMother()!=null)
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
            System.out.println("Input:"+pair1.name+"  Gender:"+pair1.gender);
            for(Person p:pair2)
            {
                System.out.println("Name:"+p.name+"  Gender:"+p.gender);
            }        
        }
    }
    private static Person getPerson(String name,char gender)
    {
        Person p;
        for(int i=0;i<family.size();i++) 
        {
            p=family.get(i);
            if(p.getName().equals(name)) 
            {
                return p;
            }
        }
        p=new Person(name, gender);
        family.add(p);
        return p;
    }
    public static void parse(String input[])
    {
        Person child=getPerson(input[0], input[1].charAt(0));
        Person father=getPerson(input[2], 'M');
        Person mother=getPerson(input[3], 'F');
        child.setFather(father);
        child.setMother(mother);
        father.addChildren(child);
        mother.addChildren(child);
        ArrayList<Person> sibling=father.getChildren();
        for(Person p:sibling)
        {
            child.addSibling(p);
        }
    }
    public static void main(String[] args) {
        
        String input[][]={{"Mahi","F","Gokul","Sania"},{"Gokul","M","Shanmugam","Saraswathy"},{"Sania","F","Raj","Pushpa"},
                          {"Nakul","M","Gokul","Sania"},{"Ram","M","Raj","Pushpa"},{"Ishu","F","Hari","Hema"},
                          {"Shiva","M","Raj","Pushpa"},{"Latha","F","Anto","Mercy"},{"Devi","F","Ram","Ishu"},
                          {"Mohan","M","Ram","Ishu"},{"Neha","F","Shiva","Latha"},{"Charu","F","Shiva","Latha"},
                          {"Sakthi","M","Shanmugam","Saraswathy"},{"Selvi","F","Rahul","Rani"},{"Gowtham","M","Sakthi","Selvi"},
                          {"Maria","F","Shanmugam","Saraswathy"},{"Kevin","M","Giresh","Keerthi"},{"Vignesh","M","Kevin","Maria"},
                          {"Jenny","F","Kevin","Maria"}};
        for(int i=0;i<input.length;i++)
        {
            Person.parse(input[i]);
        }
        Person.findMatch("Mahi");
    }
}
