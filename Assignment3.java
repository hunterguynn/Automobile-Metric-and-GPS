/**
 * Assignment3
 */

import java.awt.Toolkit;

import javax.swing.JOptionPane;

public class Assignment3{


    public static void main(String[] args) {

      /********************************
        Variables
      ********************************* */
      // Create program variables
      String carDescription = "";
      int fuelTankCapacity = 0;
      String engineDescription = "";
      int mpg = 0;
      int maxSpeed = 0;
      int legs = 0;
      double xRatio = 0;
      double yRatio =0;
      int legDistance =0;


      
      


        /********************************
        Inputs
        ********************************* */
        
        //Car description
        carDescription = JOptionPane.showInputDialog(null, "Enter Car description");

        //Fuel tank capacity
        while (fuelTankCapacity <= 0) {
          try {
            fuelTankCapacity = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Fuel tank capacity"));
          } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting.", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
          }
        }

        //Engine description
        engineDescription = JOptionPane.showInputDialog(null, "Enter Engine description");

        //Miles per gallon
        while (mpg <= 0) {
          try {
            mpg = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Miles per gallon"));
          } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting.", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
          }
        }

        //Max speed
        while (maxSpeed <= 0) {
          try {
            maxSpeed = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Max speed"));
          } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting.", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
          }
        }

        /*****************************
        Creating Car
        *******************************/

        Engine engine = new Engine(engineDescription, mpg, maxSpeed);
        Car car = new Car(carDescription, fuelTankCapacity, engine);


        /*****************************
        Display all of the car's info
        *******************************/
        // Output Car Description
        JOptionPane.showMessageDialog(null, car.getDescription(), "Car Description", JOptionPane.INFORMATION_MESSAGE);


        
        /*****************************
        Input number of legs and collect leg data
        *******************************/

        //Number of legs in the trip
        while (legs <= 0) {
          try {
            legs = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of legs in the trip"));
          } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting.", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
          }
        }

        //Setting Coordanate Array
        int[] xArray = new int[legs +1];
        int[] yArray = new int[legs +1];




        //Fill up car before it starts its trip
        car.fillUp();


        //JOptionPane.showMessageDialog(null, car.getDescription(), "Car Description", JOptionPane.INFORMATION_MESSAGE);

        //For loop for driving car
        for (int i = 0; i < legs; i++) {
        

          //distance of the leg
          legDistance = 0;
          while (legDistance <= 0) {
            try {
              legDistance = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter distance of leg " + (i+1)));
            } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting.", "ERROR", JOptionPane.ERROR_MESSAGE);
              System.exit(0);
            }
          }


          xRatio = 0;
          yRatio = 0;
         //x ratio for the direction of the leg 
            try {
              xRatio = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter X ratio for the direction of leg " + (i+1)));
            } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting.", "ERROR", JOptionPane.ERROR_MESSAGE);
              System.exit(0);
            }
          
          //y ratio for the direction of the leg
            try {
              yRatio = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Y ratio for the direction of leg " + (1+i)));
            } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting.", "ERROR", JOptionPane.ERROR_MESSAGE);
              System.exit(0);
            }
          
          

        /********************************
         Car Driving
        ********************************* */
          xArray[i] = car.getX();
          yArray[i] = car.getY();
          car.drive(legDistance, xRatio, yRatio);
        
        }
        xArray[xArray.length-1] = car.getX();
        yArray[yArray.length-1] = car.getY();





        /********************************
         Display GUI
        ********************************* */
      

        DrivePanel panel = new DrivePanel(xArray,yArray);
        panel.setVisible(true);
        

      
      }

      
}