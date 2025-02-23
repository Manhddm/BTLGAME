package utilz;

public class Constants {
    public static class PlayerConstans{
        public static final int IDLE = 0;
        public static final int RUNNING = 1;
//        public static final int JUMPING = 2;
//        public static final int FALLING = 3;
        public static final int ATTACKING_1 = 2;
        public static final int ATTACKING_2 =3;
        public static final int ATTACKING_3 = 4;
        public static final int HIT = 5;
        public static final int DEAD = 6;

        public static int GetSpriteAmount(int player_action){
            switch (player_action){
                case RUNNING:
                    return 7;
                case IDLE:
                    return 7;
                case ATTACKING_1:
                    return 12;
                case ATTACKING_2:
                    return 12;
                case ATTACKING_3:
                    return 16;
                case HIT:
                    return 4;
                case DEAD:
                    return 8;
                default:
                    return 1;
            }
        }
    }
}
