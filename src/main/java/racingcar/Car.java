package racingcar;

import java.util.Random;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name){
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

     public int getPosition() {
        return position;
     }

     public void move(int position) {
        Random random = new Random();
        int randomValue = random.nextInt(10);

        if(randomValue > 4) {
            position = position + 1;
        }
        this.position = position;
     }

}
