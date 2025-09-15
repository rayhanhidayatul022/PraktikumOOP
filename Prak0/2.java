/**
 * Main.java
 * 
 * @author 18223022 Rayhan Hidayatul Fikri
 */

 import java.util.Scanner;

 public class Main {
     /**
      * Mengecek apabila kartu memiliki nilai 10, J, Q, K, A
      * 
      * @param cards
      * @return true apabila kartu memiliki 10 sampai As, false sebaliknya
      */
     public static boolean isRoyal(String[] cards) {
         char symbol = cards[0].charAt(0);
         for(int i = 1; i < 5; i++){
             if(cards[i].charAt(0) != symbol) return false;
         }
         int frekuensi[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
         for(int i = 0; i < 5; i++){
             if(cards[i].charAt(1) == 'K') frekuensi[12]++;
             else if(cards[i].charAt(1) == 'Q') frekuensi[11]++;
             else if(cards[i].charAt(1) == 'J') frekuensi[10]++;
             else if(cards[i].charAt(1) == 'T') frekuensi[9]++;
             else if(cards[i].charAt(1) == '9') frekuensi[8]++;
             else if(cards[i].charAt(1) == '8') frekuensi[7]++;
             else if(cards[i].charAt(1) == '7') frekuensi[6]++;
             else if(cards[i].charAt(1) == '6') frekuensi[5]++;
             else if(cards[i].charAt(1) == '5') frekuensi[4]++;
             else if(cards[i].charAt(1) == '4') frekuensi[3]++;
             else if(cards[i].charAt(1) == '3') frekuensi[2]++;
             else if(cards[i].charAt(1) == '2') frekuensi[1]++;
             else if(cards[i].charAt(1) == 'A') frekuensi[0]++;
         }
         if((frekuensi[0] == 1) && (frekuensi[12] == 1) && (frekuensi[11] == 1) && (frekuensi [10] == 1) && (frekuensi[9] == 1)) return true;
         else return false;
     }
 
     /**
      * Mengecek apabila kartu dapat membentuk Full House
      * 
      * @param cards
      * @return true apabila kartu dapat membentuk Full House, false sebaliknya
      */
     public static boolean isFullHouse(String[] cards) {
         int frekuensi[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
         for(int i = 0; i < 5; i++){
             if(cards[i].charAt(1) == 'K') frekuensi[12]++;
             else if(cards[i].charAt(1) == 'Q') frekuensi[11]++;
             else if(cards[i].charAt(1) == 'J') frekuensi[10]++;
             else if(cards[i].charAt(1) == 'T') frekuensi[9]++;
             else if(cards[i].charAt(1) == '9') frekuensi[8]++;
             else if(cards[i].charAt(1) == '8') frekuensi[7]++;
             else if(cards[i].charAt(1) == '7') frekuensi[6]++;
             else if(cards[i].charAt(1) == '6') frekuensi[5]++;
             else if(cards[i].charAt(1) == '5') frekuensi[4]++;
             else if(cards[i].charAt(1) == '4') frekuensi[3]++;
             else if(cards[i].charAt(1) == '3') frekuensi[2]++;
             else if(cards[i].charAt(1) == '2') frekuensi[1]++;
             else if(cards[i].charAt(1) == 'A') frekuensi[0]++;
         }
         boolean pair = false;
         boolean threeOfKind = false;
         for(int i = 0; i < 13; i++){
             if(frekuensi[i] == 3) threeOfKind = true;
             else if(frekuensi[i] == 2) pair = true;
         }
         return pair && threeOfKind;
     }
 
     /**
      * Mengecek apabila kartu dapat membentuk Flush
      * 
      * @param cards
      * @return true apabila kartu dapat membentuk Flush, false sebaliknya
      */
     public static boolean isFlush(String[] cards) {
         char symbol = cards[0].charAt(0);
         for(int i = 1; i < 5; i++){
             if(cards[i].charAt(0) != symbol) return false;
         }
         return true;
     }
 
     /**
      * Mengembalikan rangking dari set yang dimiliki dengan rangking berikut:
      * - Royal Flush: 3
      * - Full House: 2
      * - Flush: 1
      * - High Card: 0
      * 
      * @param cards
      * @return rangking
      */
     public static int getSetRanking(String[] cards) {
         if(isRoyal(cards)) return 3;
         else if(isFullHouse(cards)) return 2;
         else if(isFlush(cards)) return 1;
         else return 0;
     }
 
     public static void main(String[] args) {
         String[] cardsTuanBil = new String[5];
         String[] cardsTuanMask = new String[5];
         Scanner sc = new Scanner(System.in);
         for(int i = 0; i < 5; i++){
             cardsTuanBil[i] = sc.nextLine();
         }
         for(int i = 0; i < 5; i++){
             cardsTuanMask[i] = sc.nextLine();
         }
         int setRankTuanBil = getSetRanking(cardsTuanBil);
         int setRankTuanMask = getSetRanking(cardsTuanMask);
         if(setRankTuanBil == setRankTuanMask){
             System.out.println("Seri");
             System.out.println(setRankTuanBil);
         }
         else if(setRankTuanBil > setRankTuanMask){
             System.out.println("Tuan Bil");
             System.out.println(setRankTuanBil);
         }
         else{
             System.out.println("Tuan Mask");
             System.out.println(setRankTuanMask);
         }
 
     //     if(isRoyal(cardsTuanBil) || isRoyal(cardsTuanMask)){
     //         if(isRoyal(cardsTuanBil) && isRoyal(cardsTuanMask)){
     //             System.out.println("Seri");
     //             System.out.println(3);
     //         }
     //         else if(isRoyal(cardsTuanBil)){
     //             System.out.println("Tuan Bil");
     //             System.out.println(3);
     //         }
     //         else if(isRoyal(cardsTuanMask)){
     //             System.out.println("Tuan Mask");
     //             System.out.println(3);
     //         }
     //     }
     //     else if(isFullHouse(cardsTuanBil) || isFullHouse(cardsTuanMask)){
     //         if(isFullHouse(cardsTuanBil) && isFullHouse(cardsTuanMask)){
     //             System.out.println("Seri");
     //             System.out.println(2);
     //         }
     //         else if(isFullHouse(cardsTuanBil)){
     //             System.out.println("Tuan Bil");
     //             System.out.println(2);
     //         }
     //         else if(isFullHouse(cardsTuanMask)){
     //             System.out.println("Tuan Mask");
     //             System.out.println(2);
     //         }
     // }
     //     else if(isFlush(cardsTuanBil) || isFlush(cardsTuanMask)){
     //         if(isFlush(cardsTuanBil) && isFlush(cardsTuanMask)){
     //             System.out.println("Seri");
     //             System.out.println(1);
     //         }
     //         else if(isFlush(cardsTuanBil)){
     //             System.out.println("Tuan Bil");
     //             System.out.println(1);
     //         }
     //         else if(isFlush(cardsTuanMask)){
     //             System.out.println("Tuan Mask");
     //             System.out.println(1);
     //         }
     //     }
     //     else{
     //         System.out.println("Seri");
     //         System.out.println(0);
     //     }
     }
 }
