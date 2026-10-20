package Week5;

public class FavoriteThingsArray {
    public static void main(String[] args) {
        String[] favorites = {"Sleeping", "Watching Movies", "Eating", "Dancing", "Music"};

        System.out.println("My Favorite Things:");

        for (int i = 0; i < favorites.length; i++) {
            System.out.println((i + 1) + ". " + favorites[i]);
        }

        System.out.println("Total number of favorites: " + favorites.length);
    }
}
