import java.util.Scanner;

public class Player {
    private int damage,healthy,money,rHealthy;
    private String name,cName;
    private Inventory inv;
    Scanner input = new Scanner(System.in);

    public void selectCha(){
        switch (chaMenu()){
            case 1://Samuray secildi
                initPlayer("Samuray",5,21,15);
                break;
            case 2://Okcu Secildi
                initPlayer("Okcu",7,18,20);
                break;
            case 3://Sovalye secildi
                initPlayer("Sovalye",8,24,5);
                break;
            default:
                System.out.println("Hata");
        }
        System.out.println("Karakter:" + getcName()+ "   Hasar:"+getDamage()+"   Sağlık:"+getHealthy()+"   Para:"+getMoney());

    }
    public void initPlayer(String cName,int dmg, int hlt,int mny){
        setcName(cName);
        setDamage(dmg);
        setHealthy(hlt);
        setMoney(mny);
        setrHealthy(healthy);
    }
    public int chaMenu(){
        System.out.println("Lütfen Karakter Seçiniz");
        System.out.println("1-)Samurai\t Hasar :5\t Sağlık :21\t Para :15");
        System.out.println("2-)Okçu\t     Hasar :7\t Sağlık :18\t Para :20");
        System.out.println("3-)Şovalye\t Hasar :8\t Sağlık :24\t Para :5");
        System.out.print("Karakter Seçiminiz : ");
        int chaID = input.nextInt();
        while (chaID>3 || chaID<1){
            System.out.print("Lütfen geçerli bir karakter giriniz :");
            chaID = input.nextInt();
        }
        return  chaID;
    }
     public Player(String name) {
        this.name = name;
        this.inv=new Inventory();
    }

    public int getTotalDamage(){
        return this.getDamage()+this.getInv().getDamage();
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }

    public int getrHealthy() {
        return rHealthy;
    }

    public void setrHealthy(int rHealthy) {
        this.rHealthy = rHealthy;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }
}
