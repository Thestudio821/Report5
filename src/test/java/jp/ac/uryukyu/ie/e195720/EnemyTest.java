package jp.ac.uryukyu.ie.e195720;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest {
    /**
     * 「死んでる状態では攻撃できない」ことを確認!。
     */
    @Test
    public void attack() {
        int heroHP = 10;
        Hero hero = new Hero("テスト勇者", heroHP, 5, 0);
        Enemy enemy = new Enemy("テストスライム", 6, 3, 1);
        enemy.setDead(true);
        for (int i = 0; i < 10; i++) {
            if (enemy.getHitPoint() >= 0) {
                hero.attack(enemy); //乱数で0ダメージとなることもあるため、複数回実行してみる。
            }
            assertEquals(heroHP, hero.getHitPoint());
        }
    }
}