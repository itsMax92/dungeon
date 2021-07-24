package dungeon;

import java.util.Random;
import java.util.Scanner;

public class Dungeon {
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        //Enemy
        String[] enemies = {"Skeleton", "Zombie", "Assassin", "Warrior"};
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;

        //PLayer
        int health = 100;
        int damage = 50;
        int numberOfHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50;

        boolean running = true;

        System.out.println("Welcome to the Dungeon !");
        while (running){

            System.out.println("----------------------------------------------");
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " +enemy+ " has appeared #\n");

            GAME:
            while (enemyHealth > 0){
                System.out.println("\tYour HP: " +health);
                System.out.println("\t" +enemy+"'s HP: " +enemyHealth);
                System.out.println("\n\tWhat would you like to Do ?");
                System.out.println("\t1.Attack");
                System.out.println("\t2.Drink health potion");
                System.out.println("\t3.Run");

                String input = scan.nextLine();

                if (input.equals("1")){
                    int damageDealt = rand.nextInt(damage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    health -= damageTaken;
                    enemyHealth -= damageDealt;

                    System.out.println("\t> You strike the" +enemy+ " for "+damageDealt+" damage");
                    System.out.println("\t> Damage done by the "+enemy+" is " +damageTaken);

                    if (health < 1){
                        System.out.println("\t> You have taken too much damage, You can't go further");
                        break;
                    }
                }else if (input.equals("2")){
                    if (numberOfHealthPotions > 0){
                        health += healthPotionHealAmount;
                        numberOfHealthPotions--;
                        System.out.println("\t> you have drink the health potion." +
                                           "\n\t> now your health is: "+health+"" +
                                           "\n\t> you are left with "+numberOfHealthPotions+" health potions.");
                    }else {
                        System.out.println("\t> You do not have any health potions left! ,you can get one by defeating an enemy. ");
                    }

                }else if (input.equals("3")){
                    System.out.println("\t> You chose to run away from" +enemy+ " .");
                    continue GAME;

                }else {
                    System.out.println("\t> You have entered invalid Command.");

                }

            }
            if (health < 1){
                System.out.println("\t> you do not have enough health to fight " +enemy);
                break;
            }
            System.out.println("-----------------------------------------------------");
            System.out.println(" # " + enemy + " was defeated! # ");
            System.out.println(" # you have "+health+ " health left # ");
            if (rand.nextInt(100) < healthPotionDropChance){
                healthPotionDropChance++;
                System.out.println(" # The "+enemy+ " dropped a health potion! # ");
                System.out.println(" # you have now " +numberOfHealthPotions+ " health potion(s). # ");
            }

            System.out.println("------------------------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1.Continue fighting");
            System.out.println("2.Exit dungeon");

            String input = scan.nextLine();
            while(!input.equals("1") && !input.equals("2")){
                System.out.println("Invalid command");
                input = scan.nextLine();
            }
            if (input.equals("1")){
                System.out.println("You continue on your adventure");
            }
            else if (input.equals("2")){
                System.out.println("you exit the dungeon, successful from your adventure.");
                break;
            }
        }
        System.out.println("                  ######################");
        System.out.println("                  # THANKS FOR PLAYING #");
        System.out.println("                  ######################");

    }
}
