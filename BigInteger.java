class BigInteger{
    //Return a+b
    String add(String a,String b){
        int i,a_length,b_length,val1,val2,sum,co,s;
        String add;
        a_length=a.length();
        b_length=b.length();
        int dif;
        dif=Math.abs(a_length-b_length);
        for(i=1;i<=dif;i++){
            if(a_length>b_length){
                b="0"+b;
            }
            else{
                a="0"+a;
            }
        }
        a_length=a.length();
        b_length=b.length();
        co=0;
        add="";
        i=a_length-1;
        for(i=a.length()-1;i>=0;i--){
            val1=a.charAt(i)-48;
            val2=b.charAt(i)-48;
            sum=val1+val2+co;
            co=sum/10;
            s=sum%10;
            add=s+add;
        }
        if(co!=0){
           add=co+add;
        }
        return add;
    }
    //Returns a-b
    String subtract(String a, String b){
        String ta,temp,diff="";
        int i,val1,val2,d=0;
        //Making both strings equal length
        if(a.length()==1 && b.length()==1){
            int di=0;
            String s="";
            di=a.charAt(0)-48;
            di=di-(b.charAt(0)-48);
            s=s+di;
            return s;
        }
        int dif;
        dif=Math.abs(a.length()-b.length());
        for(i=1;i<=dif;i++){
            if(a.length()>b.length()){
                b="0"+b;
            }
            else{
                a="0"+a;
            }
        }
        ta="";
        ta=ta+((a.charAt(0)-48)-1);
        for(i=1;i<a.length();i++){
            ta=ta+"9";
        }
        temp=add(a.substring(1,a.length()),"1");
        
        dif=Math.abs(ta.length()-b.length());
        for(i=1;i<=dif;i++){
            if(ta.length()>b.length()){
                b="0"+b;
            }
            else{
                ta="0"+ta;
            }
        }
        for(i=ta.length()-1;i>=0;i--){
            val1=ta.charAt(i)-48;
            val2=b.charAt(i)-48;
            d=val1-val2;
            diff=d+diff;
        }
        diff=add(diff,temp);
        diff=trim(diff);
      
        return diff;

    }
    
    String multiply(String a,String b){
        String i,sum;
        sum="0";
        for(i="1";greater(b,i) || b.equals(i);i=add(i,"1")){
            sum=add(sum,a);
        }
        return sum;
    }
    
    String longMultiply(String a, String b){
        String val,prod,sum="";
        int i,j,c=0;
        for(i=b.length()-1;i>=0;i--){
            val="";
            val=val+b.charAt(i);
            prod=multiply(a,val);
            c++;
            for(j=1;j<c;j++){
                prod=prod+"0";
            }
            sum=add(sum,prod);
        }
        return sum;
    }
    
    String division(String a, String b){
        if(a.equals(b)){
            return "1";
        }
        String c="0";
        while(greater(a,b) || a.equals(b)){
            a=subtract(a,b);
            c=add(c,"1");
        }
        return c;
    }
    
    boolean greater(String a,String b){
       if(a.length()>b.length()){
           return true;
        }
        else if(a.length()>b.length()){
           return false;
        }
        else if(a.compareTo(b)>0){
            return true;
        }
        else{
            return false;
        }
    }
    
    String pow(String a, String b){
        String i,prod="0";
        prod="1";
        for(i="1";greater(b,i) || b.equals(i);i=add(i,"1")){
            prod=longMultiply(prod,a);
        }
        return prod;
    }
    
    String mod(String a, String b){
        if(a.equals(b)){
            return "0";
        }
        while(greater(a,b) || a.equals(b)){
            a=subtract(a,b);
        }
        return a;
    }
    
    String trim(String a){
        int i=0;
        if(a.length()==1){
            return a;
        }
        while(a.length()!=1 && a.charAt(i)=='0'){
            a=a.substring(i+1,a.length());
            i++;
        }
        return a;
    }
}


        
