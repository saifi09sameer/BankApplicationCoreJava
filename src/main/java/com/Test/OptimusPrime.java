package com.Test;
import java.util.Scanner;
class OptimusPrime
{
    public static void main(String... s){
        int count=0, sum=0,m;
        System.out.println();
        System.out.print("Enter any number: ");
        int x=new Scanner(System.in).nextInt();
        int y=x;
        for(int i=1; i<=x; i++)
        {
            int z=x%i;
            if(z==0)
            {
                count++;
            }
        }
        System.out.println();
        if(count==2)
        {
            System.out.println(x+" is a prime number");
        }
        else
        {
            System.out.println(x+" is not a prime number");
        }
        System.out.println();
        while(x!=0)
        {
            m=x%10;
            sum=sum+m;
            x=x/10;
        }
        System.out.print("The sum of the number "+y+" is :"+sum);
    }
}