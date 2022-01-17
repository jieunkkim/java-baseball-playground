package study;

import java.util.Random;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

public class Baseball {

    public static void main(String[] args) {
        Baseball baseball = new Baseball();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while(!exit){
            baseball.playBaseballGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String exitYn = scanner.nextLine();

            if (!StringUtils.equals("1", scanner.nextLine())) {
                exit = true;
            }
            scanner.close();
        }
    }

    public void playBaseballGame(){
        String computerData = createInitData();
        System.out.println(computerData);
        String userData = "";

        int s_count = 0;
        int b_count = 0;
        while(!(s_count==3)){
            userData = inputNumber();
            s_count = countStrike(computerData, userData);
            b_count = countBall(computerData, userData);
            System.out.printf("%d 스트라이크, %d 볼 %n", s_count, b_count);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public String inputNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");

        String userData = scanner.nextLine();
        if (checkValidationUserData(userData) == false) {
            System.out.println("유효하지 않은 숫자입니다.");
            return inputNumber();
        }

        return userData;
    }

    public boolean checkValidationUserData(String userData) {
        if(StringUtils.isNumeric(userData) == false){
            return false;
        }
        if (userData.length() != 3) {
            return false;
        }
        if (userData.charAt(0) == '0') {
            return false;
        }
        return true;
    }

    public String createInitData() {
        String computerData = "";
        for (int i = 0; i < 3; i++) {
            computerData += String
                .valueOf(getNewNumber(computerData)); // random.nextInt(10) 10 미만의 int형 난수 생성
        }
        return computerData;
    }

    private int getNewNumber(String computerData) {
        Random random = new Random();
        int randomNum = random.nextInt(10);
        if (computerData.indexOf(String.valueOf(randomNum)) == -1) {
            return randomNum;
        }
        return getNewNumber(computerData);
    }

    public int countStrike(String computerData, String userData) {
        int count = 0;
        for (int i = 0; i < computerData.length(); i++) {
            count += checkEqualNum(Character.getNumericValue(computerData.charAt(i)),
                Character.getNumericValue(userData.charAt(i)));
        }
        return count;
    }

    private int checkEqualNum(int a, int b) {
        if (a == b) {
            return 1;
        }
        return 0;
    }

    public int countBall(String computerData, String userData) {
        int count = 0;
        for (int i = 0; i < userData.length(); i++) {
            count += checkContainNum(computerData, userData.charAt(i));
            count -= checkEqualNum(computerData.charAt(i), userData.charAt(i));
        }
        return count;
    }

    private int checkContainNum(String computerData, char num) {
        if (computerData.indexOf(num) != -1) {
            return 1;
        }
        return 0;
    }
}
