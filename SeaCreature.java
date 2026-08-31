public abstract class SeaCreature {

    protected String name;
    protected int position;
    protected int speed;
    protected int direction;
    protected String color;

    public SeaCreature(String name, int position, int speed, int direction, String color)
        throws InvalidCreatureException {

    if (name == null || !name.matches("[a-zA-Z]+" )) { //notation assited by chatGPT
        throw new InvalidCreatureException(
            "Make sure your name is a String containing only letters, "+name+ " does not work");
    }
     if (position < 0) { 
        throw new InvalidCreatureException(
            "Make sure your position is positive, "+position+ " does not work");
    } 
    if(color == null || !color.matches("[a-zA-Z]+" )) {
        throw new InvalidCreatureException("You need to enter a valid color!");
    }

    this.name = name;
    this.position = position;
    this.speed = speed;
    this.direction = direction;
    this.color = color; 
}

    // Each subclass decides how it moves.
    public abstract void move(int tankWidth);

    // Each subclass decides how it looks in the terminal.
    public abstract String getSymbol();

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void turnAround() {
        direction *= -1;
    }

    protected void keepInsideTank(int tankWidth) {
        int maxPosition = Math.max(0, tankWidth - getSymbol().length());

        if (position > maxPosition) {
            position = maxPosition;
            direction = -1;
        }

        if (position < 0) {
            position = 0;
            direction = 1;
        }
    }

    public String getDirectionWord() {
        return direction >= 0 ? "right" : "left"; //? If : else
    }

    public String getColorCode() { //assisted by chatGPT
    switch (color.toLowerCase()) {
        case "red":
            return "\u001B[31m";
        case "green":
            return "\u001B[32m";
        case "yellow":
            return "\u001B[33m";
        case "blue":
            return "\u001B[34m";
        case "purple":
            return "\u001B[35m";
        case "orange":
            return "\u001B[38;5;208m";
        case "cyan":
            return "\u001B[36m";
        default:
            return "\u001B[0m";
    }
}
    @Override
    public String toString() {
        return getClass().getSimpleName()
                + " | name=" + name
                + " | position=" + position
                + " | speed=" + speed
                + " | direction=" + getDirectionWord()
                + " | color= "+color;
    }
}
