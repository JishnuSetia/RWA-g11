package OOP;

public class Date {
    int dt,mn,yr;
    public Date(){
        dt = 1;
        mn = 1;
        yr=1900;
    }
    public Date(int dt,int mn,int yr){
        this.dt = dt;
        this.mn = mn;
        this.yr = yr;
        if(!validate()){
            this.dt=0;
            this.mn=0;
            this.yr =0;
        }
    }
    public Date(String in){
        // dd/mm/yyyy
        String[] split = in.split("/");
        dt = Integer.parseInt(split[0]);
        mn = Integer.parseInt(split[1]);
        yr = Integer.parseInt(split[2]);
        if(!validate()){
            dt=0;
            mn=0;
            yr =0;
        }
    }
    public boolean validate(){
        if(mn>0&&mn<13){
            if(mn==1||mn==3||mn==5||mn==7||mn==8||mn==10||mn==12){
                if(dt>0&&dt<32){
                    return true;
                }
            }else{
                if(mn==2){
                    if(leapchk()){
                        if(dt>0&&dt<30){
                            return true;
                        }
                    }else{
                        if(dt>0&&dt<29){
                            return true;
                        }
                    }
                }else{
                    if(dt>0&&dt<31){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean leapchk() {
        /*function isLeapYear(year):
    if year is divisible by 400:
        return true
    else if year is divisible by 100:
        return false
    else if year is divisible by 4:
        return true
    else:
        return false */
        if(yr%400==0||yr%4==0){
            return true;
        }else{
            return false;
        }
    }
    private boolean leapchk(int year) {
        /*function isLeapYear(year):
    if year is divisible by 400:
        return true
    else if year is divisible by 100:
        return false
    else if year is divisible by 4:
        return true
    else:
        return false */
        if(year%400==0||year%4==0){
            return true;
        }else{
            return false;
        }
    }
    public String monthName(){
        String[] months = {"January", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        if(mn!=0){
            return months[mn-1];
        }else{
            return "-";
        }
    }
    public String displayDate(){
        return Integer.toString(dt).concat("/".concat(Integer.toString(mn).concat("/".concat(Integer.toString(yr)))));
    }
    public String longFormat(){
        if(dt!=0){
            String a = Integer.toString(dt);
            if(a.charAt(a.length()-1)=='1'){
                a = a.concat("st");
            }else if(a.charAt(a.length()-1)=='2'){
                a = a.concat("nd");
            }else if(a.charAt(a.length()-1)=='3'){
                a = a.concat("rd");
            }else{
                a=a.concat("th");
            }
            a = a.concat(" ".concat(monthName().concat(" ".concat(Integer.toString(yr)))));
            return a;
        }
        return "-";
    }
    public boolean equals(Date date){
        if(dt==date.dt&&mn==date.mn&&yr==date.yr){
            return true;
        }
        return false;
    }
    public int compareTo(Date date) {
        if (equals(date)) {
            return 0;
        }
    
        if (yr < date.yr) {
            return 1;
        } else if (yr > date.yr) {
            return -1;
        } else {
            if (mn < date.mn) {
                return 1;
            } else if (mn > date.mn) {
                return -1;
            } else {
                if (dt < date.dt) {
                    return 1;
                } else if (dt > date.dt) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    }
    public Date add(int n) {
        int d = dt + n;
        int m = mn;
        int y = yr;
    
        while (d > daysInMonth(m, y)) {
            d -= daysInMonth(m, y);
            m++;
    
            if (m > 12) {
                m = 1;
                y++;
            }
        }
    
        return new Date(d, m, y);
    }
    
    private int daysInMonth(int month, int year) {
        if (month == 2) {
            if (leapchk(year)) {
                return 29;
            } else {
                return 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30; 
        } else {
            return 31; 
        }
    }
    public Date sub(int n) {
        int d = dt - n;
        int m = mn;
        int y = yr;

        while (d < 1) {
            m--;

            if (m < 1) {
                m = 12;
                y--;
            }

            d += daysInMonth(m, y);
        }
        return new Date(d, m, y);
    }

    public int diffDate(Date date){
        if(this.equals(date)){
            return 0;
        }
        int ySum = 0;
        for(int i = 1;i<yr;i++){
            ySum+=(leapchk(i)?366:365);
        }
        int mSum = 0;
        for(int i = 0;i<mn;i++){
            mSum+=daysInMonth(i, yr);
        }
        int dSum = dt;
        
        int sum1 = ySum+mSum+dSum;

        ySum = 0;
        for(int i = 1;i<date.yr;i++){
            ySum+=(leapchk(i)?366:365);
        }
        mSum = 0;
        for(int i = 0;i<date.mn;i++){
            mSum+=daysInMonth(i, date.yr);
        }
        dSum = date.dt;

        int sum2 = ySum+mSum+dSum;
        return sum1>sum2?sum1-sum2:sum2-sum1;
    }
    public static void main(String[] args) {
        Date d = new Date(3,12,1981);
        Date e = new Date(5,6,2007);
        Date f = new Date(6,7,2008);
        // System.out.println(d.validate());
        // System.out.println(d.monthName());
        // System.out.println(d.displayDate());
        // System.out.println(d.longFormat());
        // System.out.println(e.validate());
        // System.out.println(e.monthName());
        // System.out.println(e.displayDate());
        // System.out.println(e.longFormat());
        // System.out.println(d.compareTo(e));
        // System.out.println(e.compareTo(d));
        // System.out.println(f.compareTo(e));
        // System.out.println(e.add(900).displayDate());
        // System.out.println(e.sub(900).displayDate());
        System.out.println(e.diffDate(d));
    }
}
