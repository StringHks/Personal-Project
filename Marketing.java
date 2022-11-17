import java.util.*;
import java.util.*;
class Marketing
{
    //Stock inside the shop
    static Scanner sc=new Scanner(System.in);
    static int index,tt;
    static int serialno[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
    static String items[]={"pen","pencil","eraser","ruler","notebook","chalk","whitener","nescafe","hairband","fevicol","tide detergent","rin soap","lux soap","sunsilk shampoo","dove soap","chane ki daal","urad ki daal","mixed daal","ashirvaad aata","olive oil","sarso ka tel","fairness cream","shaving cream","denim perfume","fogg perfume","dairy milk","namkeen","match box","insence stick","cold drink"};
    static String icode[]={"P001","P002","P003","P004","P005","P006","P007","P008","P009","P010","P011","P012","P013","P014","P015","P016","P017","P018","P019","P020","P021","P022","P023","P024","P025","P026","P027","P028","P029","P030"};
    static int qitems[]={100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100};
    static int priceitems[]={10,5,5,5,15,10,25,55,17,10,100,30,40,5,29,150,140,170,317,59,64,89,75,68,136,55,77,8,25,95};

    private static void index(String ic)
    {
        for(int x=0;x<30;x++)
        {
            if(ic.equals(icode[x]))
            {
                index=x;
            }
        }
    }

    private static void stockmodi(String s)
    {
        char choice;
        do
        {
            System.out.println("Enter your choice");
            System.out.println("1\t-\tModification in Quantity");
            System.out.println("2\t-\tModification in Price");
            System.out.println("3\t-\tModification in Both");
            int ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                System.out.println("Enter new stock");
                int nq=sc.nextInt();
                qitems[index]=nq+qitems[index];
                System.out.println("S.No.\tCode\t\tItem\t\tStock\t\tPrice");
                System.out.println(index+"\t\t"+s+"\t"+items[index]+"\t"+qitems[index]+"\t"+priceitems[index]);
                break;
                case 2:
                System.out.println("Enter new price");
                int price=sc.nextInt();
                priceitems[index]=price;
                System.out.println("S.No.\t\tCode\t\tItem\t\tStock\t\tPrice");
                System.out.println(index+"\t"+s+"\t"+items[index]+"\t"+qitems[index]+"\t"+priceitems[index]);
                break;
                case 3:
                System.out.println("Enter new price");
                int pr=sc.nextInt();
                priceitems[index]=pr;
                System.out.println("Enter new Stock");
                int nqq=sc.nextInt();
                qitems[index]=nqq+qitems[index];               
                System.out.println("S.No.\t\tCode\t\tItem\t\tStock\t\tPrice");
                System.out.println(index+"\t"+s+"\t"+items[index]+"\t"+qitems[index]+"\t"+priceitems[index]);
                break;
                default:System.out.println("Invalid Input!!!\nPlease Enter Again");
            }
            System.out.println("Do you want to continue?(Yes / No)");
            choice=sc.next().charAt(0);
        }while(choice=='Y');
        System.out.println("\t\t\tThank You For Modification");
        pause();
    }

