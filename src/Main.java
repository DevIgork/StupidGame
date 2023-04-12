import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        mainHero hero = new mainHero();
        Scanner sc = new Scanner(System.in);
        HumanEnemy enemy = new HumanEnemy("Джо");
        System.out.println();
        System.out.println("Ви ходите першим");
        System.out.println();
        while (true){
            hero.showInfo();
            enemy.showInfo();
            if(hero.getEnergy()>=15){
                while (true) {
                    System.out.println("Виберіть дію\n1.Аттакувати\n2.Захищатись");
                    int n = sc.nextInt();
                    if (n == 1) {
                        hero.attack(enemy);
                        if(enemy.getEnergy()>15){
                            enemy.attack(hero);
                        }
                        else {
                            BodyPart[] body = {BodyPart.HEAD,BodyPart.CHEST,BodyPart.LEFTARM,BodyPart.RIGHARM,BodyPart.LEFTLEG,BodyPart.RIGHTLEG};
                            int randomNum = ThreadLocalRandom.current().nextInt(0, 6 );
                            enemy.defend(String.valueOf(body[randomNum]));
                        }
                        break;
                    }
                    else if(n == 2){
                        if(enemy.getEnergy()>15){
                            String atack = enemy.attack(hero);
                            hero.defend(atack);
                        }
                        else {
                            BodyPart[] body = {BodyPart.HEAD,BodyPart.CHEST,BodyPart.LEFTARM,BodyPart.RIGHARM,BodyPart.LEFTLEG,BodyPart.RIGHTLEG};
                            int randomNum = ThreadLocalRandom.current().nextInt(0, 6 + 1);
                            enemy.defend(String.valueOf(body[randomNum]));
                        }
                        break;
                    }
                    else {
                        System.out.println("виберіть число з списку");
                    }
                }
            }
            else {
                System.out.println("Ви можете тільки захищатись");
                if(enemy.getEnergy()>0){
                    String atack = enemy.attack(hero);
                    hero.defend(atack);
                }
                else {
                    BodyPart[] body = {BodyPart.HEAD,BodyPart.CHEST,BodyPart.LEFTARM,BodyPart.RIGHARM,BodyPart.LEFTLEG,BodyPart.RIGHTLEG};
                    int randomNum = ThreadLocalRandom.current().nextInt(0, 6 );
                    enemy.defend(String.valueOf(body[randomNum]));
                }
            }
            if(hero.loose()|| enemy.loose()){
                break;
            }
        }
    }
}