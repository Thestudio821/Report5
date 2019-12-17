package jp.ac.uryukyu.ie.e195720;
public class Enemy extends LivingThing{
    Enemy(String name, int maximumHP, int attack, int experience){
        super(name, maximumHP, attack, experience);
    }

    @Override
    public void wounded(int damage){
        String name = getName();
        int hitPoint = getHitPoint();
        int experience = getExperience();
        hitPoint -= damage;
        setHitPoint(hitPoint);
        if( hitPoint <= 0 ) {
            setDead(true);
            System.out.printf("%sは倒れた。\n", name);
            System.out.printf("パーティーは%dの経験値を得た。\n", experience);
        }
    }

}