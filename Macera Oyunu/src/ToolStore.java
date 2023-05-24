public class ToolStore extends NormalLoc{
    ToolStore(Player player){
        super(player,"Mağaza");
    }
    @Override
    public boolean getLocation() {
        System.out.println("Para : "+player.getMoney());
        System.out.println("1-) Silahlar");
        System.out.println("2-) Zırhlar");
        System.out.println("3-)Çıkış");
        System.out.print("Seçiminiz :" );
        int selTool = input.nextByte();
        int selItemId;
        switch (selTool){
            case 1:
                selItemId = weaponMenu(); //Seçilen Silah
                buyWeapon(selItemId);
                break;
            case 2:
                selItemId=armourMenu();
                buyArmour(selItemId);
        }
        return true;
    }
    public int weaponMenu(){
        System.out.println("1-) Tabanca\t  <Hasar: 2 - Para:25> ");
        System.out.println("2-) Kılıç\t  <Hasar: 3 - Para:35> ");
        System.out.println("3-) Tüfek\t  <Hasar: 7 - Para:45> ");
        System.out.println("4-) Çıkış Yap");
        System.out.print("Bir silah seçiniz : ");
        int selectWeaponID = input.nextInt();
        return selectWeaponID;
    }

    public void buyWeapon ( int itemID){
        int damage = 0, price = 0;
        String wName = null;
        switch (itemID) {
            case 1:
                damage = 2;
                wName = "Tabanca";
                price = 25;
                break;
            case 2:
                damage = 3;
                wName = "Kılıç";
                price = 35;
                break;
            case 3:
                damage = 7;
                wName = "Tüfek";
                price = 45;
                break;
            case 4:
                System.out.println("Çıkış Yapılıyor");
                break;
            default:
                System.out.println("Geçersiz İşlem");
                break;
        }
        if (price > 0) {
            if (player.getMoney() >= price) {
                player.getInv().setDamage(damage);
                player.getInv().setwName(wName);
                player.setMoney(player.getMoney() - price);
                System.out.println(wName + " satın aldınız " + "Önceki hasar :" + player.getDamage() + " Yeni hasar : " + player.getTotalDamage());
                System.out.println("Kalan para: " + player.getMoney());
            } else {
                System.out.println("Yetersiz Bakiye");
            }
        }
    }

    public int armourMenu(){
        System.out.println("1-) Hafif\t < Para:15> ");
        System.out.println("2-) Orta\t  < Para:25> ");
        System.out.println("3-) Ağır\t  < Para:40> ");
        System .out.println("4-) Çıkış Yap");
        System.out.print("Bir Zırh seçiniz : ");
        int selArmourID = input.nextInt();
        return selArmourID;
    }
    public void buyArmour(int selItemId ) {
        int avoid = 0, price = 0;
        String aName = null;
        switch (selItemId) {
            case 1:
                avoid = 1;
                aName = "Hafif";
                price = 15;
                break;
            case 2:
                avoid = 3;
                aName = "Orta Zırh";
                price = 30;
                break;
            case 3:
                avoid = 5;
                aName = "Ağır Zırh";
                price = 40;
                break;
            case 4:
                System.out.println("Çıkış Yapılıyor");
                break;
            default:
                System.out.println("Geçersiz İşlem");
                break;
        }
        if (price > 0) {
            if (player.getMoney() >= price) {
                player.getInv().setArmour(avoid);
                player.getInv().setaName(aName);
                player.setMoney(player.getMoney() - price);
                System.out.println(aName + " satın aldınız " + "Engellene hasar :" + player.getInv().getArmour());
                System.out.println("Kalan para : " + player.getMoney());
            } else {
                System.out.println("Yetersiz Bakiye");
            }
        }


    }
}

