/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ashish Shrivastav
 * @author Sparsh Singh
 */
import java.util.*;
public class Monopoly {
    /**
     * @param args the command line arguments
     */
    /*Defining set of global variables and constants*/
    static String player_names[]=new String[4];
    static char player_status[]=new char[4];
    static int player_money[]=new int[4];
    static int player_position[]=new int[4];
    static String board[]=new String[40];
    static class Property
    {
        int position=0;
        String name="";
        int cost=0;
    }
    static Property property_names[]=new Property[28];
    static int colour_rents[][]=new int[7][22];
    static int owner[]=new int[28];
    static int rent_station;
    static int mortgage_status[][]=new int[2][28];
    //static int token[]=new int[4];
    static int houses[][]=new int[2][22];
    static int price_house[][]=new int[2][22];
    static class Chance
    {
        int id=0;
        String task="";
    }
    static Chance chances[]=new Chance[16];
    static class Community
    {
        int id=0;
        String task="";
    }
    static Community community_chests[]=new Community[16];
    static int order_chance[]=new int[16];
    static int chance_index;
    static int order_community[]=new int[16]; 
    static int community_index;
    static int jail_chances[]=new int[4];
    static int jail_free[]=new int[4];
    static int player_chance;
    static int parking_money;
    static int bank_houses;
    static int bank_hotels;
    static int first_dice;
    static int second_dice;
    static int dice;
    static int chance_id[]=new int[16];
    static int community_id[]=new int[16];
    static int chance_free;
    static int community_free;
    static Scanner sc=new Scanner(System.in);
    static int number;
    static class PlayerData{
        public String index;
        public String name;
        public String mortgage_status;
        public String price;
        public String mprice;
        public String rent0;
        public String rent1;
        public String rent2;
        public String rent3;
        public String rent4;
        public String rent5;
        public String houses;
        public String price_house;
        public String current_rent;
    }
    static class BankData{
        public String index;
        public String name;
        public String price;
        public String mprice;
        public String rent0;
        public String rent1;
        public String rent2;
        public String rent3;
        public String rent4;
        public String rent5;
        public String price_house;
    }
    static String colors[]=new String[8];
    static int wantHouses[]=new int[4];
    static int wantHotels[]=new int[4];
    
