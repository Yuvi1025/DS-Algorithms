package Tree;

public class Main {
    public static void main(String[] args) {
        Tree drinks = new Tree("drinks");
        Tree hot = new Tree("hot");
        Tree cold = new Tree("cold");
        Tree tea = new Tree("tea");
        Tree coffee = new Tree("coffee");
        Tree fanta = new Tree("fanta");
        Tree sprite = new Tree("sprite");
        drinks.addChild(hot);
        drinks.addChild(cold);
        hot.addChild(tea);
        hot.addChild(coffee);
        cold.addChild(fanta);
        cold.addChild(sprite);
        System.out.println(drinks.print(0));
    }
}
