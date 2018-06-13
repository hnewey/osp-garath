package net.castleadventure.ospgarath.model.item.itemType;

import net.castleadventure.ospgarath.model.item.Item;

import java.util.Random;

public class Book extends Item {

    //If I'm going to populate from a database, it'd probably be best to remove the enum and just use a POJO
    private enum BookTitle {
        SALT_SISTERS1("Text"),
        SALT_SISTERS2("TEXT");
        /*Book Ideas:
        -History of Salt Sisters.
        -History of Gray Warden interventions
        -History of Maglor
        -Book on the Watcher in the Water (or some sea beast that destroyed their village
        -Gray Warden theology
        -List of relics and their legends
        -Gray Warden organization structure
        -Journals to help with specific rooms/creatures
        -Special Hints book
         */

        private String bookText;
        BookTitle (String bookText) {
            this.bookText = bookText;
        }
    }

    private BookTitle bookTitle;

    public Book() {
        this.bookTitle = BookTitle.values()[new Random().nextInt(BookTitle.values().length)];
        setItemInfo(ItemType.BOOK, true, false, null, bookTitle.toString());
    }

    @Override
    protected void use() {
        System.out.println("Book Text:\n\"" + getBookText() + '\"');
    }

    @Override
    protected void equip() {

    }

    @Override
    protected void unequip() {

    }

    @Override
    protected void doEffect() {

    }

    @Override
    protected void endEffect() {

    }

    @Override
    public String toString() {
        return "Title: " + bookTitle.toString();
    }

    public String getBookText() {
        return bookTitle.bookText;
    }
}
