import java.util.*;
class Term
{
    private TreeMap<Character,Integer> variable=new TreeMap<>();
    private double coeff;
    private Term(double coeff,TreeMap<Character,Integer> variable)
    {
        this.coeff=coeff;
        this.variable=variable;
    }
    public TreeMap<Character,Integer> getVariable()
    {
        return this.variable;
    }
    public void setCoeff(double coeff)
    {
        this.coeff=coeff;
    }
    public double getCoeff()
    {
        return this.coeff;
    }
    public boolean isNegative()
    {
        if(this.coeff<0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public String toString()
    {
        String str="";
        double temp=this.coeff;
        if(this.isNegative())
        {
            str+=" - ";
            temp=this.coeff*-1;
        }
        str+=temp;
        for(char var:this.variable.keySet())
        {
            str+=var;
            str+='^';
            str+=this.variable.get(var);
        }
        return str;
    } 
    public Term multiply(Term other)
    {
        TreeMap<Character,Integer> variable=new TreeMap<>();
        for(char var:this.variable.keySet())
        {
            variable.put(var,this.variable.get(var));
        }
        double coeff=this.coeff*other.coeff;
        Term ans;
        for(char var:other.variable.keySet())
        {
            if(variable.containsKey(var))
            {
                int exp=variable.get(var);
                exp+=other.variable.get(var);
                variable.put(var, exp);
            }
            else
            {
                variable.put(var, other.variable.get(var));
            }
        }
        ans=new Term(coeff,variable);
        return ans;
    }
    public double findValue(TreeMap<Character,Double> val)
    {
        double res=this.getCoeff();
        for(char var:this.getVariable().keySet())
        {
            res*=Math.pow(val.get(var),this.getVariable().get(var));
        }
        System.out.println(res);
        return res;
    }
    private static int getNumber(String term,int start)
    {
        int num_len=0;
        int i=start;
        int number=0;
        int len=term.length();
        while(i!=len && term.charAt(i)-'0'>=0 && term.charAt(i)-'0'<=9)
        {
            num_len++;
            i++;
        }
        i=start;
        num_len--;
        while(i!=len && term.charAt(i)-'0'>=0 && term.charAt(i)-'0'<=9)
        {
            number+=(term.charAt(i)-'0')*Math.pow(10, num_len);
            num_len--;
            i++;
        } 
        return number;  
    }
    public static Term parseTerm(String term)
    {
        double coefficient=0;
        TreeMap<Character,Integer> variables=new TreeMap<>();
        int multiply=1;
        int len=term.length();
        int i=0;
        if(term.charAt(0)=='+')
        {
            multiply=1;
            i=1;
        }
        else if(term.charAt(0)=='-')
        {
            multiply=-1;
            i=1;
        }
        int start=i;
        coefficient=getNumber(term,start)*multiply;
        int exp;
        char var;
        for(int j=i;j<len;j++)
        {
            char current=term.charAt(j);
            if(current>='a' && current<='z')
            {
                var=current;
                exp=getNumber(term,j+2);
                variables.put(var, exp);
            }

        }
        return new Term(coefficient,variables);
    }
}
class Equation
{
    private ArrayList<Term> expression;
    private Equation(ArrayList<Term> expression)
    {
        this.expression=expression;
    }
    public String toString()
    {
        String  str="";
        for(Term t:expression)
        {
            if(t.isNegative()==false)
            {
                str+=" + ";
            }
            str+=t.toString();
        }
        return str;
    }
    private void resolveEqualVariables(ArrayList<Term> eqn) 
    {
        for(int i=0;i<eqn.size()-1;i++)
        {
            for(int j=i+1;j<eqn.size();j++)
            {
                if(eqn.get(i).getVariable().equals(eqn.get(j).getVariable()))
                {
                    double coeff=eqn.get(i).getCoeff()+eqn.get(j).getCoeff();
                    eqn.get(i).setCoeff(coeff);
                    eqn.remove(j);
                }
            }
        }
    }
    private Equation multiply(Equation other)
    {
        ArrayList<Term> ans=new ArrayList<>();
        for(Term t1:this.expression)
        {
            for(Term t2:other.expression)
            {
                ans.add(t1.multiply(t2));

            }
        }
        resolveEqualVariables(ans);
        return new Equation(ans);
    }
    private TreeMap<Character,Double> getValue()
    {
        Scanner sc=new Scanner(System.in);
        TreeMap<Character,Double> value=new TreeMap<>();
        double val;
        for(Term t:this.expression)
        {
            for(char var:t.getVariable().keySet())
            {
                if(!value.containsKey(var))
                {
                    System.out.print("Enter value of "+var+":");
                    val=sc.nextDouble();
                    value.put(var,val);
                }
            }
        }
        sc.close();
        return value;
    }
    private double findValue()
    {
        double res=0;
        TreeMap<Character,Double> val=new TreeMap<>();
        val=getValue();
        for(Term t:this.expression)
        {
            res+=t.findValue(val);
        }
        return res;
    }
    private static Equation parseEquation(String equation)
    {
        ArrayList<Term> terms=new ArrayList<>();
        String str="";
        int len=equation.length();
        for(int j=0;j<len;j++)
        {
            str+=equation.charAt(j);
            if(equation.charAt(j)=='+' || equation.charAt(j)=='-' || j==len-1)
            {
                terms.add(Term.parseTerm(str));
                str="";
            }
        }
        return new Equation(terms);
    }
    public static void parse(String equation1,String equation2)
    {
        Equation eq1=Equation.parseEquation(equation1);
        Equation eq2=Equation.parseEquation(equation2);
        System.out.println("Equation 1:"+eq1.toString());
        System.out.println("Equation 2:"+eq2.toString());
        Equation ans=eq1.multiply(eq2);
        System.out.println("Result:"+ans);
        double result=ans.findValue();
        System.out.println("After applying values:"+result);
    }
}

public class Maths {
    public static void main(String args[])
    {
        //String eqn1="32x^1y^2+2y^1";
        //String eqn2="4z^2y^3-2x^2";

        //String eqn1="3x^1+4y^1";
        //String eqn2="4x^1+3y^1";

        String eqn1="3s^2+5t^2";
        String eqn2="4t^2+2s^2";

        //String eqn1="1x^20+1y^20+1z^20";
        //String eqn2="1x^20+1y^20+1z^20";

        Equation.parse(eqn1,eqn2);
        
    }
}
