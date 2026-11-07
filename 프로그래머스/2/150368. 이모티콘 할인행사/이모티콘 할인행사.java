import java.util.*;
import java.io.*;
import java.lang.*;

class Point{
    int membercount;
    int price;
    
    public Point(int membercount,int price){
        this.membercount = membercount;
        this.price = price;
    }
}

class Solution {
    static int maxmembercount = 0;
    static int maxprice = 0;
    static int[] discount = {40,30,20,10};
    
    public int[] solution(int[][] users, int[] emoticons) {
        int userlength = users.length;
        
        int emolength = emoticons.length;
        
        int[] temp = new int[emolength];
        
        dfs(users,emoticons,emolength,temp,0);
        
        int[] answer = new int[2];
        
        answer[0] = maxmembercount;
        answer[1] = maxprice;
        
        return answer;
    }
    
    public static void dfs(int[][] users,int[] emoticons,int emolength,int temp[],int level){
        
        if(level == emolength){
            Point x = caculatememberAndprice(users,emoticons,emolength,temp);
            
            if(x.membercount > maxmembercount){
                maxmembercount = x.membercount;
                maxprice = x.price;
            }
            
            if(x.membercount == maxmembercount){
                if(x.price > maxprice){
                    for(int z=0;z<level;z++){
                        System.out.print(temp[z]+" ");
                    }
                    System.out.println();
                    maxprice = x.price;
                }
            }
            
            return;
        }
        
        for(int i=0;i<4;i++){
            temp[level] = discount[i];
            dfs(users,emoticons,emolength,temp,level+1);
        }
    }
    
    public static Point caculatememberAndprice(int[][] users,int[] emoticons,int emolength,int[] temp){
        int membercn = 0;
        int pricetotal = 0;
        
        int ul = users.length;
        
        int[] userpricelist = new int[ul];
        
        for(int i=0;i<emolength;i++){
            for(int j=0;j<ul;j++){
                if(temp[i] >= users[j][0]){
                    userpricelist[j]+=resultvalue(emoticons[i],temp[i]);
                }
            }
        }
        
        for(int a=0;a<ul;a++){
            if(userpricelist[a] >= users[a][1]){
                membercn++;
                userpricelist[a] = 0;
            }
            pricetotal += userpricelist[a];
        }

        return new Point(membercn,pricetotal);
    }
         
    public static int resultvalue(int emoticonvalue,int discount){
        
        int result = (emoticonvalue/100) * (100-discount);
        
        return result;
    }
}