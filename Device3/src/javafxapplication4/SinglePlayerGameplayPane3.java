package javafxapplication4;



// this class is for offline multiplayer not for single player



import java.awt.Event;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public  class SinglePlayerGameplayPane3 extends Pane {

    protected final ImageView imageView;
    protected final Button mainMenu;
    protected final Button tryAgain;
    protected final Label label;
    protected final TextField textField;
    protected final Label label0;
    protected final TextField textField0;
    protected final Label label1;
    protected final TextField textField1;
    protected final Label label2;
    protected final TextField textField2;
    protected final Button b11;
    protected final Button b12;
    protected final Button b13;
    protected final Button b21;
    protected final Button b22;
    protected final Button b23;
    protected final Button b31;
    protected final Button b32;
    protected final Button b33;
    boolean isGameEnds;
    boolean isFirstPlayerTurn = true;
    int XOCounter = 0;
    Random random = new Random();
    //int randomNumber;
    
    
    private void computerTurn(){
        while(isGameEnds==false){
            checkIfGameEnds();
            int x=random.nextInt(9);
            if( x==0 && b11.getText().equals("") ){
                      b11.getStyleClass().remove("freeCell-Class");
                      b11.getStyleClass().add("o-Class");
                      b11.setText("O");
                      break;
            }
            
            if( x==1 && b12.getText().equals("") ){
                      b12.getStyleClass().remove("freeCell-Class");
                      b12.getStyleClass().add("o-Class");
                      b12.setText("O");
                      break;
            }
            if( x==2 && b13.getText().equals("") ){
                      b13.getStyleClass().remove("freeCell-Class");
                      b13.getStyleClass().add("o-Class");
                      b13.setText("O");
                      break;
            }
            if( x==3 && b21.getText().equals("") ){
                      b21.getStyleClass().remove("freeCell-Class");
                      b21.getStyleClass().add("o-Class");
                      b21.setText("O");
                      break;
            }
            if( x==4 && b22.getText().equals("") ){
                      b22.getStyleClass().remove("freeCell-Class");
                      b22.getStyleClass().add("o-Class");
                      b22.setText("O");
                      break;
            }
            if( x==5 && b23.getText().equals("") ){
                      b23.getStyleClass().remove("freeCell-Class");
                      b23.getStyleClass().add("o-Class");
                      b23.setText("O");
                      break;
            }
            if( x==6 && b31.getText().equals("") ){
                      b31.getStyleClass().remove("freeCell-Class");
                      b31.getStyleClass().add("o-Class");
                      b31.setText("O");
                      break;
            }
            if( x==7 && b32.getText().equals("") ){
                      b32.getStyleClass().remove("freeCell-Class");
                      b32.getStyleClass().add("o-Class");
                      b32.setText("O");
                      break;
            }
            
            if( x==8 && b33.getText().equals("") ){
                      b33.getStyleClass().remove("freeCell-Class");
                      b33.getStyleClass().add("o-Class");
                      b33.setText("O");
                      break;
            }
            
        }
        
    }
     private void checkIfGameEnds() {
            
        String t00 = b11.getText();
        String t01 = b12.getText();
        String t02 = b13.getText();
        String t10 = b21.getText();
        String t11 = b22.getText();
        String t12 = b23.getText();
        String t20=  b31.getText();
        String t21 = b32.getText();
        String t22 = b33.getText();
  
        if (t00.equals(t01) && t00.equals(t02) && !t00.equals("")) {
            isGameEnds = true;
            
        }
 
        if (t10.equals(t11) && t10.equals(t12) && !t10.equals("")) {
            isGameEnds = true;
            
        }
 
        if (t20.equals(t21) && t20.equals(t22) && !t20.equals("")) {
            isGameEnds = true;
        }
 
        if (t00.equals(t10) && t00.equals(t20) && !t00.equals("")) {
            isGameEnds = true;
        }
 
        if (t01.equals(t11) && t01.equals(t21) && !t01.equals("")) {
            isGameEnds = true;
        }
 
        if (t02.equals(t12) && t02.equals(t22) && !t02.equals("")) {
            isGameEnds = true;
        }
 
        if (t00.equals(t11) && t00.equals(t22) && !t00.equals("")) {
            isGameEnds = true;
        }
 
        if (t02.equals(t11) && t02.equals(t20) && !t02.equals("")) {
            isGameEnds = true;
        }
        
        if( XOCounter >= 9)
        {
            isGameEnds = true;
            isFirstPlayerTurn = true;
            XOCounter = 0;
        }
        
        if(isGameEnds == true)
        {
            /*if(isFirstPlayerTurn)
                firstPlayerScore.setText(Integer.valueOf(firstPlayerScore.getText()) + 1 + "");
    
            else
                secondPlayerScore.setText(Integer.valueOf(secondPlayerScore.getText()) + 1 + "");*/
            XOCounter = 0;
            tryAgain.requestFocus();
        }
        
    }
    
     public void startNewGame() { 
         
            isGameEnds = false;
            b11.getStyleClass().add("freeCell-Class");
            b11.getStyleClass().remove("o-Class");
            b11.getStyleClass().remove("x-Class");
            b12.getStyleClass().add("freeCell-Class");
            b12.getStyleClass().remove("o-Class");
            b12.getStyleClass().remove("x-Class");
            b13.getStyleClass().add("freeCell-Class");
            b13.getStyleClass().remove("o-Class");
            b13.getStyleClass().remove("x-Class");
            b21.getStyleClass().add("freeCell-Class");
            b21.getStyleClass().remove("o-Class");
            b21.getStyleClass().remove("x-Class");
            b22.getStyleClass().add("freeCell-Class");
            b22.getStyleClass().remove("o-Class");
            b22.getStyleClass().remove("x-Class");
            b23.getStyleClass().add("freeCell-Class");
            b23.getStyleClass().remove("o-Class");
            b23.getStyleClass().remove("x-Class");
            b31.getStyleClass().add("freeCell-Class");
            b31.getStyleClass().remove("o-Class");
            b31.getStyleClass().remove("x-Class");
            b32.getStyleClass().add("freeCell-Class");
            b32.getStyleClass().remove("o-Class");
            b32.getStyleClass().remove("x-Class");
            b33.getStyleClass().add("freeCell-Class");
            b33.getStyleClass().remove("o-Class");
            b33.getStyleClass().remove("x-Class");
            b11.setText("0");
            b12.setText("0");
            b13.setText("0");
            b21.setText("0");
            b22.setText("0");
            b23.setText("0");
            b31.setText("0");
            b32.setText("0");
            b33.setText("0");
            //b33.fireEvent(e);

     }



    public SinglePlayerGameplayPane3() {

        imageView = new ImageView();
        mainMenu = new Button();
        tryAgain = new Button();
        label = new Label();
        textField = new TextField();
        label0 = new Label();
        textField0 = new TextField();
        label1 = new Label();
        textField1 = new TextField();
        label2 = new Label();
        textField2 = new TextField();
        b11 = new Button();
        b12 = new Button();
        b13 = new Button();
        b21 = new Button();
        b22 = new Button();
        b23 = new Button();
        b31 = new Button();
        b32 = new Button();
        b33 = new Button();

        setMaxHeight(1000.0);
        setMaxWidth(1000.0);
        setMinHeight(499.0);
        setMinWidth(450.0);
        setPrefHeight(499.0);
        setPrefWidth(450.0);
       

        imageView.setFitHeight(356.0);
        imageView.setFitWidth(500.0);
        imageView.setLayoutX(110.0);
        imageView.setLayoutY(60.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("board.jpg").toExternalForm()));
         setStyle("-fx-background-color: WHITE;");
   
        mainMenu.setLayoutX(29.0);
        mainMenu.setLayoutY(7.0);
        mainMenu.setMnemonicParsing(false);
        mainMenu.setPrefHeight(34.0);
        mainMenu.setPrefWidth(111.0);
        mainMenu.setText("Main Menu");
        mainMenu.getStyleClass().add("Button-Class"); 

        tryAgain.setLayoutX(305.0);
        tryAgain.setLayoutY(8.0);
        tryAgain.setMnemonicParsing(false);
        tryAgain.setPrefHeight(34.0);
        tryAgain.setPrefWidth(111.0);
        tryAgain.setText("Try Again");
        tryAgain.getStyleClass().add("Button-Class"); 
        
        label.setLayoutX(20.0);
        label.setLayoutY(417.0);
        label.setPrefHeight(27.0);
        label.setPrefWidth(64.0);
        label.setText("Player:");
        label.setFont(new Font("System Bold", 16.0));

        textField.setLayoutX(84.0);
        textField.setLayoutY(418.0);
        textField.setPrefHeight(25.0);
        textField.setPrefWidth(100.0);
        textField.setCursor(Cursor.DEFAULT);

        label0.setLayoutX(20.0);
        label0.setLayoutY(448.0);
        label0.setPrefHeight(27.0);
        label0.setPrefWidth(64.0);
        label0.setText("Score:");
        label0.setFont(new Font("System Bold", 16.0));

        textField0.setLayoutX(84.0);
        textField0.setLayoutY(449.0);
        textField0.setPrefHeight(25.0);
        textField0.setPrefWidth(37.0);
        textField0.setCursor(Cursor.DEFAULT);

        label1.setLayoutX(279.0);
        label1.setLayoutY(420.0);
        label1.setPrefHeight(27.0);
        label1.setPrefWidth(64.0);
        label1.setText("Player:");
        label1.setFont(new Font("System Bold", 16.0));

        textField1.setLayoutX(343.0);
        textField1.setLayoutY(421.0);
        textField1.setPrefHeight(25.0);
        textField1.setPrefWidth(100.0);
        textField1.setCursor(Cursor.DEFAULT);

        label2.setLayoutX(279.0);
        label2.setLayoutY(451.0);
        label2.setPrefHeight(27.0);
        label2.setPrefWidth(64.0);
        label2.setText("Score:");
        label2.setFont(new Font("System Bold", 16.0));

        textField2.setLayoutX(343.0);
        textField2.setLayoutY(452.0);
        textField2.setPrefHeight(25.0);
        textField2.setPrefWidth(37.0);
        textField2.setCursor(Cursor.DEFAULT);

       b11.setLayoutX(122.0);
        b11.setLayoutY(145.0);
        b11.setMnemonicParsing(false);
        b11.setPrefHeight(69.0);
        b11.setPrefWidth(64.0);
        b11.getStyleClass().add("freeCell-Class");

        b12.setLayoutX(205.0);
        b12.setLayoutY(145.0);
        b12.setMnemonicParsing(false);
        b12.setPrefHeight(69.0);
        b12.setPrefWidth(64.0);
        b12.getStyleClass().add("freeCell-Class");

        b13.setLayoutX(285.0);
        b13.setLayoutY(145.0);
        b13.setMnemonicParsing(false);
        b13.setPrefHeight(69.0);
        b13.setPrefWidth(64.0);
        b13.getStyleClass().add("freeCell-Class");

        b21.setLayoutX(122.0);
        b21.setLayoutY(230.0);
        b21.setMnemonicParsing(false);
        b21.setPrefHeight(64.0);
        b21.setPrefWidth(64.0);
        b21.getStyleClass().add("freeCell-Class");

        b22.setLayoutX(205.0);
        b22.setLayoutY(230.0);
        b22.setMnemonicParsing(false);
        b22.setPrefHeight(64.0);
        b22.setPrefWidth(64.0);
        b22.getStyleClass().add("freeCell-Class");

        b23.setLayoutX(285.0);
        b23.setLayoutY(230.0);
        b23.setMnemonicParsing(false);
        b23.setPrefHeight(64.0);
        b23.setPrefWidth(64.0);
        b23.getStyleClass().add("freeCell-Class");

        b31.setLayoutX(122.0);
        b31.setLayoutY(315.0);
        b31.setMnemonicParsing(false);
        b31.setPrefHeight(64.0);
        b31.setPrefWidth(64.0);
        b31.getStyleClass().add("freeCell-Class");
        

        b32.setLayoutX(205.0);
        b32.setLayoutY(315.0);
        b32.setMnemonicParsing(false);
        b32.setPrefHeight(64.0);
        b32.setPrefWidth(64.0);
        b32.getStyleClass().add("freeCell-Class");
        

        b33.setLayoutX(285.0);
        b33.setLayoutY(315.0);
        b33.setMnemonicParsing(false);
        b33.setPrefHeight(64.0);
        b33.setPrefWidth(64.0);
        b33.getStyleClass().add("freeCell-Class");

        getChildren().add(imageView);
        getChildren().add(mainMenu);
        getChildren().add(tryAgain);
        getChildren().add(label);
        getChildren().add(textField);
        //getChildren().add(label0);
        //getChildren().add(textField0);
        getChildren().add(label1);
        getChildren().add(textField1);
        //getChildren().add(label2);
        //getChildren().add(textField2);
        getChildren().add(b11);
        getChildren().add(b12);
        getChildren().add(b13);
        getChildren().add(b21);
        getChildren().add(b22);
        getChildren().add(b23);
        getChildren().add(b31);
        getChildren().add(b32);
        getChildren().add(b33);

        
        
        b11.setOnAction((Action) -> {
          if( isGameEnds == false && b11.getText().equals("") ){
           //  if(isFirstPlayerTurn) {
                      b11.getStyleClass().remove("freeCell-Class");
                      b11.getStyleClass().add("x-Class");
                      b11.setText("X");
            //      }
                 
                  checkIfGameEnds();
                  isFirstPlayerTurn = !isFirstPlayerTurn;
                  computerTurn();
                  checkIfGameEnds();
          }
        });
        
        b12.setOnAction((Action) -> {
         
          if( isGameEnds == false && b12.getText().equals("") ){
//               if(isFirstPlayerTurn) {
                      b12.getStyleClass().remove("freeCell-Class");
                      b12.getStyleClass().add("x-Class");
                      b12.setText("X");
//                  }
                 
                  checkIfGameEnds();
                  isFirstPlayerTurn = !isFirstPlayerTurn;
                  computerTurn();
                  checkIfGameEnds();
          }
        });
        
        b13.setOnAction((Action) -> {
          
         
          if( isGameEnds == false && b13.getText().equals("") ){
//            if(isFirstPlayerTurn) {
                      b13.getStyleClass().remove("freeCell-Class");
                      b13.getStyleClass().add("x-Class");
                      b13.setText("X");
//                  }
                 
                  checkIfGameEnds();
                  isFirstPlayerTurn = !isFirstPlayerTurn;
                  computerTurn();
                  checkIfGameEnds();
          }
        });
        
        b21.setOnAction((Action) -> {
          if( isGameEnds == false && b21.getText().equals("") ){
//               if(isFirstPlayerTurn) {
                      b21.getStyleClass().remove("freeCell-Class");
                      b21.getStyleClass().add("x-Class");
                      b21.setText("X");
//                  }
                 
                  checkIfGameEnds();
                  isFirstPlayerTurn = !isFirstPlayerTurn;
                  computerTurn();
                  checkIfGameEnds();
          }
        });
        
        b22.setOnAction((Action) -> {
          if( isGameEnds == false && b22.getText().equals("") ){
//             if(isFirstPlayerTurn) {
                      b22.getStyleClass().remove("freeCell-Class");
                      b22.getStyleClass().add("x-Class");
                      b22.setText("X");
//                  }
                 
                  checkIfGameEnds();
                  isFirstPlayerTurn = !isFirstPlayerTurn;
                  computerTurn();
                  checkIfGameEnds();
          }
        });
        
        b23.setOnAction((Action) -> {
          if( isGameEnds == false && b23.getText().equals("") ){
//             if(isFirstPlayerTurn) {
                      b23.getStyleClass().remove("freeCell-Class");
                      b23.getStyleClass().add("x-Class");
                      b23.setText("X");
//                  }
                 
                  checkIfGameEnds();
                  isFirstPlayerTurn = !isFirstPlayerTurn;
                  computerTurn();
                  checkIfGameEnds();
          }
        });
        
        b31.setOnAction((Action) -> {
            
          if( isGameEnds == false && b31.getText().equals("") ){
            // if(isFirstPlayerTurn) {
                      b31.getStyleClass().remove("freeCell-Class");
                      b31.getStyleClass().add("x-Class");
                      b31.setText("X");
               //   }
                  checkIfGameEnds();
                  isFirstPlayerTurn = !isFirstPlayerTurn;
                  computerTurn();
                  checkIfGameEnds();
          }

        });
        
        b32.setOnAction((Action) -> { 
          if( isGameEnds == false && b32.getText().equals("") ){
              // if(isFirstPlayerTurn) {
                      b32.getStyleClass().remove("freeCell-Class");
                      b32.getStyleClass().add("x-Class");
                      b32.setText("X");
               //   }
                  checkIfGameEnds();
                  isFirstPlayerTurn = !isFirstPlayerTurn;
                  computerTurn();
                  checkIfGameEnds();

          }
        });
        
        b33.setOnAction((Action) -> {
            
          if( isGameEnds == false && b33.getText().equals("") ){
           //  if(isFirstPlayerTurn) {
                      b33.getStyleClass().remove("freeCell-Class");
                      b33.getStyleClass().add("x-Class");
                      b33.setText("X");
             //     }
                  checkIfGameEnds();
                  isFirstPlayerTurn = !isFirstPlayerTurn;
                  computerTurn();
                  checkIfGameEnds();
          }
        });
        
        mainMenu.setOnAction((Action) -> {
           AppManager.viewPane(AppManager.startMenu);
        });
        
        tryAgain.setOnAction((Action) -> {
            isGameEnds=false;
            b11.getStyleClass().add("freeCell-Class");
            b11.getStyleClass().remove("o-Class");
            b11.getStyleClass().remove("x-Class");
            b12.getStyleClass().add("freeCell-Class");
            b12.getStyleClass().remove("o-Class");
            b12.getStyleClass().remove("x-Class");
            b13.getStyleClass().add("freeCell-Class");
            b13.getStyleClass().remove("o-Class");
            b13.getStyleClass().remove("x-Class");
            b21.getStyleClass().add("freeCell-Class");
            b21.getStyleClass().remove("o-Class");
            b21.getStyleClass().remove("x-Class");
            b22.getStyleClass().add("freeCell-Class");
            b22.getStyleClass().remove("o-Class");
            b22.getStyleClass().remove("x-Class");
            b23.getStyleClass().add("freeCell-Class");
            b23.getStyleClass().remove("o-Class");
            b23.getStyleClass().remove("x-Class");
            b31.getStyleClass().add("freeCell-Class");
            b31.getStyleClass().remove("o-Class");
            b31.getStyleClass().remove("x-Class");
            b32.getStyleClass().add("freeCell-Class");
            b32.getStyleClass().remove("o-Class");
            b32.getStyleClass().remove("x-Class");
            b33.getStyleClass().add("freeCell-Class");
            b33.getStyleClass().remove("o-Class");
            b33.getStyleClass().remove("x-Class");
            b11.setText("");
            b12.setText("");
            b13.setText("");
            b21.setText("");
            b22.setText("");
            b23.setText("");
            b31.setText("");
            b32.setText("");
            b33.setText("");
            
           
        });
    }
}