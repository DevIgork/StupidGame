public abstract  class AbstractEnemy {
    private int chest;
    private  int energy;
    public  AbstractEnemy(){
        chest =100;
        energy=100;
    }

  public int getChest(){
        return chest;
  }

    public int getEnergy() {
        return energy;
    }

    public  void setChest(int chest){
        this.chest=chest;
    }

    public  void  setEnergy(int energy){
        this.energy=energy;
    }

    public  boolean  loose(){
        if(chest<=0){
            return  true;
        }
        return  false;
    }

    public void getHit(String part){
        if(part.equals(String.valueOf(BodyPart.CHEST))){
            chest-=10;
        }
    }


}
