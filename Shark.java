public class Shark extends SeaCreature{
   
    private String symbol;

    public Shark(String name, int position, int speed, int direction) {
        super(name, position, speed, direction);
        symbol = "⟩<^,«⋗";
    }

    @Override
    public void move(int tankWidth) {
        position += speed * direction+(int)(Math.random()*3);
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
