import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class HumanEnemy extends  AbstractEnemy {

    private String name;
    private int leftArm;
    private int rightArm;
    private int leftLeg;
    private int rightLeg;
    private int head;
    final int energyStep=15;

    final  int hitDamage = 10;



    public HumanEnemy(String name) {
        super();
        this.name = name;
        rightArm = 100;
        leftArm = 100;
        leftLeg = 100;
        rightLeg = 100;
        head = 100;
    }



    @Override
    public void getHit(String part) {
        super.getHit(part);
        if (part.equals(String.valueOf(BodyPart.HEAD))) {
            head -= hitDamage;
        } else if (part.equals(String.valueOf(BodyPart.LEFTARM))) {
            leftArm -= hitDamage;
        } else if (part.equals(String.valueOf(BodyPart.RIGHARM))) {
            rightArm -= hitDamage;
        } else if (part.equals(String.valueOf(BodyPart.LEFTLEG))) {
            leftLeg -= hitDamage;
        } else if (part.equals(String.valueOf(BodyPart.RIGHTLEG))) {
            rightLeg -= hitDamage;
        }
    }

    public String  attack(mainHero hero){
        return  attackHeroMinVallue(hero);
    }

    private String attackHeroMinVallue(mainHero hero) {
        if(hero.minvaluepart().equals(String.valueOf(BodyPart.HEAD))){
            hero.getHit(String.valueOf(BodyPart.HEAD));
            super.setEnergy(super.getEnergy()-energyStep);
            return  String.valueOf(BodyPart.HEAD);
        }
        else if (hero.minvaluepart().equals(String.valueOf(BodyPart.CHEST))) {
            hero.getHit(String.valueOf(BodyPart.CHEST));
            super.setEnergy(super.getEnergy()-energyStep);
            return  String.valueOf(BodyPart.CHEST);
        }
        else if (hero.minvaluepart().equals(String.valueOf(BodyPart.LEFTARM))) {
            hero.getHit(String.valueOf(BodyPart.LEFTARM));
            super.setEnergy(super.getEnergy()-energyStep);
            return  String.valueOf(BodyPart.LEFTARM);
        }
        else if (hero.minvaluepart().equals(String.valueOf(BodyPart.RIGHARM))) {
            hero.getHit(String.valueOf(String.valueOf(BodyPart.RIGHARM)));
            super.setEnergy(super.getEnergy()-energyStep);
            return  String.valueOf(BodyPart.RIGHARM);
        }
        else if (hero.minvaluepart().equals(String.valueOf(BodyPart.LEFTLEG))) {
            hero.getHit(String.valueOf(BodyPart.LEFTLEG));
            super.setEnergy(super.getEnergy()-energyStep);
            return  String.valueOf(BodyPart.LEFTLEG);
        }
        else  {
            hero.getHit(String.valueOf(BodyPart.RIGHTLEG));
            super.setEnergy(super.getEnergy()-energyStep);
            return  String.valueOf(BodyPart.RIGHTLEG);
        }
    }

    public  void  defend(String attackedPart){
        int randomNum = ThreadLocalRandom.current().nextInt(0, 6 );
        BodyPart[] body = {BodyPart.HEAD,BodyPart.CHEST,BodyPart.LEFTARM,BodyPart.RIGHARM,BodyPart.LEFTLEG,BodyPart.RIGHTLEG};
        if(body[randomNum].equals(attackedPart)){
            if(body[randomNum].equals(String.valueOf(BodyPart.HEAD))){
                head+=15;
               super.setChest(super.getChest()+5);
               leftArm+=5;
               rightArm+=5;
               leftLeg+=5;
               rightLeg+=5;

            }
            else if(body[randomNum].equals(String.valueOf(BodyPart.CHEST))){
                head+=5;
                super.setChest(super.getChest()+15);
                leftArm+=5;
                rightArm+=5;
                leftLeg+=5;
                rightLeg+=5;

            }
            else if (body[randomNum].equals(String.valueOf(BodyPart.LEFTARM))) {
                head+=5;
                super.setChest(super.getChest()+5);
                leftArm+=15;
                rightArm+=5;
                leftLeg+=5;
                rightLeg+=5;
            }
            else if(body[randomNum].equals(String.valueOf(BodyPart.RIGHARM))){
                head+=5;
                super.setChest(super.getChest()+5);
                leftArm+=5;
                rightArm+=15;
                leftLeg+=5;
                rightLeg+=5;
            }
            else  if(body[randomNum].equals(String.valueOf(BodyPart.LEFTLEG))){
                head+=5;
                super.setChest(super.getChest()+5);
                leftArm+=5;
                rightArm+=5;
                leftLeg+=15;
                rightLeg+=5;
            }
            else  if(body[randomNum].equals(String.valueOf(BodyPart.RIGHTLEG))){
                head+=5;
                super.setChest(super.getChest()+5);
                leftArm+=15;
                rightArm+=5;
                leftLeg+=5;
                rightLeg+=15;
            }
        }
        else {
            head+=5;
            super.setChest(super.getChest()+5);
            leftArm+=5;
            rightArm+=5;
            leftLeg+=5;
            rightLeg+=5;
        }
        setEnergy(getEnergy()+20);
        if(getEnergy()>100){
            setEnergy(100);
        }
    }
    @Override
    public boolean loose() {
        if (rightArm <= 0 || super.getChest() <= 0 || leftArm <= 0 || leftLeg <= 0 || rightLeg <= 0 || head <= 0) {
            System.out.println("Ви виграли!");
            return true;
        }
        return false;
    }
    public  void  showInfo(){
        System.out.println(name);
        System.out.println("Голова: "+head);
        System.out.println("Тіло: "+ super.getChest());
        System.out.println("Ліва рука: " + leftArm);
        System.out.println("Права рука: "+rightArm);
        System.out.println("Ліва нога: "+ leftLeg);
        System.out.println("Права нога: " + rightLeg);
        System.out.println("енергія противника :" + super.getEnergy());
    }



}