    public static void main(String[] args) {
        // TODO code application logic here
        /*Initializing the variables*/
        
        for(int i=0;i<4;i++)
            player_status[i]='g';
        
        for(int i=0;i<4;i++)
            player_money[i]=1500;
        
        for(int i=0;i<4;i++)
            player_position[i]=0;
        
        board[0]="go";
        board[1]="mud";
        board[2]="community";
        board[3]="mud";
        board[4]="income";
        board[5]="station";
        board[6]="blue";
        board[7]="chance";
        board[8]="blue";
        board[9]="blue";
        board[10]="visit";
        board[11]="pink";
        board[12]="utility";
        board[13]="pink";
        board[14]="pink";
        board[15]="station";
        board[16]="orange";
        board[17]="community";
        board[18]="orange";
        board[19]="orange";
        board[20]="parking";
        board[21]="red";
        board[22]="chance";
        board[23]="red";
        board[24]="red";
        board[25]="station";
        board[26]="yellow";
        board[27]="yellow";
        board[28]="utility";
        board[29]="yellow";
        board[30]="jail";
        board[31]="green";
        board[32]="green";
        board[33]="community";
        board[34]="green";
        board[35]="station";
        board[36]="chance";
        board[37]="violet";
        board[38]="super";
        board[39]="violet";
        
        for(int i=0;i<28;i++)
        {
            property_names[i]=new Property();
        }
        
        property_names[0].name="OLD KENT ROAD";
        property_names[0].position=1;
        property_names[0].cost=60;
        
        property_names[1].name="WHITECHAPEL ROAD";
        property_names[1].position=3;
        property_names[1].cost=60;
        
        property_names[2].name="KING CROSS STATION";
        property_names[2].position=5;
        property_names[2].cost=200;
        
        property_names[3].name="THE ANGEL, ISLINGTON";
        property_names[3].position=6;
        property_names[3].cost=100;
        
        property_names[4].name="EUSTON ROAD";
        property_names[4].position=8;
        property_names[4].cost=100;
        
        property_names[5].name="PENTONVILLE ROAD";
        property_names[5].position=9;
        property_names[5].cost=120;
        
        property_names[6].name="PALL MALL";
        property_names[6].position=11;
        property_names[6].cost=140;
        
        property_names[7].name="ELECTRIC COMPANY";
        property_names[7].position=12;
        property_names[7].cost=150;
        
        property_names[8].name="WHITEHALL";
        property_names[8].position=13;
        property_names[8].cost=140;
        
        property_names[9].name="NORTHUMBERL'D AVENUE";
        property_names[9].position=14;
        property_names[9].cost=160;
        
        property_names[10].name="MARYLEBONE STATION";
        property_names[10].position=15;
        property_names[10].cost=200;
        
        property_names[11].name="BOW STREET";
        property_names[11].position=16;
        property_names[11].cost=180;
        
        property_names[12].name="MARLBOROUGH STREET";
        property_names[12].position=18;
        property_names[12].cost=180;
        
        property_names[13].name="VINE STREET";
        property_names[13].position=19;
        property_names[13].cost=200;
        
        property_names[14].name="STRAND";
        property_names[14].position=21;
        property_names[14].cost=220;
        
        property_names[15].name="FLEET STREET";
        property_names[15].position=23;
        property_names[15].cost=220;
        
        property_names[16].name="TRAFALGAR SQUARE";
        property_names[16].position=24;
        property_names[16].cost=240;
        
        property_names[17].name="FENCHURCH ST. STATION";
        property_names[17].position=25;
        property_names[17].cost=200;
        
        property_names[18].name="LEICESTER SQUARE";
        property_names[18].position=26;
        property_names[18].cost=260;
        
        property_names[19].name="COVENTRY STREET";
        property_names[19].position=27;
        property_names[19].cost=260;
        
        property_names[20].name="WATER WORKS";
        property_names[20].position=28;
        property_names[20].cost=150;
        
        property_names[21].name="PICCADILLY";
        property_names[21].position=29;
        property_names[21].cost=280;
        
        property_names[22].name="REGENT STREET";
        property_names[22].position=31;
        property_names[22].cost=300;
        
        property_names[23].name="OXFORD STREET";
        property_names[23].position=32;
        property_names[23].cost=300;
        
        property_names[24].name="BOND STREET";
        property_names[24].position=34;
        property_names[24].cost=320;
        
        property_names[25].name="LIVERPOOL ST. STATION";
        property_names[25].position=35;
        property_names[25].cost=200;
        
        property_names[26].name="PARK LANE";
        property_names[26].position=37;
        property_names[26].cost=350;
        
        property_names[27].name="MAYFAIR";
        property_names[27].position=39;
        property_names[27].cost=400;
        
        colour_rents[0][0]=1;
        colour_rents[1][0]=2;
        colour_rents[2][0]=10;
        colour_rents[3][0]=30;
        colour_rents[4][0]=90;
        colour_rents[5][0]=160;
        colour_rents[6][0]=250;
        
        colour_rents[0][1]=3;
        colour_rents[1][1]=4;
        colour_rents[2][1]=20;
        colour_rents[3][1]=60;
        colour_rents[4][1]=180;
        colour_rents[5][1]=320;
        colour_rents[6][1]=450;
        
        colour_rents[0][2]=6;
        colour_rents[1][2]=6;
        colour_rents[2][2]=30;
        colour_rents[3][2]=90;
        colour_rents[4][2]=270;
        colour_rents[5][2]=400;
        colour_rents[6][2]=550;
        
        colour_rents[0][3]=8;
        colour_rents[1][3]=6;
        colour_rents[2][3]=30;
        colour_rents[3][3]=90;
        colour_rents[4][3]=270;
        colour_rents[5][3]=400;
        colour_rents[6][3]=550;
        
        colour_rents[0][4]=9;
        colour_rents[1][4]=8;
        colour_rents[2][4]=40;
        colour_rents[3][4]=100;
        colour_rents[4][4]=300;
        colour_rents[5][4]=450;
        colour_rents[6][4]=600;
        
        colour_rents[0][5]=11;
        colour_rents[1][5]=10;
        colour_rents[2][5]=50;
        colour_rents[3][5]=150;
        colour_rents[4][5]=450;
        colour_rents[5][5]=625;
        colour_rents[6][5]=750;
        
        colour_rents[0][6]=13;
        colour_rents[1][6]=10;
        colour_rents[2][6]=50;
        colour_rents[3][6]=150;
        colour_rents[4][6]=450;
        colour_rents[5][6]=625;
        colour_rents[6][6]=750;
        
        colour_rents[0][7]=14;
        colour_rents[1][7]=12;
        colour_rents[2][7]=60;
        colour_rents[3][7]=180;
        colour_rents[4][7]=500;
        colour_rents[5][7]=700;
        colour_rents[6][7]=900;
        
        colour_rents[0][8]=16;
        colour_rents[1][8]=14;
        colour_rents[2][8]=70;
        colour_rents[3][8]=200;
        colour_rents[4][8]=550;
        colour_rents[5][8]=750;
        colour_rents[6][8]=950;
        
        colour_rents[0][9]=18;
        colour_rents[1][9]=14;
        colour_rents[2][9]=70;
        colour_rents[3][9]=200;
        colour_rents[4][9]=550;
        colour_rents[5][9]=750;
        colour_rents[6][9]=950;
        
        colour_rents[0][10]=19;
        colour_rents[1][10]=16;
        colour_rents[2][10]=80;
        colour_rents[3][10]=220;
        colour_rents[4][10]=600;
        colour_rents[5][10]=800;
        colour_rents[6][10]=1000;
        
        colour_rents[0][11]=21;
        colour_rents[1][11]=18;
        colour_rents[2][11]=90;
        colour_rents[3][11]=250;
        colour_rents[4][11]=700;
        colour_rents[5][11]=875;
        colour_rents[6][11]=1050;
        
        colour_rents[0][12]=23;
        colour_rents[1][12]=18;
        colour_rents[2][12]=90;
        colour_rents[3][12]=250;
        colour_rents[4][12]=700;
        colour_rents[5][12]=875;
        colour_rents[6][12]=1050;
        
        colour_rents[0][13]=24;
        colour_rents[1][13]=20;
        colour_rents[2][13]=100;
        colour_rents[3][13]=300;
        colour_rents[4][13]=750;
        colour_rents[5][13]=925;
        colour_rents[6][13]=1100;
        
        colour_rents[0][14]=26;
        colour_rents[1][14]=22;
        colour_rents[2][14]=110;
        colour_rents[3][14]=330;
        colour_rents[4][14]=800;
        colour_rents[5][14]=975;
        colour_rents[6][14]=1150;
        
        colour_rents[0][15]=27;
        colour_rents[1][15]=22;
        colour_rents[2][15]=110;
        colour_rents[3][15]=330;
        colour_rents[4][15]=800;
        colour_rents[5][15]=975;
        colour_rents[6][15]=1150;
        
        colour_rents[0][16]=29;
        colour_rents[1][16]=24;
        colour_rents[2][16]=120;
        colour_rents[3][16]=360;
        colour_rents[4][16]=850;
        colour_rents[5][16]=1025;
        colour_rents[6][16]=1200;
        
        colour_rents[0][17]=31;
        colour_rents[1][17]=26;
        colour_rents[2][17]=130;
        colour_rents[3][17]=390;
        colour_rents[4][17]=900;
        colour_rents[5][17]=1100;
        colour_rents[6][17]=1275;
        
        colour_rents[0][18]=32;
        colour_rents[1][18]=26;
        colour_rents[2][18]=130;
        colour_rents[3][18]=390;
        colour_rents[4][18]=900;
        colour_rents[5][18]=1100;
        colour_rents[6][18]=1275;
        
        colour_rents[0][19]=34;
        colour_rents[1][19]=28;
        colour_rents[2][19]=150;
        colour_rents[3][19]=450;
        colour_rents[4][19]=1000;
        colour_rents[5][19]=1200;
        colour_rents[6][19]=1400;
        
        colour_rents[0][20]=37;
        colour_rents[1][20]=35;
        colour_rents[2][20]=175;
        colour_rents[3][20]=500;
        colour_rents[4][20]=1100;
        colour_rents[5][20]=1300;
        colour_rents[6][20]=1500;
        
        colour_rents[0][21]=39;
        colour_rents[1][21]=50;
        colour_rents[2][21]=200;
        colour_rents[3][21]=600;
        colour_rents[4][21]=1400;
        colour_rents[5][21]=1700;
        colour_rents[6][21]=2000;
        
        for(int i=0;i<28;i++)
            owner[i]=0;
        
        rent_station=25;
        
        for(int i=0;i<28;i++)
        {
            mortgage_status[0][i]=property_names[i].position;
            mortgage_status[1][i]=0;
        }
        
        for(int i=0;i<22;i++)
        {
            houses[0][i]=colour_rents[0][i];
            houses[1][i]=0;
        }
        
        for(int i=0;i<4;i++)
            jail_chances[i]=0;
        
        for(int i=0;i<4;i++)
            jail_free[i]=0;
        
        parking_money=0;
        
        bank_houses=32;
        
        bank_hotels=12;
        
        for(int i=0;i<22;i++)
            price_house[0][i]=colour_rents[0][i];
        
        price_house[1][0]=50;
        price_house[1][1]=50;
        price_house[1][2]=50;
        price_house[1][3]=50;
        price_house[1][4]=50;
        
        price_house[1][5]=100;
        price_house[1][6]=100;
        price_house[1][7]=100;
        price_house[1][8]=100;
        price_house[1][9]=100;
        price_house[1][10]=100;
        
        price_house[1][11]=150;
        price_house[1][12]=150;
        price_house[1][13]=150;
        price_house[1][14]=150;
        price_house[1][15]=150;
        price_house[1][16]=150;
        
        price_house[1][17]=200;
        price_house[1][18]=200;
        price_house[1][19]=200;
        price_house[1][20]=200;
        price_house[1][21]=200;
        
        for(int i=0;i<16;i++)
        {
            chances[i]=new Chance();
        }
        
        chances[0].id=0;
        chances[0].task="GO BACK THREE SPACES";
        
        chances[1].id=1;
        chances[1].task="ADVANCE TO TRAFALGAR SQUARE IF YOU PASS 'GO' COLLECT 200";
        
        chances[2].id=2;
        chances[2].task="PAY SCHOOL FEE OF 150";
        
        chances[3].id=3;
        chances[3].task="MAKE GENERAL REPAIRS ON ALL OF YOUR BUILDINGS\nFOR EACH HOUSE PAY 25\nFOR EACH HOTEL PAY 100";
        
        chances[4].id=4;
        chances[4].task="ADVANCE TO 'GO'";
        
        chances[5].id=5;
        chances[5].task="YOU HAVE WON A CROSSWORD COMPETITION COLLECT 100";
        
        chances[6].id=6;
        chances[6].task="'DRUNK IN CHARGE' FINE 20";
        
        chances[7].id=7;
        chances[7].task="GO TO JAIL\nMOVE DIRECTLY TO JAIL\nDO NOT PASS 'GO' DO NOT COLLECT 200";
        
        chances[8].id=8;
        chances[8].task="YOU ARE ASSESSED FOR STREET REPAIRS\n40 PER HOUSE\n115 PER HOTEL";
        
        chances[9].id=9;
        chances[9].task="YOUR BUILDING LOAN MATURES RECEIVE 150";
        
        chances[10].id=10;
        chances[10].task="BANK PAYS YOU DIVIDEND OF 50";
        
        chances[11].id=11;
        chances[11].task="ADVANCE TO MAYFAIR";
        
        chances[12].id=12;
        chances[12].task="SPEEDING FINE 15";
        
        chances[13].id=13;
        chances[13].task="TAKE A TRIP TO MARYLEBONE STATION\nIF YOU PASS 'GO' COLLECT 200";
        
        chances[14].id=14;
        chances[14].task="ADVANCE TO PALL MALL\nIF YOU PASS 'GO' COLLECT 200";
        
        chances[15].id=15;
        chances[15].task="GET OUT OF JAIL FREE CARD";
        
        for(int i=0;i<16;i++)
        {
            community_chests[i]=new Community();
        }
        
        community_chests[0].id=0;
        community_chests[0].task="FROM SALE OF STOCK YOU GET 50";
        
        community_chests[1].id=1;
        community_chests[1].task="BANK ERROR IN YOUR FAVOUR COLLECT 200";
        
        community_chests[2].id=2;
        community_chests[2].task="PAY YOUR INSURANCE PREMIUM 50";
        
        community_chests[3].id=3;
        community_chests[3].task="YOU HAVE WON SECOND PRIZE IN A BEAUTY CONTEST COLLECT 10";
        
        community_chests[4].id=4;
        community_chests[4].task="ANNUITY MATURES COLLECT 100";
        
        community_chests[5].id=5;
        community_chests[5].task="ADVANCE TO 'GO'";
        
        community_chests[6].id=6;
        community_chests[6].task="INCOME TAX REFUND COLLECT 20";
        
        community_chests[7].id=7;
        community_chests[7].task="GO TO JAIL\nMOVE DIRECTLY TO JAIL\nDO NOT PASS 'GO'\nDO NOT COLLECT 200";
        
        community_chests[8].id=8;
        community_chests[8].task="DOCTOR'S FEE PAY 50";
        
        community_chests[9].id=9;
        community_chests[9].task="PAY A 10 FINE OR TAKE A 'CHANCE'";
        
        community_chests[10].id=10;
        community_chests[10].task="RECEIVE INTEREST ON 7% PREFERENCE SHARES 25";
        
        community_chests[11].id=11;
        community_chests[11].task="PAY HOSPITAL 100";
        
        community_chests[12].id=12;
        community_chests[12].task="YOU INHERIT 100";
        
        community_chests[13].id=13;
        community_chests[13].task="IT IS YOUR BIRTHDAY COLLECT 10 FROM EACH PLAYER";
        
        community_chests[14].id=14;
        community_chests[14].task="GO BACK TO OLD KENT ROAD";
        
        community_chests[15].id=15;
        community_chests[15].task="GET OUT OF JAIL FREE CARD";
        
        number=4;
        
        colors[0]="mud";
        colors[1]="blue";
        colors[2]="pink";
        colors[3]="orange";
        colors[4]="red";
        colors[5]="yellow";
        colors[6]="green";
        colors[7]="violet";
        
        /*Welcome Note*/
        System.out.println("WELCOME TO MONOPOLY WITH ARTIFICIAL INTELLIGENCE");
        System.out.println("GAME CREDITS: ASHISH SHRIVASTAV\n");
        
        /*Decide chance of players*/
        Random rand=new Random();
        String player[]=new String[4];
        
        System.out.print("Enter name of first player: ");
        player[0]=sc.nextLine();
        System.out.print(player[0]+" press any key to roll the dice");
        sc.nextLine();
        first_dice=rand.nextInt(6)+1;
        second_dice=rand.nextInt(6)+1;
        int total1=first_dice+second_dice;
        System.out.println("You got "+total1+" on dice");
        
        System.out.print("Enter name of second player: ");
        player[1]=sc.nextLine();
        System.out.print(player[1]+" press any key to roll the dice");
        sc.nextLine();
        first_dice=rand.nextInt(6)+1;
        second_dice=rand.nextInt(6)+1;
        int total2=first_dice+second_dice;
        System.out.println("You got "+total2+" on dice");
        
        System.out.print("Enter name of third player: ");
        player[2]=sc.nextLine();
        System.out.print(player[2]+" press any key to roll the dice");
        sc.nextLine();
        first_dice=rand.nextInt(6)+1;
        second_dice=rand.nextInt(6)+1;
        int total3=first_dice+second_dice;
        System.out.println("You got "+total3+" on dice");
        
        System.out.print("Enter name of fourth player: ");
        player[3]=sc.nextLine();
        System.out.print(player[3]+" press any key to roll the dice");
        sc.nextLine();
        first_dice=rand.nextInt(6)+1;
        second_dice=rand.nextInt(6)+1;
        int total4=first_dice+second_dice;
        System.out.println("You got "+total4+" on dice");
        
        int max=Math.max(Math.max(total1,total2),Math.max(total3,total4));
        if(max==total1)
        {
            player_names[0]=player[0];
            player_names[1]=player[1];
            player_names[2]=player[2];
            player_names[3]=player[3];
        }
        else if(max==total2)
        {
            player_names[0]=player[1];
            player_names[1]=player[2];
            player_names[2]=player[3];
            player_names[3]=player[0];
        }
        else if(max==total3)
        {
            player_names[0]=player[2];
            player_names[1]=player[3];
            player_names[2]=player[0];
            player_names[3]=player[1];
        }
        else
        {
            player_names[0]=player[3];
            player_names[1]=player[0];
            player_names[2]=player[1];
            player_names[3]=player[2];
        }
        /*Printing order of chances*/
        System.out.println("Order of chances: "+player_names[0]+"->"+player_names[1]+"->"+player_names[2]+"->"+player_names[3]);
        
        /*Shuffling the chance cards*/
        for(int i=0;i<16;i++)
        {
            chance_id[i]=i;
        }
        int index;
        for (int i = chance_id.length - 1; i > 0; i--)
        {
        index = rand.nextInt(i + 1);
            if (index != i)
            {
                chance_id[index] ^= chance_id[i];
                chance_id[i] ^= chance_id[index];
                chance_id[index] ^= chance_id[i];
            }
        }
        chance_index=chance_id[0];
        chance_free=0;
        
        /*Shuffling the community chest cards*/
        for(int i=0;i<16;i++)
        {
            community_id[i]=i;
        }
        for(int i=community_id.length-1;i>0;i--)
        {
            index=rand.nextInt(i+1);
            if(index!=i)
            {
                community_id[index]^=community_id[i];
                community_id[i]^=community_id[index];
                community_id[index]^=community_id[i];
            }
        }
        community_index=community_id[0];
        community_free=0;
        
        /*Menu*/
        player_chance=0;
        int doublet=0;
        while(player_status[0]!='w'&&player_status[1]!='w'&&player_status[2]!='w'&&player_status[3]!='w')
        {
            System.out.println(player_names[player_chance]+"'s chance");
            int chance_played=0;
            while(true)
            {
                if(chance_played==0)
                {
                    System.out.println("MENU");
                    System.out.println("1: Play Chance");
                    System.out.println("2: See Data");
                    System.out.println("3: Trade");
                    System.out.println("4: Build");
                    System.out.println("5: Mortgage");
                    System.out.println("6: Sell");
                    System.out.println("7: Unmortgage");
                    System.out.println("8: Auction");
                    System.out.println("9: Declare bankruptcy");
                    System.out.print("Enter Selection: ");
                    int selection=sc.nextInt();
                    int exit=0;
                    switch(selection)
                    {
                        case 1:
                            int jail_choice=0;
                            if(jail_chances[player_chance]==1||jail_chances[player_chance]==2)
                            {
                                System.out.println("1: Get out of jail by giving 50");
                                System.out.println("2: Get out of jail by jail free card");
                                System.out.println("3: Do not get out of jail");
                                System.out.println("Warning: If you don't have jail free card then 50 would be deducted");
                                System.out.print("Enter Selection: ");
                                jail_choice=sc.nextInt();
                                if(jail_choice!=1&&jail_choice!=2&&jail_choice!=3)
                                    System.out.println("Invalid selection, you will not get out from jail now");
                            }
                            else if(jail_chances[player_chance]==3)
                            {
                                System.out.println("1: Get out of jail by giving 50");
                                System.out.println("2. Get out of jail by jail free card");
                                System.out.println("Warning: If you don't have jail free card then 50 would be deducted");
                                System.out.print("Enter Selection: "); 
                                jail_choice=sc.nextInt();
                                if(jail_choice!=1&&jail_choice!=2)
                                    System.out.println("Invalid selection, you will get out from jail now by giving 50");
                            }
                            System.out.print("Enter number you want on first dice: ");
                            first_dice=sc.nextInt();
                            System.out.print("Enter number you want on second dice: ");
                            second_dice=sc.nextInt();
                            dice=first_dice+second_dice;
                            if(jail_chances[player_chance]==0)
                            {
                                int previous=player_position[player_chance];
                                player_position[player_chance]=(player_position[player_chance]+dice)%40;
                                if(player_position[player_chance]<previous)
                                    player_money[player_chance]+=200;
                                if(first_dice==second_dice)
                                {
                                    doublet++;
                                    chance_played=-1;
                                    if(doublet==3)
                                    {
                                        System.out.println("You got three consecutive doublets...Moving you to jail");
                                        player_position[player_chance]=10;
                                        jail_chances[player_chance]=1;
                                        chance_played=0;
                                        doublet=0;
                                    }
                                }
                                else
                                    doublet=0;
                            }
                            else if(first_dice==second_dice)
                            {
                                int previous=player_position[player_chance];
                                player_position[player_chance]=(player_position[player_chance]+dice)%40;
                                if(player_position[player_chance]<previous)
                                    player_money[player_chance]+=200;
                                jail_chances[player_chance]=0;
                            }
                            else if(jail_chances[player_chance]==1||jail_chances[player_chance]==2)
                            {
                                if(jail_choice!=3)
                                {
                                    getOutOfJail(player_chance,jail_choice);
                                    int previous=player_position[player_chance];
                                    player_position[player_chance]=(player_position[player_chance]+dice)%40;
                                    if(player_position[player_chance]<previous)
                                        player_money[player_chance]+=200;
                                }
                                else
                                    jail_chances[player_chance]++;
                            }
                            else
                            {
                                getOutOfJail(player_chance,jail_choice);
                                int previous=player_position[player_chance];
                                player_position[player_chance]=(player_position[player_chance]+dice)%40;
                                if(player_position[player_chance]<previous)
                                    player_money[player_chance]+=200;
                            }
                            int flag=0;
                            for(int i=0;i<28;i++)
                            {
                                if(player_position[player_chance]==property_names[i].position)
                                {
                                  flag=1;
                                  break;
                                }
                            }
                            if(flag==1)
                                onProperty(player_position[player_chance],player_chance);
                            else
                            {
                                if(board[player_position[player_chance]].equals("income"))
                                {
                                    System.out.println("You land on INCOME TAX of 200");
                                    payBank(200,player_chance);
                                }
                                else if(board[player_position[player_chance]].equals("super"))
                                {
                                    System.out.println("You land on SUPER TAX of 100");
                                    payBank(100,player_chance);
                                    parking_money+=100;
                                }
                                else if(board[player_position[player_chance]].equals("jail"))
                                {
                                    System.out.println("You land on GO TO JAIL...moving you to jail");
                                    player_position[player_chance]=10;
                                    jail_chances[player_chance]=1;
                                }
                                else if(board[player_position[player_chance]].equals("parking"))
                                {
                                    System.out.println("You land on free parking");
                                    if(parking_money>0)
                                    {
                                        System.out.println("You got "+parking_money+" on free parking");
                                        player_money[player_chance]+=parking_money;
                                        parking_money=0;
                                    }
                                }
                                else if(board[player_position[player_chance]].equals("chance"))
                                {
                                    System.out.println("You land on chance");
                                    drawChance(player_chance);
                                }
                                else if(board[player_position[player_chance]].equals("community"))
                                {
                                    System.out.println("You land on Community Chest");
                                    drawCommunity(player_chance);
                                }
                                else if(board[player_position[player_chance]].equals("visit"))
                                {
                                    System.out.println("You just visiting the jail");
                                }
                            }
                        chance_played++;
                        break;     
                        case 2:
                            seeData(player_chance);
                            break;
                        case 3:
                            trade(player_chance);
                            break;
                        case 4:
                            build(player_chance);
                            break;
                        case 5:
                            mortgage(player_chance);
                            break;
                        case 6:
                            sell(player_chance);
                            break;
                        case 7:
                            unmortgage(player_chance);
                            break;
                        case 8:
                            auction(player_chance);
                            break;
                        case 9:
                            sellAllHouses(player_chance);
                            for(int i=0;i<28;i++)
                            {
                                if((owner[i]==player_chance+1)&&(mortgage_status[0][i]==1))
                                    mortgage_status[1][i]=0;
                            }
                            for(int i=0;i<28;i++)
                            {
                                if(owner[i]==player_chance+1)
                                    owner[i]=0;
                            }
                            removePlayer(player_chance);
                            exit=1;
                            break;
                        default:
                            System.out.println("Invalid selection Try again");
                    }
                }
                else
                {
                    System.out.println("MENU");
                    System.out.println("1: See Data");
                    System.out.println("2: Trade");
                    System.out.println("3: Build");
                    System.out.println("4: Mortgage");
                    System.out.println("5: Sell");
                    System.out.println("6: Unmortgage");
                    System.out.println("7: Auction");
                    System.out.println("8: Pass the chance to next player");
                    System.out.println("9: Declare Bankruptcy");
                    System.out.print("Enter Selection: ");
                    int selection=sc.nextInt();
                    int exit=0;
                    switch(selection)
                    {
                        case 1:
                            seeData(player_chance);
                            break;
                        case 2:
                            trade(player_chance);
                            break;
                        case 3:
                            build(player_chance);
                            break;
                        case 4:
                            mortgage(player_chance);
                            break;
                        case 5:
                            sell(player_chance);
                            break;
                        case 6:
                            unmortgage(player_chance);
                            break;
                        case 7:
                            auction(player_chance);
                            break;
                        case 8:
                            exit=1;
                            break;
                        case 9:
                            sellAllHouses(player_chance);
                            for(int i=0;i<28;i++)
                            {
                                if((owner[i]==player_chance+1)&&(mortgage_status[0][i]==1))
                                    mortgage_status[1][i]=0;
                            }
                            for(int i=0;i<28;i++)
                            {
                                if(owner[i]==player_chance+1)
                                    owner[i]=0;
                            }
                            removePlayer(player_chance);
                            exit=1;
                            break;
                        default:
                            System.out.println("Invalid selection, Try again");
                            break;
                }
                    if(exit==1)
                        break;
                }
            }
            player_chance=(player_chance+1)%number;
            System.out.println("----------------------------------------------------------------------------------------------");
            System.out.println("\n");
        }  
    } 
    
