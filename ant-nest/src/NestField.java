public abstract class NestField {

    protected Position position;

    public abstract String toString();

    public Position getPosition() {
        return this.position;
    }

    public NestField setPosition(Position position) {
        this.position = position;

        return this;
    }

}
