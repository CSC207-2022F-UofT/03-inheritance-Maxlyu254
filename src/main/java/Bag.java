/*
 * This file defines an abstract class named Bag.
 * In this exercise, you will be writing a larger class according to
 * the TODOs we have left you. You may find the readings in chapter
 * 1. Introduction to Java helpful.
 */

public abstract class Bag {
    /*
     * TODO: Create the following private instance variables
     *       - a String named color
     *       - an int named numberOfContents
     *       - an int named capacity
     *       - an array of Strings named contents
     */
    private String color;
    private int numberOfContents;
    private int capacity;
    private String[] contents;



    /**
     * A constructor that takes two arguments: the bag's color and capacity.
     *
     * @param color a String representing the Bag's color
     *
     * @param capacity an int representing the Bag's capacity
     */
    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.contents = new String[capacity];
        this.numberOfContents = 0;
    }



    public String getColor() {
        return color;
    }

    public int getNumberOfContents() {
        return numberOfContents;
    }

    public int getCapacity() {
        return capacity;
    }


    public void setColor(String color) {
        this.color = color;
    }

    /**
     * takes in a String representing an item in the bag. The item wouldn't be added to the bag
     * if the capacity of the bag is full.
     *
     * @param item a string that represents the item to be added in the bag.
     */
    public boolean addItem(String item) {
        if (numberOfContents < capacity) {
            contents[numberOfContents] = item;
            numberOfContents ++;
            return true;
        }
        return false;
    }





    /**
     * If there are no items in this Bag, return null.
     *
     * @return the popped item in the bag
     */
    public String popItem() {
        if (numberOfContents > 0) {
            String result = contents[numberOfContents - 1];
            contents[numberOfContents - 1] = null;
            numberOfContents --;
            return result;
        }
        return null;
    }





    /**
     * Increase this bag's capacity by n.
     *
     * @param n the amount to increase this Bag's capacity by. Has to be non-negative.
     */
    public void increaseCapacity(int n) {
        int oldCapacity = this.capacity;
        String[] oldContents = this.contents.clone();
        this.capacity = this.capacity + n;
        this.contents = new String[this.capacity];
        if (oldCapacity >= 0) {
            System.arraycopy(oldContents, 0, this.contents, 0, oldCapacity);
        }
    }

    /**
     * Return the details of this Bag.
     * This method requires you to have created the private
     * instance variables mentioned above.
     *
     * @return
     */
    @Override
    public String toString() {
        return this.color + " Bag (" + this.numberOfContents + " / " +
                this.capacity + ")";
    }

    /*
     * Below we have defined an abstract method.
     * This method takes no arguments and does not return anything.
     * It increases the capacity of this Bag.
     *
     * You will need to implement this method in
     * HandBag.java and CrossbodyBag.java.
     *
     * We recommend you look at HandBag.java first.
     */
    public abstract void enhance();
}