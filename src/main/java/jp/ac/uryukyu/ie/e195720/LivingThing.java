package jp.ac.uryukyu.ie.e195720;

/**
 * 対象の基本ステータス
 * 名称、HP、攻撃力、被倒時の経験値
 */
public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private int experience;
    private boolean dead;

    LivingThing(String name, int maximumHP, int attack, int experience) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        this.experience = experience;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }
    boolean getDead() {
        return !dead;
    }

    void setDead(boolean dead){
        this.dead = dead;
    }
    String getName() {
        return name;
    }

    int getHitPoint() {
        return hitPoint;
    }
    void setHitPoint(int HP) {
        this.hitPoint = HP;
    }

    /**
     * 倒した敵から得られるご褒美。
     * @return
     * ステータス内に値が保管されている。
     */
    public int getExperience(){
        return experience;
    }

    /**
     * HPが0になるまで攻撃するよ
     * @param opponent
     * 攻撃の対象。
     */
    public void attack(LivingThing opponent) {
        int damage = (int) (Math.random() * attack);
        if (hitPoint > 0) {
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    /**
     * HPが0以下になると負け（死亡）する
     * @param damage
     * attackを実行した時に生成された相手にダメージを与える値
     */
    public void wounded(int damage) {
        String name = getName();
        int experience = getExperience();
        hitPoint -= damage;
        if (hitPoint <= 0) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
            System.out.printf("パーティーは%dの経験値を得た。", experience );
        }
    }
}