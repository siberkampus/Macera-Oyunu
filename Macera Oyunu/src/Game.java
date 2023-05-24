import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner input = new Scanner(System.in);
    public void login(){
        System.out.println("Macera Oyununa Hoşgeldiniz!!!");
        System.out.print("Oyuna Başlamadan Önce İsminizi Giriniz :");
        //String playerName = input.nextLine();
        player = new Player("Muhammed");
        player.selectCha();
        start();
    }
    public void start(){
       while(true){
           System.out.println();
           System.out.println("===============");
           System.out.println();
           System.out.println("Eylem gerçekleştirmek için bir yer seçiniz");
           System.out.println("1. Güvenli Ev --> Size ait güvenli bir mekan,düşman yok");
           System.out.println("2. Mağara --> Karşınıza zombi çıkabilir!!");
           System.out.println("3. Orman  --> Karşınıza vampir çıkabilir!!");
           System.out.println("4. Nehir  --> Karşınıza ayı çıkabilir!!");
           System.out.println("5. Mağaza --> Silah ve Zırh alabilirsiniz" );
           System.out.print("Gitmek istediğiniz yeri giriniz :");
           int selectLoc = input.nextInt();
           while(selectLoc<1 || selectLoc>5){
               System.out.print("Lütfen geçerli bir yer giriniz:");
               selectLoc = input.nextInt();
           }
           switch (selectLoc){
               case 1:
                   location=new SafeHouse(player);
                   break;
               case 2:
                   location=new Cave(player);
                   break;
               case 3:
                   location=new Forest(player);
                   break;
               case 4:
                   location=new River(player);
                   break;
               case 5:
                   location=new ToolStore(player);
                   break;
           }
           if(location.getClass().getName().equals("SafeHouse")){
               if(player.getInv().isFirewood() && player.getInv().isWater() && player.getInv().isFood() ){
                   System.out.println("Tebrikler!! Oyunu Kazandınız");
                   break;
               }
           }
           if(!location.getLocation()){
               System.out.println("Oyun Bitti !!");
               break;
           }
       }
     }

}
