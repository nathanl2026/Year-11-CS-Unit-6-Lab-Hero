public class Hero {
    private String name;
    private int hitPoints;

    public Hero(String name) {
        this.name = name;
        hitPoints = 100;
    }

    public String getName(){
        return name;
    }

    public int getHitPoints(){
        return hitPoints;
    }

    @Override
    public String toString(){
        return "Hero{name='" + name + "', hitPoints=" + hitPoints + "}";
    }

    public void attack(Hero opponent) {
        double random = Math.random()*0.99; //double random = min + Math.random()*(max-min);

        if (random < 0.5) {
            opponent.hitPoints-=10;
        }
        else {
            hitPoints-=10;
        }
    }
    public void senzuBean() {
        hitPoints = 100;
    }
    private void fightUntilTheDeathHelper(Hero opponent) {
        while(hitPoints>0 && opponent.hitPoints>0) {
            attack(opponent);
        }
    }
    public String fightUntilTheDeath(Hero opponent) {
        senzuBean();
        fightUntilTheDeathHelper(opponent);
        return name + ": " + hitPoints + "\t" + opponent.name + ": " + opponent.hitPoints;
        // Andrew Tate: 0  Taylor Swift: 20
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n) {
        int heroWins = 0;
        int opponentWins = 0;
        for (int i = 0; i < n; i++) {
            fightUntilTheDeathHelper(opponent);
            if (hitPoints==0 && opponent.hitPoints>0) {
                opponentWins++;
            }
            else if (hitPoints>0 && opponent.hitPoints==0) {
                heroWins++;
            }
            senzuBean();
        }
        return new int[]{heroWins, opponentWins};
    }

    public String nFightsToTheDeath(Hero opponent, int n) {
        int[] winsLosses = nFightsToTheDeathHelper(opponent, n);
        if (winsLosses[0] == winsLosses[1]) {
            return name + ": " + winsLosses[0] + " wins\n" + opponent.name + ": " + winsLosses[1] + "wins\n" + "OMG! It was actually a draw!";
        }
        else if (winsLosses[0] > winsLosses[1]) {
            return name + ": " + winsLosses[0] + " wins\n" + opponent.name + ": " + winsLosses[1] + "wins\n" + name + "wins!";
        }
        return name + ": " + winsLosses[0] + " wins\n" + opponent.name + ": " + winsLosses[1] + "wins\n" + opponent.name + "wins!";
    }

    public void dramaticFightToTheDeath(Hero opponent) {
        senzuBean();
        while(hitPoints>0 && opponent.hitPoints>0) {
            attack(opponent);
            System.out.println(name + ": " + hitPoints + "\t" + opponent.name + ": " + opponent.hitPoints);
        }
        if (hitPoints > opponent.hitPoints) {
            System.out.println(name + "wins!");
        }
        System.out.println(opponent.name + "wins!");
    }
}
