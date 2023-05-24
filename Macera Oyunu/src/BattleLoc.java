import java.sql.SQLOutput;
import java.util.Scanner;

public class BattleLoc extends Location{
        protected Obstacle obs;
        protected String award ;
        BattleLoc(Player player,String name,Obstacle obs,String award){
            super(player);
            this.name=name;
            this.obs=obs;
            this.award = award;
        }
        Scanner input = new Scanner(System.in);
         public boolean getLocation(){
             int obsCount=obs.Count();
             System.out.println("Şu an buradasınız : "+this.getName());
             System.out.println("Dikkatli Ol!! Burada "+obsCount+" tane "+obs.getName()+" yaşıyor" );
             System.out.print("<S>avaş veya <K>aç: ");
             String selCase =input.nextLine();
             selCase=selCase.toUpperCase();
             if(selCase.equals("S")) {
                 if (Combat(obsCount)) {
                     System.out.println(this.getName() + " bölgesindeki tüm düşmanları temizlediniz ");
                     if(this.award.equals("Yemek") && player.getInv().isFood()==false){
                         System.out.println(this.award+" kazandınız!!");
                         player.getInv().setFood(true);
                     }else if(this.award.equals("Su") && player.getInv().isWater()==false){
                         System.out.println(this.award+" kazandınız!!");
                         player.getInv().setWater(true);
                     }else if(this.award.equals("Odun") && player.getInv().isFirewood()==false){
                         System.out.println(this.award+" kazandınız!!");
                         player.getInv().setFirewood(true);
                     }
                     return true;
                 }if(player.getHealthy()<=0) {
                     System.out.println("Öldünüz !!");
                     return false;
                 }

             }
             return true;
         }
         public  boolean Combat(int obsCount){
            for(int i=0;i<obsCount;i++){
                int obsDefHealth = obs.getHealth();
                playerStats();//Güç değerleri
                enemyStats();
                while (player.getHealthy() > 0 && obs.getHealth() > 0) {

                    System.out.print("<V>ur veya <K>aç:");
                    String selCase = input.nextLine();
                    selCase=selCase.toUpperCase();
                    if(selCase.equals("V")){
                        System.out.println("Siz Vurdunuz!!");
                        obs.setHealth(obs.getHealth()-player.getTotalDamage());
                        afterHit();
                        if(obs.getHealth()>0) {
                            System.out.println();
                            System.out.println(obs.getName()+" Size Vurdu!!");
                            player.setHealthy(player.getHealthy() - obs.getDamage() + player.getInv().getArmour());
                            afterHit();
                            System.out.println();
                        }
                    }
                    else {
                        return false;
                    }
                }
                if(obs.getHealth()<= 0  && player.getHealthy()>0){
                    System.out.println("Düşmanı Yendiniz!!");
                    player.setMoney(player.getMoney()+obs.getAward());
                    System.out.println("Güncel Paranız : "+player.getMoney());
                    obs.setHealth(obsDefHealth);
                }
                else {
                    return  false;
                }
            }
             return true;
         }
         public void afterHit(){
             System.out.println("Oyuncunun canı : "+player.getHealthy());
             System.out.println(obs.getName()+" canı: "+obs.getHealth());
         }
         public void playerStats(){
             System.out.println("---------------\nOyuncu Degerleri\n----------------");
             System.out.println("Hasar: "+ player.getTotalDamage()+"\nCan: "+player.getHealthy());
             System.out.println("Para :"+player.getMoney());
             if(player.getInv().getDamage()>0){
                 System.out.println("Silah: "+player.getInv().getwName());
             }
             if(player.getInv().getArmour()>0){
                 System.out.println("Zırh: "+player.getInv().getaName());
             }

         }
         public void enemyStats(){
             System.out.println("---------------\n"+obs.getName()+" Degerleri\n---------------");
             System.out.println("Hasar: "+obs.getDamage()+"\nCan: "+obs.getHealth());
             System.out.println("Ödül: "+obs.getAward());
         }
}