    private static void Billing(String n,long phone)
    {
        int x=0;
        char uch;
        String cd[]=new String[30];
        String name[]=new String[30];
        int price[]=new int[30];
        int ppp[]=new int[30];
        int quantity[]=new int[30];
        System.out.println("\n\t\t---------->WELCOME!To Buy Items<----------");
        do
        {
            System.out.println("Enter Item Code");
            String code=sc.next();
            index(code);
            if(code.equals(icode[index]))
            {
                System.out.println("S.No.\t\tCode\t\tItem\t\tStock\t\tPrice");
                System.out.println(index+"\t"+icode[index]+"\t"+items[index]+"\t"+qitems[index]+"\t"+priceitems[index]);
                cd[x]=code;
                name[x]=items[index];
                ppp[x]=priceitems[index];
                System.out.println("Enter number of Quantity to buy");
                int q=sc.nextInt();
                if(q>qitems[index])
                {
                    System.out.println("Only "+qitems[index]+" is available");
                    System.out.println("Please Re-Enter number of Quantity to buy");
                    q=sc.nextInt();
                    qitems[index]=qitems[index]-q;
                    quantity[x]=q;
                    price[x]=q*priceitems[index];
                }
                else
                {
                    qitems[index]=qitems[index]-q;
                    quantity[x]=q;
                    price[x]=q*priceitems[index];
                }
            }
            else
            {
                System.out.println("Invalid Item Code");
                System.out.println("Please Re-Enter Item Code");
                code=sc.next();
                index(code);
                if(code.equals(icode[index]))
                {
                    System.out.println("S.No.\t\tCode\t\tItem\t\tStock\t\tPrice");
                    System.out.println(index+"\t"+icode[index]+"\t"+items[index]+"\t"+qitems[index]+"\t"+priceitems[index]);
                    cd[x]=code;
                    name[x]=items[index];
                    ppp[x]=priceitems[index];
                    System.out.println("Enter number of Quantity  to Buy");
                    int q=sc.nextInt();
                    if(q>qitems[index])
                    {
                        System.out.println("Only "+qitems[index]+" is available");
                        System.out.println("Please Re-Enter Quantity of Items to Buy");
                        q=sc.nextInt();
                        qitems[index]=qitems[index]-q;
                        quantity[x]=q;
                        price[x]=q*priceitems[index];
                    }
                    else
                    {
                        qitems[index]=qitems[index]-q;
                        quantity[x]=q;
                        price[x]=q*priceitems[index];
                    }
                }
            }
            x++;
            System.out.println("Do You Want To Buy More Items(Yes / No)");
            uch=sc.next().charAt(0);
        }while(uch=='Y');
        int total=0,c1=0,c2=0;
        System.out.println("\f\t\t\t*-*-*-*-*-*-*-*->>BILL<<-*-*-*-*-*-*-*-*");
        System.out.println("Customer Name:"+n);
        System.out.println("Mobile No.:"+phone);
        System.out.println("\nItem :\t\tCode :\t\tQuantity :\t\tPricePerPiece\\Packet :\t\tPrice :");
        for(int y=0;y<30;y++)
        {
            if(quantity[y]>0)
            {
                c1++;
                c2+=quantity[y];
                total+=price[y];
                System.out.println(name[y]+"\t"+cd[y]+"\t"+quantity[y]+"\t\t"+"Rs."+ppp[y]+".0"+"\t\t\t"+"Rs."+price[y]+".0");
            }
        }
        System.out.println("\nNo.of Items :\tNo.of Quantities :\t\t\tAmount :");
        System.out.println(c1+"\t\t"+c2+"\t\t\t\t\t"+"Rs."+total+".0");
        double t=0.0,net=0.0;
        t=(23.0/100.0)*total;
        net=total+t;
        System.out.println("\n23%GST =Rs."+t);
        System.out.println("Amount payable(including GST) = Rs."+net);
        System.out.println("\n\t\t\tThanks For Visiting\nPlease Come Again.");
        pause();
    }

    public static void main(String args[])
    {
        int ch;
        do{

            System.out.println("*.-*.-*.-*.-*.-*.-*~~~WELCOME TO PRAYAGRAJ COMPLEX~~~*-.*-.*-.*-.*-.*-.*-.*");
            System.out.println("1\t-\tStock Modification");
            System.out.println("2\t-\tBilling");
            System.out.println("3\t-\tExit");
            System.out.println("ENTER YOUR CHOICE");

            ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                System.out.println("STOCK MODIFICATION");
                System.out.println("Enter Item Code");
                String ic=sc.next();
                boolean f=false;
                index(ic);
                if(ic.equals(icode[index]))
                {
                    System.out.println("S.No.\tCode\tItem\tStock\tPrice");
                    System.out.println(index+"\t"+icode[index]+"\t"+items[index]+"\t"+qitems[index]+"\t"+priceitems[index]);
                    stockmodi(ic);
                    f=true;
                    break;
                }
                if(f==false)
                {
                    System.out.println("Invalid Item Code");
                    System.out.println("Please Re-Enter Item Code");
                    ic=sc.next();
                    index(ic);
                    if(ic.equals(icode[index]))
                    {
                        System.out.println("S.No.\t\tCode\t\tItem\t\tStock\t\tPrice");
                        System.out.println(index+"\t"+icode[index]+"\t"+items[index]+"\t"+qitems[index]+"\t"+priceitems[index]);
                        stockmodi(ic);
                        break;
                    }
                }
                pause();
                break;
                case 2:
                System.out.println("Enter Customer Name");
                sc.nextLine();
                String name=sc.nextLine();
                System.out.println("Enter Mobile Number");
                long phone=sc.nextLong();
                Billing(name,phone);
                break;
                case 3:
                System.out.println("EXIT\n\t\t~~~~~Thanks For Visiting.~~~~~~");
                break;
                default:System.out.println("Wrong Input\nPlease Try Again");
                pause();
            }
        }while(ch!=3);

    }

    private static void pause()
    {
        System.out.println("Please Enter to Continnue");
        String s=sc.nextLine();
        String s1=sc.nextLine();
        System.out.println("\f");
    }
}