import java.util.Scanner;

public class NormalLoc extends Location{
    Scanner input = new Scanner(System.in);
    NormalLoc(Player player, String name){
        super(player);
        this.name=name;
    }

    @Override
    public boolean getLocation() {
        return true;
    }
}