    public static void getOutOfJail(int i,int j){
        int bankrupt=0;
        if(jail_free[i]>0&&j==2)
        {
            if(chance_free==1)
            {
                chance_free=0;
                int free_index=0;
                for(int m=0;m<16;m++)
                {
                    if(chance_id[m]==16)
                        free_index=m;
                }
                for(int m=free_index;m<15;m++)
                {
                    chance_id[m]=chance_id[m+1];
                }
                chance_id[15]=15;
                jail_free[i]--;
            }
            else if(community_free==1)
            {
                community_free=0;
                int free_index=0;
                for(int m=0;m<16;m++)
                {
                    if(community_id[m]==16)
                        free_index=m;
                }
                for(int m=free_index;m<15;m++)
                {
                    community_id[m]=community_id[m+1];
                }
                community_id[15]=15;
                jail_free[i]--;
            }
        }
        else
        {
            int tmp_money=player_money[i]-50;
            if(tmp_money>=0)
            {
                player_money[i]-=50;
            }
            else
            {
                System.out.println("Pay 50 to bank for getting out of jail but you don't have enough cash");
                player_money[i]=0;
            }
            while(tmp_money<0)
            {
                System.out.println("You have to pay "+(-tmp_money)+" more");
                if(isBankrupt(i)||bankrupt==1)
                {
                    removePlayer(i);
                }
                else
                {
                    System.out.println("Select a way to arrange money for paying it to the bank: ");
                    System.out.println("1: Declare Bankruptcy");
                    System.out.println("2: Trade");
                    System.out.println("3: Sell");
                    System.out.println("4: Auction");
                    System.out.println("5: Mortgage");
                    System.out.print("Enter Selection: ");
                    int selection=sc.nextInt();
                    switch(selection)
                    {
                        case 1:
                            bankrupt=1;
                            break;
                        case 2:
                            trade(i);
                            System.out.println("Money arranged="+player_money[i]);
                            break;
                        case 3:
                            sell(i);
                            System.out.println("Money arranged="+player_money[i]);
                            break;
                        case 4:
                            auction(i);
                            System.out.println("Money arranged="+player_money[i]);
                            break;
                        case 5:
                            mortgage(i);
                            System.out.println("Money arranged="+player_money[i]); 
                            break;
                    }
                    if(player_money[i]>=(-tmp_money))
                    {
                        player_money[i]+=tmp_money;
                        break;
                    }
                }
            }
        }
        if(player_status[i]=='g')
                jail_chances[i]=0;
    }
    
    public static void removePlayer(int i){
        
    }
    
    public static boolean isBankrupt(int i){
        int property=0;
        for(int j=0;j<28;j++)
        {
            if(owner[j]==i+1)
                property=1;
        }
        return property==0;
    }
    
    public static void trade(int i){
        System.out.println("------------------------------------TRADE--------------------------------------------------");
        System.out.println("Select player to trade with: ");
        int k=1;
        for(int j=0;j<number;j++)
        {
            if(j!=i)
                System.out.println((k++)+" : "+player_names[j]);
        }
        System.out.print("Enter selection: ");
        int player=sc.nextInt()-1;
        if(player>=i)
            player=player+1;
        System.out.println("-----------------------------------------------------------------------------------------------------");
        data(i);
        System.out.println("-----------------------------------------------------------------------------------------------------");
        data(player);
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("1: Take money from "+player_names[player]);
        System.out.println("2: Give money to "+player_names[player]);
        int gt=sc.nextInt();
        int tMoney=0,gMoney=0;
        if(gt==1)
        {
            while(true)
            {
                System.out.print("Enter amount of money you want to take: ");
                tMoney=sc.nextInt();
                if(player_money[player]>=tMoney)
                    break;
                else
                    System.out.println("Money entered is greater than total money of "+player_names[player]);
            }
        }
        else
        {
            while(true)
            {
                System.out.print("Enter amount of money you want to give: ");
                gMoney=sc.nextInt();
                if(player_money[i]>=gMoney)
                    break;
                else
                    System.out.println("Money entered is greater than total money of "+player_names[i]);
            }
        }
        int giveproperty[]=new int[28];
        int takeproperty[]=new int[28];
        System.out.println("Giving properties: ");
        for(int j=0;j<28;j++)
        {
            if(owner[j]==i+1&&noHouseOn(j))
            {
                System.out.println("1: Add "+property_names[j].name+" to trade");
                System.out.println("0: Don't add "+property_names[j].name+" to trade");
                System.out.print("Enter selection: ");
                int g=sc.nextInt();
                if(g==1)
                giveproperty[j]=1;
            }
        }
        System.out.println("Taking properties: ");
        for(int j=0;j<28;j++)
        {
            if(owner[j]==player+1&&noHouseOn(j))
            {
                System.out.println("1: Add "+property_names[j].name+" to trade");
                System.out.println("0: Don't add "+property_names[j].name+" to trade");
                System.out.print("Enter selection: ");
                int t=sc.nextInt();
                if(t==1)
                takeproperty[j]=1;
            }
        }
        System.out.println("Trade details for "+player_names[player]);
        if(gt==1)
            System.out.println(player_names[i]+" is asking "+tMoney+" from you");
        else
            System.out.println(player_names[i]+" is giving "+gMoney+" to you");
        System.out.println("Properties asked in trade by "+player_names[i]);
        k=1;
        for(int j=0;j<28;j++)
        {
            if(takeproperty[j]==1)
            {
                System.out.println(k+". "+property_names[j].name);
                k++;
            }
        }
        if(k==1)
            System.out.println("No properties asked");
        k=1;
        System.out.println("Properties offered in trade by "+player_names[i]);
        for(int j=0;j<28;j++)
        {
            if(giveproperty[j]==1)
            {
                System.out.println(k+". "+property_names[j].name);
                k++;
            }
        }
        if(k==1)
            System.out.println("No properties offered");
        System.out.println("");
        System.out.println("1: Accpet the trade");
        System.out.println("2: Reject the trade");
        int trade=sc.nextInt()-1;
        if(trade==0)
        {
            if(gt==1)
            {
                player_money[player]-=tMoney;
                player_money[i]+=tMoney;
            }
            else
            {
                player_money[player]+=gMoney;
                player_money[i]-=gMoney;
            }
            for(int j=0;j<28;j++)
            {
                if(giveproperty[j]==1)
                    owner[j]=player+1;
                else if(takeproperty[j]==1)
                    owner[j]=i+1;
            }
            System.out.println("Trade Successful");
        }
        else
            System.out.println("Trade Rejected by "+player_names[player]);
    }
    
    public static boolean noHouseOn(int j){
        int pos=property_names[j].position;
        String color=board[pos];
        int isColor=0;
        for(int i=0;i<8;i++)
        {
            if(color.equals(colors[i]))
            {
                isColor=1;
                break;
            }
        }    
        if(isColor==0)
            return true;
        else
        {
            int t_house=0;
            for(int i=0;i<40;i++)
            {
                if(board[i].equals(color))
                {
                    for(int k=0;k<22;k++)
                    {
                        if(houses[0][k]==i)
                            t_house+=houses[1][k];
                    }
                }
            }
            if(t_house==0)
                return true;
            else
                return false;
        }
    }
            
    public static void mortgage(int i){
        System.out.println("Select one of the properties to mortgage");
        int prop=0;
        for(int j=0;j<28;j++)
        {
            if(owner[j]==i+1&&mortgage_status[1][j]==0&&noHouseOnSet(j))
            {
                System.out.println((++prop)+": "+property_names[j].name);
            }
        }
        if(prop==0)
            System.out.println("No properties to mortgage");
        else
        {
            System.out.print("Enter Selection: ");
            int sel=sc.nextInt();
            int k=0;
            for(int j=0;j<28;j++)
            {
                if(owner[j]==i+1&&mortgage_status[1][j]==0&&noHouseOnSet(j))
                    k++;
                if(k==sel)
                {
                    System.out.println(property_names[j].name+" mortgaged");
                    int amount=property_names[j].cost/2;
                    System.out.println(amount+" received from bank");
                    player_money[i]+=amount;
                    mortgage_status[1][j]=1;
                    break;
                }
            }
        }
    }
    
    public static boolean noHouseOnSet(int j) {
        int ind=property_names[j].position;
        String color;
        color=board[ind];
        int total_house=0;
        for(int i=0;i<40;i++)
        {
            if(board[i].equals(color))
            {
                for(int k=0;k<22;k++)
                {
                    if(houses[0][k]==i)
                        total_house+=houses[1][k];
                }
            }
        }
        if(total_house==0)
            return true;
        else
            return false;
    }
    
    public static void unmortgage(int i){
        int prop=0;
        System.out.println("Select properties to unmortgage");
        for(int j=0;j<28;j++)
        {
            if((owner[j]==i+1)&&mortgage_status[1][j]==1)
                System.out.println(++prop+": "+property_names[j].name);
        }
        if(prop==0)
            System.out.println("No Properties to unmortgage");
        else
        {
            System.out.print("Enter selection: ");
            int sel=sc.nextInt();
            int k=0;
            for(int j=0;j<28;j++)
            {
                if((owner[j]==i+1)&&mortgage_status[1][j]==1)
                    k++;
                if(k==sel)
                {
                    int amount=property_names[j].cost/2;
                    amount=(int)((double)amount*1.1);
                    if(player_money[i]<amount)
                        System.out.println("Not enough money to mortgage");
                    else
                    {
                        player_money[i]-=amount;
                        System.out.println(amount+" paid to bank to unmortgage "+property_names[j].name);
                        mortgage_status[1][j]=0;
                        break;
                    }
                }
            }
        }
    }
    
    public static void sell(int i){
        System.out.println("1: Sell house");
        System.out.println("2: Sell hotel");
        System.out.println("3: Multiple Sell");
        System.out.print("Enter Selection: ");
        int sel=sc.nextInt();
        if(sel==1)
        {
            int Color=0;
            int l=0;
            String color[]=new String [8];
            for(int j=0;j<8;j++)
            {
                if(canSellHouse(colors[j],i))
                {
                    System.out.println((++Color)+": Sell house of "+colors[j]+" color");
                    color[l++]=colors[j];
                }
            }
            if(Color==0)
            {
                System.out.println("No houses to sell");
            }
            else
            {
                System.out.print("Enter selection: ");
                int choice=sc.nextInt();
                sellHouse(color[choice-1],i);
            }
        }
        else if(sel==2)
        {
            int Color=0;
            int l=0;
            String color[]=new String [8];
            for(int j=0;j<8;j++)
            {
                if(canSellHotel(colors[j],i))
                {
                    System.out.println((++Color)+": Sell hotel of "+colors[j]+" color");
                    color[l++]=colors[j];
                }
            }
            if(Color==0)
            {
                System.out.println("No hotels to sell");
            }
            else
            {
                System.out.print("Enter selection: ");
                int choice=sc.nextInt();
                sellHotel(color[choice-1],i);
            }
        }
        else if(sel==3)
        {
            System.out.println("Assuming hotels as 5 houses");
            int color=0;
            String Color[]=new String[8];
            int k=0;
            for(int j=0;j<8;j++)
            {
                if(canSell(colors[j],i))
                {
                    System.out.println((++color)+" :Multiple sell houses of "+colors[j]+" color");
                    Color[k++]=colors[j];
                }
            }
            System.out.print("Enter Selection: ");
            int choice=sc.nextInt();
            multipleSell(Color[choice-1],i);
        }
        else
        {
            System.out.println("Invalid Selection");
        }
    }
    
