public class Squid extends SeaCreature {
      private String symbol;
      private int tracker;
      private int movement; 

    public Squid(String name, int position, int speed, int direction) {
        super(name, position, speed, direction);
        tracker = 0; 
        movement = 1; 
        symbol = "＜コ：ミ";
    }

    @Override
    public void move(int tankWidth) {
        position += movement;
        tracker +=movement; 
        if (tracker == 14)
        {
            movement = -1; 
        }
        if (tracker == 0)
        {
            movement = 1;
        }

        keepInsideTank(tankWidth);
    }

    @Override
    public String getSymbol() {
        return direction >= 0 ? symbol : reverseSymbol(symbol);
    }

    private String reverseSymbol(String text) {
        return new StringBuilder(text).reverse().toString();
    }
}
