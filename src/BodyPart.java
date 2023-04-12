public final class BodyPart {
    final static BodyPart RIGHTLEG = new BodyPart("Права нога");

    final static BodyPart LEFTLEG = new BodyPart("Ліва нога");
    final static BodyPart HEAD = new BodyPart("Голова");
    final static BodyPart RIGHARM = new BodyPart("Права рука");

    final static BodyPart LEFTARM = new BodyPart("Ліва рука");
    final static BodyPart CHEST = new BodyPart("грудь");

    final  static  BodyPart HOLLOWNESS = new BodyPart("пустота");

    private String bodyPart;

    private BodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    @Override
    public String toString() {
        return this.bodyPart;
    }
}