    public static void multipleSell(String color,int player){
        
        int curr[]=new int[3];
        int sell[]=new int[3];
        int k=0,price=0;
        for(int i=0;i<40;i++)
        {
            if(board[i].equals(color))
            {
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==i)
                    {
                        curr[k]=houses[1][j];
                        price=price_house[1][j]/2;
                        if(houses[1][j]!=0)
                        {
                            System.out.println("Current houses on "+property_names[getOwnerIndex(i)].name+" are "+houses[1][j]);
                            System.out.print("Enter no. of houses you want to sell of "+property_names[getOwnerIndex(i)].name+": ");
                            sell[k]=sc.nextInt();
                        }
                        k++;
                    }
                }
            }
        }
        if(isValidSell(sell,curr,k))
        {
            int total=0;
            for(int j=0;j<k;j++)
                total+=sell[j];
            System.out.println("Sell successful");
            int money=total*price;
            player_money[player]+=(money);
            System.out.println(money+" received from bank");
            int l=0;
            for(int i=0;i<40;i++)
            {
                if(board[i].equals(color))
                {
                    for(int j=0;j<22;j++)
                    {
                        if(houses[0][j]==i)
                        {
                            houses[1][j]=curr[l]-sell[l];
                            l++;
                        }
                    }
                }
            }
            for(int i=0;i<k;i++)
            {
                if(curr[i]==5&&(curr[i]-sell[i])<5)
                {
                    bank_hotels++;
                    bank_houses-=(curr[i]-sell[i]);
                }
                else
                    bank_houses+=(curr[i]-sell[i]);
            }
        }
        else
        {
            System.out.println("Not a valid sell");
        }
    }
    
    public static boolean isValidSell(int sell[],int curr[],int k){
        int rem[]=new int[k];
        for(int i=0;i<k;i++)
        {
            rem[i]=curr[i]-sell[i];
        }
        if(k==2)
        {
            int diff=maxDiff(rem[0],rem[1]);
            if(diff!=0&&diff!=1)
                return false;
            for(int i=0;i<k;i++)
            {
                if(rem[i]<0||rem[i]>5)
                    return false;
            }
        }
        else
        {
            int diff=maxDiff(rem[0],rem[1],rem[2]);
            if(diff!=0&&diff!=1)
                return false;
            for(int i=0;i<k;i++)
            {
                if(rem[i]<0||rem[i]>5)
                    return false;
            }
        }
        int house=0;
        for(int i=0;i<k;i++)
        {
            if(curr[i]==5&&rem[i]<5)
            {
                house+=4;
                house-=(4-rem[i]);
            }
            else
            {
                house-=sell[i];
            }
        }
        return bank_houses >= house;
    }
    
    public static void sellHouse(String color,int player){
        int house[]=new int[3];
        int ind=0;
        for(int i=0;i<40;i++)
        {
            if(board[i].equals(color)&&owner[getOwnerIndex(i)]==player+1)
            {
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==i)
                        house[ind++]=houses[1][j];
                }
            }
        }
        int max=0;
        for(int i=0;i<3;i++)
        {
            if(max<house[i])
                max=house[i];
        }
        int l=0;
        int pos[]=new int[3];
        for(int i=0;i<40;i++)
        {
            if(board[i].equals(color)&&owner[getOwnerIndex(i)]==player+1)
            {
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==i&&houses[1][j]==max)
                    {
                        System.out.println((++l)+": Sell house of "+property_names[getOwnerIndex(i)].name);
                        pos[l-1]=property_names[getOwnerIndex(i)].position;
                    }
                }
            }
        }
        System.out.print("Enter Selection: ");
        int sel=sc.nextInt();
        for(int i=0;i<22;i++)
        {
            if(houses[0][i]==pos[sel-1])
            {
                houses[1][i]--;
                player_money[player]+=(price_house[1][i]/2);
                int amount=price_house[1][i]/2;
                System.out.println("House sold on "+property_names[getOwnerIndex(pos[sel-1])].name);
                System.out.println(amount+" received from bank");
                bank_houses++;
                break;
            }
        }
    }
    
    public static boolean canSell(String color,int player) {
        for(int i=0;i<40;i++)
        {
            if(board[i].equals(color)&&owner[getOwnerIndex(i)]==player+1)
            {
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==i)
                    {
                        if(houses[1][j]>0&&houses[1][j]<=5)
                            return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean canSellHouse(String color,int player){
        for(int i=0;i<40;i++)
        {
            if(board[i].equals(color)&&owner[getOwnerIndex(i)]==player+1)
            {
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==i)
                    {
                        if(houses[1][j]>0&&houses[1][j]<5)
                            return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static void sellHotel(String color,int player){
        int price=0;
        int k=0;
        for(int i=0;i<40;i++)
        {
            if(board[i].equals(color)&&owner[getOwnerIndex(i)]==player+1)
            {
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==i&&houses[1][j]==5)
                    {
                        System.out.println((++k)+": Sell hotel of "+property_names[getOwnerIndex(i)].name);
                        price=price_house[1][j]/2;
                    }
                }
            }
        }
        System.out.print("Enter selection: ");
        int sel=sc.nextInt();
        k=0;
        for(int i=0;i<40;i++)
        {
            if(board[i].equals(color)&&owner[getOwnerIndex(i)]==player+1)
            {
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==i&&houses[1][j]==5)
                    {
                        k++;
                    }
                    if(k==sel)
                    {
                        houses[1][j]=4;
                        player_money[player]+=price;
                        System.out.println(price+" received from the bank");
                        k++;
                    }
                }
            }
        }
    }
    
    public static boolean canSellHotel(String color,int player){
        int hotels=0;
        for(int i=0;i<40;i++)
        {
            if(board[i].equals(color)&&owner[getOwnerIndex(i)]==player+1)
            {
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==i)
                    {
                        if(houses[1][j]==5)
                            hotels=1;
                    }
                }
            }
        }
        return hotels==1&&bank_houses>=4;
    }
    
    public static void build(int i){
        System.out.println("1: Build house");
        System.out.println("2: Build hotel");
        System.out.print("Enter selection: ");
        int hh=sc.nextInt();
        if(hh==1&&bank_houses==0)
        {
            int Color=0;
            for(int j=0;j<8;j++)
            {
                if(canBuildHouse(colors[j],i))
                {
                    ++Color;
                }
            }
            if(Color==0)
                System.out.println("No sets of colors owned to build houses or maximum houses on each property build");
            else
            {
                System.out.println("There are no houses in the bank");
                System.out.println("Build house by buying houses in auction when bank gets some houses");
                wantHouses[i]=1;   
            }
        }
        else if(hh==1)
        {
            String color[]=new String [8];
            int l=0;
            int Color=0;
            for(int j=0;j<8;j++)
            {
                if(canBuildHouse(colors[j],i))
                {
                    System.out.println((++Color)+": Build house on "+colors[j]+" color.");
                    color[l++]=colors[j];
                }
            }
            if(Color==0)
                System.out.println("No sets of colors owned to build houses or maximum houses on each property build");
            else
            {
                System.out.print("Enter selection: ");
                int sel=sc.nextInt();
                buildHouse(color[sel-1],i);
            }
        }
        else if(hh==2&&bank_hotels==0)
        {
            int Color=0;
            for(int j=0;j<8;j++)
            {
                if(canBuildHotel(colors[j],i))
                {
                    ++Color;
                }
            }
            if(Color==0)
                System.out.println("No sets of colors owned to build hotels or maximum hotels on each property build");
            else
            {
                System.out.println("There are no hotels in the bank");
                System.out.println("Build hotel by buying hotel in auction when bank gets some hotels");
                wantHotels[i]=1;   
            }
        }
        else if(hh==2)
        {
            String color[]=new String[8];
            int Color=0;
            int l=0;
            for(int j=0;j<8;j++)
            {
                if(canBuildHotel(colors[j],i))
                {
                    System.out.println((++Color)+": Build hotel on "+colors[j]+" color.");
                    color[l++]=colors[j];
                }
            }
            if(Color==0)
                System.out.println("No sets of colors owned to build hotels or maximum hotels on each property build");
            else
            {
                System.out.print("Enter Selection: ");
                int sel=sc.nextInt();
                buildHotel(color[sel-1],i);
            }
        }
    }
    
    public static void buildHouse(String color,int player){
        int house[]=new int[3];
        int pos[]=new int[3];
        int k=0;
        for(int i=0;i<40;i++)
        {
            if(board[i].equals(color))
            {
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==i)
                    {
                        house[k]=houses[1][j];
                        pos[k++]=i;
                    }
                }
            }
        }
        if(color.equals("mud")||color.equals("violet"))
        {
            if(house[0]==house[1])
            {
                for(int i=0;i<28;i++)
                {
                    if(property_names[i].position==pos[0])
                    {
                        System.out.println("1: Build house on "+property_names[i].name);
                    }
                    else if(property_names[i].position==pos[1])
                    {
                        System.out.println("2: Build house on "+property_names[i].name);
                    }
                }
                System.out.print("Enter selection: ");
                int choice=sc.nextInt();
                if(choice!=1&&choice!=2)
                {
                    System.out.println("Invalid selection.");
                    return;
                }
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==pos[choice-1])
                    {
                        if(player_money[player]<price_house[1][j])
                        {
                            System.out.println("You don't have enough money to build house on "+property_names[getOwnerIndex(houses[0][j])].name);
                            return;
                        }
                        else
                        {
                            player_money[player]-=price_house[1][j];
                        }
                        houses[1][j]++;
                        bank_houses--;
                        break;
                    }
                }
            }
            else if(house[0]>house[1])
            {
                for(int i=0;i<28;i++)
                {
                    if(property_names[i].position==pos[1])
                    {
                        System.out.println("1: Build house on "+property_names[i].name);
                    }
                }
                System.out.print("Enter selection: ");
                int choice=sc.nextInt();
                if(choice!=1)
                {
                    System.out.println("Invalid selection.");
                    return;
                }
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==pos[1])
                    {
                        if(player_money[player]<price_house[1][j])
                        {
                            System.out.println("You don't have enough money to build house on "+property_names[getOwnerIndex(houses[0][j])].name);
                            return;
                        }
                        else
                        {
                            player_money[player]-=price_house[1][j];
                        }
                        houses[1][j]++;
                        bank_houses--;
                        break;
                    }
                }
            }
            else
            {
                for(int i=0;i<28;i++)
                {
                    if(property_names[i].position==pos[0])
                    {
                        System.out.println("1: Build house on "+property_names[i].name);
                    }
                }
                System.out.print("Enter selection: ");
                int choice=sc.nextInt();
                if(choice!=1)
                {
                    System.out.println("Invalid selection.");
                    return;
                }
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==pos[0])
                    {
                        if(player_money[player]<price_house[1][j])
                        {
                            System.out.println("You don't have enough money to build house on "+property_names[getOwnerIndex(houses[0][j])].name);
                            return;
                        }
                        else
                        {
                            player_money[player]-=price_house[1][j];
                        }
                        houses[1][j]++;
                        bank_houses--;
                        break;
                    }
                }
            }
        }
        else
        {
            if(house[0]==house[1]&&house[1]==house[2])
            {
                for(int i=0;i<28;i++)
                {
                    if(property_names[i].position==pos[0])
                        System.out.println("1: Build house on "+property_names[i].name);
                    else if(property_names[i].position==pos[1])
                        System.out.println("2: Build house on "+property_names[i].name);
                    else if(property_names[i].position==pos[2])
                        System.out.println("3: Build house on "+property_names[i].name);
                }
                System.out.print("Enter selection: ");
                int choice=sc.nextInt();
                if(choice!=1&&choice!=2&&choice!=3)
                {
                    System.out.println("Invalid selection.");
                    return;
                }
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==pos[choice-1])
                    {
                        if(player_money[player]<price_house[1][j])
                        {
                            System.out.println("You don't have enough money to build house on "+property_names[getOwnerIndex(houses[0][j])].name);
                            return;
                        }
                        else
                        {
                            player_money[player]-=price_house[1][j];
                        }
                        houses[1][j]++;
                        bank_houses--;
                        break;
                    }
                }   
            }
            else if(house[0]==house[1]&&house[1]+1==house[2])
            {
                for(int i=0;i<28;i++)
                {
                    if(property_names[i].position==pos[0])
                        System.out.println("1: Build house on "+property_names[i].name);
                    else if(property_names[i].position==pos[1])
                        System.out.println("2: Build house on "+property_names[i].name);
                }
                System.out.print("Enter selection: ");
                int choice=sc.nextInt();
                if(choice!=1&&choice!=2)
                {
                    System.out.println("Invalid selection.");
                    return;
                }
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==pos[choice-1])
                    {
                        if(player_money[player]<price_house[1][j])
                        {
                            System.out.println("You don't have enough money to build house on "+property_names[getOwnerIndex(houses[0][j])].name);
                            return;
                        }
                        else
                        {
                            player_money[player]-=price_house[1][j];
                        }
                        houses[1][j]++;
                        bank_houses--;
                        break;
                    }
                }
            }
            else if(house[0]==house[1]+1&&house[1]==house[2])
            {
                for(int i=0;i<28;i++)
                {
                    if(property_names[i].position==pos[1])
                        System.out.println("1: Build house on "+property_names[i].name);
                    else if(property_names[i].position==pos[2])
                        System.out.println("2: Build house on "+property_names[i].name);
                }
                System.out.print("Enter selection: ");
                int choice=sc.nextInt();
                if(choice!=1&&choice!=2)
                {
                    System.out.println("Invalid selection.");
                    return;
                }
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==pos[choice])
                    {
                        if(player_money[player]<price_house[1][j])
                        {
                            System.out.println("You don't have enough money to build house on "+property_names[getOwnerIndex(houses[0][j])].name);
                            return;
                        }
                        else
                        {
                            player_money[player]-=price_house[1][j];
                        }
                        houses[1][j]++;
                        bank_houses--;
                        break;
                    }
                }
            }
            else if(house[0]+1==house[1]&&house[1]==house[2]+1)
            {
                for(int i=0;i<28;i++)
                {
                    if(property_names[i].position==pos[0])
                        System.out.println("1: Build house on "+property_names[i].name);
                    else if(property_names[i].position==pos[2])
                        System.out.println("2: Build house on "+property_names[i].name);
                }
                System.out.print("Enter selection: ");
                int choice=sc.nextInt();
                if(choice!=1&&choice!=2)
                {
                    System.out.println("Invalid selection.");
                    return;
                }
                if(choice==1)
                    choice=1;
                else 
                    choice=3;
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==pos[choice-1])
                    {
                        if(player_money[player]<price_house[1][j])
                        {
                            System.out.println("You don't have enough money to build house on "+property_names[getOwnerIndex(houses[0][j])].name);
                            return;
                        }
                        else
                        {
                            player_money[player]-=price_house[1][j];
                        }
                        houses[1][j]++;
                        bank_houses--;
                        break;
                    }
                }
            }
            else if(house[0]==house[1]+1&&house[1]+1==house[2])
            {
                for(int i=0;i<28;i++)
                {
                    if(property_names[i].position==pos[1])
                        System.out.println("1: Build house on "+property_names[i].name);
                }
                System.out.print("Enter selection: ");
                int choice=sc.nextInt();
                if(choice!=1)
                {
                    System.out.println("Invalid selection.");
                    return;
                }
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==pos[1])
                    {
                        if(player_money[player]<price_house[1][j])
                        {
                            System.out.println("You don't have enough money to build house on "+property_names[getOwnerIndex(houses[0][j])].name);
                            return;
                        }
                        else
                        {
                            player_money[player]-=price_house[1][j];
                        }
                        houses[1][j]++;
                        bank_houses--;
                        break;
                    }
                }
            }
            else if(house[0]+1==house[1]&&house[1]==house[2])
            {
                for(int i=0;i<28;i++)
                {
                    if(property_names[i].position==pos[0])
                        System.out.println("1: Build house on "+property_names[i].name);
                }
                System.out.print("Enter selection: ");
                int choice=sc.nextInt();
                if(choice!=1)
                {
                    System.out.println("Invalid selection.");
                    return;
                }
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==pos[0])
                    {
                        if(player_money[player]<price_house[1][j])
                        {
                            System.out.println("You don't have enough money to build house on "+property_names[getOwnerIndex(houses[0][j])].name);
                            return;
                        }
                        else
                        {
                            player_money[player]-=price_house[1][j];
                        }
                        houses[1][j]++;
                        bank_houses--;
                        break;
                    }
                }
            }
            else
            {
                for(int i=0;i<28;i++)
                {
                    if(property_names[i].position==pos[2])
                        System.out.println("1: Build house on "+property_names[i].name);
                }
                System.out.print("Enter selection: ");
                int choice=sc.nextInt();
                if(choice!=1)
                {
                    System.out.println("Invalid selection.");
                    return;
                }
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==pos[2])
                    {
                        if(player_money[player]<price_house[1][j])
                        {
                            System.out.println("You don't have enough money to build house on "+property_names[getOwnerIndex(houses[0][j])].name);
                            return;
                        }
                        else
                        {
                            player_money[player]-=price_house[1][j];
                        }
                        houses[1][j]++;
                        bank_houses--;
                        break;
                    }
                }
            }
        }
    }
    
    public static void buildHotel(String color,int player){
        int hotel[]=new int[3];
        int pos[]=new int[3];
        int k=0;
        for(int i=0;i<40;i++)
        {
            if(board[i].equals(color))
            {
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==i)
                    {
                        hotel[k]=houses[1][j];
                        pos[k++]=i;
                    }
                }
            }
        }
        if(color.equals("mud")||color.equals("violet"))
        {
            if(hotel[0]==4&&hotel[0]==4)
            {
                for(int i=0;i<28;i++)
                {
                    if(property_names[i].position==pos[0])
                    {
                        System.out.println("1: Build hotel on "+property_names[i].name);
                    }
                    else if(property_names[i].position==pos[1])
                    {
                        System.out.println("2: Build hotel on "+property_names[i].name);
                    }
                }
                System.out.print("Enter selection: ");
                int choice=sc.nextInt();
                if(choice!=1&&choice!=2)
                {
                    System.out.println("Invalid selection.");
                    return;
                }
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==pos[choice-1])
                    {
                        if(player_money[player]<price_house[1][j])
                        {
                            System.out.println("You don't have enough money to build hotel on "+property_names[getOwnerIndex(houses[0][j])].name);
                            return;
                        }
                        else
                        {
                            player_money[player]-=price_house[1][j];
                        }
                        houses[1][j]++;
                        bank_hotels--;
                        bank_houses+=4;
                        if(wantHouses())
                            houseAuction();
                        break;
                    }
                }
            }
            else if(hotel[0]==5&&hotel[1]==4)
            {
                for(int i=0;i<28;i++)
                {
                    if(property_names[i].position==pos[1])
                    {
                        System.out.println("1: Build hotel on "+property_names[i].name);
                    }
                }
                System.out.print("Enter selection: ");
                int choice=sc.nextInt();
                if(choice!=1)
                {
                    System.out.println("Invalid selection.");
                    return;
                }
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==pos[1])
                    {
                        if(player_money[player]<price_house[1][j])
                        {
                            System.out.println("You don't have enough money to build hotel on "+property_names[getOwnerIndex(houses[0][j])].name);
                            return;
                        }
                        else
                        {
                            player_money[player]-=price_house[1][j];
                        }
                        houses[1][j]++;
                        bank_hotels--;
                        bank_houses+=4;
                        if(wantHouses())
                            houseAuction();
                        break;
                    }
                }
            }
            else
            {
                for(int i=0;i<28;i++)
                {
                    if(property_names[i].position==pos[0])
                    {
                        System.out.println("1: Build hotel on "+property_names[i].name);
                    }
                }
                System.out.print("Enter selection: ");
                int choice=sc.nextInt();
                if(choice!=1)
                {
                    System.out.println("Invalid selection.");
                    return;
                }
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==pos[0])
                    {
                        if(player_money[player]<price_house[1][j])
                        {
                            System.out.println("You don't have enough money to build hotel on "+property_names[getOwnerIndex(houses[0][j])].name);
                            return;
                        }
                        else
                        {
                            player_money[player]-=price_house[1][j];
                        }
                        houses[1][j]++;
                        bank_hotels--;
                        bank_houses+=4;
                        if(wantHouses())
                            houseAuction();
                        break;
                    }
                }
            }
        }
        else
        {
            if(hotel[0]==4&&hotel[1]==4&&hotel[2]==4)
            {
                for(int i=0;i<28;i++)
                {
                    if(property_names[i].position==pos[0])
                        System.out.println("1: Build hotel on "+property_names[i].name);
                    else if(property_names[i].position==pos[1])
                        System.out.println("2: Build hotel on "+property_names[i].name);
                    else if(property_names[i].position==pos[2])
                        System.out.println("3: Build hotel on "+property_names[i].name);
                }
                System.out.print("Enter selection: ");
                int choice=sc.nextInt();
                if(choice!=1&&choice!=2&&choice!=3)
                {
                    System.out.println("Invalid selection.");
                    return;
                }
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==pos[choice-1])
                    {
                        if(player_money[player]<price_house[1][j])
                        {
                            System.out.println("You don't have enough money to build hotel on "+property_names[getOwnerIndex(houses[0][j])].name);
                            return;
                        }
                        else
                        {
                            player_money[player]-=price_house[1][j];
                        }
                        houses[1][j]++;
                        bank_hotels--;
                        bank_houses+=4;
                        if(wantHouses())
                            houseAuction();
                        break;
                    }
                }   
            }
            else if(hotel[0]==4&&hotel[1]==4&&hotel[2]==5)
            {
                for(int i=0;i<28;i++)
                {
                    if(property_names[i].position==pos[0])
                        System.out.println("1: Build hotel on "+property_names[i].name);
                    else if(property_names[i].position==pos[1])
                        System.out.println("2: Build hotel on "+property_names[i].name);
                }
                System.out.print("Enter selection: ");
                int choice=sc.nextInt();
                if(choice!=1&&choice!=2)
                {
                    System.out.println("Invalid selection.");
                    return;
                }
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==pos[choice-1])
                    {
                        if(player_money[player]<price_house[1][j])
                        {
                            System.out.println("You don't have enough money to build hotel on "+property_names[getOwnerIndex(houses[0][j])].name);
                            return;
                        }
                        else
                        {
                            player_money[player]-=price_house[1][j];
                        }
                        houses[1][j]++;
                        bank_hotels--;
                        bank_houses+=4;
                        if(wantHouses())
                            houseAuction();
                        break;
                    }
                }
            }
            else if(hotel[0]==5&&hotel[1]==4&&hotel[2]==4)
            {
                for(int i=0;i<28;i++)
                {
                    if(property_names[i].position==pos[1])
                        System.out.println("1: Build hotel on "+property_names[i].name);
                    else if(property_names[i].position==pos[2])
                        System.out.println("2: Build hotel on "+property_names[i].name);
                }
                System.out.print("Enter selection: ");
                int choice=sc.nextInt();
                if(choice!=1&&choice!=2)
                {
                    System.out.println("Invalid selection.");
                    return;
                }
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==pos[choice])
                    {
                        if(player_money[player]<price_house[1][j])
                        {
                            System.out.println("You don't have enough money to build hotel on "+property_names[getOwnerIndex(houses[0][j])].name);
                            return;
                        }
                        else
                        {
                            player_money[player]-=price_house[1][j];
                        }
                        houses[1][j]++;
                        bank_hotels--;
                        bank_houses+=4;
                        if(wantHouses())
                            houseAuction();
                        break;
                    }
                }
            }
            else if(hotel[0]==4&&hotel[1]==5&&hotel[2]==4)
            {
                for(int i=0;i<28;i++)
                {
                    if(property_names[i].position==pos[0])
                        System.out.println("1: Build hotel on "+property_names[i].name);
                    else if(property_names[i].position==pos[2])
                        System.out.println("2: Build hotel on "+property_names[i].name);
                }
                System.out.print("Enter selection: ");
                int choice=sc.nextInt();
                if(choice!=1&&choice!=2)
                {
                    System.out.println("Invalid selection.");
                    return;
                }
                if(choice==1)
                    choice=1;
                else 
                    choice=3;
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==pos[choice-1])
                    {
                        if(player_money[player]<price_house[1][j])
                        {
                            System.out.println("You don't have enough money to build hotel on "+property_names[getOwnerIndex(houses[0][j])].name);
                            return;
                        }
                        else
                        {
                            player_money[player]-=price_house[1][j];
                        }
                        houses[1][j]++;
                        bank_hotels--;
                        bank_houses+=4;
                        if(wantHouses())
                            houseAuction();
                        break;
                    }
                }
            }
            else if(hotel[0]==5&&hotel[1]==4&&hotel[2]==5)
            {
                for(int i=0;i<28;i++)
                {
                    if(property_names[i].position==pos[1])
                        System.out.println("1: Build hotel on "+property_names[i].name);
                }
                System.out.print("Enter selection: ");
                int choice=sc.nextInt();
                if(choice!=1)
                {
                    System.out.println("Invalid selection.");
                    return;
                }
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==pos[1])
                    {
                        if(player_money[player]<price_house[1][j])
                        {
                            System.out.println("You don't have enough money to build hotel on "+property_names[getOwnerIndex(houses[0][j])].name);
                            return;
                        }
                        else
                        {
                            player_money[player]-=price_house[1][j];
                        }
                        houses[1][j]++;
                        bank_hotels--;
                        bank_houses+=4;
                        if(wantHouses())
                            houseAuction();
                        break;
                    }
                }
            }
            else if(hotel[0]==4&&hotel[1]==5&&hotel[2]==5)
            {
                for(int i=0;i<28;i++)
                {
                    if(property_names[i].position==pos[0])
                        System.out.println("1: Build hotel on "+property_names[i].name);
                }
                System.out.print("Enter selection: ");
                int choice=sc.nextInt();
                if(choice!=1)
                {
                    System.out.println("Invalid selection.");
                    return;
                }
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==pos[0])
                    {
                        if(player_money[player]<price_house[1][j])
                        {
                            System.out.println("You don't have enough money to build hotel on "+property_names[getOwnerIndex(houses[0][j])].name);
                            return;
                        }
                        else
                        {
                            player_money[player]-=price_house[1][j];
                        }
                        houses[1][j]++;
                        bank_hotels--;
                        bank_houses+=4;
                        if(wantHouses())
                            houseAuction();
                        break;
                    }
                }
            }
            else
            {
                for(int i=0;i<28;i++)
                {
                    if(property_names[i].position==pos[2])
                        System.out.println("1: Build hotel on "+property_names[i].name);
                }
                System.out.print("Enter selection: ");
                int choice=sc.nextInt();
                if(choice!=1)
                {
                    System.out.println("Invalid selection.");
                    return;
                }
                for(int j=0;j<22;j++)
                {
                    if(houses[0][j]==pos[2])
                    {
                        if(player_money[player]<price_house[1][j])
                        {
                            System.out.println("You don't have enough money to build hotel on "+property_names[getOwnerIndex(houses[0][j])].name);
                            return;
                        }
                        else
                        {
                            player_money[player]-=price_house[1][j];
                        }
                        houses[1][j]++;
                        bank_hotels--;
                        bank_houses+=4;
                        if(wantHouses())
                            houseAuction();
                        break;
                    }
                }
            }
        }
    }
    
    public static boolean wantHouses(){
        return false;
    }
    
    public static void houseAuction(){
        
    }
    
    public static boolean canBuildHouse(String color,int player){
        if(!notMortgagedSet(color))
            return false;
        if(color.equals("mud")||color.equals("violet"))
        {
            int house[]=new int[2];
            house[0]=-1;
            house[1]=-1;
            int k=0;
            for(int i=0;i<40;i++)
            {
                if(board[i].equals(color)&&owner[getOwnerIndex(i)]==player+1)
                {
                    for(int j=0;j<22;j++)
                    {
                        if(houses[0][j]==i)
                        {
                            house[k++]=houses[1][j];
                            break;
                        }
                    }
                }
            }
            if(house[0]==house[1]&&house[0]<4&&house[1]<4&&house[0]>=0&&house[1]>=0)
                return true;
            else if(house[0]+1==house[1]&&house[0]<4&&house[1]<=4&&house[0]>=0&&house[1]>0)
                return true;
            else if(house[0]==house[1]+1&&house[0]<=4&&house[1]<4&&house[0]>0&&house[1]>=0)
                return true;
            else 
                return false;
        }
        else
        {
            int house[]=new int[3];
            house[0]=-1;
            house[1]=-1;
            house[2]=-1;
            int k=0;
            for(int i=0;i<40;i++)
            {
                if(board[i].equals(color)&&owner[getOwnerIndex(i)]==player+1)
                {
                    for(int j=0;j<22;j++)
                    {
                        if(houses[0][j]==i)
                        {
                            house[k++]=houses[1][j];
                            break;
                        }
                    }
                }
            }
            if(house[0]<=4&&house[1]<=4&&house[2]<=4&&house[0]>=0&&house[1]>=0&&house[2]>=0)
            {
                if(house[0]==4&&house[1]==4&&house[2]==4)
                    return false;
                int max=maxDiff(house[0],house[1],house[2]);
                if(max==0||max==1)
                    return true;
                else
                    return false;
            }
            else 
                return false;
        }
    }
    
    public static int maxDiff(int i,int j,int k) {
        if(i>=j&&i>=k)
        {
            if(j>=k)
                return i-k;
            else
                return i-j;
        }
        else if(j>=i&&j>=k)
        {
            if(i>=k)
                return j-k;
            else
                return j-i;
        }
        else
        {
            if(j>=i)
                return k-i;
            else
                return k-j;
        }
    }
    
    public static int maxDiff(int i,int j){
        if(i>=j)
            return i-j;
        else
            return j-i;
    }
    
    public static boolean canBuildHotel(String color,int player){
        int hotel[]=new int[3];
        int k=0;
        for(int i=0;i<40;i++)
        {
            if(board[i].equals(color)&&owner[getOwnerIndex(i)]==player+1)
            {
                for(int j=0;j<22;j++)
                    {
                        if(houses[0][j]==i)
                        {
                            hotel[k++]=houses[1][j];
                            break;
                        }
                    }
            }
        }
        if(hotel[0]==4&&hotel[1]==4&&hotel[2]==4)
            return true;
        else if(hotel[0]==4&&hotel[1]==4&&hotel[2]==0)
            return true;
        else if(hotel[0]==5&&hotel[1]==4&&hotel[2]==4)
            return true;
        else if(hotel[0]==4&&hotel[1]==5&&hotel[2]==4)
            return true;
        else if(hotel[0]==4&&hotel[1]==4&&hotel[2]==5)
            return true;
        else if(hotel[0]==5&&hotel[1]==5&&hotel[2]==4)
            return true;
        else if(hotel[0]==5&&hotel[1]==4&&hotel[2]==5)
            return true;
        else if(hotel[0]==4&&hotel[1]==5&&hotel[2]==5)
            return true;
        else if(hotel[0]==5&&hotel[1]==4&&hotel[2]==0)
            return true;
        else if(hotel[0]==4&&hotel[1]==5&&hotel[2]==0)
            return true;
        else 
            return false;
    }
    
    public static void seeData(int i){
        System.out.println("MENU FOR SEE DATA");
        for(int j=0;j<number;j++)
        {
            if(i==j)
                System.out.println((j+1)+" : See your own data");
            else
                System.out.println((j+1)+" : See "+player_names[j]+"'s data");
        }
        System.out.println((number+1)+" : See bank's data");
        System.out.print("Enter Selection: ");
        int sel=sc.nextInt();
        //for(int j=0;j<28;j++)
          //  owner[j]=i+1;
        if(sel<=number)
        {
            data(sel-1);
        }
        else if(sel==number+1)
            bankData();
    }
    
    public static void data(int i){
       System.out.println(player_names[i]+"'s data");
       System.out.println("Cash in hand: "+player_money[i]);
       System.out.println(player_names[i]+" is at "+position(player_position[i],i));
       System.out.println("Jail free cards: "+jail_free[i]);
       int n=0;
       for(int j=0;j<28;j++)
       {
           if(owner[j]==i+1)
           {
               n++;
           }
       }
       if(n==0)
           System.out.println("No properties owned");
       else
       {
          int position[]=new int[n];
          int k=0;
          for(int j=0;j<28;j++)
          {
              if(owner[j]==i+1)
              {
                  position[k++]=property_names[j].position;
              }
          }
          System.out.println("S.No    |Property Name          |Mortgaged Status    |Price    |MPrice    |             Rent            |Houses    |Price per house |Current Rent");
          System.out.println("        |                       |                    |         |          | 0  | 1  | 2  | 3  | 4  | 5  |          |                |            ");
          System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
          PlayerData data[]=new PlayerData[n];
          for(int j=0;j<n;j++)
              data[j]=new PlayerData();
          for(int j=0;j<n;j++)
          {
              data[j].index=Integer.toString(j+1)+addSpaces(8,Integer.toString(j+1).length());
              data[j].name=getName(position[j])+addSpaces(23,getName(position[j]).length());
              data[j].mortgage_status=getMortgagedStatus(position[j])+addSpaces(20,getMortgagedStatus(position[j]).length());
              data[j].price=getPrice(position[j])+addSpaces(9,getPrice(position[j]).length());
              data[j].mprice=getMPrice(position[j])+addSpaces(10,getMPrice(position[j]).length());
              data[j].rent0=getRent(0,position[j])+addSpaces(4,getRent(0,position[j]).length());
              data[j].rent1=getRent(1,position[j])+addSpaces(4,getRent(1,position[j]).length());
              data[j].rent2=getRent(2,position[j])+addSpaces(4,getRent(2,position[j]).length());
              data[j].rent3=getRent(3,position[j])+addSpaces(4,getRent(3,position[j]).length());
              data[j].rent4=getRent(4,position[j])+addSpaces(4,getRent(4,position[j]).length());
              data[j].rent5=getRent(5,position[j])+addSpaces(4,getRent(5,position[j]).length());
              data[j].houses=getHouses(position[j])+addSpaces(10,getHouses(position[j]).length());
              data[j].price_house=getPriceHouse(position[j])+addSpaces(16,getPriceHouse(position[j]).length());
              data[j].current_rent=getCurrentRent(position[j],i);
          }
          for(int j=0;j<n;j++)
              System.out.println(data[j].index+"|"+data[j].name+"|"+data[j].mortgage_status+"|"+data[j].price+"|"+data[j].mprice+"|"+data[j].rent0+"|"+data[j].rent1+"|"+data[j].rent2+"|"+data[j].rent3+"|"+data[j].rent4+"|"+data[j].rent5+"|"+data[j].houses+"|"+data[j].price_house+"|"+data[j].current_rent);
       }
    }
    
    public static void bankData(){
        System.out.println("No. of houses in bank: "+bank_houses);
        System.out.println("No. of hotels in bank: "+bank_hotels);
        int n=0;
        for(int i=0;i<28;i++)
        {
            if(owner[i]==0)
                n++;
        }
        if(n==0)
            System.out.println("No properties in bank");
        else
        {
            int position[]=new int[n];
            int k=0;
            for(int i=0;i<28;i++)
            {
                if(owner[i]==0)
                    position[k++]=property_names[i].position;
            }
            BankData data[]=new BankData[n];
            for(int i=0;i<n;i++)
                data[i]=new BankData();
            System.out.println("S.No    |Property Name          |Price    |MPrice    |             Rent            |Price per house ");
            System.out.println("        |                       |         |          | 0  | 1  | 2  | 3  | 4  | 5  |                ");
            System.out.println("----------------------------------------------------------------------------------------------------");
            for(int j=0;j<n;j++)
            {
                data[j].index=Integer.toString(j+1)+addSpaces(8,Integer.toString(j+1).length());
                data[j].name=getName(position[j])+addSpaces(23,getName(position[j]).length());
                //data[j].mortgage_status=getMortgagedStatus(position[j])+addSpaces(20,getMortgagedStatus(position[j]).length());
                data[j].price=getPrice(position[j])+addSpaces(9,getPrice(position[j]).length());
                data[j].mprice=getMPrice(position[j])+addSpaces(10,getMPrice(position[j]).length());
                data[j].rent0=getRent(0,position[j])+addSpaces(4,getRent(0,position[j]).length());
                data[j].rent1=getRent(1,position[j])+addSpaces(4,getRent(1,position[j]).length());
                data[j].rent2=getRent(2,position[j])+addSpaces(4,getRent(2,position[j]).length());
                data[j].rent3=getRent(3,position[j])+addSpaces(4,getRent(3,position[j]).length());
                data[j].rent4=getRent(4,position[j])+addSpaces(4,getRent(4,position[j]).length());
                data[j].rent5=getRent(5,position[j])+addSpaces(4,getRent(5,position[j]).length());
                //data[j].houses=getHouses(position[j])+addSpaces(10,getHouses(position[j]).length());
                data[j].price_house=getPriceHouse(position[j])+addSpaces(16,getPriceHouse(position[j]).length());
                //data[j].current_rent=getCurrentRent(position[j],i); 
            }
            for(int j=0;j<n;j++)
              System.out.println(data[j].index+"|"+data[j].name+"|"+data[j].price+"|"+data[j].mprice+"|"+data[j].rent0+"|"+data[j].rent1+"|"+data[j].rent2+"|"+data[j].rent3+"|"+data[j].rent4+"|"+data[j].rent5+"|"+data[j].price_house);    
        }
    }
    
    public static String getCurrentRent(int i,int player){
        for(int k=0;k<28;k++)
        {
            if(property_names[k].position==i)
            {
                if(mortgage_status[1][k]==1)
                    return "0";
            }
        }
        if(board[i].equals("station"))
        {
            int station=0;
            for(int j=0;j<40;j++)
            {
                if(board[j].equals("station")&&owner[getOwnerIndex(j)]==player+1&&mortgage_status[1][getOwnerIndex(j)]==0)
                    station++;
            }
            if(station==1)
                return Integer.toString(rent_station);
            else if(station==2)
                return Integer.toString(2*rent_station);
            else if(station==3)
                return Integer.toString(4*rent_station);
            else
                return Integer.toString(8*rent_station); 
        }
        else if(board[i].equals("utility"))
        {
            int utility=0;
            for(int j=0;j<40;j++)
            {
                if(board[j].equals("utility")&&owner[getOwnerIndex(j)]==player+1&&mortgage_status[1][getOwnerIndex(j)]==0)
                    utility++;
            }
            if(utility==1)
                return"x4";
            else
                return"x10";
        }
        else
        {
            int h=0;
            for(int j=0;j<22;j++)
            {
                if(houses[0][j]==i)
                    h=houses[1][j];
            }
            for(int j=0;j<22;j++)
            {
                if(colour_rents[0][j]==i)
                {
                    if(isPartOfSet(colour_rents[0][j],player)&&h==0&&notMortgagedSet(i))
                        return Integer.toString(2*colour_rents[h+1][j]);
                    else
                        return Integer.toString(colour_rents[h+1][j]);
                }
            }
        }
        return null;
    }
    
    public static boolean notMortgagedSet(int i){
        String color=board[i];
        int total_mortgage=0;
        for(int j=0;j<40;j++)
        {
            if(board[j].equals(color))
                total_mortgage+=mortgage_status[1][getOwnerIndex(j)];
        }
        if(total_mortgage==0)
            return true;
        else
            return false;
    }
    
    public static boolean notMortgagedSet(String color){
        int total_mortgage=0;
        for(int j=0;j<40;j++)
        {
            if(board[j].equals(color))
                total_mortgage+=mortgage_status[1][getOwnerIndex(j)];
        }
        if(total_mortgage==0)
            return true;
        else
            return false;
    }
    
    public static int getOwnerIndex(int j){
        for(int i=0;i<28;i++)
        {
            if(property_names[i].position==j)
                return i;
        }
        return 0;
    }
    
    public static boolean isPartOfSet(int j,int i){
        String color=board[j];
        int x=0;
        for(int k=0;k<40;k++)
        {
            if(board[k].equals(color)&&owner[getOwnerIndex(k)]!=(i+1))
                x=1;
        }
        if(x==1)
            return false;
        return true;
    }
    
    public static String getPriceHouse(int i){
        for(int j=0;j<22;j++)
        {
            if(price_house[0][j]==i)
                return Integer.toString(price_house[1][j]);
        }
        return"-";
    }
    
    public static String getHouses(int i){
        for(int j=0;j<22;j++)
        {
            if(houses[0][j]==i)
                return Integer.toString(houses[1][j]); 
        }
        return "-";
    }
    
    public static String getRent(int h,int i){
        if(isColor(i))
        {
            for(int k=0;k<22;k++)
            {
                if(colour_rents[0][k]==i)
                    return Integer.toString(colour_rents[h+1][k]);
            }
        }
        else
        {
            if(h==0)
            {
                if(board[i].equals("station"))
                    return Integer.toString(rent_station);
                else 
                    return "x4";
            }
            else
                return " -";
        }
        return null;
    }
    
    public static String getMPrice(int i){
        for(int j=0;j<28;j++)
        {
            if(property_names[j].position==i)
                return Integer.toString((property_names[j].cost)/2);
        }
        return null;
    }
    
    public static String getPrice(int i){
        for(int j=0;j<28;j++)
        {
            if(property_names[j].position==i)
                return Integer.toString(property_names[j].cost);
        }
        return null;
    }
    
    public static String getMortgagedStatus(int i){
        int m=0;
        for(int j=0;j<28;j++)
        {
            if(mortgage_status[0][j]==i)
            {
                m=mortgage_status[1][j];
                break;
            }
        }
        if(m==0)
            return "Unmortgaged";
        else
            return "Mortgaged";
    }
    
    public static String getName(int i){
        for(int j=0;j<28;j++)
        {
            if(property_names[j].position==i)
                return property_names[j].name;
        }
        return null;
    }
    
    public static String addSpaces(int i,int j){
        String space="";
        for(int k=0;k<(i-j);k++)
            space+=" ";
        return space;
    }
    
    public static boolean isColor(int i){
        for(int j=0;j<22;j++){
            if(colour_rents[0][j]==i)
                return true;
        }
        return false;
    }
    
    public static void auction(int i){
        int k=0;
        int property[]=new int[28];
        System.out.println("Auction for properties: ");
        for(int j=0;j<40;j++)
        {
            if(isProperty(j))
            {
                if(noHouseOn(getOwnerIndex(j))&&owner[getOwnerIndex(j)]==i+1)
                {
                    property[k]=j;
                    System.out.println((++k)+": "+property_names[getOwnerIndex(j)].name);
                }
            }
        }
        if(k==0)
        {
            System.out.println("No properties for auction");
        }
        else
        {
            System.out.print("Enter Selection: ");
            int sel=sc.nextInt();
            System.out.print("Enter base price for auction");
            int base=sc.nextInt();
            
        }
    }
    
    public static boolean isProperty(int i){
        for(int j=0;j<28;j++)
        {
            if(property_names[j].position==i)
                return true;
        }
        return false;
    }
    
    public static void buy(int index,int i){
        int cost=property_names[index].cost;
        if(player_money[i]>=cost)
        {
            player_money[i]-=cost;
            owner[index]=i+1;
        }
        else
        {
            int buy=0;
            System.out.println("You need "+(cost-player_money[i])+" more to buy");
            while(true)
            {
                if(player_money[i]>=cost)
                {
                    player_money[i]-=cost;
                    owner[index]=i+1;
                    break;
                    
                }
                System.out.println("Cash in hand: "+player_money[i]);
                System.out.println("Arrange money: ");
                System.out.println("1: Trade");
                System.out.println("2: Sell");
                System.out.println("3: Mortgage");
                System.out.println("4: Auction");
                System.out.println("5: Not buy property directly send in auction");
                System.out.print("Enter Selection: ");
                int sel=sc.nextInt();
                switch(sel)
                {
                    case 1:
                        trade(i);
                        break;
                    case 2:
                        sell(i);
                        break;
                    case 3:
                        mortgage(i);
                        break;
                    case 4:
                        auction(i);
                        break;
                    case 5:
                        unsold_auction(index);
                        buy=1;
                        break;
                }
                if(buy==1)
                    break;
            }
        }
    }
    
    public static void unsold_auction(int index){
        System.out.println("Auction for "+property_names[index].name);
        System.out.println("----------------------------------------");
        int bid=0;
        int fold[]=new int[number];
        int bidder=0;
        int sold=0;
        while(true)
        {
            for(int i=0;i<number;i++)
            {
                System.out.println(player_names[i]+"'s chance to bid or fold");
                System.out.println("Current bid is "+(bid+1));
                System.out.println("Cash in hand = "+player_money[i]);
                System.out.println("1: Bid");
                System.out.println("2: Fold");
                System.out.println("3: Increase Bid");
                System.out.print("Enter selection: ");
                int sel=sc.nextInt();
                switch(sel)
                {
                    case 1:
                        bid=bid+1;
                        if(bid>player_money[i])
                        {
                            System.out.println("Your bid value is greater than cash in hand");
                            while(true)
                            {
                                System.out.println("Bid = "+bid);
                                System.out.println("Cash in hand = "+player_money[i]);
                                if(noProperty(i))
                                {
                                    System.out.println("You don't have properties to arrange money");
                                    System.out.println("Folding your bid");
                                    fold[i]=1;
                                    bid=bid-1;
                                    break;
                                }
                                System.out.println("1: Trade to arrange money");
                                System.out.println("2: Sell to arrange money");
                                System.out.println("3: Mortgage to arrange money");
                                System.out.println("4: Fold from the auction");
                                System.out.print("Enter selection: ");
                                int s=sc.nextInt();
                                switch(s)
                                {
                                    case 1:
                                        trade(i);
                                        break;
                                    case 2:
                                        sell(i);
                                        break;
                                    case 3:
                                        mortgage(i);
                                        break;
                                    case 4:
                                        fold[i]=1;
                                        break;
                                }
                                if(player_money[i]>=bid||fold[i]==1)
                                    break;
                            }
                            if(player_money[i]>=bid)
                                bidder=i+1;
                            else if(fold[i]==1)
                                bid=bid-1;
                        }
                        else
                            bidder=i+1;
                    break;
                    case 2:
                        System.out.println(player_names[i]+" folded");
                        fold[i]=1;
                        break;
                    case 3:
                        System.out.print("Enter by how much you want to increase the current bid: ");
                        int inc=sc.nextInt();
                        bid=bid+1+inc;
                        if(bid>player_money[i])
                        {
                            System.out.println("Your bid value is greater than cash in hand");
                            while(true)
                            {
                                System.out.println("Bid = "+bid);
                                System.out.println("Cash in hand = "+player_money[i]);
                                if(noProperty(i))
                                {
                                    System.out.println("You don't have properties to arrange money");
                                    System.out.println("Folding your bid");
                                    fold[i]=1;
                                    bid-=(1+inc);
                                    break;
                                }
                                System.out.println("1: Trade to arrange money");
                                System.out.println("2: Sell to arrange money");
                                System.out.println("3: Mortgage to arrange money");
                                System.out.println("4: Fold from the auction");
                                System.out.print("Enter selection: ");
                                int s=sc.nextInt();
                                switch(s)
                                {
                                    case 1:
                                        trade(i);
                                        break;
                                    case 2:
                                        sell(i);
                                        break;
                                    case 3:
                                        mortgage(i);
                                        break;
                                    case 4:
                                        fold[i]=1;
                                        break;
                                }
                                if(player_money[i]>=bid||fold[i]==1)
                                    break;
                            }
                            if(player_money[i]>=bid)
                                bidder=i+1;
                            else if(fold[i]==1)
                                bid-=(1+inc);
                        }
                        else
                            bidder=i+1;
                    break;
                }
                int nfold=0;
                for(int k=0;k<number;k++)
                {
                    if(fold[k]==1)
                        nfold++;
                }
                if(nfold==number-1)
                {
                    if(bidder==0)
                    {
                        System.out.println(property_names[index].name+" goes to bank");
                    }
                    else
                    {
                        System.out.println(property_names[index].name+" goes to "+player_names[bidder-1]+" in "+bid);
                        player_money[bidder-1]-=bid;
                        owner[index]=bidder;
                    }
                    sold=1;
                    break;
                }
            }
            if(sold==1)
                break;
        }
    }
    
    public static boolean noProperty(int i){
        for(int j=0;j<28;j++)
        {
            if(owner[j]==i+1)
                return false;
        }
        return true;
    } 
    
    public static void sellAllHouses(int i){
        
    }
    
    public static void transferAllProperties(int i,int j){
        
    }
    
    public static void onProperty(int index,int player_chance){
        int cost=0;
        String name="";
        int ind=0;
        for(int i=0;i<28;i++)
        {
            if(property_names[i].position==index)
            {
                name=property_names[i].name;
                cost=property_names[i].cost;
                ind=i;
                break;
            }
        }
        System.out.println("You land on "+name);
        if(owner[ind]==0)
        {
            System.out.println("Do you want to buy "+name+" for "+cost);
            System.out.println("1:Yes");
            System.out.println("2:No");
            System.out.print("Enter selection: ");
            int select=sc.nextInt();
            if(select==1)
            {
                buy(ind,player_chance);
            }
            else
            {
                unsold_auction(ind);
            }
        }
        else if((owner[ind]!=player_chance+1)&&(mortgage_status[1][ind]==0))
        {
            System.out.println("This is "+player_names[owner[ind]-1]+"'s Property");
            String r=getCurrentRent(index,owner[ind]-1);
            int rent;
            if(r.equals("x4"))
            {
                rent=dice*4;
            }
            else if(r.equals("x10"))
            {
                rent=dice*10;
            }
            else
                rent=Integer.parseInt(r);
            System.out.println("You have to pay "+rent+" to "+player_names[owner[ind]-1]);
            if(rent<=player_money[player_chance])
            {
                player_money[owner[ind]-1]+=rent;
                player_money[player_chance]-=rent;
                System.out.println("Rent paid from cash in hand");
                System.out.println("Remaining cash: "+player_money[player_chance]);
            }
            else
            {
                System.out.println("You run short of money");
                int tmp_money=rent-player_money[player_chance];
                int bankrupt=0;
                System.out.println("Arrange money to pay remaining rent of "+tmp_money+" by some temporary operations");
                System.out.println("At the end if you are not able to the pay rent completely and you became bankrupt then all temporary operations will be rolled back");
                player_money[owner[ind]-1]+=player_money[player_chance];
                player_money[player_chance]=0;
                int current_money[]=new int[number];
                for(int i=0;i<number;i++)
                    current_money[i]=player_money[i];
                int current_owner[]=new int[28];
                for(int i=0;i<28;i++)
                    current_owner[i]=owner[i];
                int current_mortgage_status[]=new int[28];
                for(int i=0;i<28;i++)
                    current_mortgage_status[i]=mortgage_status[1][i];
                int current_houses[]=new int[22];
                for(int i=0;i<22;i++)
                    current_houses[i]=houses[1][i];
                int current_bank_houses=bank_houses;
                int current_bank_hotels=bank_hotels;
                while(true)
                {
                    if(isBankrupt(player_chance)||bankrupt==1)
                    {
                        System.out.println("You can not arrange enough money to pay for the rent");
                        System.out.println("All your previous trades,mortgages,sells,auctions are now rolled back");
                        System.out.println("Then all your houses are sold and money is given to"+player_names[owner[ind]-1]);
                        System.out.println("Then all your property is now given to "+player_names[owner[ind]-1]);
                        for(int i=0;i<number;i++)
                            player_money[i]=current_money[i];
                        for(int i=0;i<28;i++)
                            owner[i]=current_owner[i];
                        for(int i=0;i<28;i++)
                            mortgage_status[1][i]=current_mortgage_status[i];
                        for(int i=0;i<22;i++)
                            houses[1][i]=current_houses[i];
                        bank_houses=current_bank_houses;
                        bank_hotels=current_bank_hotels;
                        sellAllHouses(player_chance);
                        mortgageAllProperties(player_chance);
                        if(rent>player_money[player_chance])
                        {
                            player_money[owner[ind]-1]+=player_money[player_chance];
                            rent-=player_money[player_chance];
                            player_money[player_chance]=0;
                            int k;
                            for(k=0;k<28;k++)
                            {
                                if(owner[k]==player_chance+1)
                                    bankruptAuction(player_chance,k,owner[ind]-1);
                                if(rent<=player_money[player_chance])
                                {
                                    player_money[owner[ind]-1]+=rent;
                                    rent=0;
                                    break;
                                }
                            }
                            for(k=0;k<28;k++)
                            {
                                if(owner[k]==player_chance+1)
                                    owner[k]=0;
                            }
                            for(k=0;k<28;k++)
                            {
                                if(owner[k]==0)
                                    mortgage_status[owner[k]][k]=0;
                            }
                        }
                        else
                        {
                            player_money[owner[ind]-1]+=rent;
                            rent=0;
                            int k;
                            for(k=0;k<28;k++)
                            {
                                if(owner[k]==player_chance+1)
                                    owner[k]=0;
                            }
                            for(k=0;k<28;k++)
                            {
                                if(owner[k]==0)
                                    mortgage_status[owner[k]][k]=0;
                            }
                        }
                        removePlayer(player_chance);
                        break;
                    }
                    else
                    {
                        System.out.println("1: Temporary Trade");
                        System.out.println("2: Temporary Sell");
                        System.out.println("3: Temporary Mortgage");
                        System.out.println("4: Temporary Auction");
                        System.out.println("5: Declare Bankruptcy");
                        System.out.print("Enter Selection: ");
                        int select=sc.nextInt();
                        switch(select)
                        {
                            case 1:
                                trade(player_chance);
                                break;
                            case 2:
                                sell(player_chance);
                                break;
                            case 3:
                                mortgage(player_chance);
                                break;
                            case 4:
                                auction(player_chance);
                                break;
                            case 5:
                                bankrupt=1;
                                break;
                        }
                        if(player_money[player_chance]>=tmp_money)
                        {
                            player_money[player_chance]-=tmp_money;
                            player_money[owner[ind]-1]+=tmp_money;
                            break;
                        }
                    }
                }
            }
        }                      
    }  
    
    public static void bankruptAuction(int player1,int ind,int player2){
        
    }
    
    public static void mortgageAllProperties(int i){
        
    }
    
    public static void drawChance(int i){
        System.out.println("TASK: "+chances[chance_index].task);
        switch(chances[chance_index].id) {
            case 0:
                player_position[i]-=3;
                onBoard();
                break;
            case 1:
                if(player_position[i]>24)
                    player_money[i]+=200;
                player_position[i]=24;
                onBoard();
                break;
            case 2:
                payBank(150,i);
                break;
            case 3:
                int pay=0;
                for(int j=0;j<28;j++)
                {
                    if(owner[j]==i+1)
                    {
                        int pos=property_names[j].position;
                        for(int k=0;k<22;k++)
                        {
                            if(houses[0][k]==pos)
                            {
                                if(houses[1][k]==5)
                                    pay+=100;
                                else
                                    pay+=(25*houses[1][k]);
                            }
                        }
                    }
                }
                payBank(pay,i);
                break;
            case 4:
                player_position[i]=0;
                player_money[i]+=200;
                break;
            case 5:
                System.out.println("100 received from bank");
                player_money[i]+=100;
                break;
            case 6:
                payBank(20,i);
                break;
            case 7:
                player_position[i]=10;
                jail_chances[i]=1;
                break;
            case 8:
                pay=0;
                for(int j=0;j<28;j++)
                {
                    if(owner[j]==i+1)
                    {
                        int pos=property_names[j].position;
                        for(int k=0;k<22;k++)
                        {
                            if(houses[0][k]==pos)
                            {
                                if(houses[1][k]==5)
                                    pay+=115;
                                else
                                    pay+=(40*houses[1][k]);
                            }
                        }
                    }
                }
                payBank(pay,i);
                break;
            case 9:
                System.out.println("150 received from bank");
                player_money[i]+=150;
                break;
            case 10:
                System.out.println("50 received from bank");
                player_money[i]+=50;
                break;
            case 11:
                player_position[i]=39;
                onBoard();
                break;
            case 12:
                payBank(15,i);
                break;
            case 13:
                int pos=player_position[i];
                player_position[i]=15;
                if(pos>player_position[i])
                    player_money[i]+=200;
                onBoard();
                break;
            case 14:
                pos=player_position[i];
                player_position[i]=11;
                if(pos>player_position[i])
                    player_money[i]+=200;
                onBoard();
                break;
            case 15:
                chance_id[chance_index]=16;
                jail_free[i]++;
                break;
            case 16:
                chance_index=(chance_index+1)%16;
                drawChance(i);
                break;
            default:
                break;
        }
        chance_index=(chance_index+1)%16;
    }
    
    public static void drawCommunity(int i){
        System.out.println("TASK: "+community_chests[community_index].task);
        community_chests[community_index].id=13;
        switch(community_chests[community_index].id) {
            case 0:
                System.out.println("50 received from bank");
                player_money[i]+=50;
                break;
            case 1:
                System.out.println("200 received from bank");
                player_money[i]+=200;
                break;
            case 2:
                payBank(50,i);
                break;
            case 3:
                System.out.println("10 received from the bank");
                player_money[i]+=10;
                break;
            case 4:
                System.out.println("100 received from the bank");
                player_money[i]+=100;
                break;
            case 5:
                player_money[i]+=200;
                player_position[i]=0;
            case 6:
                System.out.println("20 received from the bank");
                player_money[i]+=20;
                break;
            case 7:
                player_position[i]=10;
                jail_chances[i]=1;
                break;
            case 8:
                payBank(50,i);
                break;
            case 9:
                System.out.println("1 : Pay a 10 fine");
                System.out.println("2: Take a chance");
                System.out.print("Enter selection: ");
                int x=sc.nextInt();
                if(x==1)
                {
                    payBank(10,i);
                }
                else
                {
                    System.out.println("Drawing a chance");
                    drawChance(i);
                }
                break;
            case 10:
                System.out.println("25 received from the bank");
                player_money[i]+=25;
                break;
            case 11:
                payBank(100,i);
                break;
            case 12:
                System.out.println("100 received from the bank");
                player_money[i]+=100;
                break;
            case 13:
                for(int j=0;j<number;j++)
                {
                    if(j!=i)
                    {
                        pay(10,j,i);
                    }
                }
                break;
            case 14:
                player_position[i]=1;
                onBoard();
                break;
            case 15:
                jail_free[i]++;
                community_id[community_index]=16;
                break;
            case 16:
                community_index=(community_index+1)%16;
                drawCommunity(i);
                break;
            default:
                break;
        }
        community_index=(community_index+1)%16;
    }
    
    public static String position(int i,int j){
        switch(i)
        {
            case 0:
                return "GO";
            case 1:
                return "OLD KENT ROAD";
            case 2:
                return "COMMUNITY CHEST 1";
            case 3:
                return "WHITECHAPEL ROAD";
            case 4:
                return "INCOME TAX";
            case 5:
                return "KINGCROSS STATION";
            case 6:
                return "THE ANGEL, ISLINGTON";
            case 7:
                return "CHANCE 1";
            case 8:
                return "EUSTON ROAD";
            case 9:
                return "PENTONVILLE ROAD";
            case 10:
                if(jail_chances[j]==0)
                    return "JUST VISITING THE JAIL";
                else
                    return "JAIL";
            case 11:
                return "PALL MALL";
            case 12:
                return "ELECTRIC COMPANY";
            case 13:
                return "WHITEHALL";
            case 14:
                return "NORTHUMBERL'D AVENUE";
            case 15:
                return "MARYLEBONE STATION";
            case 16:
                return "BOW STREET";
            case 17:
                return "COMMUNITY CHEST 2";
            case 18:
                return "MARLBOROUGH STREET";
            case 19:
                return "VINE STREET";
            case 20:
                return "FREE PARKING";
            case 21:
                return "STRAND";
            case 22:
                return "CHANCE 2";
            case 23:
                return "FLEET STREET";
            case 24:
                return "TRAFALGAR SQUARE";
            case 25:
                return "FENCHURCH ST. STATION";
            case 26:
                return "LEICESTER SQUARE";
            case 27:
                return "COVENTRY STREET";
            case 28:
                return "WATER WORKS";
            case 29:
                return "PICCADILLY";
            case 30:
                return "GO TO JAIL";
            case 31:
                return "REGENT STREET";
            case 32:
                return "OXFORD STREET";
            case 33:
                return "COMMUNITY CHEST 3";
            case 34:
                return "BOND STREET";
            case 35:
                return "LIVERPOOL ST. STATION";
            case 36:
                return "CHANCE 3";
            case 37:
                return "PARK LANE";
            case 38:
                return "SUPER TAX";
            case 39:
                return "MAYFAIR";
        }
        return null;   
    }
    
    public static void onBoard(){
        int flag=0;
        for(int i=0;i<28;i++)
        {
            if(player_position[player_chance]==property_names[i].position)
            {
              flag=1;
              break;
            }
        }
        if(flag==1)
            onProperty(player_position[player_chance],player_chance);
        else
        {
            if(board[player_position[player_chance]].equals("income"))
            {
                System.out.println("You land on INCOME TAX of 200");
                payBank(200,player_chance);
            }
            else if(board[player_position[player_chance]].equals("super"))
            {
                System.out.println("You land on SUPER TAX of 100");
                payBank(100,player_chance);
                parking_money+=100;
            }
            else if(board[player_position[player_chance]].equals("jail"))
            {
                System.out.println("You land on GO TO JAIL...moving you to jail");
                player_position[player_chance]=10;
                jail_chances[player_chance]=1;
            }
            else if(board[player_position[player_chance]].equals("parking"))
            {
                System.out.println("You land on free parking");
                if(parking_money>0)
                {
                    System.out.println("You got "+parking_money+" on free parking");
                    player_money[player_chance]+=parking_money;
                    parking_money=0;
                }
            }
            else if(board[player_position[player_chance]].equals("chance"))
            {
                System.out.println("You land on chance");
                drawChance(player_chance);
            }
            else if(board[player_position[player_chance]].equals("community"))
            {
                System.out.println("You land on Community Chest");
                drawCommunity(player_chance);
            }
            else if(board[player_position[player_chance]].equals("visit"))
            {
                System.out.println("You just visiting the jail");
            }
        }
    }
    
    public static void payBank(int money,int i){
        if(money<=player_money[i])
        {
            player_money[i]-=money;
            System.out.println(money+" paid to bank");
        }
        else
        {
            int bankrupt=0;
            System.out.println("Arrange money: ");
            while(true)
            {
                if(money<=player_money[i])
                {
                    player_money[i]-=money;
                    break;
                }
                if(isBankrupt(i)||bankrupt==1)
                {
                    player_money[i]=0;
                    for(int j=0;j<28;j++)
                    {
                        if(owner[j]==i+1)
                        {
                            int pos=property_names[j].position;
                            for(int k=0;k<22;k++)
                            {
                                if(houses[0][k]==pos)
                                    houses[1][k]=0;
                            }
                            if(mortgage_status[1][j]==1)
                                mortgage_status[1][j]=0;
                            owner[j]=0;
                        }
                    }
                    removePlayer(i);
                    break;
                }
                System.out.println("1: Trade");
                System.out.println("2: Sell");
                System.out.println("3: Mortgage");
                System.out.println("4: Auction");
                System.out.println("5: Declare bankruptcy");
                System.out.print("Enter Selection: ");
                int sel=sc.nextInt();
                switch(sel){
                    case 1:
                        trade(i);
                        break;
                    case 2:
                        sell(i);
                        break;
                    case 3:
                        mortgage(i);
                        break;
                    case 4:
                        auction(i);
                        break;
                    case 5:
                        bankrupt=1;
                        break;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
            }
        }
    }
   
    public static void pay(int money,int i,int j){
        System.out.println("Payment of "+money+" from "+player_names[i]+" to "+player_names[j]);
        System.out.println("Here you is referred to "+player_names[i]);
        if(money<=player_money[i])
            {
                player_money[j]+=money;
                player_money[i]-=money;
                System.out.println("Rent paid from cash in hand");
                System.out.println("Remaining cash: "+player_money[i]);
            }
            else
            {
                System.out.println("You run short of money");
                int tmp_money=money-player_money[i];
                int bankrupt=0;
                System.out.println("Arrange money to pay remaining rent of "+tmp_money+" by some temporary operations");
                System.out.println("At the end if you are not able to the pay rent completely and you became bankrupt then all temporary operations will be rolled back");
                player_money[j]+=player_money[i];
                player_money[i]=0;
                int current_money[]=new int[number];
                for(int l=0;l<number;l++)
                    current_money[l]=player_money[l];
                int current_owner[]=new int[28];
                for(int l=0;l<28;l++)
                    current_owner[l]=owner[l];
                int current_mortgage_status[]=new int[28];
                for(int l=0;l<28;l++)
                    current_mortgage_status[l]=mortgage_status[1][l];
                int current_houses[]=new int[22];
                for(int l=0;l<22;l++)
                    current_houses[l]=houses[1][l];
                int current_bank_houses=bank_houses;
                int current_bank_hotels=bank_hotels;
                while(true)
                {
                    if(isBankrupt(i)||bankrupt==1)
                    {
                        System.out.println("You can not arrange enough money to pay for the rent");
                        System.out.println("All your previous trades,mortgages,sells,auctions are now rolled back");
                        System.out.println("Then all your houses are sold and money is given to"+player_names[j]);
                        System.out.println("Then all your property is now given to "+player_names[j]);
                        for(int l=0;l<number;l++)
                            player_money[l]=current_money[l];
                        for(int l=0;l<28;l++)
                            owner[l]=current_owner[l];
                        for(int l=0;l<28;l++)
                            mortgage_status[1][l]=current_mortgage_status[l];
                        for(int l=0;l<22;l++)
                            houses[1][l]=current_houses[l];
                        bank_houses=current_bank_houses;
                        bank_hotels=current_bank_hotels;
                        sellAllHouses(i);
                        mortgageAllProperties(i);
                        if(money>player_money[i])
                        {
                            player_money[j]+=player_money[i];
                            money-=player_money[i];
                            player_money[i]=0;
                            int k;
                            for(k=0;k<28;k++)
                            {
                                if(owner[k]==i+1)
                                    bankruptAuction(i,k,j);
                                if(money<=player_money[i])
                                {
                                    player_money[j]+=money;
                                    money=0;
                                    break;
                                }
                            }
                            for(k=0;k<28;k++)
                            {
                                if(owner[k]==i+1)
                                    owner[k]=0;
                            }
                            for(k=0;k<28;k++)
                            {
                                if(owner[k]==0)
                                    mortgage_status[1][k]=0;
                            }
                        }
                        else
                        {
                            player_money[j]+=money;
                            money=0;
                            int k;
                            for(k=0;k<28;k++)
                            {
                                if(owner[k]==i+1)
                                    owner[k]=0;
                            }
                            for(k=0;k<28;k++)
                            {
                                if(owner[k]==0)
                                    mortgage_status[1][k]=0;
                            }
                        }
                        removePlayer(i);
                        break;
                    }
                    else
                    {
                        System.out.println("1: Temporary Trade");
                        System.out.println("2: Temporary Sell");
                        System.out.println("3: Temporary Mortgage");
                        System.out.println("4: Temporary Auction");
                        System.out.println("5: Declare Bankruptcy");
                        System.out.print("Enter Selection: ");
                        int select=sc.nextInt();
                        switch(select)
                        {
                            case 1:
                                trade(i);
                                break;
                            case 2:
                                sell(i);
                                break;
                            case 3:
                                mortgage(i);
                                break;
                            case 4:
                                auction(i);
                                break;
                            case 5:
                                bankrupt=1;
                                break;
                        }
                        if(player_money[i]>=tmp_money)
                        {
                            player_money[i]-=tmp_money;
                            player_money[j]+=tmp_money;
                            break;
                        }
                    }
                }
            }
    }
    
}




