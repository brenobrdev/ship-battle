package Utilities;

import Models.Vector2;

public class Input {
    public static Vector2 parse(String input) {
        int length = input.length();

        if (length == 2){
            int x = input.charAt(0) - 64;
            int y = input.charAt(1) - 48;

            return new Vector2(x, y);
        } else if (length == 3) {
            try {
                int x = input.charAt(0) - 64;
                int y = Integer.parseInt(input.substring(1, 3));
                return new Vector2(x, y);
            } catch (Exception e) {
                return null;
            }
        } else {
            return null;
        }
    }
}
