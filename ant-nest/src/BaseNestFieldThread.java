public class BaseNestFieldThread extends Thread implements NestField {

    protected final BaseNestField delegate = new BaseNestField();

    @Override
    public Position getPosition() {
        return delegate.getPosition();
    }

    @Override
    public void setPosition(Position position) {
        delegate.setPosition(position);
    }


}
