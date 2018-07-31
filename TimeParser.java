package time.parser;

/*
 * Name: Peter Trinh
 * Class: CSCE 351 - Automota & Complexity
 * Instructor: Faye Tanner
 * Date: February 4 2017
 * 
This program identifies time(Standard, Military, and Abbreviated) through a DFA.

-cases 0-11 cover military time
-cases 0, 14-22 cover regular time
-cases 0, 12, 23-29 cover abbreviated time
*/
public class TimeParser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
     String source = "Hello Myra, the meeting is on 2/5 in room 1300. It will last from 1-2 PM. There will\n" +
                    "be a sumptuous banquet afterward at 1800 hours. The address is 2300 Sycamore Lane.\n" +
                    "Please RSVP by 5:30 PM on February 1 at 786-4819. You can check out our new wide\n" +
                    "screen set with the 16:9 aspect ratio!";
     
     int state = 0;
     char st0=0,st1=0,st2=0,st3=0,st4=0,st5=0,st6=0,st7=0,st8=0,st9=0,st10=0,
     st11=0,st12=0,st13=0,st14=0,st15=0,st16=0,st17=0,st18=0,st19=0,st20=0,
     st21=0,st22=0,st23=0,st24=0,st25=0,st26=0,st27=0,st28=0,st29=0;
     
     for (char c : source.toCharArray()){ //iterates through string
        
         switch (state){
         
             case (0):{
                 if(c =='a'){
                     state = 1;
                     st0=c;
                 }
                 else if(c=='1'){
                     state = 12;
                     st0=c;
                 }
                 else if (c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9'){
                     state = 14;
                     st0=c;
                 }
                 else{
                     state = 0;
                 }
                 break;
             }
             case (1): {
                 if (c=='t'){
                     state = 2;
                     st1=c;
                 }
                 else{
                     state = 0;
                 }
                 break;
                 }
             case (2):{
                 if (c== ' '){
                     state = 3;
                     st2=c;
                 }
                 else{
                     state=0;
                 }
                 break;
             }
             case(3):{
                 if (c=='1' || c=='0') {
                     state = 4;
                     st3=c;
                 }
                 else if (c=='2') {
                     state = 5;
                     st3=c;
                 }
                 else{
                     state = 0;
                 }
                 break;
             }
             case (4):{
                 if ( c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9' || c=='0'){
                     state = 6;
                     st4=c;
                 }
                 else{
                     state = 0;
                 }
                 break;
             }
             case (5):{
                 if (c == '1' || c == '2' || c == '3' || c == '0') {
                     state = 6;
                     st5=c;
                 }
                 else{
                         state = 0;
                 }
                 break;
            }
             case (6):{
                 if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '0') {
                     state = 7;
                     st6=c;
                 }
                 else{
                     state = 0;
                 }
                 break;
             }
             case (7):{
                 if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == '0' ) {
                     state = 8;
                     st7=c;
                 }
                 else{
                     state = 0;
                 }
                 break;
             }
             case (8): {
                 if (c == '-'){
                     state = 3;
                     st8=c;
                     char[] time = new char[] {st0,st1,st2,st3,st4,st5,st6,st7,st8}; //chars output time
                     String output = new String(time);
                     System.out.println(output);
                 }
                 else if(c == ' '){
                     state = 9;
                     st8=c;
                     
                     if( st3==st4){
                         char[] string = new char[] {st2,st3,st5,st6,st7,st8};
                         String output = new String(string);
                         System.out.println(output);
                         break;
                     }
                     char[] string = new char[] {st2,st3,st4,st5,st6,st7,st8};
                     String output = new String(string);
                     System.out.println(output);
                     
                 }
                 else{
                     
                 }
                 break;
                 }
             case (9):{
                 if (c == 't') {
                     state = 10;
                     st9=c;
                 }
                 else{
                     state = 0;
                     st9=c;
                 }
                 break;
             }
             case (10):{
                 if(c == 'o'){
                     state = 11;
                     st10=c;
                 }
                 else{
                     state = 0;
                 }
                 break;
             }
             case(11):{
                 if (c == ' '){
                     state = 3;
                     st1=c;
                 }
                 else{
                     state = 0;
                 }
                 break;
             }
             case (12):{
                 if (c == '-'){
                     state = 23;
                     st12=c;
                 }
                 else if(c== ' '){
                     state = 24;
                     st12=c;
                 }
                 else if(c==':'){
                     state = 15;
                     st12=c;
                 }
                 else if(c=='0' || c=='1'  || c=='2'){
                     state = 13;
                     st12=c;
                 }
                 else{
                     state = 0;
                 }
                 break;
             }
             case (13):{
                 if (c== ':'){
                     state = 15;
                     st13=c;
                 }
                 else if (c == '-'){
                     state = 23;
                     st13=c;
                 }
                 else if (c == ' '){
                     state = 24;
                     st13=c;
                 }
                 else{
                     state = 0;
                 }
                 break;
             }
             case (14):{
                 if(c == ':'){
                     state = 15;
                     st14=c;
                 }
                 else if (c == '-'){
                     state = 23;
                     st14=c;
                 }
                 else if (c == ' '){
                     state = 24;
                     st14=c;
                 }
                 else{
                     state = 0;
                 }
                 break;
             }
             case (15):{
                 if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '0'){
                     state = 16;
                     st15=c;
                 }
                 else{
                     state = 0;
                 }
                 break;
             }
             case (16): {
                 if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == '0') {
                     state = 17;
                     st16=c;
                 }
                 else {
                     state = 0;
                 }
                 break;
             }
             case (17): { //Holds special conditions to print correctly
                 if (c == '-') {
                     state = 0;
                     st17=c;
                     char[] string = new char[] {st0,st12,st13,st15,st16,st17};
                     String output = new String(string);
                     System.out.println(output);
                 }
                 if(st19=='M' && st14!=':'){  // needed this so it won't print 1::30
                     state = 0;
                     st17=c;
                     char[] string = new char[] {st0,st13,st15,st16,st17};
                     String output = new String(string);
                     System.out.println(output);
                     break;
                 }
                 else if( c == ' ' && st14 == ':' && st12 == ':') { // needed this so it won't print 1::30
                     state = 18;
                     char[] string = new char[] {st0,st14,st13,st16,st17};
                     String output = new String(string);
                     System.out.println(output);
                     st17=c;
                     break;
                 }
                 if(st14==':' && st13==':' && st12!='2'&&st12!='0'&& st12!='1'){ 
                     state = 18;
                     st17=c;
                     char[] string = new char[] {st0,st12,st13,st15,st16,st17};
                     String output = new String(string);
                     System.out.println(output);
                     break;
                 }
                 if(st14==':'&& st13==':' && st12!='2'&&st12!='0'&& st12!='1'){
                    state = 18;
                    st17=c;
                    char[] string = new char[] {st0,st12,st13,st15,st16,st17};
                    String output = new String(string);
                    System.out.println(output);
                    break;
                }
                 if(st14==':'&& st13==':'&&st15=='0' ){// needed this so it won't print 1::30 and 52:15
                    state = 18;
                    st17=c;
                    char[] string = new char[] {st0,st12,st13,st15,st16,st17};
                    String output = new String(string);
                    System.out.println(output);
                    break;
                 }
                if(st0>=0 && st14==':'&& st12==':'){// needed this so it won't print 1::30 and 52:15
                    state = 18;
                    st17=c;
                    char[] string = new char[] {st0,st13,st15,st16,st17};//st14
                    String output = new String(string);
                    if(st0>=0 && st14==':'|| st12==':'){  // needed this so it won't print 1::30 and 52:15
                     state = 18;
                    st17=c;
                    char[] string2 = new char[] {st0,st13,st15,st16,st17};//st14
                    String output2 = new String(string2);
                    System.out.println(output2);
                    break;
                }
                 System.out.println(output);
                 break;
                 }

                if(st12>=0 &&st13==':'){// needed this so it won't print 1::30 and 52:15
                    state = 18;
                    st17=c;
                    if(st0=='1' && st12>=0){
                    char[] string = new char[] {st0,st12,st13,st15,st16,st17};
                    String output = new String(string);
                    System.out.println(output);
                    break;
                 }
                 if(st12=='0'){
                     char[] string = new char[] {st0,st12,st13,st15,st16,st17};
                     String output = new String(string);
                     System.out.println(output);
                     break;
                 }
                    char[] string = new char[] {st0,st13,st15,st16,st17};
                    String output = new String(string);
                    System.out.println(output);
                    break;
                 }
                 if(st14==':'&& st13==':'&&st12!=' '&& st12!=':' ){
                    state = 18;
                    st17=c;
                    char[] string = new char[] {st0,st12,st13,st15,st16,st17};
                     String output = new String(string);
                    System.out.println(output);
                    break;
                  }

                  if(st14==':'&& st13==':'){  // needed this so it won't print 1:30(should be 10:30) and 52:15
                    state = 18;
                    st17=c;
                    char[] string = new char[] {st0,st12,st13,st15,st16,st17};
                    String output = new String(string);
                    System.out.println(output);
                    break;
                    }
                     if(st12==':' && st13==':'){
                    state = 18;
                    st17=c;
                    char[] string = new char[] {st0,st12,st15,st16,st17};
                     String output = new String(string);
                     System.out.println(output);
                     break;
                     }
                    if(st12==':'){
                    state = 18;
                    st17=c;
                    char[] string = new char[] {st0,st12,st13,st15,st16,st17};
                    String output = new String(string);
                    System.out.println(output);
                    break;
                    }
                    if(st18!='t'&& st12!='2'&& st12!='0' &&st12!='1'){

                     st17=c;
                    char[] string = new char[] {st0,st14,st13,st15,st16,st17};
                    String output = new String(string);
                    System.out.println(output);
                    state = 0;
                    break;
                    }
                     if(st14 == ':' && st12!='2'){
                     state = 18;
                    st17=c;
                    char[] string = new char[] {st0,st14,st13,st15,st16,st17};
                    String output = new String(string);
                    System.out.println(output);
                   }
                    else {
                    char[] string = new char[] {st0,st12,st13,st15,st16,st17};
                    String output = new String(string);
                    System.out.println(output);
                    state = 0;
                    break;                                                                                   
                    }
                }
                case (18):{
                 if (c == 'A'|| c == 'P') {
                  state = 19;
                  st18=c;
                  }
                  else if(c=='t' ){
                  state =21;
                  st18=c;
                  }
                   else{
                    state = 0;
                 }
                 break;
                }
                case (19): {
                 if (c == 'M') {
                  state = 20;
                  st19=c;
                  } 
                  else {
                  char[] string = new char[] {st0,st12,st13,st14,st15,st16,st17,st18};
                  String output = new String(string);
                  System.out.println(output); 
                  state = 0;
                  }
                  break;
                }
                case (20): {
                 state = 0;
                 st20=c;
                 if(st14==':' && st12=='-' && st19=='M'){
                 break;
                 }
                 if(st14==':' && st12=='-' && st19=='M' && st18=='P'){
                  char[] string = new char[] {st0,st12,st23,st18,st19};//st0,st1
                  String output = new String(string);
                  System.out.println(output);
                  }
                  if(st12=='-'){
                   if(st14==':'){
                    char[] string = new char[] {st0,st13,st14,st15,st16,st17,st29,st18,st19};//st0,st1
                     String output = new String(string);
                     System.out.println(output);
                     break;
                     }
                      if(st19=='M'){
                       break;
                      }
                     char[] string = new char[] {st0,st12,st13,st14,st15,st16,st17,st23,st29,st18,st19};//st0,st1
                    String output = new String(string);
                    System.out.println(output);
                    }
                    break;
                }
                case (21): {
                 if (c == 'o' ) {
                  state = 22;
                  st21  =c;
                  }
                  else{
                  state = 0;
                  }
                  break;
                }
                case (22):{
                 if (c == ' ' ){
                  state = 0;
                  st22=c;
                  }
                   else{
                    state = 0;
                    }
                     break;
                }
                case (23):{
                  if (c == '1' ) {
                  state = 28;
                  st23=c;
                  }
                  else if(c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9'  ){
                    state =29;
                    st23=c;
                    }
                     else{
                     state = 0;
                     }
                     break;
                 }
                 case (24): {
                 if (c == 't' ) {
                 state = 25;
                  st24=c;
                  }
                  else{ state = 0;
                  }
                  break;
                }
                case (25):{
                 if (c == 'o') {
                  state = 26;
                  st25=c;
                   }
                 else{ state = 0;}
                 break;
                }
                case (26):{
                  if (c == ' ') {
                  state = 27;
                  st26=c;
                  }
                  else{ state = 0;}
                  break;
                  }
                case (27): {
                  if (c == '1'){
                    state = 28;
                    st27=c;
                   }
                    else if(c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9'){
                    state = 29;
                    st27=c;    
                  }
                  else{ state = 0;}
                   break;
                }
                case (28):{
                  if (c == '2' || c == '1' || c == '0' ) {
                    state = 29;
                    st29=c;
                    }
                  else{ state = 0;}
                    break;
                }
                case (29):{
                 if(st24=='t' && st25=='o' && st12!='-'){
                  state = 18; 
                  st29=c;
                  char[] string = new char[] {st0,st12,st24,st25,st26,st23,st27};
                  String output = new String(string);
                 System.out.println(output);  
                  }
                if (c == ' '&& st12!=' ' ){
                  state = 18; 
                  st29=c;
                  char[] string = new char[] {st0,st12,st23};
                  String output = new String(string);
                  System.out.println(output);  
                  }
                  else{
                    state = 0;
                    }
                    break;
                }
              }
            }

                if(state==8)
                {
                  char[] string = new char[] {st2,st3,st4,st5,st6,st7,st8};//catches back to back times & special cases 
                             String output = new String(string);
                              System.out.println(output);  
                }
                 if(state==17)
               {
                 char[] string = new char[] {st0,st12,st13,st15,st16,st17};//catches back to back times & special cases 
                            String output = new String(string);
                            System.out.println(output);  
               }

                if(state==29)
                {
                  char[] string = new char[] {st0,st12,st13,st14,st23,st26,st28,st29,st19,st20};//catches special cases when it takes the route of "time to time"  && "time-time"
                             String output = new String(string);
                              System.out.println(output);  
                }
            }

}