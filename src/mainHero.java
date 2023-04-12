import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;

public class mainHero  {
    private  String name;
    private  int chest;
    private  int leftArm;
    private  int rightArm;
    private int leftLeg;
    private int rightLeg;
    private int head;
    private  int energy;

    private  final  int energyStep=15;
    public mainHero(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть своє імя");
        String Hname=sc.nextLine();
        name = Hname;
        chest = 100;
        leftArm = 100;
        rightArm = 100;
        leftLeg = 100;
        rightLeg = 100;
        head = 100;
        energy = 100;
    }


    public  String getName(){
        return name;
    }

    public int getChest() {
        return chest;
    }

    public int getLeftArm() {
        return leftArm;
    }

    public int getRightArm() {
        return rightArm;
    }

    public int getLeftLeg() {
        return leftLeg;
    }

    public int getRightLeg() {
        return rightLeg;
    }

    public int getHead() {
        return head;
    }

    public  int getEnergy(){
        return energy;
    }


    public void setChest(int chest) {
        this.chest = chest;
    }

    public void setLeftArm(int leftArm) {
        this.leftArm = leftArm;
    }

    public void setRightArm(int rightArm) {
        this.rightArm = rightArm;
    }

    public void setLeftLeg(int leftLeg) {
        this.leftLeg = leftLeg;
    }

    public void setRightLeg(int rightLeg) {
        this.rightLeg = rightLeg;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public void getHit(String part){
        if(part.equals(String.valueOf(BodyPart.CHEST))) {
            chest-=10;
        }
        else if(part.equals(String.valueOf(BodyPart.HEAD))){
            head-=10;
        }
        else if(part.equals(String.valueOf(BodyPart.LEFTARM))){
            leftArm-=10;
        }
        else if(part.equals(String.valueOf(BodyPart.RIGHARM))){
            rightArm-=10;

        }
        else if(part.equals(String.valueOf(BodyPart.LEFTLEG))){
            leftLeg-=10;
        }
        else if(part.equals(String.valueOf(BodyPart.RIGHTLEG))){
            rightLeg-=10;
        }
    }

    public  boolean  loose(){
        if(chest<=0||head<=0||leftArm<=0||rightArm<=0||leftLeg<=0||rightLeg<=0){
            System.out.println("Ви програли!");
            return  true;
        }
        return  false;
    }

    public  void attack(AbstractEnemy enemy){
        Scanner sc = new Scanner(System.in);
        int n=7;

        if(enemy instanceof  HumanEnemy){
            BodyPart[] body = {BodyPart.HEAD,BodyPart.CHEST,BodyPart.LEFTARM,BodyPart.RIGHARM,BodyPart.LEFTLEG,BodyPart.RIGHTLEG};
            while (true) {
                System.out.println("Виберіть місце атаки \n1.голова\n2.тіло\n3.ліва рука\n4.права рука\n5.ліва нога\n6.права нога \n");
                n = sc.nextInt();
                if(n>6||n<1){
                    System.out.println("виберіть число з списку");
                }
                else {
                    HumanEnemy enemy1 = (HumanEnemy) enemy;
                    enemy1.getHit(String.valueOf(body[n-1]));
                    System.out.println("Ви вдарили "+String.valueOf(body[n-1])+" противника");
                    energy-=energyStep;
                    break;
                }
            }

        }
    }

    public  void  defend(String attackedPart) {
        Scanner sc = new Scanner(System.in);
        int n;
        BodyPart[] body = {BodyPart.HEAD,BodyPart.CHEST,BodyPart.LEFTARM,BodyPart.RIGHARM,BodyPart.LEFTLEG,BodyPart.RIGHTLEG};
        while (true) {
            System.out.println("Виберіть місце захисту \n1.голова\n2.тіло\n3.ліва рука\n4.права рука\n5.ліва нога\n6.права нога \n");
            n = sc.nextInt();
            if(n>6||n<1){
                System.out.println("виберіть число з списку");
            }
            else {
                System.out.println("Ви захищаєте "+String.valueOf(body[n-1]));
                if (String.valueOf(body[n-1]).equals(attackedPart)) {
                    if (String.valueOf(body[n-1]).equals(String.valueOf(BodyPart.HEAD))) {
                        head += 15;
                        chest += 5;
                        leftArm += 5;
                        rightArm += 5;
                        leftLeg += 5;
                        rightLeg += 5;

                    } else if (String.valueOf(body[n-1]).equals(String.valueOf(BodyPart.CHEST))) {
                        head += 5;
                        chest += 15;
                        leftArm += 5;
                        rightArm += 5;
                        leftLeg += 5;
                        rightLeg += 5;

                    } else if (String.valueOf(body[n-1]).equals(String.valueOf(BodyPart.LEFTARM))) {
                        head += 5;
                        chest += 5;
                        leftArm += 15;
                        rightArm += 5;
                        leftLeg += 5;
                        rightLeg += 5;
                    } else if (String.valueOf(body[n-1]).equals(String.valueOf(BodyPart.RIGHARM))) {
                        head += 5;
                        chest += 5;
                        leftArm += 5;
                        rightArm += 15;
                        leftLeg += 5;
                        rightLeg += 5;
                    } else if (String.valueOf(body[n-1]).equals(String.valueOf(BodyPart.LEFTLEG))) {
                        head += 5;
                        chest += 5;
                        leftArm += 5;
                        rightArm += 5;
                        leftLeg += 15;
                        rightLeg += 5;
                    } else if (String.valueOf(body[n-1]).equals(String.valueOf(BodyPart.RIGHTLEG))) {
                        head += 5;
                        chest += 5;
                        leftArm += 15;
                        rightArm += 5;
                        leftLeg += 5;
                        rightLeg += 15;
                    }
                }
                else {
                    head += 5;
                    chest += 5;
                    leftArm += 5;
                    rightArm += 5;
                    leftLeg += 5;
                    rightLeg += 5;
                }
                energy+=10;
                if(energy>100){
                    energy=100;
                }
                break;
            }
        }
    }

    public void  showInfo(){
        System.out.println(name);
        System.out.println("Голова: "+head);
        System.out.println("Тіло: "+ chest);
        System.out.println("Ліва рука: " + leftArm);
        System.out.println("Права рука: "+rightArm);
        System.out.println("Ліва нога: "+ leftLeg);
        System.out.println("Права нога: " + rightLeg);
        System.out.println("Ваша енергія:" + energy);
        System.out.println();
    }



    public String minvaluepart(){
        int[] heroBodyValues =  {head,chest,leftArm,rightArm,leftLeg,rightArm};
        Arrays.sort(heroBodyValues);
        int min = heroBodyValues[0];
        if(min==head){
            return String.valueOf(BodyPart.HEAD);
        }
        else if(min==chest){
            return  String.valueOf(BodyPart.CHEST);
        }
        else if(min==leftArm){
            return  String.valueOf(BodyPart.LEFTARM);
        }
        else if(min==rightArm){
            return  String.valueOf(BodyPart.RIGHARM);
        }
        else if(min==leftLeg){
            return  String.valueOf(BodyPart.LEFTLEG);
        }
        else if(min==rightLeg){
            return  String.valueOf(BodyPart.RIGHTLEG);
        }
        return  String.valueOf(BodyPart.HOLLOWNESS);
    }



}
